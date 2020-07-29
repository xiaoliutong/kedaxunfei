package com.kedaxunfei.service;

import com.alibaba.fastjson.JSONObject;
import com.kedaxunfei.dao.RememberLastIdDao;
import com.kedaxunfei.dao.TXtYhDao;
import com.kedaxunfei.dao.TxYwclZxsmDao;
import com.kedaxunfei.dao.TxYwclZxxxDao;
import com.kedaxunfei.entity.PublicTxYwclZxxx;
import com.kedaxunfei.entity.RememberLastId;
import com.kedaxunfei.entity.TXtYh;
import com.kedaxunfei.properties.RemoteUrl;
import com.kedaxunfei.properties.TenantCode;
import com.kedaxunfei.urlparams.UrlParams;
import com.kedaxunfei.utils.HttpPostUtils;
import com.kedaxunfei.vo.TxCallZxxxVo;
import com.kedaxunfei.vo.TxYwclZxsmVo;
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
public class TxYwclZxxxSchedule {

    @Resource
    private TenantCode tenantCode;
    @Resource
    private RemoteUrl remoteUrl;
    @Resource
    private HttpPostUtils httpPostUtils;
    @Resource
    private TxYwclZxxxDao txYwclZxxxDao;

    @Resource
    private RememberLastIdDao rememberLastIdDao;

    @Resource
    private TXtYhDao tXtYhDao;

    private String txYwclZxxxJianDeId = "0";

    private String txYwclZxxxFuYangId = "0";

    private String txYwclZxxxChunAnId = "0";

    private String txYwclZxxxTongLuId = "0";

    @Scheduled( cron = "${corn}")
    @Transactional
    @PostConstruct
    public void saveTxYwclZxxxSchedule() {
        Map<String, String> map = tenantCode.getData();
        Set<String> keySet = map.keySet();
        UrlParams urlParams = null;
        String v = null;
        String param = null;
        TxCallZxxxVo txCallZxxxVo = null;
        //List<PublicTxYwclZxsm> txYwclZxsms = null;
        List<TxCallZxxxVo.Data> dataList = null;
        RememberLastId rememberLastId = null;
        for (String k : keySet) {
            urlParams = new UrlParams();
            v = map.get(k);
            urlParams.setTenantCode(v);
            urlParams.setQueryCount("100");
            if ("建德市".equals(k)) {
                urlParams.setLastID(txYwclZxxxJianDeId);
            } else if ("富阳区".equals(k)) {
                urlParams.setLastID(txYwclZxxxFuYangId);
            } else if ("淳安县".equals(k)) {
                urlParams.setLastID(txYwclZxxxChunAnId);
            } else {
                urlParams.setLastID(txYwclZxxxTongLuId);
            }

            txCallZxxxVo = httpPostUtils.getResponse(TxCallZxxxVo.class, JSONObject.toJSONString(urlParams), remoteUrl.getTxYwclZxxxUrl());

            if ("0".equals(txCallZxxxVo.getResult())) {
                log.info(remoteUrl.getTxYwclZxxxUrl() + "调用失败 失败信息=" + txCallZxxxVo.getMsg());
            }

            rememberLastIdDao.findOne("1");
            if ("建德市".equals(k)) {
                txYwclZxxxJianDeId = txCallZxxxVo.getLastId();
                rememberLastId.setTxYwclZxxxJianDeId(txCallZxxxVo.getLastId());
            } else if ("富阳区".equals(k)) {
                txYwclZxxxFuYangId = txCallZxxxVo.getLastId();
                rememberLastId.setTxYwclZxxxFuYangId(txCallZxxxVo.getLastId());
            } else if ("淳安县".equals(k)) {
                txYwclZxxxChunAnId = txCallZxxxVo.getLastId();
                rememberLastId.setTxYwclZxxxChunAnId(txCallZxxxVo.getLastId());
            } else {
                txYwclZxxxTongLuId = txCallZxxxVo.getLastId();
                rememberLastId.setTxYwclZxsmTongLuId(txCallZxxxVo.getLastId());
            }
            rememberLastIdDao.save(rememberLastId);
            dataList = txCallZxxxVo.getData();
            //遍历
            List<PublicTxYwclZxxx> publicTxYwclZxxxes = new ArrayList<>();
            dataList.forEach((data) -> {
                PublicTxYwclZxxx publicTxYwclZxxx = new PublicTxYwclZxxx();
                publicTxYwclZxxx.setXx_zxgh(data.getEmployeeID());
                publicTxYwclZxxx.setXx_kssj(data.getStartTime());
                publicTxYwclZxxx.setXx_jssj(data.getEndTime());
                publicTxYwclZxxx.setXx_qqxxsc(data.getTimeLength());
                TXtYh tXtYh = tXtYhDao.getByYH_DM(data.getName());
                publicTxYwclZxxx.setXx_yhid(tXtYh.getYH_ID());
                publicTxYwclZxxxes.add(publicTxYwclZxxx);
            });
            txYwclZxxxDao.save(publicTxYwclZxxxes);
            log.info(k + "地区zxxx表传输完成");
        }
    }
}