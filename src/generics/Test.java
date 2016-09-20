package generics;

import java.util.*;

/**
 * Created by Valentina on 20.09.2016.
 */
public class Test {


    public static void main(String[] args) {
        CountMap<Integer> map = new CountMapIml<Integer>();
        //CountMap<Integer> map = new CountMapItem<Integer>();
        List <String> list=new ArrayList<>();
        list.add("3");
        list.add("2");
        list.add("5");
        list.add("1");
        list.add("5");
        list.add("5");
        list.add("2");
        list.add(null);
        System.out.println(Arrays.toString(list.toArray()));
        list.remove("2");
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.size());

//        int intr=list.get(0);
//        System.out.println(intr);
      //  map.add(null);
        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);
        map.add(null);
        map.add(null);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);
        map.add(7);





//        int count1 = map.getCount(6); // 1
//        int count2 = map.getCount(10); // 3*/
//        int count4=map.getCount(9);
//        int count = map.getCount(5); // 2
//        int rem=map.remove(5);
        int nullnum=map.getCount(null);
        int size=map.size();
        System.out.println(nullnum);
        Map<Integer, Integer> a=map.toMap();
        for (Integer s : a.keySet())
            System.out.println(s + ": " + a.get(s));

        // System.out.println(rem);
       // System.out.println(count+" "+count1+" "+count2+" "+count4+" rem "+rem);


//        List<Integer> f=new ArrayList<>();
//
//        System.out.println(f.add(8));
    }


}
