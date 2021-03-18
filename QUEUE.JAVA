
package dynamicarrayqueue;
public class DynamicArrayQueue {
private int capacity = 2;
    int queueArr[];
    int head = 0;
    int tail = -1;
    int currentSize = 0;
     
    public DynamicArrayQueue(){
        queueArr = new int[this.capacity];
    }
    public void enqueue(int item) {
         
        if (isQueueFull()) {
            System.out.println("Queue is full, increase capacity...");
            increaseCapacity();
        }
        tail++;
        if(tail >= queueArr.length && currentSize != queueArr.length){
            tail = 0;
        }
        queueArr[tail] = item;
        currentSize++;
        System.out.println("Add: " + item);
    }
    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Underflow ! elemn is not removed from queue");
        } else {
            head++;
            if(head > queueArr.length-1){
                System.out.println("removed: "+queueArr[head-1]);
                head = 0;
            } else {
                System.out.println("removed: "+queueArr[head-1]);
            }
            currentSize--;
        }
    }
    public boolean isQueueFull(){
        boolean status = false;
        if (currentSize == queueArr.length){
            status = true;
        }
        return status;
    }
    public boolean isQueueEmpty(){
        boolean status = false;
        if (currentSize == 0){
            status = true;
        }
        return status;
    }
     
    private void increaseCapacity(){
        int newCapacity = this.queueArr.length*2;
        int[] newArr = new int[newCapacity];
        int tmphead = head;
        int index = -1;
        while(true){
            newArr[++index] = this.queueArr[tmphead];
            tmphead++;
            if(tmphead == this.queueArr.length){
                tmphead = 0;
            }
            if(currentSize == index+1){
                break;
            }
        }
        this.queueArr = newArr;
        System.out.println("New array capacity: "+this.queueArr.length);
        this.head = 0;
        this.head = index;
    }
     
    public static void main(String a[]){
         
        DynamicArrayQueue queue = new DynamicArrayQueue();
        queue.enqueue(62);
        queue.dequeue();
        queue.enqueue(40);
        queue.enqueue(96);
        queue.enqueue(35);
        queue.dequeue();
        queue.enqueue(34);
        queue.enqueue(99);
        queue.dequeue();
        
    }
}