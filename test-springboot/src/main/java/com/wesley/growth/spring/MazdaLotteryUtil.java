package com.wesley.growth.spring;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * LotteryUtil
 *
 * @author WangPanYong
 * @since 2020/11/02 11:01
 */
public class MazdaLotteryUtil {

    private final RestTemplate restTemplate = new RestTemplate();

    private final HttpHeaders headers = new HttpHeaders();

    private final List<String> keyIds = new ArrayList<>();

    private int count = 0;

    private static final int TIMES = 50;

    {
        headers.set("Accept", "application/json, text/plain, */*");
        headers.set("Accept-Language", "zh-CN,zh;q=0.9");
        headers.set("Content-Type", "application/x-www-form-urlencoded");
        headers.set("User-Agent", "Mozilla/5.0 (Linux; Android 9; V1809A) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.110 Mobile Safari/537.36");
        headers.set("Host", "iclient.pingan.com.cn");
        headers.set("Origin", "https://b.pingan.com.cn");
        headers.set("Referer", "https://b.pingan.com.cn/");

        keyIds.add("13f38b9965b375797ddaf9535b9d676a"); // 2020年11月4日10:01:44
        keyIds.add("b054d6fce89edd7828ee62567e41ae24"); // 2020年11月4日10:16:44
        keyIds.add("4dd76191c5d89fe614affd5fba494da1"); // 2020年11月4日10:20:44
    }

    public void drawLottery() {
        if (count > TIMES) {
            System.out.println(" ====> 已经执行 "+ TIMES + " 次, 退出程序...");
            return;
        }

        try {
            URI uri = new URI("https://iclient.pingan.com.cn/lum/stp/cust/cfss-pocket-loan/intopieces/lottery/drawLottery.do");
            String params = "activityId=4d8c7a8cd21f0204d607dcddf51d7c3d&keyId=%s";
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            while (count < TIMES) {
                for (String keyId : keyIds) {
                    String body = String.format(params, keyId);
                    RequestEntity<String> request = new RequestEntity<>(body, headers, HttpMethod.POST, uri);
                    ResponseEntity<String> response = restTemplate.exchange(request, String.class);
                    String msg = " ====> " + format.format(new Date()) + " : " + response.getBody();
                    System.out.println(msg);
                }
                count++;
                TimeUnit.SECONDS.sleep(3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args)  {
        MazdaLotteryUtil util = new MazdaLotteryUtil();
        util.drawLottery();
    }
}
