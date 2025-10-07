
// How would you do that?
//   By using a single underlying array that stores all elements,
//   and a variable that tracks how many elements are currently stored.
//
// How would you implement the automatic expansion?
//   When size reaches currentCapacity, create a new array with larger capacity, copy all elements into it, 
//   and replace the old array.
//
//   
// What important task needs to be done to preserve stored data?
//   You must copy all existing elements from the old array into the new, larger array
//   before assigning it to the reference.
//
// What additional steps do you need to take when you add/remove an element?
//   When adding, check capacity and expand if full. When removing, shift all elements
//   after the removed index to the left to fill the gap.
//
// Are there any pre/post conditions to consider?
//   Precondition: Index must be within valid bounds.
//   Postcondition: The array remains compact and size accurately reflects the number of stored elements.

public class FlexArray {
    private String[] data;   // underlying array
    private int size;        // current number of stored elements

    // Default constructor — starts with capacity of 5
    public FlexArray() {
        data = new String[5];
        size = 0;
    }

    // Adds an element to the end of the array
    public void addToEnd(String elementToAdd) {
        ensureCapacity();
        data[size] = elementToAdd;
        size++;
    }

    // Stores a new element at a certain index (replaces existing one)
    public void set(int index, String elementToAdd) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        data[index] = elementToAdd;
    }

    // Clears all data
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    // Removes element at a certain index
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        // Shift elements left
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null; // clear last element
        size--;
    }

    // Returns the current number of elements
    public int size() {
        return size;
    }

    // Returns current capacity of underlying array
    public int currentCapacity() {
        return data.length;
    }

    // Checks if array is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Expands array capacity automatically when full
    private void ensureCapacity() {
        if (size >= data.length) {
            int newCapacity = data.length * 2; // double the capacity
            String[] newData = new String[newCapacity];
            // Copy existing data
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            data = newData; // replace old array
        }
    }

    // Optional: Get element at index
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return data[index];
    }

    // Displays the list content
    public void display() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // Test the FlexArray class
    public static void main(String[] args) {
        FlexArray fa = new FlexArray();

        // Add elements
        fa.addToEnd("Iron Man");
        fa.addToEnd("Inception");
        fa.addToEnd("Matrix");
        fa.addToEnd("Avatar");
        fa.addToEnd("Tenet");
        fa.addToEnd("Dune"); // triggers auto expansion

        System.out.println("Initial list:");
        fa.display();
        System.out.println("Size: " + fa.size() + ", Capacity: " + fa.currentCapacity());

        // Replace one
        fa.set(2, "The Batman");
        System.out.println("\nAfter replacing index 2:");
        fa.display();

        // Remove one
        fa.remove(4);
        System.out.println("\nAfter removing index 4:");
        fa.display();

        // Clear all
        fa.clear();
        System.out.println("\nAfter clearing:");
        fa.display();
        System.out.println("Empty? " + fa.isEmpty());
    }
}
