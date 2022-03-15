package service;

import java.util.Random;

public class ListServiceImpl implements Service {
    @Override
    public Object doWork(Object... args) {
        int length = (Integer) args[0];
        int range = (Integer) args[1];
        int[] arr = new int[length];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(range + 1);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return arr;
    }
}
