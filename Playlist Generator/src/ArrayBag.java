import java.util.Arrays;

public class ArrayBag<T> implements IBag<T> {

    private T[] bag;
    private static final int DEFAULT_CAPACITY = 100;
    private int numberOfEntries;

    public ArrayBag(int capacity){
        numberOfEntries = 0;
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object [capacity];
        bag = tempBag;
    }

    public ArrayBag(){
        this(DEFAULT_CAPACITY);
    }

    @Override
    public boolean isArrayFull() {
        return numberOfEntries >= bag.length;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean add(T item) {
        boolean result = true;
        if (isArrayFull()){
            doubleCapacity();
        }
        else{
            bag[numberOfEntries] = item;
            numberOfEntries++;
        }
        return result;
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        for (int index = 0; index < numberOfEntries; index++){
            result[index] = bag[index];
        }
        return result;
    }

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public int getFrequencyOf(T item) {
        int counter = 0;
        for (int index = 0; index < numberOfEntries; index++){
            if (item.equals(bag[index])){
                counter++;
            }
        }
        return counter;
    }

    @Override
    public boolean contain(T item) {
        boolean wasFound = false;
        int index = 0;
        while (!wasFound && (index < numberOfEntries)){
            if (item.equals(bag[index])){
                wasFound = true;
            }
            else{
                index++;
            }
        }
        return wasFound;
    }

    @Override
    public T remove() {
        T result = null;
        if (!isEmpty()){
            result = bag[numberOfEntries-1];
            bag[numberOfEntries-1] = null;
            numberOfEntries --;
        }
        return result;
    }

    @Override
    public void clear() {
        while (!isEmpty()){
            remove();
        }
    }

    @Override
    public boolean remove(T item) {
        boolean wasFound = false;
        int index = 0;
        while (!wasFound && (index < numberOfEntries)){
            if (item.equals(bag[index])){
                wasFound = true;
                bag[index] = bag[numberOfEntries-1];
                bag[numberOfEntries-1] = null;
                numberOfEntries--;
            }
            else {
                index++;
            }
        }
        return wasFound;
    }

    private void doubleCapacity(){
          int newLength = 2 * bag.length;
          bag = Arrays.copyOf(bag,newLength);
    }

    public void displayItems(){
        for (int index = 0; index < numberOfEntries; index++){
            System.out.println(bag[index]);
        }

    }

    @Override
    public T getItemByIndex(int index) {
        return bag[index];
    }


}
