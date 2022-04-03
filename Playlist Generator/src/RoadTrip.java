public class RoadTrip<T> implements IBag<T> {

    private T[] roadTripBag;
    private static final int MINIMUM_DURATION = 10800;
    private int duration;
    private int numberOfEntries;


    public RoadTrip(){
        numberOfEntries = 0;
        duration = 0;
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object [50];
        roadTripBag = tempBag;
    }

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isArrayFull() {
        return duration >= MINIMUM_DURATION;
    }

    @Override
    public boolean add(T item) {
        if (isArrayFull()){
            return false;
        }
        else {
            roadTripBag[numberOfEntries] = item;
            duration += Integer.parseInt(item.toString().split(",")[2]);
            numberOfEntries++;
            return true;
        }
    }

    @Override
    public T remove() {
        T result = null;
        if (!isEmpty()){
            result = roadTripBag[numberOfEntries-1];
            roadTripBag[numberOfEntries-1] = null;
            numberOfEntries --;
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean remove(T item) {
        boolean wasFound = false;
        int index = 0;
        while (!wasFound && (index < numberOfEntries)){
            if (item.equals(roadTripBag[index])){
                wasFound = true;
                roadTripBag[index] = roadTripBag[numberOfEntries-1];
                roadTripBag[numberOfEntries-1] = null;
                numberOfEntries--;
            }
            else{
                index++;
            }
        }
        return wasFound;
    }

    @Override
    public void clear() {
        while (!isEmpty()){
            remove();
        }
    }

    @Override
    public int getFrequencyOf(T item) {
        int counter = 0;
        for (int index = 0; index < numberOfEntries; index++){
            if (item.equals(roadTripBag[index])){
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
            if (item.equals(roadTripBag[index])){
                wasFound = true;
            }
            else{
                index++;
            }
        }
        return wasFound;
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        for (int index = 0; index < numberOfEntries; index++){
            result[index] = roadTripBag[index];
        }
        return result;
    }

    @Override
    public void displayItems() {
        for (int index = 0; index < getCurrentSize(); index++){
            System.out.println(roadTripBag[index]);
        }
    }

    @Override
    public T getItemByIndex(int index) {
        return roadTripBag[index];
    }

}
