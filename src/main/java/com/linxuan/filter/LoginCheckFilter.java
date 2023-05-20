package com.linxuan.filter;

import com.alibaba.fastjson.JSON;
import com.linxuan.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebFilter("/*")
public class LoginCheckFilter implements Filter {
    // 路径匹配器，支持通配符
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 向下转型。获取Session对象是由HttpServletRequest里面的方法获取的，不是ServletRequest
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 获取本次请求的URI。URI：统一资源标识符，没有前面的http协议以及项目名称信息
        String requestURI = request.getRequestURI();

        // 打印日志
        log.info("拦截到请求：{}", requestURI);

        // 定义不需要处理的请求路径
        String[] urls = new String[]{
                "/page/**", // 登录页面不需要进行处理
                "/index.html", // 页面不需要处理
                "/images/**", // 图片资源不需要处理
                "/js/**", // JS资源不需要处理
                "/plugins/**", // 扩展资源不需要处理
                "/styles/**", // CSS样式不需要处理
                "/api/**", // 请求资源不需要处理
                "/admin/login", // 登录操作不需要拦截
                "/admin/logout" // 退出操作不需要拦截
        };

        // 判断本次请求是否需要处理，如果检查当前请求路径在数组里面那么代表不需要进行任何处理，直接放行即可。
        if (check(urls, requestURI)) {
            log.info("本次请求{}不需要处理", requestURI);
            // 放行
            filterChain.doFilter(request, response);
            return;
        }

        // 判断登录状态，如果已登录，则直接放行
        if (request.getSession().getAttribute("admin") != null) {
            log.info("用户已登录，用户id为：{}", request.getSession().getAttribute("admin"));
            filterChain.doFilter(request, response);
            return;
        }

        // 如果未登录控制台打印信息并且返回未登录结果，通过输出流向客户端页面响应数据
        log.info("用户未登录");
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
    }

    // 路径匹配，检查本次请求是否需要放行
    public boolean check(String[] urls, String requestURI) {
        for (String url : urls) {
            if (PATH_MATCHER.match(url, requestURI)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void destroy() {

    }
}
