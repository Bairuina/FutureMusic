package service.user.consumer.account;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * 注册账号
 *
 * @author 5月11日 张易兴创建
 */
@Service(value = "RegisterService")
public class RegisterService {
    /**
     * 发送邮箱返回验证码
     *
     * @param mailbox 接收邮箱号
     * @return String 返回验证码
     */
    public String sendMail(String mailbox) {
        return null;
    }
    /**
     * 注册成功将账号密码存入数据库
     *
     * @param mailbox 注册的邮箱
     * @param password 注册的密码
     * @return String 返回验证码
     */
    public boolean registerAccount(String mailbox,String password) {
        return false;
    }
}
