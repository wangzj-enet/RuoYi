package com.ruoyi.project.pdd.util;

import cn.hutool.core.bean.BeanUtil;
import com.ruoyi.project.pdd.pddGoodsDataAdd.domain.PddGoodsDataAdd;
import com.ruoyi.project.pdd.pddGoodsDataOrigin.domain.PddGoodsDataOrigin;
import com.ruoyi.project.pdd.pddGoodsPropertiesAdd.domain.PddGoodsPropertiesAdd;
import com.ruoyi.project.pdd.pddGoodsPropertiesOrigin.domain.PddGoodsPropertiesOrigin;
import com.ruoyi.project.pdd.pddSkuListAdd.domain.PddSkuListAdd;
import com.ruoyi.project.pdd.pddSkuListOrigin.domain.PddSkuListOrigin;

import java.util.ArrayList;
import java.util.List;

public class PddCopyUtils {

    /**
     * 根据Origin生成add for PddGoodsDataAdd
     * @param pddGoodsDataOrigin
     * @return
     */
    public static PddGoodsDataAdd originToAddForData(PddGoodsDataOrigin pddGoodsDataOrigin) {
        PddGoodsDataAdd pddGoodsDataAdd = new PddGoodsDataAdd();
        BeanUtil.copyProperties(pddGoodsDataOrigin,pddGoodsDataAdd);
        //传递修改id
        pddGoodsDataAdd.setGoodsDataAddId(pddGoodsDataOrigin.getGoodsDataOriginId());
        return pddGoodsDataAdd;
    }

    /**
     * copyOriginToAddForProperties
     * @param pddGoodsPropertiesOriginList
     * @return
     */
    public static  List<PddGoodsPropertiesAdd> originToAddForProperties(List<PddGoodsPropertiesOrigin> pddGoodsPropertiesOriginList) {
        List<PddGoodsPropertiesAdd> pddGoodsPropertiesAddList = new ArrayList<>();
        for (PddGoodsPropertiesOrigin pddGoodsPropertiesOrigin2:pddGoodsPropertiesOriginList) {
            PddGoodsPropertiesAdd pddGoodsPropertiesAdd = new PddGoodsPropertiesAdd();
            BeanUtil.copyProperties(pddGoodsPropertiesOrigin2,pddGoodsPropertiesAdd);
            //传递修改id
            pddGoodsPropertiesAdd.setGoodsPropertiesAddId(pddGoodsPropertiesOrigin2.getGoodsPropertiesOriginId());
            pddGoodsPropertiesAddList.add(pddGoodsPropertiesAdd);
        }
        return pddGoodsPropertiesAddList;
    }

    /**
     * originToAddForSkuList
     * @param pddSkuListOriginList
     * @return
     */
    public static  List<PddSkuListAdd> originToAddForSkuList(List<PddSkuListOrigin> pddSkuListOriginList) {
        List<PddSkuListAdd> pddSkuListAddList = new ArrayList<>();
        for (PddSkuListOrigin pddSkuListOrigin2:pddSkuListOriginList) {
            PddSkuListAdd pddSkuListAdd = new PddSkuListAdd();
            BeanUtil.copyProperties(pddSkuListOrigin2,pddSkuListAdd);
            //传递修改id
            pddSkuListAdd.setSkuListAddId(pddSkuListOrigin2.getSkuListOriginId());
            pddSkuListAddList.add(pddSkuListAdd);
        }
        return pddSkuListAddList;
    }


}
