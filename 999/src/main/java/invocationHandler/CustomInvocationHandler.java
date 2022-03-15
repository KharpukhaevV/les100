package invocationHandler;

import annotation.Cache;
import cache.CacheObject;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomInvocationHandler implements InvocationHandler {
    private final Object delegate;

    public CustomInvocationHandler(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        method.setAccessible(true);
        Cache cache = method.getAnnotation(Cache.class);
        List<String> arguments = new ArrayList<>();
        Object[] temp = (Object[]) args[0];

        for (int i = 0; i < temp.length; i++) {
            arguments.add(temp[i].toString());

        }

        String fileName;

        fileName = arguments.get(0);

        if (CacheObject.getResults().containsKey(arguments)) {
            result = CacheObject.getResults().get(arguments);
        } else {
            result = method.invoke(delegate, args);
            CacheObject.addResults(arguments, result);
            FileOutputStream fos = new FileOutputStream(new File(fileName));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            CacheObject cacheObject = new CacheObject();
            oos.writeObject(cacheObject);
            oos.close();
            fos.close();
        }



        return result;
    }
}
