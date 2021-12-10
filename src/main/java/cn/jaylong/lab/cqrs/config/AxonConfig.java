package cn.jaylong.lab.cqrs.config;

import org.axonframework.config.EventProcessingConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/12/9
 * Url: jaylong.cn
 */
@Configuration
public class AxonConfig {

    @Autowired
    public void configureProcessorDefault(EventProcessingConfigurer processingConfigurer) {
        processingConfigurer.usingSubscribingEventProcessors();
    }
}
