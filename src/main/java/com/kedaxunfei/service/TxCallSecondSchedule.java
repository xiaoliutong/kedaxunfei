package com.kedaxunfei.service;

import com.alibaba.fastjson.JSONObject;
import com.kedaxunfei.dao.TxCallSecondDao;
import com.kedaxunfei.entity.PublicTxCallSecond;
import com.kedaxunfei.properties.RemoteUrl;
import com.kedaxunfei.properties.TenantCode;
import com.kedaxunfei.urlparams.UrlParams;
import com.kedaxunfei.utils.HttpPostUtils;
import com.kedaxunfei.vo.TxCallSecondVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@Component
@SuppressWarnings("all")
public class TxCallSecondSchedule {


    @Resource
    private TenantCode tenantCode;
    @Resource
    private RemoteUrl remoteUrl;

    @Resource
    private TxCallSecondDao txCallSecondDao;

    @Resource
    private HttpPostUtils httpPostUtils;

    @Scheduled( cron = "${corn}")
    @Transactional
    @PostConstruct
    public void saveTxCallSecond() {
        Map<String, String> map = tenantCode.getData();
        Set<String> keySet = map.keySet();
        UrlParams urlParams = null;
        String v = null;
        String param = null;
        TxCallSecondVo txCallSecondVo = null;
        PublicTxCallSecond publicTxCallSecond = null;
        TxCallSecondVo.Data data = null;
        for (String k : keySet) {
            urlParams = new UrlParams();
            v = map.get(k);
            urlParams.setTenantCode(v);
            JSONObject.toJSONString(urlParams);
            txCallSecondVo = httpPostUtils.getResponse(TxCallSecondVo.class, param, remoteUrl.getTxCallSecondUrl());
            if ("0".equals(txCallSecondVo.getResult())) {
                log.info(remoteUrl.getTxCallSecondUrl()+"接口返回失败信息 错误提示如下=" + txCallSecondVo.getMsg());
            }

            data = txCallSecondVo.getData();
            publicTxCallSecond = new PublicTxCallSecond();
            publicTxCallSecond.setWaiters(data.getWaiters());
            publicTxCallSecond.setSignin(data.getSignin());
            publicTxCallSecond.setCalling(data.getCalling());
            publicTxCallSecond.setTidy(data.getTidy());
            publicTxCallSecond.setBusy(data.getBusy());
            publicTxCallSecond.setFree(data.getFree());
            publicTxCallSecond.setRest(data.getReset());
            txCallSecondDao.saveAndFlush(publicTxCallSecond);
            log.info(k + "地区txCallSecond数据保存完毕");
          /*  private String waiters;
            private String signin;
            private String calling;
            private String tidy;
            private String busy;
            private String free;
            private String reset;*/
        }


    }
}
