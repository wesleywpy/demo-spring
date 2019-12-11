package com.wesley.spring.reactive;

import java.util.concurrent.CompletableFuture;

/**
 * <p>
 *  链式 Future
 * </p>
 *
 * @author Created by Yani on 2019/12/11
 */
public class ChainDataLoader extends DataLoader{

    /**
     * CompletableFuture 属于异步操作，但是强制等待结束的话，又回到了阻塞编程的方式
     */
    protected void doLoad() {
        // main -> submit -> ...
        // sub-thread : F1 -> F2 -> F3
        CompletableFuture
                .runAsync(super::loadConfigurations)
                .thenRun(super::loadUsers)
                .thenRun(super::loadOrders)
                .whenComplete((result, throwable) -> {
                    // 完成时回调
                    System.out.println("[线程 : " + Thread.currentThread().getName() + "] 加载完成");
                })
                .join(); // 等待完成
    }

    public static void main(String[] args) {
        new ChainDataLoader().load();
    }
}
