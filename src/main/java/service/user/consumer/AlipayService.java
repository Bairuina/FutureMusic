package service.user.consumer;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import controller.user.consumer.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import util.AlipayConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * @author HP
 */
@Service(value = "AlipayService")
public class AlipayService {
    private static final Logger logger = LoggerFactory.getLogger(AlipayService.class);

    public void ali(HttpServletRequest request, HttpServletResponse response, int type) throws AlipayApiException, IOException {
        logger.debug("type"+type);
        //设置编码
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest aliPayRequest = new AlipayTradePagePayRequest();
        aliPayRequest.setReturnUrl(AlipayConfig.return_url);
        aliPayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，后台可以写一个工具类生成一个订单号，必填
        Random random = new Random();
        int randomInt = random.nextInt(10000);
        String id = System.currentTimeMillis() + "" + randomInt;
        //订单名称，必填
        String subject = "未来音乐";
        String money="0";
        if(type==1){
            money="10";
        }else if(type==2){
            money="25";
        }else if(type==3){
            money="100";
        }
        aliPayRequest.setBizContent("{\"out_trade_no\":\"" + id + "\","
                //付款金额，从前台获取，必填
                + "\"total_amount\":\"" + money + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        String result = alipayClient.pageExecute(aliPayRequest).getBody();
        logger.debug("准备充值"+money);
        request.getSession().setAttribute("token",money+".00");

        //输出
        out.println(result);
    }
}
