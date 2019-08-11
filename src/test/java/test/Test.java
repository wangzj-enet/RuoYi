package test;

import com.ruoyi.project.pdd.pddGoodsDataOrigin.domain.PddGoodsDataOrigin;

public class Test {

    public static void main(String[] args) {
        Object a = 999;
        PddGoodsDataOrigin pddGoodsDataOrigin = new PddGoodsDataOrigin();
        pddGoodsDataOrigin.setBuyLimit(Long.valueOf(a.toString()));
        System.out.println(pddGoodsDataOrigin.getBuyLimit());
    }
}
