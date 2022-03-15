package service;

import annotation.Cache;

public interface Service {
    @Cache(fileNamePrefix = "data1", identityBy = {String.class})
    Object doWork(Object... args);
}
