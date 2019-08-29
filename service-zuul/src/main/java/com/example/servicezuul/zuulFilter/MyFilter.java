package com.example.servicezuul.zuulFilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@Component
public class MyFilter extends ZuulFilter {
    @Override
    /*过滤器的类型*/
    public String filterType() {
        return "pre";//前置过滤
        //pre：路由之前
        //routing：路由之时
        //post： 路由之后
        //error：发送错误调用
    }

    @Override
    public int filterOrder() {
        return 0;//有多个过滤器时的过滤排序
    }

    @Override
    public boolean shouldFilter() {
        return true;// 是否启用过滤

    }

    @Override
    public Object run() throws ZuulException {
        //业务逻辑
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        //token=offcn    token必须等于offcn，才让他请求到目标资源
        String token = request.getParameter("token");
        if(token!=null&&token.equals("offcn")){
            System.out.println("pass!!!");//放行，请求到目标资源
        }else{
            currentContext.setSendZuulResponse(false);//拦截
            currentContext.setResponseStatusCode(401);
            try {
                currentContext.getResponse().getWriter().write("yanzhengshibai");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
