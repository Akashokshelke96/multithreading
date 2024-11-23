public class Deadlock {

    public static void main(String[] args) {
        //Create a code block which simulates Deadlock in Java!

        System.out.println("Main starts!!!");
        String lock1 = "God Is";
        String lock2 = "Great!";

        Thread thread1 = new Thread(
                () -> {
                    synchronized (lock1){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        synchronized (lock2){
                            System.out.println("Thread1 acquires lock1");
                        }
                    }
                }, "thread1"
        );

        Thread thread2 = new Thread(
                () -> {
                    synchronized (lock2){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        synchronized (lock1){
                            System.out.println("Thread2 acquires lock2");
                        }
                    }
                },"thread2"
        );

        //to resolve the deadlock we need the locks in thread2 to be in the same order as locks in thread 1
        thread1.start();
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main exits!!!");
    }
}
