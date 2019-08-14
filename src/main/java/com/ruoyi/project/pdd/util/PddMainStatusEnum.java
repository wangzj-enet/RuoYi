package com.ruoyi.project.pdd.util;

public enum PddMainStatusEnum {
    /*
    标记，下载，解析，复制，本地化，规则化，结束，作废
    init download analysis copy local rule end Discard
     */
    INIT("00","标记"),
    DOWNLOAD("01","下载"),
    ANALYSIS("02","解析"),
    COPY("03","复制"),
    LOCAL("04","本地化"),
    RULE("05","规则化"),
    END("10","结束"),
    DISCARD("99","作废");

    PddMainStatusEnum(String code, String desc){
        this.code=code;
        this.desc=desc;
    }

    private String code;
    private String desc;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
