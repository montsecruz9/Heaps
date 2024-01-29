public class Heap {

    private int[] heap;
    private int size;

    //in our constructor we will initialize our array letting the caller tell us how big the heap will be
    public Heap(int capacity) {
        heap = new int[capacity];
    }


    public void insert(int value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Heap is Full")
        }
        heap[size++] = value;

        fixHeapAbove(size);
        size++;
    }

    private void fixHeapAbove(int index) {
        int newValue = heap[index];
        while (index > 0 && newValue > heap[getParent(index)]) {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }

        heap[index] = newValue;
    }

    //check to see whether the heap is full
    public boolean isFull() {
        return size == heap.length;
    }

    //utility method for getting the parent of certain element in the array
    public int getParent(int index) {
        return (index - 1) / 2;
    }


}
