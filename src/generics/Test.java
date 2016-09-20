package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valentina on 20.09.2016.
 */
public class Test {


    public static void main(String[] args) {
        //CountMap<Integer> map = new CountMapIml<Integer>();
        CountMap<Integer> map = new CountMapItem<Integer>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);



        int count1 = map.getCount(6); // 1
        int count2 = map.getCount(10); // 3*/
        int count4=map.getCount(9);
        int count = map.getCount(5); // 2

        System.out.println(count+" "+count1+" "+count2+" "+count4);


//        List<Integer> f=new ArrayList<>();
//
//        System.out.println(f.add(8));
    }


}
