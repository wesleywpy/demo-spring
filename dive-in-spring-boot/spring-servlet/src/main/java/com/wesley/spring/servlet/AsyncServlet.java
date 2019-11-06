package com.wesley.spring.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Created by Wesley on 2019/11/06
 */
@WebServlet(urlPatterns = "/async-servlet", asyncSupported = true)
public class AsyncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.isAsyncSupported()) {
            AsyncContext asyncContext = req.startAsync();
            // 超时时间
            asyncContext.setTimeout(10);
            asyncContext.addListener(new AsyncListener() {
                @Override
                public void onComplete(AsyncEvent asyncEvent) throws IOException {
                    println("执行完成");
                }

                @Override
                public void onTimeout(AsyncEvent asyncEvent) throws IOException {
                    println("执行超时");
                }

                @Override
                public void onError(AsyncEvent asyncEvent) throws IOException {
                    println("执行错误");
                }

                @Override
                public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
                    println("开始执行");
                }
            });
            println("Hello...");
            ServletResponse servletResponse = asyncContext.getResponse();
            // 设置响应媒体类型
            servletResponse.setContentType("text/plain;charset=UTF-8");
            // 获取字符输出流
            PrintWriter writer = servletResponse.getWriter();
            writer.println("Hello,World");
            writer.flush();
        }
    }

    private static void println(Object object) {
        String threadName = Thread.currentThread().getName();
        System.out.println("AsyncServlet [" + threadName + "] : " + object);
    }
}
