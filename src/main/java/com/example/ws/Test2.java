package com.example.ws;

import java.util.HashMap;
import java.util.Map;

public class Test2 {
    final static Map map = new HashMap<String,String>(){
        { put("准备中","1");
            put("生效","2");
            put("生效且协议签署","3");
            put("取消","4");
            put("云服务协议","1");
            put("私有云协议","2");
            put("增购模块协议","3");
            put("运营服务协议","4");
            put("培训服务协议","5");
            put("实施服务协议","6");
            put("技术开发协议","7");
            put("短信及邮件增补","8");
            put("授权代理合作协议","9");
            put("出货协议","10");
            put("指定客户协议","11");
            put("项目合作协议","12");
            put("战略合作协议","13");
            put("其他服务协议","14");
            put("代运营协议","15");
            put("补充协议","16");
            put("售后VIP服务包","17");
            put("项目管理费用","22");
            put("DM Hub订阅费","23");
            put("DM Hub部署费","24");
            put("DM Hub私有部署维护费","25");
            put("实施费(业务技术不分开)","26");
            put("业务实施费","27");
            put("技术实施费","28");
            put("运营服务费用","29");
            put("短信充值费用","30");
            put("邮件充值费用","31");
            put("其他费用","32");
            put("软件永久授权费用","33");
            put("未开票","1");
            put("申请开票","2");
            put("已开票","3");
            put("未收款","1");
            put("已收款","2");
        }
    };

    public static void main(String[] args) {
        int a = 1;

       // System.out.println(++a);
        System.out.println(a++);
    }
}
