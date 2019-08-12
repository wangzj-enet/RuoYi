package com.ruoyi.project.ip.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;



@Component
@ConfigurationProperties(prefix = "region")
public class RegionConfig
{
    private String  dbpath;

    private Integer algorithm;

    private String  qqpath;

    public String getDbpath() {
        return dbpath;
    }

    public void setDbpath(String dbpath) {
        this.dbpath = dbpath;
    }

    public Integer getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(Integer algorithm) {
        this.algorithm = algorithm;
    }

    public String getQqpath() {
        return qqpath;
    }

    public void setQqpath(String qqpath) {
        this.qqpath = qqpath;
    }
}
