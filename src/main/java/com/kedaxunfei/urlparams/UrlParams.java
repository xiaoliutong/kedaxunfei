package com.kedaxunfei.urlparams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlParams {
    private String TenantCode;
    private String LastID;
    private String QueryCount;
}
