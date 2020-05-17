package cn.qingwei.graduationproject.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        Object user = request.getSession().getAttribute("user_id");
        if (user == null || user.equals(""))  {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}

