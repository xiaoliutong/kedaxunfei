import com.kedaxunfei.StartApplication;
import com.kedaxunfei.dao.TxCallSecondDao;
import com.kedaxunfei.entity.PublicTxCallSecond;
import com.kedaxunfei.properties.TenantCode;
import com.kedaxunfei.vo.TxCallSecondVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.xml.crypto.Data;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StartApplication.class})
public class TestProperties {
    @Resource
    private TenantCode tenantCode;
    @Resource
    private TxCallSecondDao txCallSecondDao;

    @Value(value = "${corn}")
    private String corn;

    @Test
    public void testProperties() {
        //System.out.println(tenantCode.getData());
        PublicTxCallSecond publicTxCallSecond =
                txCallSecondDao.findOne("4028880571731ee20171731f9bb20003");
        publicTxCallSecond.setUnitcode("ccccc");
        publicTxCallSecond = txCallSecondDao.saveAndFlush(publicTxCallSecond);
        System.out.println(publicTxCallSecond);

        TxCallSecondVo txCallSecondVo = new TxCallSecondVo();
        TxCallSecondVo.Data data = txCallSecondVo.getData();
        System.out.println(corn);
    }
}
