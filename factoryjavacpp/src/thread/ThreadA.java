package thread;

public class ThreadA  extends Thread{
	public void run() {
	}
	public void release() {
             synchronized(this){
                 notify();
                 }
	}
}
