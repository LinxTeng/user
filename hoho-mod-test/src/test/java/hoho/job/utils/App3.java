package hoho.job.utils;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class App3 {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1", 9989);
            s.setTcpNoDelay(true);
            StringBuffer bb = new StringBuffer();
            ByteBuffer bbb = ByteBuffer.allocate(00);

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Thread aa = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub

            }
        });
        aa.setName("app3-main-1");

        Executor exe = Executors.newCachedThreadPool();
        exe.execute(aa);


    }
}
