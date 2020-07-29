
package com.kedaxunfei.service;

import com.alibaba.fastjson.JSONObject;
import com.kedaxunfei.dao.RememberLastIdDao;
import com.kedaxunfei.dao.TxCallLogoDao;
import com.kedaxunfei.dao.TxCallSecondDao;
import com.kedaxunfei.entity.RememberLastId;
import com.kedaxunfei.entity.TxCallLogo;
import com.kedaxunfei.properties.RemoteUrl;
import com.kedaxunfei.properties.TenantCode;
import com.kedaxunfei.urlparams.UrlParams;
import com.kedaxunfei.utils.HttpPostUtils;
import com.kedaxunfei.vo.TxCallLogoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
@Slf4j
public class TxCallLogoSchedule {
    @Resource
    private TenantCode tenantCode;
    @Resource
    private RemoteUrl remoteUrl;
    @Resource
    private HttpPostUtils httpPostUtils;
    @Resource
    private TxCallLogoDao txCallLogoDao;

    @Resource
    private RememberLastIdDao rememberLastIdDao;

    private String txCallLogoJianDeId = "0";

    private String txCallLogoFuYangId = "0";

    private String txCallLogoChunAnId = "0";

    private String txCallLogoTongLuId = "0";

    @Scheduled( cron = "${corn}")
    @Transactional
    @PostConstruct
    public void saveTxCallLogo() {
        Map<String, String> map = tenantCode.getData();
        Set<String> keySet = map.keySet();
        UrlParams urlParams = null;
        String v = null;
        String param = null;
        TxCallLogoVo txCallLogoVo = null;
        List<TxCallLogo> txCallLogos = null;
        List<TxCallLogoVo.Data> dataList = null;
        RememberLastId rememberLastId = null;
        for (String k : keySet) {
            urlParams = new UrlParams();
            v = map.get(k);
            urlParams.setTenantCode(v);
            urlParams.setQueryCount("100");
            if ("建德市".equals(k)) {
                urlParams.setLastID(txCallLogoJianDeId);
            } else if ("富阳区".equals(k)) {
                urlParams.setLastID(txCallLogoFuYangId);
            } else if ("淳安县".equals(k)) {
                urlParams.setLastID(txCallLogoChunAnId);
            } else {
                urlParams.setLastID(txCallLogoTongLuId);
            }
            txCallLogoVo = httpPostUtils.getResponse(TxCallLogoVo.class, JSONObject.toJSONString(urlParams), remoteUrl.getTxCallLogoUrl());
            if ("0".equals(txCallLogoVo.getResult())) {
                log.info(remoteUrl.getTxCallLogoUrl()+"接口返回失败信息 错误提示如下=" + txCallLogoVo.getMsg());
            }
            rememberLastId = rememberLastIdDao.findOne("1");
            if ("建德市".equals(k)) {
                txCallLogoJianDeId = txCallLogoVo.getLastId();
                rememberLastId.setTxCallLogoJianDeId(txCallLogoVo.getLastId());
            } else if ("富阳区".equals(k)) {
                txCallLogoFuYangId = txCallLogoVo.getLastId();
                rememberLastId.setTxCallLogoFuYangId(txCallLogoVo.getLastId());
            } else if ("淳安县".equals(k)) {
                txCallLogoChunAnId = txCallLogoVo.getLastId();
                rememberLastId.setTxCallLogoChunAnId(txCallLogoVo.getLastId());
            } else {
                txCallLogoTongLuId = txCallLogoVo.getLastId();
                rememberLastId.setTxCallLogoTongLuId(txCallLogoVo.getLastId());
            }
            rememberLastIdDao.save(rememberLastId);
            //保存数据
            dataList = txCallLogoVo.getData();
            txCallLogos = new ArrayList<>(dataList.size());
            List<TxCallLogo> finalTxCallLogos = new ArrayList<>();
            //TxCallLogo txCallLogo = null;

/* COID	呼叫流水号
            CallerNumber	来电号码
            CalledNumber	被叫号码
            InivrTime	进入IVR时间
            InqueneTime	进入队列时间
            RingTime	坐席振铃时间
            InseatTime	坐席摘机时间*/

            dataList.forEach((data) -> {
                TxCallLogo txCallLogo = new TxCallLogo();
                txCallLogo.setCallid(data.getCOID());
                txCallLogo.setCallerno(data.getCallerNumber());
                txCallLogo.setCalledno(data.getCalledNumber());
                txCallLogo.setInivrdt(data.getInivrTime());
                txCallLogo.setInquenedt(data.getInqueneTime());
                txCallLogo.setRingdt(data.getRingTime());
                txCallLogo.setInseatdt(data.getInseatTime());
                finalTxCallLogos.add(
                        txCallLogo
                );
            });

            txCallLogoDao.save(finalTxCallLogos);
            log.info(k + "地区txCallLogo表传输完成");

        }

    }

}

