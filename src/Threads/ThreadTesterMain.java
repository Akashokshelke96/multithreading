package Threads;

public class ThreadTesterMain {
    public static void main(String[] args) {

        System.out.println("Main Starts!!");
        //since Runnable is a functional interface we can use lambda here, Thread class implements Runnable
//        Thread thread1 = new Thread(
//                () -> {
//                    for (int i = 0; i < 2; i++) {
//                        System.out.println("Hi from Thread 2 !!!");
//                    }
//                }
//        );

//      thread1.setDaemon(true);// to mark this thread as a daemon thread!
//        thread1.start();


        // Here to learn synchronization we are creating stack and running loops to un-stabilize the stack
        Stack stack = new Stack(10);

        new Thread(
                () -> {
                    int counter = 0 ;
                    while(++counter < 10){
                        System.out.println("Pushed Element " + stack.push(100));
                    }
                },"Pusher").start();


        new Thread(
                ()-> {
                    int counter = 0 ;
                    while(++counter < 10){
                        System.out.println("Popped Element " + stack.pop());
                    }
                },"Popper").start();

        System.out.println(stack.toString());
        System.out.println("Main Exits!!");

    }
}
