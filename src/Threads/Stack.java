package Threads;

import java.util.Arrays;

public class Stack {
 private int stackTop;
 private int[] stack;

 public Stack(int capacity){
     stack = new int[capacity];
     stackTop = -1;
 }

 public synchronized boolean push(int element) {
     if (isFull()){
         return false;
     }
     ++stackTop;
     try {
         Thread.sleep(1000);
     } catch (InterruptedException e) {
         throw new RuntimeException(e);
     }
     stack[stackTop] = element;
     return true;
 }

 public synchronized int pop(){
     if(isEmpty()) return Integer.MIN_VALUE;
     int obj = stack[stackTop];
     stack[stackTop] = Integer.MIN_VALUE;
     try {
         Thread.sleep(1000);
     } catch (InterruptedException e) {
         throw new RuntimeException(e);
     }
     System.out.println("element removed from stack: " + obj);
     stackTop--;
     return obj;
 }

    @Override
    public String toString() {
        return "Threads.Stack{" +
                "stackTop=" + stackTop +
                ", stack=" + Arrays.toString(stack) +
                '}';
    }

    public boolean isEmpty(){
     return stackTop < 0;
    }

    public boolean isFull(){
     return stackTop >= stack.length -1;
    }

}
