import java.util.Map;

public interface CountMap<K extends Object> {
    void add(K o);

    int getCount(K o);

    int remove(K o);

    int size();

    void addAll(CountMap source);

    Map toMap();

    void toMap(Map destination);
}
