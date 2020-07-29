package com.kedaxunfei.service;

import com.alibaba.fastjson.JSONObject;
import com.kedaxunfei.dao.RememberLastIdDao;
import com.kedaxunfei.dao.TXtYhDao;
import com.kedaxunfei.dao.TxAgentoperDao;
import com.kedaxunfei.dao.TxYwclZxxxDao;
import com.kedaxunfei.entity.PublicTxAgentoperate;
import com.kedaxunfei.entity.RememberLastId;
import com.kedaxunfei.properties.RemoteUrl;
import com.kedaxunfei.properties.TenantCode;
import com.kedaxunfei.urlparams.UrlParams;
import com.kedaxunfei.utils.HttpPostUtils;
import com.kedaxunfei.vo.TxAgentOperateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
@Slf4j
public class TxAgentOperateSchedule {
    @Resource
    private TenantCode tenantCode;
    @Resource
    private RemoteUrl remoteUrl;
    @Resource
    private HttpPostUtils httpPostUtils;
    @Resource
    private TxAgentoperDao txAgentoperDao;

    @Resource
    private RememberLastIdDao rememberLastIdDao;

    @Resource
    private TXtYhDao tXtYhDao;

    private String txAgentOperateJianDeId = "0";

    private String txAgentOperateFuYangId = "0";

    private String txAgentOperateChunAnId = "0";

    private String txAgentOperateTongLuId = "0";


    @Scheduled( cron = "${corn}")
    @Transactional
    @PostConstruct
    public void saveTxAgentOperateSchedule() {
        Map<String, String> map = tenantCode.getData();
        Set<String> keySet = map.keySet();
        UrlParams urlParams = null;
        String v = null;
        String param = null;
        TxAgentOperateVo txAgentOperateVo = null;
        //List<PublicTxYwclZxsm> txYwclZxsms = null;
        List<TxAgentOperateVo.Data> dataList = null;
        RememberLastId rememberLastId = null;
        for (String k : keySet) {
            urlParams = new UrlParams();
            v = map.get(k);
            urlParams.setTenantCode(v);
            urlParams.setQueryCount("100");
            if ("建德市".equals(k)) {
                urlParams.setLastID(txAgentOperateJianDeId);
            } else if ("富阳区".equals(k)) {
                urlParams.setLastID(txAgentOperateFuYangId);
            } else if ("淳安县".equals(k)) {
                urlParams.setLastID(txAgentOperateChunAnId);
            } else {
                urlParams.setLastID(txAgentOperateTongLuId);
            }

            txAgentOperateVo = httpPostUtils.getResponse(TxAgentOperateVo.class, JSONObject.toJSONString(urlParams), remoteUrl.getTxYwclZxxxUrl());

            if ("0".equals(txAgentOperateVo.getResult())) {
                log.info(remoteUrl.getTxYwclZxxxUrl() + "调用失败 失败信息=" + txAgentOperateVo.getMsg());
            }
            rememberLastId = rememberLastIdDao.findOne("1");
            if ("建德市".equals(k)) {
                txAgentOperateJianDeId = txAgentOperateVo.getLastId();
                rememberLastId.setTxAgentOperateJianDeId(txAgentOperateVo.getLastId());
            } else if ("富阳区".equals(k)) {
                txAgentOperateFuYangId = txAgentOperateVo.getLastId();
                rememberLastId.setTxAgentOperateFuYangId(txAgentOperateVo.getLastId());
            } else if ("淳安县".equals(k)) {
                txAgentOperateChunAnId = txAgentOperateVo.getLastId();
                rememberLastId.setTxAgentOperateChunAnId(txAgentOperateVo.getLastId());
            } else {
                txAgentOperateTongLuId = txAgentOperateVo.getLastId();
                rememberLastId.setTxAgentOperateTongLuId(txAgentOperateVo.getLastId());
            }
            rememberLastIdDao.save(rememberLastId);
            dataList = txAgentOperateVo.getData();
            List<PublicTxAgentoperate> publicTxAgentoperates = new ArrayList<>(dataList.size());
            dataList.forEach((data)->{
              PublicTxAgentoperate publicTxAgentoperate = new PublicTxAgentoperate();
              publicTxAgentoperate.setZxgh(data.getEmployeeID());
              publicTxAgentoperate.setKssj(data.getStartTime());
              publicTxAgentoperate.setJssj(data.getEndTime());
              publicTxAgentoperate.setUnitcode(data.getDeptID());
              //操作类型
            });
            log.info(k+"地区操作表Operate数据传输完成");
        }
    }
}