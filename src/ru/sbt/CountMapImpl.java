package ru.sbt;

import java.util.Map;
import java.util.TreeMap;

public class CountMapImpl<T> implements CountMap<T> {

    private Map<T, Integer> map;

    public CountMapImpl() {
        map = new TreeMap<T, Integer>();
    }
    
    private void addMore(T key, Integer times) {
        if (map.containsKey(key)) {
            Integer integer = map.get(key);
            map.put(key, integer.intValue() + times);
            return ;
        }

        map.put(key, 1);
    }

    @Override
    public void add(T key) {
        addMore(key, 1);
    }

    @Override
    public int getCount(T key) {
        if (map.containsKey(key))
            return map.get(key);

        return 0;
    }

    @Override
    public int remove(T key) {
        if (map.containsKey(key))
            return map.remove(key);

        return 0;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<? extends T> source) {
        Map<?, Integer> mapSource = source.toMap();

        for (Object o : mapSource.keySet()) {
            int times = (map.containsKey(o)) ? (map.get(o).intValue() + 1) : 1;
            
            addMore((T) o, times);
        }
    }

    @Override
    public Map<? super T, Integer> toMap() {
        return map;
    }

    @Override
    public void toMap(Map<? super T, Integer> destination) {

        for (T t : map.keySet()) {
            destination.put(t, map.get(t));
        }
    }
}
