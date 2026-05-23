package com.sky.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
public class Commonfig {
    @Configuration
    public class WebMvcConfiguration implements WebMvcConfigurer {

        @Value("${sky.upload-path}")
        private String basePath;

        /**
         * 设置静态资源映射
         */
        public void addResourceHanlers(ResourceHandlerRegistry registry) {
            log.info("开始设置静态资源映射...");
            // 当请求路径匹配 /download/** 时，去本地磁盘路径找文件
            registry.addResourceHandler("/download/**")
                    .addResourceLocations("file:" + basePath);
        }
    }
}
