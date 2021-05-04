package com.dmj.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

//国际化解析器，定义组件LocaleResolver，实现按钮的自动切换
public class MyLocaleResolver implements LocaleResolver {

    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取请求中的语言参数信息
        String language = request.getParameter("l");
        //如果没有就使用默认的
        Locale locale = Locale.getDefault();
        //判断language是否为空,isEmpty已经过时，可使用hasText
        if (StringUtils.hasText(language)){
            String[] split = language.split("_");//zh_CN
            locale = new Locale(split[0], split[1]);//国家，地区
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
