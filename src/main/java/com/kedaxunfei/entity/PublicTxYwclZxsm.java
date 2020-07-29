package com.kedaxunfei.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@SuppressWarnings("All")
@Entity
@Table(name = "TX_YWCL_ZXSM")
public class PublicTxYwclZxsm implements Serializable {
    // Fields

    private String sm_bh;
    private String sm_zxgh;
    private String sm_kssj;
    private String sm_smsc;
    private String sm_sjsj;
    private String sm_jgid;
   // private String smSmlxid;
    private String gxsj;
    /*private String bbh;
    private String jhzt;
    private String xzqh;
    private String smQqsj;
    private Date lastmodifytime;*/
    private String sm_yhid;

    // Constructors

    /** default constructor */
    public PublicTxYwclZxsm() {
    }


    /** full constructor */
    public PublicTxYwclZxsm(String sm_bh, String sm_zxgh, String sm_kssj, String sm_smsc,
                            String sm_sjsj, String sm_jgid, String gxsj,
                            String sm_yhid) {
      this.sm_bh=sm_bh;
      this.sm_zxgh=sm_zxgh;
      this.sm_kssj=sm_kssj;
      this.sm_smsc=sm_smsc;
      this.sm_sjsj=sm_sjsj;
      this.sm_jgid=sm_jgid;
      this.gxsj=gxsj;
      this.sm_yhid=sm_yhid;
    }

    // Property accessors
   @GenericGenerator(strategy = "uuid.hex",name = "tx_ywcl_zxsm")
    @GeneratedValue(generator = "tx_ywcl_zxsm")
    @Id
    @Column(name = "SM_BH", unique = true, nullable = false, length = 32,insertable = true,updatable = true)
    public String getSmBh() {
        return this.sm_bh;
    }

    public void setSmBh(String smBh) {
        this.sm_bh = smBh;
    }

    @Column(name = "SM_ZXGH", length = 32)
    public String getSmZxgh() {
        return this.sm_zxgh;
    }

    public void setSmZxgh(String smZxgh) {
        this.sm_zxgh = smZxgh;
    }

    @Column(name = "SM_KSSJ", length = 32)
    public String getSmKssj() {
        return this.sm_kssj;
    }

    public void setSmKssj(String smKssj) {
        this.sm_kssj = smKssj;
    }

    @Column(name = "SM_SMSC", length = 32)
    public String getSmSmsc() {
        return this.sm_smsc;
    }

    public void setSmSmsc(String smSmsc) {
        this.sm_smsc = smSmsc;
    }

    @Column(name = "SM_SJSJ", length = 32)
    public String getSmSjsj() {
        return this.sm_sjsj;
    }

    public void setSmSjsj(String smSjsj) {
        this.sm_sjsj = smSjsj;
    }

    @Column(name = "SM_JGID", length = 32)
    public String getSmJgid() {
        return this.sm_jgid;
    }

    public void setSmJgid(String smJgid) {
        this.sm_jgid = smJgid;
    }


    @Column(name = "GXSJ", length = 32)
    public String getGxsj() {
        return this.gxsj;
    }

    public void setGxsj(String gxsj) {
        this.gxsj = gxsj;
    }

    @Column(name = "SM_YHID", length = 32)
    public String getSmYhid() {
        return sm_yhid;
    }

    public void setSmYhid(String smYhid) {
        this.sm_yhid = smYhid;
    }
}
