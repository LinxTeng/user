package com.hoho.alipay;

public class AlipayClientFactory {
    /*
     * private static final String OPEN_GATEWAY = "https://openapi.alipay.com/gateway.do";
     * 
     * private static ConcurrentHashMap<String, AlipayClient> alipayClientMap = new ConcurrentHashMap<>();
     * 
     * 
     * public static AlipayClient getAlipayClient(String appId, String appPriKey, String zfbPubKey) { if
     * (StringUtils.isEmpty(appId)) { return null; } AlipayClient alipayClient = null; if (alipayClientMap.containsKey(appId)) {
     * alipayClient = alipayClientMap.get(appId); } else { synchronized (AlipayClientFactory.class) { if
     * (alipayClientMap.containsKey(appId)) { alipayClient = alipayClientMap.get(appId); } else { alipayClient = new
     * DefaultAlipayClient(OPEN_GATEWAY, appId, appPriKey, "JSON", "utf-8", zfbPubKey, "RSA"); alipayClientMap.put(appId,
     * alipayClient); } } } return alipayClient; }
     */
}
