package generics;

import java.util.*;

/**
 * Created by Valentina on 21.09.2016.
 */
public class CollectionUtils {

    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<T>();
    }

    public static <T> int indexOf(List<? extends T> source, T t) {
        return source.indexOf(t);
    }

    public static <T> List<T> limit(List<? extends T> source, int size) {
        List<T> list = new ArrayList<>();
        int limit = size <= source.size() ? size : source.size();
        for (int i = 0; i < limit; i++)
            list.add(source.get(i));
        return list;
    }

    public static <T> void add(List<? super T> source, T t) {
        source.add(t);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        for (int i = 0; i < c2.size(); i++) {
            for (int j = 0; j < removeFrom.size(); j++) {
                if (c2.get(i).equals(removeFrom.get(j))) {
                    removeFrom.remove(j);
                }
            }
        }
    }

    public static <T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    public static <T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        for (T t : c2) {
            if (c1.contains(t))
                return true;
        }
        return false;
    }


    public static <T extends Comparable<? super T>> List<T> range(List<T> list, T min, T max) {

        List<T> sortList = new ArrayList<T>();
        sortList.addAll(list);

        Collections.sort(sortList, new Comparator<T>() {
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        });
        if (min.compareTo(max) > 0) {
            T temp = max;
            max = min;
            min = temp;
        }
        int minIndex = sortList.indexOf(min);
        int maxIndex = sortList.indexOf(max);

        if (minIndex == -1) {
            for (int i = 0; i < sortList.size() - 1; i++) {
                if (min.compareTo(sortList.get(0)) < 0) {
                    minIndex = 0;
                } else if (min.compareTo(sortList.get(i)) > 0 && min.compareTo(sortList.get(i + 1)) < 0)
                    minIndex = i + 1;
            }
        }
        if (maxIndex == -1) {
            for (int i = 0; i < sortList.size() - 1; i++) {
                if (max.compareTo(sortList.get(sortList.size() - 1)) > 0) {
                    maxIndex = sortList.size() - 1;
                } else if (max.compareTo(sortList.get(i)) > 0 && max.compareTo(sortList.get(i + 1)) < 0)
                    maxIndex = i;
            }
        }

        List<T> resultList = new ArrayList<T>();

        if (minIndex != -1 && maxIndex != -1) {
            for (int i = minIndex; i <= maxIndex; i++) {
                resultList.add(sortList.get(i));
            }
        }
        return resultList;
    }


    public static <T> List<T> range(List<? extends T> list, T min, T max, Comparator<? super T> comparator) {

        List<T> sortList = new ArrayList<T>();
        sortList.addAll(list);

        Collections.sort(sortList, comparator);

        if (comparator.compare(min, max) > 0) {
            T temp = max;
            max = min;
            min = temp;
        }
        int minIndex = sortList.indexOf(min);
        int maxIndex = sortList.indexOf(max);

        if (minIndex == -1) {
            for (int i = 0; i < sortList.size() - 1; i++) {
                if (comparator.compare(min, sortList.get(0)) < 0) {
                    minIndex = 0;
                } else if (comparator.compare(min, sortList.get(i)) > 0 && comparator.compare(min, sortList.get(i + 1)) < 0)
                    minIndex = i + 1;
            }
        }
        if (maxIndex == -1) {
            for (int i = 0; i < sortList.size() - 1; i++) {
                if (comparator.compare(max, sortList.get(sortList.size() - 1)) > 0) {
                    maxIndex = sortList.size() - 1;
                } else if (comparator.compare(max, sortList.get(i)) > 0 && comparator.compare(max, sortList.get(i + 1)) < 0)
                    maxIndex = i;
            }
        }

        List<T> resultList = new ArrayList<T>();
        if (minIndex != -1 && maxIndex != -1) {
            for (int i = minIndex; i <= maxIndex; i++) {
                resultList.add(sortList.get(i));
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        List<String> str1 = Arrays.asList("a","b");//a, b

        List<String> str2 = new ArrayList<>(); //c, d
        str2.add("c");
        str2.add("d");

        addAll(str1, str2);
        System.out.print("addAll(str1, str2):");
        for (String s:str2)
            System.out.print(s+" ");

        System.out.print("\nIndexOf \"a\":"+indexOf(str2, "a"));

        List<String>str3=limit(str2, 3); //c,d, a
        System.out.print("\nlimit(str2, 3):");
        for (String s:str3)
            System.out.print(s+" ");

        add(str3,"e");
        System.out.print("\nadd(str3,\"e\"):");
        for (String s:str3)
            System.out.print(s+" ");

        removeAll(str3, str1); // из [c d a e]  удалить [a b]
        System.out.print("\nremoveAll(str3, str1);");
        for (String s:str3)
            System.out.print(s+" ");

        System.out.println("\n"+containsAll(str3, str2)); //str3: c d a, str2: c d a b
        System.out.println(containsAny(str3, str2));

        List<String> str4=range(str2, "a","c"); //str2: c d a b
        System.out.print("range(str2, \"a\",\"c\"): ");
        for (String s:str4)
            System.out.print(s+" ");

        List<Integer>list=range(Arrays.asList(8,1,3,5,6, 4), -5, 5);
        System.out.println("\n"+Arrays.toString(list.toArray()));

    }
}

