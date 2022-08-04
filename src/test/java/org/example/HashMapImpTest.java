package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Optional.ofNullable;
import static org.junit.jupiter.api.Assertions.*;

class HashMapImpTest {

    @Test
    void shouldPutEntryIntoMap() {
        // given
        HashMapImp<String, String> hashMap = new HashMapImp<>();
        String key = "testKey";
        String value = "testValue";
        Entry<String, String> expectedEntry = new Entry<>(key, value);

        // when
        hashMap.put(key, value);

        // then
        List<Entry> entries = IntStream.range(0, hashMap.getSize())
                .mapToObj(index -> ofNullable(hashMap.getEntrySet()[index]))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        assertEquals(1, entries.size());
        assertEquals(expectedEntry, entries.get(0));
    }
}