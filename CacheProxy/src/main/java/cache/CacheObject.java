package cache;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheObject implements Serializable {
    private static final Map<List<String>, Object> results = new HashMap<>();

    public static Map<List<String>, Object> getResults() {
        return results;
    }

    public static void addResults(List<String> parameters, Object result) {
        results.put(parameters,result);
    }

    @Override
    public String toString() {
        return "CacheData{ works=" + results +
                '}';
    }
}
