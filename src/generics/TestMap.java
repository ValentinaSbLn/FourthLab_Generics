package generics;

import java.util.Map;

/**
 * Created by Valentina on 21.09.2016.
 */
public class TestMap {
    public static void main(String[] args) {
        CountMap<Integer> map = new CountMapIml<>();

        CountMap<Integer> mapAdd = new CountMapIml<>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        mapAdd.add(2);
        mapAdd.add(5);
        mapAdd.add(5);

        int count = map.getCount(5); // 2
        int count1 = map.getCount(6); // 1
        int count2 = map.getCount(10);// 3

        System.out.println("getCount: "+count+" "+count1+" "+count2);

        int del = map.remove(6); //1
        int del2 = map.remove(7); //0
        System.out.println("remove: "+del+" "+del2);

        System.out.println("size: "+map.size());

        map.addAll(mapAdd);

        Map<Integer, Integer>mapToMap=map.toMap();

        mapToMap.put(3,8);
        mapToMap.put(0,7);
        mapToMap.put(11,40);

        for (Integer s : mapToMap.keySet())
            System.out.println("map.toMap()+put: ("+s + ": " + mapToMap.get(s)+")");

        map.toMap(mapToMap);

               for (Integer s : mapToMap.keySet())
            System.out.println("toMap(mapToMap): ("+s + ": " + mapToMap.get(s)+")");


    }





}
