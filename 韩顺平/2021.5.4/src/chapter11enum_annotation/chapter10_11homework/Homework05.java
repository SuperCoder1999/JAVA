package chapter11enum_annotation.chapter10_11homework;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Homework05 {
    public static void main(String[] args) {
        new A().test();
    }
}

class A {
    private String name = "Tom";
    public void test() {
        class B {
            private String name = "jack";
            public void show() {
                System.out.println(name);
                System.out.println(A.this.name);
            }
        }
        new B().show();
    }
}