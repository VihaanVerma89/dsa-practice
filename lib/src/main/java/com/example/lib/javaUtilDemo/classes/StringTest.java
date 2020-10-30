package com.example.lib.javaUtilDemo.classes;

public class StringTest {

//    public void test() {
//        String test = null;
//    }

    public void test(){
//        String []s = new String[]{"2", "abc"};

        int argcount = 2; // number of IN arguments
        String[] args = new String[]{ "1", "2" };
        StringBuilder inList = new StringBuilder(argcount * 2);
        for (int i = 0; i < argcount; i++) {
            if(i > 0) {
                inList.append(",");
            }
            inList.append("?");
        }

//        cursor = contentResolver.query(
//                CONTENT_URI,
//                PROJECTION,
//                "field IN (" + inList.toString() + ")",
//                args,
//                null);
        String s1 = inList.toString();
        System.out.println(s1);
    }

    public static void main(String[] args) {

        StringTest stringTest = new StringTest();
        stringTest.test();

    }
}
