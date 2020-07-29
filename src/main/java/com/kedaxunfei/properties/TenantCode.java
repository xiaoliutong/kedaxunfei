package com.kedaxunfei.properties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;
@Data
@Component
@ConfigurationProperties(prefix = "TenantCode")
public class TenantCode {
    private  Map<String,String> data;
}
