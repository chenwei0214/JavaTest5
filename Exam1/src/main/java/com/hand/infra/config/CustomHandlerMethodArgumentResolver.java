package com.hand.infra.config;

import com.hand.infra.util.Page;
import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class CustomHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {

        return methodParameter.getParameterType().equals(Page.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {
        String pageSize = nativeWebRequest.getParameter("pageSize");
        String page = nativeWebRequest.getParameter("page");
        Page pageResult = new Page();
        if (!StringUtils.isEmpty(pageSize)) {
            pageResult.setPageSize(Integer.parseInt(pageSize));
        }
        if (!StringUtils.isEmpty(page)) {
            pageResult.setPage(Integer.parseInt(page));
        }
        return pageResult;
    }
}
