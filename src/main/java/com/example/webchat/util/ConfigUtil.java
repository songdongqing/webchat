package com.example.webchat.util;

import java.io.IOException;
import java.util.Properties;


import org.slf4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * 读取配置文件工具类
 * @author Administrator
 *
 */
public class ConfigUtil {



    private static Properties config = null;

    /**
     * 返回weixin.properties配置信息
     * @param key key值
     * @return value值
     */
    public static String getProperty(String key) {
        if (config == null) {
            synchronized (ConfigUtil.class) {
                if (null == config) {
                    try {
                        Resource resource = new ClassPathResource("weixin.properties");
                        config = PropertiesLoaderUtils.loadProperties(resource);
                    } catch (IOException e) {

                    }
                }
            }
        }

        return config.getProperty(key);
    }
}