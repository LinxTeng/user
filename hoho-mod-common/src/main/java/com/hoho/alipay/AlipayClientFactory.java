package com.hoho.alipay;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.util.StringUtils;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

public class AlipayClientFactory {

    private static final String OPEN_GATEWAY = "https://openapi.alipay.com/gateway.do";

    private static ConcurrentHashMap<String, AlipayClient> alipayClientMap = new ConcurrentHashMap<>();

    private static final Object lockObject = new Object();

    public static AlipayClient getAlipayClient(String appId, String appPriKey, String zfbPubKey) {
        if (StringUtils.isEmpty(appId)) {
            return null;
        }
        AlipayClient alipayClient = null;
        if (alipayClientMap.containsKey(appId)) {
            alipayClient = alipayClientMap.get(appId);
        } else {
            synchronized (lockObject) {
                if (alipayClientMap.containsKey(appId)) {
                    alipayClient = alipayClientMap.get(appId);
                } else {
                    alipayClient = new DefaultAlipayClient(OPEN_GATEWAY, appId, appPriKey, "JSON", "utf-8", zfbPubKey, "RSA");
                    alipayClientMap.put(appId, alipayClient);
                }
            }
        }
        return alipayClient;
    }
}
