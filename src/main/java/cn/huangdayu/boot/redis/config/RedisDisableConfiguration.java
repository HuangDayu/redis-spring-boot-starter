package cn.huangdayu.boot.redis.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * @author huangdayu create at 2021/2/1 15:07
 */
@Configuration
@ConditionalOnExpression("'false'.equals('${spring.redis.enabled:true}')")
@EnableAutoConfiguration(exclude = {RedisAutoConfiguration.class})
public class RedisDisableConfiguration {

}
