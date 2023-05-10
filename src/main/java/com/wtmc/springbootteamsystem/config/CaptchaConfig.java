package com.wtmc.springbootteamsystem.config;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;


@Configuration
public class CaptchaConfig {

    @Bean
    public Producer captchaProducer() {
        Properties props = new Properties();
        // 配置 kaptcha 图片生成器
        props.setProperty("kaptcha.border", "no");
        props.setProperty("kaptcha.textproducer.font.color", "black");
        props.setProperty("kaptcha.image.width", "120");
        props.setProperty("kaptcha.image.height", "40");
        props.setProperty("kaptcha.textproducer.char.length", "4");
        Config config = new Config(props);
        // 使用默认的图像生成器创建生产者实例
        DefaultKaptcha kaptcha = new DefaultKaptcha();
        kaptcha.setConfig(config);
        return kaptcha;
    }
}