package com.kedaxunfei.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.print.attribute.standard.MediaSize;

@SuppressWarnings("all")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rememberLastId")
public class RememberLastId {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "txCallLogoJianDeId")
    private String txCallLogoJianDeId;
    @Column(name = "txCallLogoFuYangId")
    private String txCallLogoFuYangId;
    @Column(name = "txCallLogoChunAnId")
    private String txCallLogoChunAnId;
    @Column(name = "txCallLogoTongLuId")
    private String txCallLogoTongLuId;
    @Column(name = "txYwclZxsmJianDeId")
    private String txYwclZxsmJianDeId;
    @Column(name = "txYwclZxsmFuYangId")
    private String txYwclZxsmFuYangId;
    @Column(name = "txYwclZxsmChunAnId")
    private String txYwclZxsmChunAnId;
    @Column(name = "txYwclZxsmTongLuId")
    private String txYwclZxsmTongLuId;
    @Column(name = "txYwclZxxxJianDeId")
    private String txYwclZxxxJianDeId;
    @Column(name = "txYwclZxxxFuYangId")
    private String txYwclZxxxFuYangId;
    @Column(name = "txYwclZxxxChunAnId")
    private String txYwclZxxxChunAnId;
    @Column(name = "txYwclZxxxTongLuId")
    private String txYwclZxxxTongLuId;
    @Column(name = "txAgentOperateJianDeId")
    private String txAgentOperateJianDeId;
    @Column(name = "txAgentOperateFuYangId")
    private String txAgentOperateFuYangId;
    @Column(name = "txAgentOperateChunAnId")
    private String txAgentOperateChunAnId;
    @Column(name = "txAgentOperateTongLuId")
    private String txAgentOperateTongLuId;

    //建德市: 191020400, 富阳区: 191020300,淳安县: 191020200,桐庐县: 191020100
}
