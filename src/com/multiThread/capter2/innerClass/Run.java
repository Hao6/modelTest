package com.multiThread.capter2.innerClass;

import java.io.PrintWriter;

/**
 * Created by hao on 17-6-1.
 */
public class Run {
    public static void main(String []args){
        PublicClass publicClass=new PublicClass();
        publicClass.setUsername("usernameValue");
        publicClass.setPassword("passwordValue");

        System.out.println(publicClass.getUsername()+" "+publicClass.getPassword());

        PublicClass.PrivateClass privateClass=publicClass.new PrivateClass();
        privateClass.setAge("ageValue");
        privateClass.setAddress("addressInfo");
        System.out.println(privateClass.getAddress()+" "+privateClass.getAge());

    }
}
