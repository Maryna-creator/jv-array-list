package core.basesyntax;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayList<T> implements List<T> {
    private Object[] elementData;
    private int size;
    private int arraySize = 10;

    public ArrayList() {
        elementData = new Object[arraySize];
        size = 0;
    }

    @Override
    public void add(T value) {
        if (size == elementData.length) {
            int newCapacity = elementData.length + elementData.length / 2;
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
        elementData[size] = value;
        size++;
    }

    @Override
    public void add(T value, int index) {
        if (index < 0 || index > size) {
            throw new ArrayListIndexOutOfBoundsException("Not found this index");
        }
        if (size == elementData.length) {
            int newCapacity = elementData.length + elementData.length / 2;
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = value;
        size++;
    }

    @Override
    public void addAll(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }

    @Override
    public T get(int index) {
        if (index >= 0 && index < size) {
            return (T) elementData[index];
        } else {
            throw new ArrayListIndexOutOfBoundsException("Not found this index");
        }
    }

    @Override
    public void set(T value, int index) {
        if (index >= 0 && index < size) {
            elementData[index] = value;
        } else {
            throw new ArrayListIndexOutOfBoundsException("Not found this index");
        }
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayListIndexOutOfBoundsException("Not found this index");
        } else {
            T removedElement = (T) elementData[index];
            System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
            size--;
            return removedElement;
        }
    }

    @Override
    public T remove(T element) {
        for (int i = 0; i < size; i++) {
            if (element == null ? elementData[i] == null : elementData[i] != null
                    && elementData[i].equals(element)) {
                return remove(i);
            }
        }
        throw new NoSuchElementException("There is not such element");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
