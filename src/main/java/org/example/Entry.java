package org.example;

import lombok.Data;
import lombok.Getter;

@Data
public class Entry<K, T> {

    private K key;
    private T value;

    public Entry() {
        this.key = null;
        this.value = null;
    }

    public Entry(K key, T value) {
        this.key = key;
        this.value = value;
    }
}
