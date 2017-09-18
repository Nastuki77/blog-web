package com.nastuki.blog;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nastuki on 2017/8/24.
 */
public class StringTest {

    @Test
    public void test1(){
        String s = "--123";
        Map<String,String> map = new HashMap<>();
        System.out.println(s.substring(0,s.indexOf("--")));
        System.out.println(s.substring(s.indexOf("--")+2));
        System.out.println("=========="+map.get("--")+"==========");
    }

}
