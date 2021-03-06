package util.interceptor;

import entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import service.user.SpecialFunctions;
import util.exception.ExceptionJump;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author HP
 */
public class ShowInterceptor implements HandlerInterceptor {
    @Resource(name = "SpecialFunctions")
    SpecialFunctions specialFunctions;
    @Resource(name = "ExceptionJump")
    ExceptionJump exceptionJump;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user=specialFunctions.getUser(session);
        // 会话中没有用户时候执行
        if ( user!= null) {
            // 判断用户等级,为客服才可以查看
            if(user.getLevel()>=3){
                return true;
            }
        }
        request.setAttribute("exception","用户没有查看的权限");
        exceptionJump.pageJump(request,response);
        // 跳转页面，表示没有权限访问
        return false;
    }
}
