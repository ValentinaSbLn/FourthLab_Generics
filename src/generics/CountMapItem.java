package generics;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Valentina on 20.09.2016.
 */
public class CountMapItem <E> implements CountMap<E>{
    HashMap<E, Integer>items=new HashMap<E, Integer>();

    @Override
    public void add(E e) {
        items.put(e, (items.containsKey(e)) ? items.get(e) + 1 : 1);

    }

    @Override
    public int getCount(E e) {

        return items.containsKey(e) ? items.get(e) : 0;
    }

    @Override
    public int remove(E e) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void addAll(CountMap source) {

    }

    @Override
    public Map toMap() {
        return null;
    }

    @Override
    public void toMap(Map destination) {

    }
}
