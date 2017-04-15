package com.Patterns.Design;

/**
 * Created by hongji on 2017/4/7.
 */

/**
 * 代码块同步
 */
public class Singleton2 {
    int data;
    private volatile  static Singleton2 instance=null;//volatile关键字是对象的简单操作原子化，不知道
    // 起不起作用
    private Singleton2(int data){
        this.data=data;
    }
    public  static Singleton2 getInstance(){  //使分配方法同步
        if(instance!=null){   //只进行一次加锁操作
            synchronized(Singleton2.class){
                if(instance==null){   //no thread safe
                    instance=new Singleton2(5);
                }
            }
        }
        return instance;  //return操作是原子操作
    }
}
