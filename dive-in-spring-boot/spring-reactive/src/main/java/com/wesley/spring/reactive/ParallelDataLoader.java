package com.wesley.spring.reactive;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2019/12/11
 */
public class ParallelDataLoader extends DataLoader{

    /**
     * 明显地，程序改造为并行加载后，性能和资源利用率得到提升，消耗时间取最大者。
     *
     * 并行计算
     * 总耗时 max(1s, 2s, 3s) >= 3s
     */
    protected void doLoad() {
        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletionService completionService = new ExecutorCompletionService(executorService);
        // 耗时 >= 1s
        completionService.submit(super::loadConfigurations, null);
        // 耗时 >= 2s
        completionService.submit(super::loadUsers, null);
        // 耗时 >= 3s
        completionService.submit(super::loadOrders, null);
        int count = 0;
        while (count < 3) { // 等待三个任务完成
            if (completionService.poll() != null) {
                count++;
            }
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {
        new ParallelDataLoader().load();
    }

}
