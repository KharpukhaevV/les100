import cache.CacheProxy;
import service.Service;
import service.ListServiceImpl;

public class Main {
    public static void main(String[] args) {
        CacheProxy cacheProxy = new CacheProxy();

        Service listService = cacheProxy.cache(new ListServiceImpl());

        listService.doWork(10, 100);
        listService.doWork(5, 20);
        listService.doWork(15, 10);
        listService.doWork(10, 100);
    }
}
