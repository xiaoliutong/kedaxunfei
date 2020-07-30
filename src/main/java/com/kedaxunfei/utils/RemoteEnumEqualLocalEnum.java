package com.kedaxunfei.utils;

public    class   RemoteEnumEqualLocalEnum {

private static   String criterion;
    /*2：保持,——7  保持
       5三方通话——18、21、22
       6转坐席——26  内部通话
       7转出——9、13、14、15
       4整理——19  话后*/
public static String getTrueType(String remoteParam){
    if ("7".equals(remoteParam)){
        criterion="2";
    }else if ("18".equals(remoteParam)||"21".equals(remoteParam)||"22".equals(remoteParam)){
        criterion="5";
    }else if ("26".equals(remoteParam)){
        criterion="6";
    }else if ("9".equals(remoteParam)||"13".equals(remoteParam)||"14".equals(remoteParam)||"15".equals(remoteParam)){
        criterion="7";
    }else if ("19".equals(remoteParam)){
        criterion="4";
    }

    return criterion;
}

    /* 2：保持,3,签入，4整理，5三方通话，6转坐席，7转出
    0	未连接
1	初始化
2	初始化话机
3	空闲
4	通话准备(播放工号)
5	通话准备(震铃)
6	通话
7	保持
8	外拨准备(输入号码)
9	外拨中
10	咨询请求中（震铃）
            11	咨询
12	咨询保持
13	保持呼外线中
14	保持外线通话
15	通话保持外线
16	监控准备(选择座席)
17	监控
18	强插三方
19	话后
20	被咨询
21	咨询三方
22	外线三方
23	离席
24	内呼准备(选择座席)
25	内呼中(震铃)
26	内部通话
27	等待物理连接
28	预览中
29	非实时业务
30	从属会议
31	等待IVR认证
32	单步转移中
33	内外线直接绑定的模式下的咨询状态，此时软电话不显示三方按钮。
            34	无设备座席在线
35	多方会议咨询通话状态
36	座席咨询时做切换操作（临时状态）
            37	座席咨做切换回到原咨询状态的操作（临时状态)
            38	座席被咨询时被保持的状态
39	外线咨询切换操作(临时状态)
40	外线保持切换操作(临时状态)
41	座席内部通话时的保持状态
42	座席内部通话被保持状态
43	IVR边外拨边转移，转移座席成功后的外拨状态
44	座席振铃是转移的状态
45	座席动态主叫外拨，等待外拨的状态。
            46	外拨等待回振状态
47	外拨正在回振的状态
48	内呼等待回振状态
49	内呼正在回振的状态*/
}
