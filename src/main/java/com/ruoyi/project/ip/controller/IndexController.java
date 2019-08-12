package com.ruoyi.project.ip.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;

import com.ruoyi.common.utils.IpUtils;
import com.ruoyi.common.utils.spring.SpringUtils;
import com.ruoyi.project.ip.handler.IpHandler;
import com.ruoyi.project.ip.util.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@Controller
@RequestMapping("/ip2region")
public class IndexController
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
    public R region(HttpServletRequest request, String ip,
            @RequestParam(name = "type", defaultValue = "db") String type)
    {
        if (null == ip) {ip = IpUtils.getIpAddr(request);}
        String handlername = map.get(type);
        if (null == handlername) {return R.error("参数错误");}
        IpHandler handler = SpringUtils.getBean(handlername);
        return R.ok().put("data", handler.getRegion(ip)).put("ip", ip);
    }
}
