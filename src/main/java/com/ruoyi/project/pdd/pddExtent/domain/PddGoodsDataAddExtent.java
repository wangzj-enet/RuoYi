package com.ruoyi.project.pdd.pddExtent.domain;

import com.ruoyi.project.pdd.pddGoodsDataAdd.domain.PddGoodsDataAdd;
import com.ruoyi.project.pdd.pddGoodsPropertiesAdd.domain.PddGoodsPropertiesAdd;
import com.ruoyi.project.pdd.pddSkuListAdd.domain.PddSkuListAdd;

import java.util.List;

public class PddGoodsDataAddExtent{

    private PddGoodsDataAdd pddGoodsDataAdd;
    private List<PddSkuListAdd>  pddSkuListAddlist;
    private List<PddGoodsPropertiesAdd> pddGoodsPropertiesAddList;


    public List<PddGoodsPropertiesAdd> getPddGoodsPropertiesAddList() {
        return pddGoodsPropertiesAddList;
    }

    public void setPddGoodsPropertiesAddList(List<PddGoodsPropertiesAdd> pddGoodsPropertiesAddList) {
        this.pddGoodsPropertiesAddList = pddGoodsPropertiesAddList;
    }

    public List<PddSkuListAdd> getPddSkuListAddlist() {
        return pddSkuListAddlist;
    }

    public void setPddSkuListAddlist(List<PddSkuListAdd> pddSkuListAddlist) {
        this.pddSkuListAddlist = pddSkuListAddlist;
    }

    public PddGoodsDataAdd getPddGoodsDataAdd() {
        return pddGoodsDataAdd;
    }

    public void setPddGoodsDataAdd(PddGoodsDataAdd pddGoodsDataAdd) {
        this.pddGoodsDataAdd = pddGoodsDataAdd;
    }
}
