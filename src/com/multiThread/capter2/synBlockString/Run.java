package com.multiThread.capter2.synBlockString;

/**
 * Created by hongji on 2017/5/29.
 */
public class Run {
    public static void main(String[] args) {
        Service service=new Service();
        ThreadA threadA=new ThreadA(service);
        threadA.setName("A");
        threadA.start();
        ThreadB threadB=new ThreadB(service);
        threadB.setName("B");
        threadB.start();
    }
}
