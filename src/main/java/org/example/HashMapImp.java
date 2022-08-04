package org.example;

import lombok.Getter;

import java.util.Objects;

public class HashMapImp<K, T> {
    @Getter
    private int size;
    @Getter
    private Entry[] entrySet;
    public HashMapImp() {
        this.size = 10;
        this.entrySet = new Entry[size];
    }

    public HashMapImp(int size) {
        this.size = size;
        this.entrySet = new Entry[size];
    }

    public void put(K key, T value) {
        entrySet[getIndex(key.hashCode())] = new Entry(key, value);
    }

    public void remove(K key) {
        entrySet[key.hashCode() % size] = null;
    }

    public Entry<K, T> getEntry(K key) {
        Entry<K, T> entry = entrySet[getIndex(key.hashCode())];
        if (Objects.isNull(entry)) {
            throw new IllegalArgumentException("Key does not exist.");
        }
        return entry;
    }

    public T getValue(K key) {
        return getEntry(key).getValue();
    }

    private int getIndex(int hashCode) {
        return Math.abs(hashCode) % size;
    }
}
