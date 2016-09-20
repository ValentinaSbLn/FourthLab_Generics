package generics;

import java.util.*;

/**
 * Created by Valentina on 20.09.2016.
 */
public class CountMapIml<E> implements CountMap<E>{

    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] DEFAULT_ELEMENTDATA = new Object[0];
    //private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = new Object[0];
    private Object[] elementData;
    private int size;

    public CountMapIml() {
        this.elementData = DEFAULT_ELEMENTDATA;
    }

    @Override
    public void add(E e) {
        this.growArray(this.size + 1);
        this.elementData[this.size++] = e;
    }

    @Override
    public int getCount(E e) {


        int count = 0;
        for (int i = 0; i < this.size; i++) {
            if (this.elementData[i]==null){
               if (e==null)
                count++;
            }else if (this.elementData[i].equals(e)) {
                count++;
            }
        }
       return count;
    }

    @Override
    public int remove(E e) {
        int beforeRemote=this.getCount(e);
        System.out.println("befor "+Arrays.toString(elementData));

        if(e == null) {
            for(int i = 0; i < this.size; i++) {
                if(this.elementData[i] == null) {

                    int numItem = this.size - i - 1;
                    if(numItem > 0) {
                        System.arraycopy(this.elementData, i + 1, this.elementData, i, numItem);
                    }

                    this.elementData[--this.size] = null;
                    System.out.println("after "+Arrays.toString(elementData));
                    return beforeRemote;

                }
            }
        } else {
            for (int i = 0; i < this.size; i++) {
                if (e.equals(this.elementData[i])) {
                    int numItem = this.size - i - 1;
                    if (numItem > 0) {
                        System.out.println("Зашли");
                        System.arraycopy(this.elementData, i + 1, this.elementData, i, numItem);
                    }
                    this.elementData[--this.size] = null;
                    System.out.println("after "+Arrays.toString(elementData));
                    return beforeRemote;
                }
            }
        }
        System.out.println("after "+Arrays.toString(elementData));
        return beforeRemote;
    }

    @Override
    public int size() {
        int count=0;

        Set<Object> sizeCountMap=new HashSet<>();
        for (int i=0; i<this.size; i++){
            sizeCountMap.add(this.elementData[i]);
        }
        return sizeCountMap.size();
    }

    @Override
    public Map<E, Integer> toMap() {
        Map<E, Integer> map=new HashMap<>();
        for (int i=0; i<this.size(); i++){
            System.out.println("#"+i+" "+(E) this.elementData[i]);
            map.put((E) this.elementData[i], (map.containsKey(this.elementData[i])) ? map.get(this.elementData[i]) + 1 : 1);
        }
        return map;
    }


    @Override
    public void addAll(CountMap source) {

    }

//    @Override
//    public Map<E, Integer> toMap() {
//        Map<E, Integer> map=new HashMap<>();
//        for (int i=0; i<this.size(); i++){
//            map.put(this.elementData[i], (map.containsKey(this.elementData[i])) ? map.get(this.elementData[i]) + 1 : 1);
//        }
//        return map;
//    }

    @Override
    public void toMap(Map<E,Integer> destination) {
        for (int i=0; i<this.size(); i++){
            destination.put((E) this.elementData[i], (destination.containsKey(this.elementData[i])) ? destination.get(this.elementData[i]) + 1 : 1);
        }
    }

    private void growArray(int var1) {
        if (this.elementData == DEFAULT_ELEMENTDATA) {
            var1 = Math.max(10, var1);
        }
        if (var1 - this.elementData.length > 0) {
            int var2 = this.elementData.length;
            int var3 = var2 + (var2 >> 1);
            if (var3 - var1 < 0) {
                var3 = var1;
            }
            this.elementData = Arrays.copyOf(this.elementData, var3);
        }
    }




}
