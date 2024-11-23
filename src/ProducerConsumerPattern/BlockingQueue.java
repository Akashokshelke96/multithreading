package ProducerConsumerPattern;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {

    private Queue<Integer> queue;
    private int capacity;

    public BlockingQueue(int cap){
      queue = new LinkedList<>();
      capacity = cap;
    }

    public boolean add(int elem){
        synchronized (queue){
            if(capacity == queue.size()){
                //here we add a wait, so multiple threads running the add method should create inconsistent state
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            //we are notifying all threads which are waiting on EMPTY queue to remove an element, that we have added a new one.
            queue.notifyAll();
            queue.add(elem);
            return true;
        }
    }

    public int remove(){
        synchronized (queue){
            if (queue.size() == 0){
                //here we add a wait, so if queue is null, we wait for another thread to put in a valid value so we don't throw any null exceptions
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            //we are notifying all threads that are waiting on a FULL queue, that this thread has removed one element.
            queue.notifyAll();
            int obj = queue.poll();
            return obj;
        }

    }
}
