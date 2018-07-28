package com.hoho.test.Thread;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

//管道流通信
public class PipeStream {

	public class WriteData {
		public void writeMethod(PipedOutputStream out) {
			try {
				System.out.println("write :");
				for(int i=0;i<300;i++) {
					String outData=""+(i+1);
					out.write(outData.getBytes());
					System.out.println("写入:"+outData);
				}
				System.out.println();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public class ReadData{
		public void readMethod(PipedInputStream input) {
			try {
				System.out.println("read :");
				byte[] byteArray=new byte[20];
				int readLength=input.read(byteArray);
				while(readLength !=-1) {
					String newData=new String(byteArray,0,readLength);
					System.out.println("读取："+newData);
					readLength=input.read(byteArray);
				}
				System.out.println();
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public class ThreadWrite extends Thread{
		private WriteData write;
		private PipedOutputStream out;
		
		public ThreadWrite(WriteData write,PipedOutputStream out) {
			this.write=write;
			this.out=out;
		}

		@Override
		public void run() {
			write.writeMethod(out);
		}
	}
	
	public class ThreadRead extends Thread{
		private ReadData read;
		private PipedInputStream input;
		
		public ThreadRead(ReadData read,PipedInputStream input) {
			this.read=read;
			this.input=input;
		}

		@Override
		public void run() {
			read.readMethod(input);
		}
	}
	
	public static void main(String[] args) {
		
		try {
			WriteData writeData=new PipeStream().new WriteData();
			ReadData readData=new PipeStream().new ReadData();
			
			PipedInputStream inputStream=new PipedInputStream();
			PipedOutputStream outputStream=new PipedOutputStream();
			
//			inputStream.connect(outputStream);
			outputStream.connect(inputStream);
			
			
			ThreadRead threadRead=new PipeStream().new ThreadRead(readData, inputStream);
			threadRead.start();
			
			Thread.sleep(2000);
			//注意这里的顺序，此处读取的值是乱的。但是将下面的write放到read前面则会顺序读取
			
			ThreadWrite threadWrite =new PipeStream().new ThreadWrite(writeData, outputStream);
			threadWrite.start();
			
			threadWrite.join();
			
		
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
