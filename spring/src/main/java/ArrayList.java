
/**
 * Your implementation of an ArrayList.
 */
public class ArrayList<T> {

    /*
     * The initial capacity of the ArrayList.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 9;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new ArrayList.
     * 
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast an Object[] to a T[] to get the generic typing.
     */
    public ArrayList() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the data to the front of the list.
     *
     * This add may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        } else {
            ensureCapacity();
            for (int i = size; i > 0; i--) {
                backingArray[i] = backingArray[i - 1];
            }
            backingArray[0] = data;
            size++;
        }
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    }

    /**
     * Adds the data to the back of the list.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        } else {
            ensureCapacity();
            backingArray[size] = data;
            size++;
        }
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Do not shrink the backing array.
     *
     * This remove may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() { if (size == 0) {
            throw new java.util.NoSuchElementException("ArrayList is empty");
        } else {
            T removedData = backingArray[0];
            for (int i = 1; i < size; i++) {
                backingArray[i - 1] = backingArray[i];
            }
            backingArray[size - 1] = null;
            size--;
            return removedData;
        }
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Do not shrink the backing array.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() { if (size == 0) {
            throw new java.util.NoSuchElementException("ArrayList is empty");
        } else {
            T removedData = backingArray[size - 1];
            backingArray[size - 1] = null;
            size--;
            return removedData;
        }
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    }

    /**
     * Returns the backing array of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }


    private void ensureCapacity() {
        if (size == backingArray.length) {
            T[] newArray = (T[]) new Object[backingArray.length * 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = backingArray[i];
            }
            backingArray = newArray;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(backingArray[i]);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        // addToBack
        ArrayList<Object> list = new ArrayList<>();
        list.addToBack(1);
        list.addToBack(2);
        list.addToBack(3);
        System.out.println(list);
        // addToFront
        list.addToFront(0);
        list.addToFront(-1);
        System.out.println(list);
        // resize
        list.addToBack(4);
        list.addToBack(5);
        list.addToBack(6);
        list.addToBack(7);
        list.addToBack(8);
        list.addToBack(9);
        list.addToBack(10);
        list.addToBack(11);
        System.out.println(list);
        list.addToFront(-2);
        System.out.println(list);
        list.removeFromFront();
        System.out.println(list);
        list.removeFromBack();
        System.out.println(list);
        System.out.println(12 == list.size);

    }
}