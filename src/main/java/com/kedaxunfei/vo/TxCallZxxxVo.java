package com.kedaxunfei.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TxCallZxxxVo {
    private String Result;
    private String Msg;
    private String LastId;
    private List<Data> Data;
    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Data{
        private String EmployeeID;
        private String TimeLength;
        private String StartTime;
        private String EndTime;
        private String ID;
        private String Name;
        private String LeaveReason;

    }



}
