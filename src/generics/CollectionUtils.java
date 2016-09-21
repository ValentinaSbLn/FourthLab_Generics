package generics;

import java.util.*;

/**
 * Created by Valentina on 21.09.2016.
 */
public class CollectionUtils {
    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
            return new ArrayList<>();
    }

    public static <T>int indexOf(List<? extends T> source, T t) {
        return source.indexOf(t);
    }
//
    public static <T>List <T>limit(List<? extends T> source, int size) {
        List<T> list=new ArrayList<>();
        int limit=size<=source.size() ? size : source.size();
            for (int i = 0; i < limit; i++)
                list.add(source.get(i));
            return list;

    }
//
    public static <T>void add(List<? super T> source, T t) {
        source.add(t);
    }

    public static <T>void removeAll(List <? super T> removeFrom, List <? extends T> c2) {
        for (int i=0; i<c2.size(); i++){
            for (int j=0; j<removeFrom.size(); j++){
                if (c2.get(i).equals(removeFrom.get(j))){
                    removeFrom.remove(j);
                }
            }
        }
    }
//
    public static <T>boolean containsAll(List <? extends T> c1, List <? extends T> c2) {
       return c1.containsAll(c2);
    }
//
    public static <T>boolean containsAny(List <? extends T> c1, List <? extends T> c2) {
        for (T t: c2){
           if (c1.contains(t))
               return true;
        }
        return false;
    }

    public static <T extends Number> List<T> range(List <? extends T>  list, T min, T max) {
        List<T> sortList = new ArrayList<T>();
        sortList.addAll(list);
        Set<T>sort=new HashSet<>();
        for (T t: list)
        sort.add(t);

        Collections.sort(list, new Comparator<T>() {
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        });

    }


    public static <T>List <T>range(List <? extends T> list, T min, T max, Comparator <? super T>comparator) {


        List<T> sortList = new ArrayList<T>();
        sortList.addAll(list);
        Collections.sort(sortList, comparator);
        System.out.println("sortlist_range "+Arrays.toString(sortList.toArray()));
        System.out.println("list_range "+Arrays.toString(list.toArray()));
        int minIndex=sortList.indexOf(min);
        int maxIndex = sortList.indexOf(max);
        System.out.println(minIndex+" "+maxIndex);
        List<T> resultList = new ArrayList<T>();
        for (int i=minIndex; i<=maxIndex; i++){
            resultList.add(sortList.get(i));
        }
        return resultList;

    }

    public static void main(String[] args) {
        CollectionUtils test=new CollectionUtils();
//        List<String> s1=new ArrayList<>();
//        s1.add("1");
//        s1.add("1");
//        List<String> s2=new ArrayList<>();
//        test.addAll(s1,s2);
//        for (String s: s2)
//        System.out.println(s);

        List<Integer> list=test.newArrayList();

        list.add(1);
        list.add(2);
        list.add(5);
        list.add(null);

        List<Integer>list2;
        list2=limit(list, 2);


//        System.out.println(test.indexOf(s1, "3"));
//        System.out.println(s1.indexOf("3"));
        add(list, 8);

        System.out.println("Contains:"+containsAll(list, list2) );

        System.out.println(Arrays.toString(list2.toArray()));
        System.out.println("before "+Arrays.toString(list.toArray()));

        removeAll(list, list2);
        System.out.println("after "+Arrays.toString(list.toArray()));

        System.out.println("Contains: "+containsAll(list, list2) );
        add(list2, 6);
        add(list, 4);
        add(list, 7);
        add(list, 2);
        list.remove(null);
        System.out.println("list "+Arrays.toString(list.toArray()));
        System.out.println("list2 "+Arrays.toString(list2.toArray()));
        System.out.println("ContainsAny: "+containsAny(list, list2));
        Comparator<Integer> t= new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        List list3=range(Arrays.asList(8,1,3,5,6, 4), 3, 6,t) ;
        System.out.println("list "+Arrays.toString(list.toArray()));
        System.out.println("list3 "+Arrays.toString(list3.toArray()));

    }
}

