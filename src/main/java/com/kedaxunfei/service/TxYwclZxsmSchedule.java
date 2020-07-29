package com.kedaxunfei.service;

import com.alibaba.fastjson.JSONObject;
import com.kedaxunfei.dao.RememberLastIdDao;
import com.kedaxunfei.dao.TXtYhDao;
import com.kedaxunfei.dao.TxCallLogoDao;
import com.kedaxunfei.dao.TxYwclZxsmDao;
import com.kedaxunfei.entity.PublicTxYwclZxsm;
import com.kedaxunfei.entity.RememberLastId;
import com.kedaxunfei.entity.TXtYh;
import com.kedaxunfei.entity.TxCallLogo;
import com.kedaxunfei.properties.RemoteUrl;
import com.kedaxunfei.properties.TenantCode;
import com.kedaxunfei.urlparams.UrlParams;
import com.kedaxunfei.utils.HttpPostUtils;
import com.kedaxunfei.vo.TxCallLogoVo;
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
public class TxYwclZxsmSchedule {

    @Resource
    private TenantCode tenantCode;
    @Resource
    private RemoteUrl remoteUrl;
    @Resource
    private HttpPostUtils httpPostUtils;
    @Resource
    private TxYwclZxsmDao txYwclZxsmDao;

    @Resource
    private RememberLastIdDao rememberLastIdDao;

    @Resource
    private TXtYhDao tXtYhDao;

    private String txYwclZxsmJianDeId = "0";

    private String txYwclZxsmFuYangId = "0";

    private String txYwclZxsmChunAnId = "0";

    private String txYwclZxsmTongLuId = "0";

    @Scheduled( cron = "${corn}")
    @Transactional
    @PostConstruct
    public void saveTxYwclZxsmSchedule() {
        Map<String, String> map = tenantCode.getData();
        Set<String> keySet = map.keySet();
        UrlParams urlParams = null;
        String v = null;
        String param = null;
        TxYwclZxsmVo txYwclZxsmVo = null;
        //List<PublicTxYwclZxsm> txYwclZxsms = null;
        List<TxYwclZxsmVo.Data> dataList = null;
        RememberLastId rememberLastId = null;
        for (String k : keySet) {
            urlParams = new UrlParams();
            v = map.get(k);
            urlParams.setTenantCode(v);
            urlParams.setQueryCount("100");
            if ("建德市".equals(k)) {
                urlParams.setLastID(txYwclZxsmJianDeId);
            } else if ("富阳区".equals(k)) {
                urlParams.setLastID(txYwclZxsmFuYangId);
            } else if ("淳安县".equals(k)) {
                urlParams.setLastID(txYwclZxsmChunAnId);
            } else {
                urlParams.setLastID(txYwclZxsmTongLuId);
            }
            //调用接口
            txYwclZxsmVo =
                    httpPostUtils.getResponse(TxYwclZxsmVo.class, JSONObject.toJSONString(urlParams), remoteUrl.getTxYwclZxsmUrl());
            //取出来lastId  存入缓存（就是上面的属性中）
            if ("0".equals(txYwclZxsmVo.getResult())) {
                log.info(remoteUrl.getTxYwclZxsmUrl()+"接口返回失败信息 错误提示如下=" + txYwclZxsmVo.getMsg());
            }
            rememberLastId = rememberLastIdDao.findOne("1");
            if ("建德市".equals(k)) {
                txYwclZxsmJianDeId = txYwclZxsmVo.getLastId();
                rememberLastId.setTxYwclZxsmJianDeId(txYwclZxsmVo.getLastId());
            } else if ("富阳区".equals(k)) {
                txYwclZxsmFuYangId = txYwclZxsmVo.getLastId();
                rememberLastId.setTxYwclZxsmFuYangId(txYwclZxsmVo.getLastId());
            } else if ("淳安县".equals(k)) {
                txYwclZxsmChunAnId = txYwclZxsmVo.getLastId();
                rememberLastId.setTxYwclZxsmChunAnId(txYwclZxsmVo.getLastId());
            } else {
                txYwclZxsmTongLuId = txYwclZxsmVo.getLastId();
                rememberLastId.setTxYwclZxsmTongLuId(txYwclZxsmVo.getLastId());
            }
            rememberLastIdDao.save(rememberLastId);

            //保存到数据库
            dataList = txYwclZxsmVo.getData();
            List<PublicTxYwclZxsm> txYwclZxsms = new ArrayList<>(dataList.size());

            dataList.forEach((data) -> {
                PublicTxYwclZxsm publicTxYwclZxsm = new PublicTxYwclZxsm();
                TXtYh tXtYh = tXtYhDao.getByYH_DM(data.getName());
                publicTxYwclZxsm.setSmYhid(tXtYh.getYH_ID());
                publicTxYwclZxsm.setSmZxgh(data.getEmployeeID());
                publicTxYwclZxsm.setSmSmsc(data.getTimeLength());
                publicTxYwclZxsm.setSmKssj(data.getStartTime());
                publicTxYwclZxsm.setSmSjsj(data.getEndTime());
                txYwclZxsms.add(publicTxYwclZxsm);
            });
            txYwclZxsmDao.save(txYwclZxsms);
            log.info(k+"地区TxYwclZxsm表数据传输完成");
        }

    }
}