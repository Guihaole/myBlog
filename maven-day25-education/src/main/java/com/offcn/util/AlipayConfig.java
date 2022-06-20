package com.offcn.util;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000119628156";
    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCvuDRwUss5K93xKnrSw+i502B4nG8N8xk7aSvk1nAfDdz1pPt6lDBN1HP+6NFMuutaSj7LU9mJrG5NJNVaKGv9UQONyXF3uNv240RHVCHKbex7roLQMv+XZDEGvZ63JlqfEQe7+g6sWa7/PRTGD/xBHzQDRqP8H2b3N3mnzVER2zztUNJ4XfJSBpV4EvCmFO2/QlgKhvftbBxdmQ2dM6HbCRZUGwUmxSVAYyAlLonmcL/hTrQMI4PbIcMFdwaf9mGnBTxubhVvExqNkTU8o0qk3jUXRiDWrFNmO7DGzqIbXlV97p1RYZgYAYvuTiOQCwGXg0JPoyR3xPWrUqkxhTn3AgMBAAECggEAalhyLBR/d59L1/vcj5gPTf9WYEhUkb2xZJpW/UymWLT8KBJsPBhZT5Enjnt6yBRMAb3zWPzrJ/4aV0fWc5UJHiscmn/y0wEm5rlOhlithqSWPZg1BSoIM6hoX2r9Flz49VHKO4KvxLEWTtS5sNDV2te2k9D5x8l9eFqzntGMod/pHKWBfdakMVodrAF1DDAkUFj4IMVEZh65R/kYtAii87IyxC0ZdKwL0K6drNIngTCaJH4Di2/jsQSlQqiTOJCse6LkJ3oXKwWEGsmXs3JWPO2rAP90+2jHY71vBr7KyYxT4CLkaz0trCo4pqaftvk0F362FLp8RqA7WUzCQypG2QKBgQD0pEfbA1hAiilLRyb4ZKCsmOnwIAXxc9twb6dRDuXkuIHTBxyvn+3sU0rN5QfaBxOzrfCVXhIjwdZ+cDNlRgaBLL6wOwmeqTsGWBYhPi3gnY1NFh1upGYNSNeD1iqgjLoKIY68u8yZzSuiUt6RxMi0rg1vAhhZ4E/KfYy/DZyURQKBgQC34L2/FRVg3mG6H0SotS+0rG1AIGBLRqpEXvU/9AkO0Bk5xYyalw0F3gi+nD5IOCzONKuhVue3ztWJypkHaDOuBzlPow7coO76b0MnesAX5r9zajAmqPjZNOzUQxwCRyOx0jNgkTv+lkZp3Ono7kFRpsMRU55XdtPZHUm1miSfCwKBgQC4hhEMyQEP7SYoeYqTYJMwnEYXsI/LBzBFJnJ1WV9dnS2PFpY0gdTbpBeQJWg+s4fQxynoAAR+o/49cDPT93WAiVdrZZxj6BF1P4uxl0zTVwL1WfDpO2ceLgsgjbGpV3wbmCQphx1UBMUcspTeLieU4JORX2sun1qPyRMYKBQqYQKBgACW1cTQ+nqO+90u0HeB7R81FjyIXgafuVfyvfJwg77qZ8pJmcO9DCuipICH26M7mtkmTg58Ss3J+eExJwBhExlRqJtauGd4lIt049Aykn8BHEfwZSsai4GWq9OaS3Kua6zcMZHzpS+Rp7QbIxy99rOeRy29CNra5J7jeyL71XY1AoGBANlPAVcOdTZscKHplirf9bXrq0rlXVmx9nXZu15VQus3Ojs7ifhnfExeTexbm++fRFr6A0mu0C2I9IhsYAQtTRSAu8MuEvCSaroTwkPmfstza74bMm7Qj/XYyrteKVKQ4/j1lurqyXxGpwoL17innJrqWw+9nPJIOMI3pCa4P1NO";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkjkDBEN/eRvJI2dQiMIY9GYjA5SOjy60ozYWIdCdqRluhAirLXTk+XcIA3wrVxqYeA26n8Zz/54IJ/l82IJxdBjX1IaoHjAFJtZVrOpWf9tPumD+wNO46QrYeWDhj18PTgyjD2gnkhcl+JyK8+RlsG0lk36DjXCOYjwaiYeGjhZmm85t5QgUYJx5hDkkFN0J+6rM2FmmX6HhHFFs7hOWeQ+4MGRNn2ZS4HONn87H0Jt2LAbM6/Tj8mPTlnS5s8/InSZs6tCnpYQTd/ov9tUJsAMkBzkUxlCMVIpL6mIcwUImNPAu2HmpmOzNc/Mhsif2AYuD8pxBxt+6x8zVzsYrAQIDAQAB";
    // 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://www.baidu.com";
    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://www.baidu.com";
    // 签名方式
    public static String sign_type = "RSA2";
    // 字符编码格式
    public static String charset = "utf-8";
    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
    // 支付宝网关
    public static String log_path = "C:\\";
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" +
                    System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
