package com.multiThread.capter2.innerStaticClass;

/**
 * Created by hao on 17-6-1.
 */
public class PublicClass {
    private static String username;
    private static String password;
    static class PrivateClass{
        private String age;
        private String address;

        public String getAge() {
            return age;
        }

        public String getAddress() {
            return address;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public void setAddress(String address) {
            this.address = address;
        }
        public void printPublicProperty(){
            System.out.println(username+" "+password);
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
