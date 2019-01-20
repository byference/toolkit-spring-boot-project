package com.github.baifenghe.toolkit.filter;


import com.github.baifenghe.toolkit.request.HttpServletRequestCacheWrapper;
import org.springframework.http.HttpMethod;
import org.springframework.web.filter.OncePerRequestFilter;

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
public class RequestCacheFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String method = request.getMethod();
        if (HttpMethod.POST.matches(method) || HttpMethod.PATCH.matches(method) || HttpMethod.PUT.matches(method)) {
            if (!(request instanceof HttpServletRequestCacheWrapper)) {
                request = new HttpServletRequestCacheWrapper(request);
            }
        }
        filterChain.doFilter(request, response);
    }
}
