package cn.qingwei.graduationproject.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mr sheng.z
 * @email 1865414XXXX@163.com
 * 拦截器 HandlerInterceptorAdapter 有三种方法可用。现在用的是第一种 预处理 preHandle
 * HandlerInterceptor接口主要定义了三个方法：
 * 1.boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handle)方法：该方法将在请求处理之前进行调用，只有该方法返回true，才会继续执行后续的Interceptor和Controller，当返回值为true 时就会继续调用下一个Interceptor的preHandle 方法，如果已经是最后一个Interceptor的时候就会是调用当前请求的Controller方法；
 * 2.void postHandle (HttpServletRequest request, HttpServletResponse response, Object handle, ModelAndView modelAndView)方法：该方法将在请求处理之后，DispatcherServlet进行视图返回渲染之前进行调用，可以在这个方法中对Controller 处理之后的ModelAndView 对象进行操作。
 * 3.void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handle, Exception ex)方法：该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行，该方法将在整个请求结束之后，也就是在DispatcherServlet 渲染了对应的视图之后执行。用于进行资源清理
 */
@Component
public class ErrorPageInterceptor implements HandlerInterceptor {
    private List<Integer> errorCodeList = Arrays.asList(404, 403, 500);

    /**
     * preHandle 预处理
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response) throws
            Exception {
        if (errorCodeList.contains(response.getStatus())) {
            response.sendRedirect("/error/");
            return false;
        }
        return true;
    }


    public void postHandle(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("postHandle run!");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("afterCompletion run!");
    }
}


