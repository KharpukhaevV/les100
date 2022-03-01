import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountMapIml<K> implements CountMap<K>{

    private List<K> keys = new ArrayList<>();
    private List<Integer> elements = new ArrayList<>();

    public List<K> getKeys() {
        return keys;
    }

    public List<Integer> getElements() {
        return elements;
    }

    @Override
    public void add(K o) {
        if(!keys.contains(o)){
            keys.add(o);
            elements.add(1);
        }
        else {
            int count = elements.get(keys.indexOf(o));
            count++;
            elements.set(keys.indexOf(o), count);
        }
    }

    @Override
    public int getCount(Object o) {
        return elements.get(keys.indexOf(o));
    }

    @Override
    public int remove(Object o) {
        int included = elements.get(keys.indexOf(o));
        elements.remove(keys.indexOf(o));
        keys.remove(o);
        return included;
    }

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public void addAll(CountMap source) {
        CountMapIml<K> s = (CountMapIml) source;
        for (K k : s.getKeys()) {
            if (!this.getKeys().contains(k)) {
                this.getKeys().add(k);
                this.getElements().add(1);
            }
            else {
                int count = s.getElements().get(s.getKeys().indexOf(k));
                count += this.getElements().get(this.getKeys().indexOf(k));
                elements.set(this.getKeys().indexOf(k), count);
            }
        }
    }

    @Override
    public Map toMap() {
        Map<K, Integer> map = new HashMap<>();
        for (K k : this.getKeys()) {
            map.put(k, this.getElements().get(this.keys.indexOf(k)));
        }
        return map;
    }

    @Override
    public void toMap(Map destination) {
        for (K k : this.getKeys()) {
            destination.put(k, this.getElements().get(this.keys.indexOf(k)));
        }
    }
}
