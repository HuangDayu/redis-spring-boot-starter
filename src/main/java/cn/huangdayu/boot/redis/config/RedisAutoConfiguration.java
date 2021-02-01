package cn.huangdayu.boot.redis.config;


import cn.huangdayu.boot.redis.dto.RedisPropertiesDTO;
import cn.huangdayu.boot.redis.service.RedisService;
import cn.huangdayu.boot.redis.service.impl.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

/**
 * @author huangdayu
 */
@ConditionalOnExpression("'true'.equals('${spring.redis.enabled:true}')")
@Configuration
@ConditionalOnClass(RedisService.class)
@EnableConfigurationProperties(RedisPropertiesDTO.class)
public class RedisAutoConfiguration {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Bean
    @ConditionalOnMissingBean
    public RedisService redisService() throws Exception {
        if (null == stringRedisTemplate) {
            throw new Exception("stringRedisTemplate can not be null.");
        }
        return new RedisServiceImpl(stringRedisTemplate);
    }

}
