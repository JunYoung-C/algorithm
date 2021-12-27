package test;

import java.io.IOException;
import java.util.Arrays;

public class Test {
  
  public static void main(String[] args) throws IOException {
    Hi hi1 = new Hi();
    Hi hi2 = new Hi();
    System.out.println(hi1);
    System.out.println(hi2);
    Test test = new Test();
    System.out.println(Hi.hello);
  }
  
  static class Hi {
    static String hello;

    public String getHello() {
      return hello;
    }

    public void setHello(String hello) {
      this.hello = hello;
    }
    
  }
}


