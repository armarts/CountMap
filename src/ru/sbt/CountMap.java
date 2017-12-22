package ru.sbt;

import java.util.Map;

interface CountMap<T> {
    void add(T key);
    int getCount(T key);
    int remove(T key);
    int size();
    void addAll(CountMap<? extends T> source);
    Map<? super T, Integer> toMap();
    void toMap(Map<? super T, Integer> destination);
}