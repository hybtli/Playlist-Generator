public interface IBag<T> {

    public int getCurrentSize();

    public boolean isArrayFull();

    public boolean isEmpty();

    public boolean add(T item);

    public T remove();

    public boolean remove(T item);

    public void clear();

    public int getFrequencyOf(T item);

    public boolean contain(T item);

    public T[] toArray();

    public void displayItems();

    public T getItemByIndex(int index);


}
