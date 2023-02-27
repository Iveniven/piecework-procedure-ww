package com.gec.piecework;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author iven
 * @version 2021.2.3
 * @date 2023/2/24 16:52
 */
@SpringBootApplication
@MapperScan("com.gec.piecework.mapper")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean //解决跨域问题
    public CorsFilter corsFilter() {

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // 允许cookies跨域
        config.addAllowedOrigin("*");// 允许向该服务器提交请求的URI，*表示全部允许。。这里尽量限制来源域，比如http://xxxx:8080 ,以降低安全风险。。
        config.addAllowedHeader("*");// 允许访问的头信息,*表示全部
        config.setMaxAge(18000L);// 预检请求的缓存时间（秒），即在这个时间段里，对于相同的跨域请求不会再预检了
        config.addAllowedMethod("*");// 允许提交请求的方法，*表示全部允许，也可以单独设置GET、PUT等
//        config.addAllowedMethod("HEAD");
//        config.addAllowedMethod("GET");// 允许Get的请求方法
//        config.addAllowedMethod("PUT");
//        config.addAllowedMethod("POST");
//        config.addAllowedMethod("DELETE");
//        config.addAllowedMethod("PATCH");
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }

    static {
        System.setProperty("druid.mysql.usePingMethod","false");
    }
}
