package com.demo.myrxmvpframe.constants;

/**
 * 作者：zzr
 * 创建日期：2017/8/28
 * 描述：放置静态常量
 */

public class CommonConstants {
    /**
     * 请求成功的成功码
     */
    public static final String REQUEST_SUCCESS = "000000";

    /**
     * session过期
     */
    public static final String REQUEST_OUTOFDATE = "100106";

    /**
     * SharedPreferences 名称
     */
    public static final String SP_NAME = "XJD_CONFIG";
    /**
     * 输出日志的标志
     */
    public static final String MY_LOGGER_TAG = "---logger---";
    //base64编码前缀
    public static String PRE = "data:image/jpeg;base64,";

    /**
     * 操作系统名
     */
    public static final String OSNAME = "android";

    /**
     * 不是从首页跳转到登录页面(借款fragment)
     */
    public static boolean isNotHomeJumpFlag = false;

    /**
     * 点击还款跳转到登录页面
     */
    public static boolean isRepayJumpToLoginFlag = false;

    /**
     * 跳回借款首页
     */
    public static boolean isJumpToBorrowFrament = false;

    /**
     * 跳回还款首页
     */
    public static boolean isJumpToRepayFrament = false;
    /**
     * 跳回个人中心
     */
    public static boolean isJumpToMineFrament = false;

    /*
    * 根据婚姻状况限制直系联系人关系*/
    public static final String LIMITDIRECTION="limitDirect";
    public static final String MARRAGESTATE="marrageState";
    /**
     * 学历类型
     */
    public static final String[] xuelis = {"小学", "初中", "高中/中专", "大专", "本科", "硕士及以上"};
    public static final int[] xuelisCode={1,2,3,4,5,6};
    /**
     * 第一联系人关系
     */
    public static final String[] contactRelation1 = {"父母", "配偶"};
    public static final String[] contactRelation1Limit = {"父母"};
    public static final int [] contactRelation1Code={1,2};
    /**
     * 第二联系人关系
     */
    public static final String[] contactRelation2 = {"父母", "配偶", "兄弟姐妹", "亲戚", "朋友", "同学", "同事"};
    public static final String[] contactRelation2Limit = {"父母","兄弟姐妹", "亲戚", "朋友", "同学", "同事"};
    public static final int[] contactRelation2Code={1,2,3,4,5,6,7};
    /**
     * 婚姻状况
     */
    public static final String[] marriage = {"未婚", "已婚未育", "已婚已育", "离异", "其他"};
    public static final int[] marriageCode={0,1,2,3,4};
    /**
     * 职业类别
     */
    public static final String[] occupationType = {"自由职业", "工薪族", "私营业主", "网店卖家", "学生"};
    //public static final int [] occupationTypeCode
    /**
     * 职业一
     */
    public static final String[] occupation1 = {"无业", "务农", "家庭主妇", "钟点工", "临时工", "证券投资",
            "个体运输", "流动摊贩", "游戏代练", "其他"};

    /**
     * 职业二
     */
    public static final String[] occupation2 = {"政府机关", "学校", "医院(民办)", "医院(1级)", "医院(2级)", "医院(3级)",
            "医院(其他)", "企业(国有)", "企业(股份)", "企业(私营)", "企业(外资)", "企业(合资)", "企业(其他)", "私营商铺"};

    /**
     * 职业三
     */
    public static final String[] occupation3 = {"个体工商户", "企业法人"};

    /**
     * 职业四
     */
    public static final String[] occupation4 = {"淘宝店主", "微店", "其他网店"};

    /**
     * 职业五
     */
    public static final String[] occupation5 = {"学生"};

    /**
     * MD5加密安全ma
     */
    public static final String SALT_KEY = "cv34fsVKdjh*#HJkd;782313sab4Fb$2";

    /**
     * 是否第一次被顶掉
     */
    public static boolean isBadSession = false;

    /**
     * 是否从登陆页返回
     */
    public static boolean isBacckFromLogin = false;

}
