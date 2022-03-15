package cache;

import invocationHandler.CustomInvocationHandler;

import java.lang.reflect.Proxy;

public class CacheProxy {
    public <T> T cache(T obj) {
        return (T) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(),
                new Class[]{obj.getClass().getInterfaces()[0]},
                new CustomInvocationHandler(obj));
    }
}
