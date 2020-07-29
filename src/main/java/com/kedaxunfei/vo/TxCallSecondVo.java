package com.kedaxunfei.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TxCallSecondVo {

    private String Result;
    private String Msg;
    private Data Data;
    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Data{
        private String waiters;
        private String signin;
        private String calling;
        private String tidy;
        private String busy;
        private String free;
        private String reset;
    }

}
