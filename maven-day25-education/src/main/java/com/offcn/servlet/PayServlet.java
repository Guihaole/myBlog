package com.offcn.servlet;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.offcn.util.AlipayConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/pay")
public class PayServlet extends HttpServlet {
    //http://localhost:6060/education/pay
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
                AlipayConfig.merchant_private_key, "json", AlipayConfig.charset,
                AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        //同步回调
        //alipayRequest.setReturnUrl("http://localhost:6060/education/usercourse?method=insertCourseUser&uid="+request.getParameter("uid")+"&cid="+request.getParameter("cid"));
       // alipayRequest.setReturnUrl("http://116.205.230.80:6060/maven-day25-education-1.0-SNAPSHOT/usercourse?method=insertCourseUser&uid="+request.getParameter("uid")+"&cid="+request.getParameter("cid"));
        alipayRequest.setReturnUrl("http://192.168.64.128:8080/maven-day25-education-1.0-SNAPSHOT/usercourse?method=insertCourseUser&uid="+request.getParameter("uid")+"&cid="+request.getParameter("cid"));
        // 商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = new String(request.getParameter("WIDout_trade_no"));
        //付款金额，必填
        String total_amount = new String(request.getParameter("WIDtotal_amount"));
        //订单名称，必填
        String subject = new String(request.getParameter("WIDsubject"));
        String body = new String(request.getParameter("body"));
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        String result = null;
        try {
            result = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        //输出
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().print(result);
    }
}
