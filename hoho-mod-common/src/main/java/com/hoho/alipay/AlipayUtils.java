package com.hoho.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayMarketingCardTemplateQueryRequest;
import com.alipay.api.response.AlipayMarketingCardTemplateQueryResponse;
import com.hoho.tools.JsonConsole;

public class AlipayUtils {
    AlipayClient alipayClient;

    String authToken;

    // 程序入口
    public static void main(String[] args) {
        AlipayUtils alipayUtils = new AlipayUtils();
        alipayUtils.queryShopCard();
    }

    /*
     * 查询商户设置的支付宝卡
     */
    public void queryShopCard() {
        String templateId = "20171207000000000671142000300708";
        // 请求参数
        AlipayMarketingCardTemplateQueryRequest request = new AlipayMarketingCardTemplateQueryRequest();
        request.setBizContent("{\"template_id\":\"" + templateId + "\"}");
        try {
            AlipayMarketingCardTemplateQueryResponse response = alipayClient.execute(request, null, authToken);
            System.out.println(JsonConsole.format(response.getBody()));
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
    }


    // 初始化支付宝参数
    AlipayUtils() {
        // 对应alipay_app的app_id字段
        String appId = "2017090808613465";
        // 对应alipay_app表的app_pri_key;
        String appPriKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKpl+Or6F0/ullmTIzQkdu7a8xAFuONW2OMVUgAoSqsKWuSQVMViBpMUTtidY4sFOHD+gLN5vA7vj1rbp58dRGTkZTRrw1MMWPPZlRLM/8Op3ZcxnDCi0o93BQWoYZ6oeo8PFKgXTvH+LFRzJGGbP7+tq6FSswqp4snod1PTt1HvAgMBAAECgYA51x9lc7sSEOTMRxu+CVqtvXigSbD2ynYYrxYEo6ik4oDz8OI1lg6xQkV5VgOCHyWHhXxeb8YcM8kviDwf0Kl0HuDeOX3qNOH52i6fNFmGVUVKeHDzBDYo0qbllw7o/CgJFA2usRUaSayMNKT3FvgiWSIOvr5JqVmjCsAFUzkcAQJBAO50fUlp8VcR0u6IsyYaPLHHq9YLHlMiMyIOae4BYLo6pgCiTnf0TlRjD8b1Mn5mxB3Vb3UothO1VxQWE1UXiwECQQC275MuFduoS4oBKSB8kBv8BoxOqWevWaxBQ+/rNXSx6iQRG5LUc/DBe4AtN9FfL9PYg7trR7gh3aw5ujSauIzvAkAKLFYcB7UQLeZ93r8l5QCp5Qbjvt2wVkkwLsU+LjjeORpT9Ji8bWPaHc/SgSuCUQgU7cIvkWkTNi1c4gQ5ISQBAkEAsYxuZaEzUvEV3TCEZkEb2Aym6sXCa072P1Xnqnp0ayUbojsH1Ak/Fxp9eeWd4OuziYW5RlMSZFQYjuKpoa0SowJBAJgfoi8HCxF5ti+luCi05fUG2TKK21slw8QwTu3ANUQOauMkPaXu9pn6n5cStBiE9BE9fx/ic5WguZtk/yPJLHs=";
        // 对应alipay_app表的zfb_pub_key;
        String zfbPubKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";
        this.alipayClient = AlipayClientFactory.getAlipayClient(appId, appPriKey, zfbPubKey);

        // 对应alipay_app_oauth表的app_auth_token
        this.authToken = "201711BB533c8d01f241456fa6dcbce27f5e6D41";
    }
}
