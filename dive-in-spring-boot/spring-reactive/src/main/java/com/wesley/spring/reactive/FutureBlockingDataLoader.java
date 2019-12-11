package com.wesley.spring.reactive;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * <p>
 * 理解 {@link Future#get()} 问题
 * </p>
 *
 * @author Created by Yani on 2019/12/11
 */
public class FutureBlockingDataLoader extends DataLoader{

    protected void doLoad() {
        ExecutorService executorService = Executors.newFixedThreadPool(3); // 创建线程池
        runCompletely(executorService.submit(super::loadConfigurations));
        runCompletely(executorService.submit(super::loadUsers));
        runCompletely(executorService.submit(super::loadOrders));
        executorService.shutdown();
    }

    /**
     * {@link Future#get()} 方法不得不等待任务执行完成，
     * 换言之，如果多个任务提交后，返回的多个 Future 逐一调用  get() 方法时，将会依次 blocking，任务的执行从并行变为串行。
     */
    private void runCompletely(Future<?> future) {
        try {
            future.get();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        new FutureBlockingDataLoader().load();
    }

}
