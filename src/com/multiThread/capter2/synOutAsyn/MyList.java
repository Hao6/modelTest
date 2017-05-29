package com.multiThread.capter2.synOutAsyn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongji on 2017/5/29.
 */
public class MyList {
    private List<String> list=new ArrayList();
    public synchronized void add(String username){
        System.out.println("ThreadName="+Thread.currentThread().getName()
        +" 执行了add方法");
        list.add(username);
        System.out.println("ThreadName="+Thread.currentThread().getName()
                +" 退出了add方法");
    }
    public synchronized int getSize(){
        System.out.println("ThreadName="+Thread.currentThread().getName()
                +" 执行了getSize方法");
        int sizeValue=list.size();
        System.out.println("ThreadName="+Thread.currentThread().getName()
                +" 退出了getSize方法");
        return sizeValue;
    }
}
