package com.kedaxunfei.entity;


import com.kedaxunfei.utils.DateUtils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@SuppressWarnings("ALL")
@Entity
@Table(name = "TX_CALL_LOGO")
public class TxCallLogo {
    private String xh;// ID主键
    private String callid;// 呼叫流水
    private String callerno;// 来电号码
    private String calledno;// 被叫号码
    private Date inivrdt;// 进入IVR时间
    private Date inquenedt;// 进入队列时间
    private Date ringdt;// 坐席振铃时间
    private Date inseatdt;// 坐席摘机（通话开始）时间
    private Date outdt;// 挂机时间
    private String unitcode;// 机构编码
    private Integer calltype;// 呼叫类型 0 呼入 1呼出
   // private String chanelno;// 通道号码
   // private String txcid;// 业务记录编号（供外呼关联）
   // private String zxhid;// 外呼工号
    //private String sfpd;// 是否排队
    private String lywjm;//录音文件名
    private String zxgh;
    private String yh_id;
    private String yh_dm;
    private String yh_mc;
    private String idnumber;//身份证号

    // Constructors

    /** default constructor */
    public TxCallLogo() {
    }

    /** minimal constructor */
    public TxCallLogo(String callid) {
        this.callid = callid;
    }

    /** full constructor */
    public TxCallLogo(String callid, String callerno, String calledno,
                      String inivrdt, String inquenedt, String ringdt, String inseatdt,
                      String outdt, String unitcode, Integer calltype,
                      String lywjm, String zxgh,
                      String yh_id,
                      String yh_mc, String yh_dm, String idnumber
                   ) {
        this.callid = callid;
        this.callerno = callerno;
        this.calledno = calledno;
        this.inivrdt = DateUtils.StringTODate(inivrdt);
        this.inquenedt = DateUtils.StringTODate(inquenedt);
        this.ringdt = DateUtils.StringTODate(ringdt);
        this.inseatdt = DateUtils.StringTODate(inseatdt);
        this.outdt = DateUtils.StringTODate(outdt);
        this.unitcode = unitcode;
        this.calltype = calltype;
        this.lywjm=lywjm;
        this.zxgh=zxgh;
        this.yh_id=yh_id;
        this.yh_mc=yh_mc;
        this.yh_dm=yh_dm;
        this.idnumber=idnumber;
    }

    // Property accessors

    @GenericGenerator(name = "tx_call_logo", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "tx_call_logo")
    @Column(name = "XH", unique = true, nullable = false, insertable = true, updatable = true, length = 32)
    public String getXh() {
        return this.xh;
    }


    public void setXh(String xh) {
        this.xh = xh;
    }

    @Column(name = "CALLID", nullable = false, length = 20)
    public String getCallid() {
        return this.callid;
    }

    public void setCallid(String callid) {
        this.callid = callid;
    }

    @Column(name = "CALLERNO", length = 20)
    public String getCallerno() {
        return this.callerno;
    }

    public void setCallerno(String callerno) {
        this.callerno = callerno;
    }

    @Column(name = "CALLEDNO", length = 20)
    public String getCalledno() {
        return this.calledno;
    }

    public void setCalledno(String calledno) {
        this.calledno = calledno;
    }

    @Column(name = "INIVRDT", length = 11)
    public Date getInivrdt() {
        return this.inivrdt;
    }

    public void setInivrdt(Date inivrdt) {
        this.inivrdt = inivrdt;
    }

    @Column(name = "INQUENEDT", length = 11)
    public Date getInquenedt() {
        return this.inquenedt;
    }

    public void setInquenedt(Date inquenedt) {
        this.inquenedt = inquenedt;
    }

    @Column(name = "RINGDT", length = 11)
    public Date getRingdt() {
        return this.ringdt;
    }

    public void setRingdt(Date ringdt) {
        this.ringdt = ringdt;
    }

    @Column(name = "INSEATDT", length = 11)
    public Date getInseatdt() {
        return this.inseatdt;
    }

    public void setInseatdt(Date inseatdt) {
        this.inseatdt = inseatdt;
    }

    @Column(name = "OUTDT", length = 11)
    public Date getOutdt() {
        return this.outdt;
    }

    public void setOutdt(Date outdt) {
        this.outdt = outdt;
    }

    @Column(name = "UNITCODE", length = 20)
    public String getUnitcode() {
        return this.unitcode;
    }

    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode;
    }

    @Column(name = "CALLTYPE", precision = 22, scale = 0)
    public Integer getCalltype() {
        return this.calltype;
    }

    public void setCalltype(Integer calltype) {
        this.calltype = calltype;
    }

    /*@Column(name = "CHANELNO", precision = 22, scale = 0)
    public String getChanelno() {
        return this.chanelno;
    }

    public void setChanelno(String chanelno) {
        this.chanelno = chanelno;
    }

    @Column(name = "TXCID", length = 32)
    public String getTxcid() {
        return this.txcid;
    }

    public void setTxcid(String txcid) {
        this.txcid = txcid;
    }

    @Column(name = "ZXHID", length = 32)
    public String getZxhid() {
        return this.zxhid;
    }

    public void setZxhid(String zxhid) {
        this.zxhid = zxhid;
    }

    @Column(name = "SFPD", length = 1)
    public String getSfpd() {
        return this.sfpd;
    }

    public void setSfpd(String sfpd) {
        this.sfpd = sfpd;
    }*/

    @Column(name="lywjm")
    public String getLywjm() {
        return lywjm;
    }

    public void setLywjm(String lywjm) {
        this.lywjm = lywjm;
    }

    @Column(name = "ZXGH", length = 10)
    public String getZxgh() {
        return this.zxgh;
    }

    public void setZxgh(String zxgh) {
        this.zxgh = zxgh;
    }

    @Column(name = "YH_ID", length = 20)
    public String getYhId() {
        return this.yh_id;
    }

    public void setYhId(String yhId) {
        this.yh_id = yhId;
    }

    @Column(name = "YH_DM", length = 20)
    public String getYhDm() {
        return this.yh_dm;
    }

    public void setYhDm(String yhDm) {
        this.yh_dm = yhDm;
    }

    @Column(name = "YH_MC", length = 20)
    public String getYhMc() {
        return this.yh_mc;
    }

    public void setYhMc(String yhMc) {
        this.yh_mc = yhMc;
    }
    @Column(name = "IDNUMBER", length = 40)
    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    @Override
    public String toString() {
        return "TxCallLogo{" +
                "xh='" + xh + '\'' +
                ", callid='" + callid + '\'' +
                ", callerno='" + callerno + '\'' +
                ", calledno='" + calledno + '\'' +
                ", inivrdt=" + inivrdt +
                ", inquenedt=" + inquenedt +
                ", ringdt=" + ringdt +
                ", inseatdt=" + inseatdt +
                ", outdt=" + outdt +
                ", unitcode='" + unitcode + '\'' +
                ", calltype='" + calltype + '\'' +
               /* ", chanelno='" + chanelno + '\'' +
                ", txcid='" + txcid + '\'' +
                ", zxhid='" + zxhid + '\'' +
                ", sfpd='" + sfpd + '\'' +*/
                ", lywjm='" + lywjm + '\'' +
                ", zxgh='" + zxgh + '\'' +
                ", yhId='" + yh_id + '\'' +
                ", yhDm='" + yh_dm + '\'' +
                ", yhMc='" + yh_mc + '\'' +
                ", idnumber='" + idnumber + '\'' +
                '}';
    }
}
