package com.kedaxunfei.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TxCallLogoVo {
    private String Result;
    private String Msg;
    private List<Data> Data;
    private String LastId;
    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Data {
        private String COID;
        private String CallerNumber;
        private String CalledNumber;
        private Date InivrTime;
        private Date InqueneTime;
        private Date RingTime;
        private Date InseatTime;
    }


  /*  Result
            Msg
    LastID

    COID	呼叫流水号	String
    CallerNumber	来电号码	String
    CalledNumber	被叫号码	String
    InivrTime	进入IVR时间	Datetime（2020-01-01 00：00：00）
    InqueneTime	进入队列时间	Datetime（2020-01-01 00：00：00）
    RingTime	坐席振铃时间 	Datetime（2020-01-01 00：00：00）
    InseatTime	坐席摘机时间	Datetime（2020-01-01 00：00：00）*/
}
