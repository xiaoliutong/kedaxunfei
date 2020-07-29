
package com.kedaxunfei.entity;


import com.kedaxunfei.utils.DateUtils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("all")
@Entity
@Table(name = "TX_CALL_SECOND")
public class PublicTxCallSecond implements Serializable {
    @Override
    public String toString() {
        return "TxCallSecond{" +
                "id='" + id + '\'' +
                ", unitcode='" + unitcode + '\'' +
                ", unitname='" + unitname + '\'' +
                ", waiters='" + waiters + '\'' +
                ", signin='" + signin + '\'' +
                ", calling='" + calling + '\'' +
                ", tidy='" + tidy + '\'' +
                ", busy='" + busy + '\'' +
                ", free='" + free + '\'' +
                ", rest='" + rest + '\'' +
                ", gxsj=" + gxsj +
                '}';
    }

    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", unique = true, nullable = false, insertable = true, updatable = true, length = 32)
    private String id;
    @Column(name = "UNITCODE")
    private String unitcode;
    @Column(name = "UNITNAME")
    private String unitname;
    @Column(name = "WAITERS")
    private String waiters;
    @Column(name = "SIGNIN")
    private String signin;
    @Column(name = "CALLING")
    private String calling;
    @Column(name = "TIDY")
    private String tidy;
    @Column(name = "BUSY")
    private String busy;
    @Column(name = "FREE")
    private String free;
    @Column(name = "REST")
    private String rest;
    @Column(name = "GXSJ")
    private Date gxsj;



    public PublicTxCallSecond(String unitcode,
                              String unitname, String waiters,
                              String signin, String calling,
                              String tidy, String busy,
                              String free, String rest, String gxsj) {

        this.unitcode=unitcode;
        this.unitname=unitname;
        this.waiters=waiters;
        this.signin=signin;
        this.calling=calling;
        this.tidy=tidy;
        this.busy=busy;
        this.free=free;
        this.rest=rest;
        this.gxsj= DateUtils.StringTODate(gxsj);

    }
 public PublicTxCallSecond(){

 }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnitcode() {
        return unitcode;
    }

    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public String getWaiters() {
        return waiters;
    }

    public void setWaiters(String waiters) {
        this.waiters = waiters;
    }

    public String getSignin() {
        return signin;
    }

    public void setSignin(String signin) {
        this.signin = signin;
    }

    public String getCalling() {
        return calling;
    }

    public void setCalling(String calling) {
        this.calling = calling;
    }

    public String getTidy() {
        return tidy;
    }

    public void setTidy(String tidy) {
        this.tidy = tidy;
    }

    public String getBusy() {
        return busy;
    }

    public void setBusy(String busy) {
        this.busy = busy;
    }

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }

    public String getRest() {
        return rest;
    }

    public void setRest(String rest) {
        this.rest = rest;
    }

    public Date getGxsj() {
        return gxsj;
    }

    public void setGxsj(Date gxsj) {
        this.gxsj = gxsj;
    }
}

