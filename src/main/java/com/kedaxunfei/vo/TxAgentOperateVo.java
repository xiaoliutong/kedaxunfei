package com.kedaxunfei.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TxAgentOperateVo {
    private String Result;
    private String Msg;
    private String LastId;
    private List<Data> Data;
    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Data{
        private String COID;
        private String EmployeeID;
        private String StartTime;
        private String EndTime;
        private String DeptID;
        private String ID;
    }

}
