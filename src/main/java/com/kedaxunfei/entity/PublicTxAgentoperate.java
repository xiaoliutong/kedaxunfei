package com.kedaxunfei.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@SuppressWarnings("All")
@Entity
@Table(name = "TX_AGENTOPERATE")
public class PublicTxAgentoperate implements Serializable {
    private String xh;
    private String zxgh;
    private String czlx;
    private String kssj;
    private String jssj;
    private String jgid;
    private String czlxid;
    private String gxsj;
   // private String bbh;
    //private String jhzt;
    private String unitcode;
    //private String jzzt;
   // private Date lastmodifytime;
    private String yhid;

    public PublicTxAgentoperate() {
    }
    public PublicTxAgentoperate(String xh, String zxgh, String czlx, String kssj,
                                String jssj, String jgid, String czlxid, String gxsj,
                                String unitcode, String yhid) {
        this.xh = xh;
        this.zxgh = zxgh;
        this.czlx = czlx;
        this.kssj = kssj;
        this.jssj = jssj;
        this.jgid = jgid;
        this.czlxid = czlxid;
        this.gxsj = gxsj;
        this.unitcode = unitcode;
        this.yhid = yhid;
    }
    // Property accessors
    @GenericGenerator(name = "tx_agentoperate", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "tx_agentoperate")
    @Column(name = "XH", unique = true, nullable = false, length = 32,insertable = true, updatable = true)
    public String getXh() {
        return this.xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    @Column(name = "ZXGH", length = 32)
    public String getZxgh() {
        return this.zxgh;
    }

    public void setZxgh(String zxgh) {
        this.zxgh = zxgh;
    }

    @Column(name = "CZLX", length = 1)
    public String getCzlx() {
        return this.czlx;
    }

    public void setCzlx(String czlx) {
        this.czlx = czlx;
    }

    @Column(name = "KSSJ", length = 32)
    public String getKssj() {
        return this.kssj;
    }

    public void setKssj(String kssj) {
        this.kssj = kssj;
    }

    @Column(name = "JSSJ", length = 32)
    public String getJssj() {
        return this.jssj;
    }

    public void setJssj(String jssj) {
        this.jssj = jssj;
    }

    @Column(name = "JGID", length = 32)
    public String getJgid() {
        return this.jgid;
    }

    public void setJgid(String jgid) {
        this.jgid = jgid;
    }

    @Column(name = "CZLXID", length = 32)
    public String getCzlxid() {
        return this.czlxid;
    }

    public void setCzlxid(String czlxid) {
        this.czlxid = czlxid;
    }

    @Column(name = "GXSJ", length = 32)
    public String getGxsj() {
        return this.gxsj;
    }

    public void setGxsj(String gxsj) {
        this.gxsj = gxsj;
    }

    /*@Column(name = "BBH", length = 2)
    public String getBbh() {
        return this.bbh;
    }

    public void setBbh(String bbh) {
        this.bbh = bbh;
    }

    @Column(name = "JHZT", length = 1)
    public String getJhzt() {
        return this.jhzt;
    }

    public void setJhzt(String jhzt) {
        this.jhzt = jhzt;
    }
*/
    @Column(name = "UNITCODE", length = 100)
    public String getUnitcode() {
        return this.unitcode;
    }

    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode;
    }

    /*@Column(name = "JZZT", length = 1)
    public String getJzzt() {
        return this.jzzt;
    }

    public void setJzzt(String jzzt) {
        this.jzzt = jzzt;
    }

    @Column(name = "LASTMODIFYTIME", length = 7)
    public Date getLastmodifytime() {
        return this.lastmodifytime;
    }

    public void setLastmodifytime(Date lastmodifytime) {
        this.lastmodifytime = lastmodifytime;
    }*/
    @Column(name = "YHID", length = 32)
    public String getYhid() {
        return yhid;
    }

    public void setYhid(String yhid) {
        this.yhid = yhid;
    }

}
