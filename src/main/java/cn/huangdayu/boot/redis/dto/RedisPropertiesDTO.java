package cn.huangdayu.boot.redis.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author huangdayu
 */
@ConfigurationProperties(prefix = "spring.redis")
public class RedisPropertiesDTO {

    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
