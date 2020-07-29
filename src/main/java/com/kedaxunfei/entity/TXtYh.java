package com.kedaxunfei.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("ALL")
@Entity
@Table(name = "T_Xt_YH")
@Data
public class TXtYh {
    @Id
    @Column(name = "YH_ID")
    private String YH_ID;//	N	VARCHAR2(32)	N			用户IDYH_DM	N	VARCHAR2(20)	N
    // 		用户代码(登陆用)
    @Column(name = "YH_DM")
    private String YH_DM;    //N	VARCHAR2(40)	N			用户名称

}
