package com.wesley.spring.reactive;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  由于加载过程串行执行的关系，导致消耗实现线性累加。Blocking 模式即串行执行
 * </p>
 *
 * @author Created by Yani on 2019/12/11
 */
public class DataLoader {

    public final void load() {
        // 开始时间
        long startTime = System.currentTimeMillis();
        // 具体执行
        doLoad();
        // 消耗时间
        long costTime = System.currentTimeMillis() - startTime;
        System.out.println("load() 总耗时：" + costTime + " 毫秒");
    }

    protected void doLoad() { // 串行计算
        loadConfigurations(); // 耗时 1s
        loadUsers(); // 耗时 2s
        loadOrders(); // 耗时 3s
    }

    protected final void loadConfigurations() {
        loadMock("loadConfigurations()", 1);
    }
    protected final void loadUsers() {
        loadMock("loadUsers()", 2);
    }
    protected final void loadOrders() {
        loadMock("loadOrders()", 3);
    }


    private void loadMock(String source, int seconds) {
        try {
            long startTime = System.currentTimeMillis();
            long milliseconds = TimeUnit.SECONDS.toMillis(seconds);
            Thread.sleep(milliseconds);
            long costTime = System.currentTimeMillis() - startTime;
            System.out.printf("[线程 : %s] %s 耗时 : %d 毫秒\n",
                              Thread.currentThread().getName(), source, costTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new DataLoader().load();
    }


}
