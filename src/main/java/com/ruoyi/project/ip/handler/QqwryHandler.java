package com.ruoyi.project.ip.handler;

import java.util.HashMap;
import java.util.Map;

import com.ruoyi.project.ip.config.RegionConfig;
import com.ruoyi.project.ip.qqwry.IPLocation;
import com.ruoyi.project.ip.qqwry.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class QqwryHandler implements IpHandler
{
    @Autowired
    private RegionConfig regionConfig;

    @Override
    public Map<String, Object> getRegion(String ip)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        try
        {
            IPLocation ipl = new IPLocation(regionConfig.getQqpath());
            Location loc = ipl.fetchIPLocation(ip);
            map.put("address", loc.country);
            map.put("remark", loc.area);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return map;
    }
}
