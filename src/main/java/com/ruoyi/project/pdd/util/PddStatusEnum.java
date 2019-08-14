package com.ruoyi.project.pdd.util;

public enum PddStatusEnum {
    /*
    初始状态 数据处理中 数据结束 数据作废
    init    doing        end    Discard
     */
    INIT("00","初始"),
    DOING("09","处理中"),
    END("10","结束"),
    DISCARD("99","作废");

    PddStatusEnum(String code, String desc){
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
