package com.wesley.spring.servlet;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Random;
import java.util.concurrent.*;

/**
 * <p>
 * 异步操作
 * </p>
 *
 * @author Created by Yani on 2019/11/05
 */
@RestController
@EnableScheduling
public class HelloWorldAsyncController {

    private final BlockingQueue<DeferredResult<String>> queue = new ArrayBlockingQueue<>(5);

    private final Random random = new Random();

    @Scheduled(fixedRate = 5000)
    public void process() throws InterruptedException {
        DeferredResult<String> result = null;
        do {
            result = queue.take();
            // 随机超时时间
            long timeout = random.nextInt(100);
            // 模拟等待时间, RPC请求 或 DB查询
            Thread.sleep(timeout);
            // 添加结果
            result.setResult("Hello, World");
            println("执行计算结果，消耗：" + timeout + " ms.");
        } while (result != null);
    }

    @GetMapping("/hello")
    public DeferredResult<String> hello() {
        DeferredResult<String> result = new DeferredResult<>(50L);

        // 入队
        queue.offer(result);
//        println("Hello!");
        result.onCompletion(() -> {
            println("执行结束");
        });

        result.onTimeout(() -> {
            println("执行超时");
        });

        return result;
    }

    /**
     * Callable 接口实现异步操作
     */
    @GetMapping("/hello-callable")
    public Callable<String> callableHello() {
        long startTime = System.currentTimeMillis();

        println("Hello...");
        return () -> {
            long costTime = System.currentTimeMillis() - startTime;
            println("执行计算结果，消耗：" + costTime + " ms.");
            return "Hello, World!";
        };
    }

    /**
     * java8 CompletionStage 接口实现异步操作
     */
    @GetMapping("/hello-completion")
    public CompletionStage<String> completionStage() {
        long startTime = System.currentTimeMillis();
        println("Hello...");

        return CompletableFuture.supplyAsync(() -> {
            long costTime = System.currentTimeMillis() - startTime;
            println("执行计算结果，消耗：" + costTime + " ms.");
            return "Hello, World!";
        });
    }

    private static void println(Object object) {
        String threadName = Thread.currentThread().getName();
        System.out.println("HelloWorldAsyncController[" + threadName + "]: " + object);
    }

}
