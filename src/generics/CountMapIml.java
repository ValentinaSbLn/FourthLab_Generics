package generics;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Valentina on 20.09.2016.
 */
public class CountMapIml<T> implements CountMap<T>{
    private Map<T, Integer>items=new HashMap<>();

    @Override
    public void add(T t) {
        items.put(t, (items.containsKey(t)) ? items.get(t) + 1 : 1);

    }

    @Override
    public int getCount(T t) {
        return items.containsKey(t) ? items.get(t) : 0;
    }

    @Override
    public int remove(T t) {
        int count=this.getCount(t);
        this.items.remove(t);
        return count;
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public void addAll(CountMap<? extends T> countMap) {
        Map<? extends T,Integer> map = countMap.toMap();
        for (T t : map.keySet()) {
            items.put(t, (items.containsKey(t)) ? items.get(t) + map.get(t) : 1);
        }

        for (T s : items.keySet())
            System.out.println("addAll "+s + ": " + items.get(s));
    }

    @Override
    public Map<T, Integer> toMap() {
        Map<T, Integer> map=new HashMap<T, Integer>();
                for (T t : items.keySet()) {
            map.put(t,  items.get(t));
        }
        return map;
    }

    @Override
    public void toMap(Map<? super T, Integer>destination) {
        destination.clear();
        for (T t : items.keySet()) {
            destination.put(t,  items.get(t));
        }

     }
}
