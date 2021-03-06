package com.leetcoder;

/**
 * Created by hongji on 2017/6/9.
 */
public class Solution28 {
    public int strStr(String haystack, String needle) {
        int haystackLen=haystack.length();
        int needleLen=needle.length();
        if(needleLen==0)
            return 0;
        else if(haystackLen<needleLen)
            return -1;
        //kmp算法，判断字符串needle是否是haystack的子串，如果是返回开始匹配的位置，如果不是，返回-1
        int []failure;
        failure=fail(needle);
        int i=0,j=0;
        while(i<haystackLen && j<needleLen){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;  //可以匹配，同时自增
            }else if(j==0){
                i++;   //第一个不匹配，haystack向右移
            } else {      //不是第一项不匹配，即haystack[i]!=needle[j] && j!=0
                j=failure[j-1]+1;
            }
        }
        return ((j==needleLen) ? (i-needleLen) : -1);
    }

    public int[] fail(String pat) {
        int patLen=pat.length();
        int []fail=new int[patLen];
        fail[0]=-1;
        int temp=0;
        for(int i = 1; i<patLen; i++){
            temp=fail[i-1];
            while(pat.charAt(i)!=pat.charAt(temp+1) && temp>=0){
                temp=fail[temp];
            }
            if(pat.charAt(i)==pat.charAt(temp+1)){
                fail[i]=temp+1;
            }else {
                fail[i]=-1;
            }
        }
        return fail;
    }

    public int[] fail1(String pat) {
        int patLen = pat.length();
        int[] fail = new int[patLen];
        if (patLen == 0)
            return fail;
        fail[0] = -1;
        if (patLen == 1)
            return fail;
        for (int i = 1; i < patLen; i++) {
            int k = i - 1, h;
            while (k >= 0) {
                h = fail[k];
                if (pat.charAt(i) == pat.charAt(h + 1)) {
                    fail[i] = fail[k] + 1;
                    break;
                }
                k = h;
            }
            if (k < 0)
                fail[i] = -1;
        }
        return fail;
    }
    public int strStr1(String haystack, String needle) {   //直接调用API
        return haystack.indexOf(needle);
    }
}
