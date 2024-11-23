public class Thread2 extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 2; i++) {
            System.out.println("Hi from Thread 2 !!!");
        }
    }


}
