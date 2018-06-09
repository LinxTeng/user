package com.hoho.user;

import java.awt.BorderLayout;
import java.math.BigDecimal;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

public class JProgressBarTest extends JFrame {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private Thread threadA;
  private Thread threadB;

  public void first() {
    BigDecimal a = new BigDecimal(0.3);
  }

  public JProgressBarTest() {
    super();
    final JProgressBar jProgressBar1 = new JProgressBar();
    final JProgressBar jProgressBar2 = new JProgressBar();
    this.getContentPane().add(jProgressBar1, BorderLayout.NORTH);
    this.getContentPane().add(jProgressBar2, BorderLayout.SOUTH);
    jProgressBar1.setStringPainted(true);
    jProgressBar2.setStringPainted(true);

    threadA = new Thread(new Runnable() {
      int count = 0;

      @Override
      public void run() {
        while (true) {
          jProgressBar1.setValue(++count);
          try {
            Thread.sleep(1000);
            threadB.join();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    });

    threadA.start();
    threadB = new Thread(new Runnable() {
      int count = 0;

      @Override
      public void run() {
        while (true) {
          jProgressBar2.setValue(++count);
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            break;
          }
        }
      }
    });
    threadB.start();
    threadB.interrupt();
  }

  public static void init(JFrame frame, int width, int height) {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(width, height);
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    init(new JProgressBarTest(), 100, 100);
    JProgressBarTest record = new JProgressBarTest();
    ProxyFactory di = new ProxyFactory();
    di.setTarget(record);
  }

  public void execute() {
    System.out.println("花弄影");
  }

  public class LoggerExecute implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation arg0) throws Throwable {
      System.out.println("程序开始执行");
      arg0.proceed();
      return null;
    }


  }
}
