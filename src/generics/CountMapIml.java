package generics;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by Valentina on 20.09.2016.
 */
public class CountMapIml<E> implements CountMap<E>{

    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] DEFAULT_ELEMENTDATA = new Object[0];
    //private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = new Object[0];
    Object[] elementData;
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
        System.out.println(this.elementData[0]);
        for (int i = 0; i < this.size; i++) {
            if (this.elementData[i].equals(e)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int remove(E e) {
        this.rangeCheck(var1);
        ++this.modCount;
        Object var2 = this.elementData(var1);
        int var3 = this.size - var1 - 1;
        if(var3 > 0) {
            System.arraycopy(this.elementData, var1 + 1, this.elementData, var1, var3);
        }

        this.elementData[--this.size] = null;
        return var2;
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

private void growArray(int var1) {
    if(this.elementData == DEFAULT_ELEMENTDATA) {
        var1 = Math.max(10, var1);
    }

    if(var1 - this.elementData.length > 0) {
        int var2 = this.elementData.length;
        int var3 = var2 + (var2 >> 1);
        if(var3 - var1 < 0) {
            var3 = var1;
        }



        this.elementData = Arrays.copyOf(this.elementData, var3);
    }

}



    private static int hugeCapacity(int var0) {
        if(var0 < 0) {
            throw new OutOfMemoryError();
        } else {
            return var0 > 2147483639?2147483647:2147483639;
        }
    }

}
