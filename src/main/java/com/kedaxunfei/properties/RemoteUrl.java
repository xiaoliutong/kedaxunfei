package com.kedaxunfei.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "RemoteUrl")
public class RemoteUrl {
    private String txCallSecondUrl;
    private String txCallLogoUrl;
    private String txYwclZxsmUrl;
    private String txYwclZxxxUrl;
    private String txAgentOperateUrl;
}
