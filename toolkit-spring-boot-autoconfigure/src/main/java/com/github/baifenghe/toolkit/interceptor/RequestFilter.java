package com.github.baifenghe.toolkit.interceptor;


import com.github.baifenghe.toolkit.request.HttpServletRequestCacheWrapper;
import org.springframework.http.HttpMethod;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * RequestInterceptor
 *
 * @author bfh
 * @since 2019/01/06
 */
public class RequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        final String method = request.getMethod();
        if (HttpMethod.POST.matches(method) || HttpMethod.PATCH.matches(method) || HttpMethod.PUT.matches(method)) {
            if (!(request instanceof HttpServletRequestCacheWrapper)) {
                request = new HttpServletRequestCacheWrapper(request);
            }
        }
        filterChain.doFilter(request, servletResponse);

    }

    @Override
    public void destroy() {}
}
