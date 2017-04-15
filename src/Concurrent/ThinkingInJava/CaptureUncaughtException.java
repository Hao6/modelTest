package Concurrent.ThinkingInJava;

import java.util.concurrent.*;

/**
 * Created by hongji on 2017/4/4.
 */
class ExceptionThread2 implements Runnable{

    @Override
    public void run() {
        Thread t=Thread.currentThread();
        System.out.println("run by "+t);
        System.out.println(
                "eh = "+t.getUncaughtExceptionHandler()
        );
        throw new RuntimeException();
    }
}
class MyUncaughtExceptionHandler implements
        Thread.UncaughtExceptionHandler{
    public void uncaughtException(Thread t,Throwable e){
        System.out.println("caught "+e);
    }
}
class HandlerThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r){
        System.out.println(this +" creating new thread");
        Thread t=new Thread(r);
        System.out.println("carsted "+t);
        t.setUncaughtExceptionHandler(
                new MyUncaughtExceptionHandler()
        );
        System.out.println(
                "eh = "+t.getUncaughtExceptionHandler()
        );
        return t;
    }

}
public class CaptureUncaughtException {
    public static void main(String []args){
        ExecutorService exec=Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
        exec.shutdown();
    }
}
