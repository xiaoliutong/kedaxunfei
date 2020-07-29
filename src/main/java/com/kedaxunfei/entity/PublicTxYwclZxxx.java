package com.kedaxunfei.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@SuppressWarnings("ALL")
@Entity
@Table(name="TX_YWCL_ZXXX")
public class PublicTxYwclZxxx {
    @Id
    @Column(name = "XH",nullable = false ,unique = true,  length = 32)
    @GenericGenerator(name = "tx_ywcl_zxxx",strategy = "uuid")
    @GeneratedValue(generator = "tx_ywcl_zxxx")
    private String xh;
    @Column(name = "XX_ZXGH")
    private String xx_zxgh;
    @Column(name = "XX_QQXXSC")
    private String xx_qqxxsc;
    @Column(name = "XX_KSSJ")
    private String xx_kssj;
    @Column(name = "XX_JSSJ")
    private String xx_jssj;
    @Column(name = "XX_JGID")
    private String xx_jgid;
    @Column(name = "GXSJ")
    private String gxsj;
    @Column(name = "XX_YHID")
    private String xx_yhid;

    public PublicTxYwclZxxx() {
    }
    public PublicTxYwclZxxx(String xh, String xx_zxgh, String xx_qqxxsc,
                            String xx_kssj, String xx_jssj, String xx_jgid,
                            String gxsj, String xx_yhid) {
        this.xh=xh;
        this.xx_zxgh=xx_zxgh;
        this.xx_qqxxsc=xx_qqxxsc;
        this.xx_kssj=xx_kssj;
        this.xx_jssj=xx_jssj;
        this.xx_jgid=xx_jgid;
        this.gxsj=gxsj;
        this.xx_yhid=xx_yhid;
    }
    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getXx_zxgh() {
        return xx_zxgh;
    }

    public void setXx_zxgh(String xx_zxgh) {
        this.xx_zxgh = xx_zxgh;
    }

    public String getXx_qqxxsc() {
        return xx_qqxxsc;
    }

    public void setXx_qqxxsc(String xx_qqxxsc) {
        this.xx_qqxxsc = xx_qqxxsc;
    }

    public String getXx_kssj() {
        return xx_kssj;
    }

    public void setXx_kssj(String xx_kssj) {
        this.xx_kssj = xx_kssj;
    }

    public String getXx_jssj() {
        return xx_jssj;
    }

    public void setXx_jssj(String xx_jssj) {
        this.xx_jssj = xx_jssj;
    }

    public String getXx_jgid() {
        return xx_jgid;
    }

    public void setXx_jgid(String xx_jgid) {
        this.xx_jgid = xx_jgid;
    }

    public String getGxsj() {
        return gxsj;
    }

    public void setGxsj(String gxsj) {
        this.gxsj = gxsj;
    }

    public String getXx_yhid() {
        return xx_yhid;
    }

    public void setXx_yhid(String xx_yhid) {
        this.xx_yhid = xx_yhid;
    }
}
