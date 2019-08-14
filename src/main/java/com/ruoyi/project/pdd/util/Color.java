package com.ruoyi.project.pdd.util;

public enum Color {
    /*
    测试枚举
     */
    RED(0,"红色"),
    BLUE(1,"这是蓝色"),
    YELLOW(2,"这是黄色"),
    GREEN(3,"这是绿色");

    Color(int code,String desc){
        this.code=code;
        this.desc=desc;
    }

    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
