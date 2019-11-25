package cyx.redis1;


import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableCaching
@EnableTransactionManagement
public class Redis1Application {
    /**
     * fastjson替代默认json
     * @return
     */
    @Bean
    public HttpMessageConverters fastJsonMessageConverter(){
        //创建fastjson的消息转换器
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        //创建fastjson的配置对象
        FastJsonConfig config = new FastJsonConfig();
        //对json数据进行格式化
        config.setSerializerFeatures(SerializerFeature.PrettyFormat);

        //处理中文乱码
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        converter.setSupportedMediaTypes(fastMediaTypes);

        converter.setFastJsonConfig(config);
        HttpMessageConverter<?> con = converter;
        return new HttpMessageConverters(con);
    }

    public static void main(String[] args) {
        SpringApplication.run(Redis1Application.class, args);
    }

}
