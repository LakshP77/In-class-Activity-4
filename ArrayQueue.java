public class ArrayQueue {
    private int[] queue;     // array to store elements
    private int front;       // index of front element
    private int rear;        // index of last element
    private int count;       // number of elements in queue
    private int capacity;    // max number of elements

    // (a) Parameterized constructor
    public ArrayQueue(int size) {
        capacity = size;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        count = 0;
    }

    // Enqueue — adds element to the rear
    public void enqueue(int dataItem) {
        if (isFull()) {
            throw new RuntimeException("Queue overflow — cannot enqueue, queue is full!");
        }
        rear = (rear + 1) % capacity;  // circular increment
        queue[rear] = dataItem;
        count++;
    }

    // (b) Dequeue — removes and returns front element
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow — cannot dequeue from empty queue!");
        }
        int data = queue[front];
        front = (front + 1) % capacity; // circular increment
        count--;
        return data;
    }

    // (c) Check if queue is empty
    public boolean isEmpty() {
        return count == 0;
    }

    // Check if queue is full
    public boolean isFull() {
        return count == capacity;
    }

    // Returns current number of elements
    public int size() {
        return count;
    }

    // Returns the element at the front without removing
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty — nothing to peek!");
        }
        return queue[front];
    }

    // Display the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue (front → rear): ");
        for (int i = 0; i < count; i++) {
            int index = (front + i) % capacity;
            System.out.print(queue[index] + " ");
        }
        System.out.println();
    }

    // Test the queue implementation
    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();

        System.out.println("Dequeued: " + q.dequeue());
        q.display();
        System.out.println("Front element: " + q.peek());
        System.out.println("Current size: " + q.size());
    }
}
