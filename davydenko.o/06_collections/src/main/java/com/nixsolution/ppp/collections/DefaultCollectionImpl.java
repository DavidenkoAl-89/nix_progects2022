package com.nixsolution.ppp.collections;

import com.nixsolutions.ppp.collections.DefaultCollection;
import com.nixsolutions.ppp.collections.DefaultIterator;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DefaultCollectionImpl<T> implements DefaultCollection<T> {
    private T[] arr;
    private int size;
    public DefaultCollectionImpl(T[] arr) {
        this.arr = arr;
        this.size = arr.length;
    }
    private class DefaultIteratorImpl implements DefaultIterator<T> {
        private int index;
        @Override
        public boolean hasNext() {
            if (index < arr.length) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("no such element");
            }
            return (T) arr[index++];
        }
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public DefaultIterator<T> iterator() {
        return new DefaultIteratorImpl();
    }
    @Override
    public boolean add(Object object) {
        try {
            T[] tempArr = arr;
            arr = (T[]) new Object[tempArr.length + 1];
            System.arraycopy(tempArr, 0, arr, 0, tempArr.length);
            arr[arr.length - 1] = (T) object;
            size++;
            return true;
        } catch (ClassCastException e) {
        throw new RuntimeException(e);
        }
    }

    @Override
    public boolean addAll(Collection collection) {
        if (arr.length == 0) {
            arr = (T[]) collection.toArray();
        }
        if (collection.isEmpty()) {
            return false;
        }
        for (Object item : collection) {
            add((T) item);
        }
        return true;
    }

    @Override
    public void clear() {
        arr = (T[]) new Object[10];
        size = 0;
    }

    @Override
    public boolean retainAll(Collection collection) {
        if (collection == null) {
            throw new NullPointerException("collection is null");
        }
        boolean modified = false;
        Iterator<T> it = iterator();

        T[] arrayForRemove = (T[]) new Object[0];
        while (it.hasNext()) {
            T valueForRemove = it.next();
            if (collection.contains(valueForRemove)) {

            } else {
                T[] tempArr = arrayForRemove;
                arrayForRemove = (T[]) new Object[tempArr.length + 1];
                System.arraycopy(tempArr, 0, arrayForRemove, 0, tempArr.length);
                arrayForRemove[arrayForRemove.length - 1] = valueForRemove;
                modified = true;
            }
        }
        for (T t : arrayForRemove) {
            for (int j = 0; j < size; j++) {
                if (t.equals(arr[j])) {
                    remove(t);
                    if (j > 0) {
                        j--;
                    }
                }
            }
        }
        return modified;
    }

    @Override
    public boolean remove(Object object) {
        Iterator<T> it = iterator();
        int k = 0;
        if (object == null) {
            while (it.hasNext()) {
                k++;
                if (it.next() == null) {
                    T[] newData = (T[]) new Object[arr.length - 1];
                    System.arraycopy(arr, 0, newData, 0, k - 1);

                    if (k - 1 < newData.length)
                        System.arraycopy(arr, k, newData, k - 1, arr.length - k--);
                    size--;
                    arr = newData;
                    return true;
                }
            }
        }

        int position = -1;
        for (int i = 0; i < size; i++) {
            if (object.equals(arr[i])) {
                position = i;
                break;
            }
        }
        if (position < 0) {
            return false;
        }
        T[] tempArray = (T[]) new Object[arr.length - 1];

        for (int i = 0; i < position; i++) {
            tempArray[i] = (T) arr[i];
        }
        for (int i = position + 1; i < arr.length; i++) {
            tempArray[i - 1] = (T) arr[i];
        }
        arr = tempArray;
        size--;
        return true;
    }

    @Override
    public boolean removeAll(Collection collection) {
        if (collection == null) {
            throw new NullPointerException("collection is null");
        }
        if (collection.isEmpty()) {
            return false;
        }
        for (Object item : collection) {
            remove(item);
        }
        return true;
    }

    @Override
    public boolean contains(Object object) {
        Iterator<T> it = iterator();
        if (object == null) {
            while (it.hasNext())
                if (it.next() == null)
                    return true;
        } else {
            while (it.hasNext())
                if (object.equals(it.next()))
                    return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection collection) {
        for (Object item : collection)
            if (!contains(item)) {
                return false;
            }
        return true;
    }

    @Override
    public Object[] toArray(Object[] objects) {
        return this.toArray();
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[size];
        System.arraycopy(arr, 0, newArray, 0, size);
        return newArray;
    }
}

