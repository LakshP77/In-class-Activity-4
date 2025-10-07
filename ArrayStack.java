
public class ArrayStack {
    private int top;          // index of the top element
    private int[] stack;      // array to hold stack elements
    private int capacity;     // maximum number of elements

    // Constructor — initializes stack with given capacity
    public ArrayStack(int size) {
        capacity = size;
        stack = new int[capacity];
        top = -1; // empty stack indicator
    }

    // Push — adds data item to the top
    public void push(int dataItem) {
        if (isFull()) {
            throw new RuntimeException("Stack overflow — cannot push, stack is full!");
        }
        stack[++top] = dataItem;
    }

    // Pop — removes and returns the top data item
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow — cannot pop from empty stack!");
        }
        return stack[top--];
    }

    // Peek — returns top data item without removing
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty — nothing to peek!");
        }
        return stack[top];
    }

    // isEmpty — returns true if stack has no elements
    public boolean isEmpty() {
        return top == -1;
    }

    // isFull — returns true if stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // size — returns current number of elements in stack
    public int size() {
        return top + 1;
    }

    // Optional: Display all stack elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack (top → bottom): ");
            for (int i = top; i >= 0; i--) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }

    // Test the stack implementation
    public static void main(String[] args) {
        ArrayStack s = new ArrayStack(5);
        s.push(10);
        s.push(20);
        s.push(30);
        s.display();

        System.out.println("Peek: " + s.peek());
        System.out.println("Popped: " + s.pop());
        s.display();
        System.out.println("Current size: " + s.size());
    }
}
