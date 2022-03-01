import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CountMap<Integer> map = new CountMapIml<>();
        CountMap<Integer> map2 = new CountMapIml<>();
        map.add(10);
        map.add(10);
        map.add(10);
        map.add(15);
        map.add(11);
        map.add(11);
        map.add(12);
        map.add(12);
        map2.add(12);
        map2.add(12);
        map2.add(12);
        map2.add(13);

        System.out.println("Количество вхождений 10 - " + map.getCount(10));
        System.out.println("Количество вхождений 11 - " + map.getCount(11));
        System.out.println("Количество вхождений 12 - " + map.getCount(12));
        System.out.println("Количество вхождений 15 - " + map.getCount(15));
        System.out.println("Размер map - " + map.size());
        System.out.println("Удаление 10, количество вхождений до удаления - " + map.remove(10));
        System.out.println("Размер map - " + map.size());
        System.out.println("Добавляем map2 в map");
        map.addAll(map2);
        System.out.println("Размер map - " + map.size());
        System.out.println("Количество вхождений 12 - " + map.getCount(12));
        System.out.println("Перевод в Map - " + map.toMap());

        Map<Integer, Integer> newMap = new HashMap<>();
        map2.toMap(newMap);
        System.out.println(newMap);
    }
}
