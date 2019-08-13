package com.ruoyi.project.ip.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;

import com.ruoyi.common.utils.IpUtils;
import com.ruoyi.common.utils.spring.SpringUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.ip.handler.IpHandler;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Api("真实IP归属地")
@Controller
@RequestMapping("/ip2region")
public class Ip2regionController
{
    private static final Map<String, String> map;
    static
    {
        map = new ConcurrentHashMap<String, String>();
        map.put("db", "dbHandler");
        map.put("baidu", "baiduHandler");
        map.put("qqwry", "qqwryHandler");
    }

    @RequestMapping("/getIp")
    @Log(title = "真实IP归属地", businessType = BusinessType.OTHER)
    @ResponseBody
    public AjaxResult region(HttpServletRequest request, String ip,
                             @RequestParam(name = "type", defaultValue = "db") String type)
    {
        if (null == ip) {ip = IpUtils.getIpAddr(request);}
        String handlername = map.get(type);
        if (null == handlername) {return AjaxResult.error("参数错误");}
        IpHandler handler = SpringUtils.getBean(handlername);
        Map<String,Object> map = new HashMap<>();
        map.put("data", handler.getRegion(ip));
        map.put("ip", ip);
        return  AjaxResult.success(map);
    }
}
