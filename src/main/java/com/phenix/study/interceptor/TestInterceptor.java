package com.phenix.study.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 * Custom interceptor
 *
 * @author john
 * @since 2017-06-12
 */
public class TestInterceptor implements HandlerInterceptor {
    private Logger log = Logger.getLogger(TestInterceptor.this.getClass()
                                                              .getSimpleName());

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        log.info("preHandle()->1");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        log.info("postHandle()->2");
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        log.info("afterHandle()->3");
    }
}
