package com.ruoyi.project.pdd.util;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.pdd.pddGoodsDataOrigin.domain.PddGoodsDataOrigin;
import com.ruoyi.project.pdd.pddGoodsPropertiesOrigin.domain.PddGoodsPropertiesOrigin;
import com.ruoyi.project.pdd.pddSkuListOrigin.domain.PddSkuListOrigin;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PddAnalysisUtils {

    public static PddGoodsDataOrigin JsonToBeanPddGoodsDataOrigin(JSONObject obj) {
        //数据映射结束
        //插入原商品表主表
        //数据转换成数据库对应对象，必填字段，页面填写使用字段，其他字段留后
        PddGoodsDataOrigin pddGoodsDataOrigin = new PddGoodsDataOrigin();
        //`main_id` bigint(20) DEFAULT NULL COMMENT '主记录id',
        //pddGoodsDataOrigin.setMainId(pddGoodsDownload2.getMainId());
        //`goods_id` bigint(20) DEFAULT NULL COMMENT '商品id',
        //pddGoodsDataOrigin.setGoodsId(pddGoodsDownload2.getGoodsId());
        //`third_id` bigint(20) DEFAULT NULL COMMENT '三方id',
        //`goods_name` varchar(255)  '商品标题',
        pddGoodsDataOrigin.setGoodsName(String.valueOf(obj.get("goodsName")));
        //`goods_type` bigint(20) DEFAULT NULL COMMENT '商品类型',
        //{'1': '普通商品','2':'进口商品','3':'直供商品','4':'直邮商品'}
        pddGoodsDataOrigin.setGoodsType(Long.valueOf(String.valueOf(obj.get("goodsType"))));
        //`goods_desc` varchar(255)  '商品描述',
        pddGoodsDataOrigin.setGoodsDesc(String.valueOf(obj.get("goodsDesc")));
        //`cat_id` bigint(20) DEFAULT NULL COMMENT '叶子类目ID',
        pddGoodsDataOrigin.setCatId(Long.valueOf(String.valueOf(obj.get("catID"))));
        pddGoodsDataOrigin.setCatId1(Long.valueOf(String.valueOf(obj.get("catID1"))));
        pddGoodsDataOrigin.setCatId2(Long.valueOf(String.valueOf(obj.get("catID2"))));
        pddGoodsDataOrigin.setCatId3(Long.valueOf(String.valueOf(obj.get("catID3"))));
        pddGoodsDataOrigin.setCatId4(Long.valueOf(String.valueOf(obj.get("catID4"))));
        //`tiny_name` varchar(255)  '商品短标题',
        //`country_id` bigint(20) DEFAULT NULL COMMENT '国家ID',
        if(StringUtils.isNotEmpty(String.valueOf(obj.get("country")))){
            pddGoodsDataOrigin.setCountryId(Long.valueOf(String.valueOf(obj.get("country"))));
        }

        //`warehouse` varchar(255)  '保税仓',
        //`customs` varchar(255)  '报关海关',
        //`is_customs` char(1)  '是否上报海关',
        //`market_price` bigint(20) DEFAULT NULL COMMENT '市场价格',
        //最大单买价格
        pddGoodsDataOrigin.setMarketPrice(Long.valueOf(String.valueOf(obj.get("maxNormalPrice"))));
        //`is_pre_sale` char(1)  '是否预售',
        //`pre_sale_time` bigint(20) DEFAULT NULL COMMENT '预售时间',
        //`shipment_limit_second` bigint(20) DEFAULT NULL COMMENT '承诺发货时间（ 秒）',
        //update
        //`cost_template_id` bigint(20) DEFAULT NULL COMMENT '物流运费模板ID',
        //update
        //`customer_num` bigint(20) DEFAULT NULL COMMENT '团购人数',
        List<Map<String, Object>> groupTypes = (List) obj.get("groupTypes");
        pddGoodsDataOrigin.setCustomerNum(Long.valueOf(String.valueOf(groupTypes.get(1).get("requireNum"))));
        //`buy_limit` bigint(20) DEFAULT NULL COMMENT '限购次数',
        pddGoodsDataOrigin.setBuyLimit(Long.valueOf(groupTypes.get(1).get("orderLimit").toString()));
        //`order_limit` bigint(20) DEFAULT NULL COMMENT '单次限量',
        pddGoodsDataOrigin.setOrderLimit(Long.valueOf(groupTypes.get(0).get("orderLimit").toString()));

        //`second_hand` char(1)  '是否二手商品',
        //{'0': '非二手','1':'二手'}
        pddGoodsDataOrigin.setSecondHand(String.valueOf(obj.get("isSecondHand")));

        //`warm_tips` varchar(255)  '水果类目温馨提示',
        //`out_goods_id` varchar(255)  '商品goods外部编码',
        //`image_url` varchar(255)  '商品活动主图',

        //`carousel_gallery` varchar(255)  '商品轮播图',
        //轮播图
        List<String> topGallery = (List) obj.get("topGallery");
        StringBuffer topGallerySu = new StringBuffer();
        for (String img :topGallery) {
            topGallerySu.append(img);
            topGallerySu.append("|");
        }
        pddGoodsDataOrigin.setCarouselGallery(StringUtils.lastNameBefore(topGallerySu.toString(),"|"));
        //`detail_gallery` varchar(255)  '商品详情图',
        //详情图
        List<Map<String,String>> detailGallery = (List) obj.get("detailGallery");
        StringBuffer detailGallerySu = new StringBuffer();
        for (Map map :detailGallery) {
            detailGallerySu.append(map.get("url"));
            detailGallerySu.append("|");
        }
        pddGoodsDataOrigin.setDetailGallery(StringUtils.lastNameBefore(detailGallerySu.toString(),"|"));
        //`invoice_status` bigint(20) DEFAULT NULL COMMENT '是否支持正品发票',
        //`quan_guo_lian_bao` bigint(20) DEFAULT NULL COMMENT '是否支持全国联保',
        //`zhi_huan_bu_xiu` bigint(20) DEFAULT NULL COMMENT '只换不修的天数',
        //`song_huo_ru_hu` varchar(255)  '送货入户模版id//',
        //`shang_men_an_zhuang` varchar(255)  '上门安装模版id//',
        //`song_huo_an_zhuang` varchar(255)  '送货入户并安装模版id//',
        //`mai_jia_zi_ti` varchar(255)  '买家自提模版id//',
        //`bad_fruit_claim` bigint(20) DEFAULT NULL COMMENT '坏果包赔',
        //`lack_of_weight_claim` bigint(20) DEFAULT NULL COMMENT '缺重包退',
        //`origin_country_id` bigint(20) DEFAULT NULL COMMENT '原产地id',


        //`oversea_goods_origin_id` bigint(20) DEFAULT NULL COMMENT '海外原id',
        //`carousel_video_origin_id` bigint(20) DEFAULT NULL COMMENT '商品视频',

        List<Map<String,Object>> videoGallery = (List)obj.get("videoGallery");
        StringBuffer videoGallerySu = new StringBuffer();
        for (Map<String,Object> map:videoGallery) {
            videoGallerySu.append(String.valueOf(map.get("videoUrl")));
            videoGallerySu.append("|");
        }
        pddGoodsDataOrigin.setCarouselVideoOrigin(StringUtils.lastNameBefore(videoGallerySu.toString(),"|"));
        //`is_folt` char(1)  '是否支持假一赔十',
        //`is_refundable` char(1)  '是否7天无理由退换货',
        //服务 退货包运费3 极速退款24 全场包邮1 7天退换2 48小时发货13
        Map<String,List<Map<String,Object>>> mallService = (Map) obj.get("mallService");
        List<Map<String,Object>> serviceList = mallService.get("service");
        StringBuffer mallServiceSu = new StringBuffer();
        for (Map<String,Object> map : serviceList) {
            String id = map.get("id").toString();
            mallServiceSu.append(id);
            mallServiceSu.append(",");
            String type = String.valueOf(map.get("type"));
            mallServiceSu.append(type);
            mallServiceSu.append("|");
            int idl = Integer.valueOf(id);
            switch (idl) {
                case 1:
                    System.out.println("idl");
                    break;
                case 2:
                    System.out.println("idl");
                    pddGoodsDataOrigin.setRefundableServer(type);
                    break;
                case 3:
                    System.out.println("idl");
                    break;
                case 13:
                    System.out.println("idl");
                    pddGoodsDataOrigin.setShipmentLimitServer(type);
                    break;
                case 24:
                    System.out.println("idl");
                    break;
                default:
                    System.out.println("未添加的服务...");
                    break;
            }

        }
        pddGoodsDataOrigin.setMallService(StringUtils.lastNameBefore(mallServiceSu.toString(),"|"));

        //`status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '00' COMMENT '状态',
        //`create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '创建者',
        //`create_time` datetime DEFAULT NULL COMMENT '创建时间',
        //`update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '更新者',
        //`update_time` datetime DEFAULT NULL COMMENT '更新时间',
        //`remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '备注信息',

        return  pddGoodsDataOrigin;
    }


    public static   List<PddGoodsPropertiesOrigin> JsonToBeanPddGoodsPropertiesOriginList(JSONObject obj) {
        //`goods_properties_origin_id` bigint(20) DEFAULT NULL COMMENT '商品属性列表',
        List<PddGoodsPropertiesOrigin> pddGoodsPropertiesOriginList = new ArrayList<>();

        List<Map<String,Object>> goodsProperty = (List) obj.get("goodsProperty");
        for (Map<String,Object> map : goodsProperty) {
            PddGoodsPropertiesOrigin pddGoodsPropertiesOrigin = new PddGoodsPropertiesOrigin();
            pddGoodsPropertiesOrigin.setGoodsId(Long.valueOf(String.valueOf(obj.get("goodsID"))));
            pddGoodsPropertiesOrigin.setValueUnit(String.valueOf(map.get("key")));
            List<String> valuesList =  ((JSONArray)map.get("values")).toList(String.class);
            StringBuffer valuesSu = new StringBuffer();
            for (String value :valuesList) {
                valuesSu.append(value);
                valuesSu.append("|");
            }
            pddGoodsPropertiesOrigin.setValue(StringUtils.lastNameBefore(valuesSu.toString(),"|"));
            pddGoodsPropertiesOriginList.add(pddGoodsPropertiesOrigin);
        }
        return  pddGoodsPropertiesOriginList;
    }

    public static List<PddSkuListOrigin> JsonToBeanPddSkuListOriginList(JSONObject obj) {
        //`sku_list_origin_id` bigint(20) DEFAULT NULL COMMENT 'sku对象列表',
        List<PddSkuListOrigin> pddSkuListOriginList = new ArrayList<>();
        List<Map<String,Object>> skus = (List) obj.get("skus");
        for (int i = 0; i < skus.size(); i++) {
            Map<String,Object> map = skus.get(i);
            PddSkuListOrigin pddSkuListOrigin = new PddSkuListOrigin();

            //"defaultQuantity":100,
            //"limitQuantity":999999,
            pddSkuListOrigin.setLimitQuantity(Long.valueOf(String.valueOf(map.get("limitQuantity"))));
            //"groupPrice":"55",
            BigDecimal multiPrice = new BigDecimal(String.valueOf(map.get("groupPrice")));
            pddSkuListOrigin.setMultiPrice(multiPrice);
            //"initQuantity":0,
            //"isOnSale":1,
            pddSkuListOrigin.setIsOnsale(String.valueOf(map.get("isOnSale")));
            //"normalPrice":"59",
            BigDecimal normalPrice = new BigDecimal(String.valueOf(map.get("normalPrice")));
            pddSkuListOrigin.setPrice(normalPrice);
            //"oldGroupPrice":"55",

            //"quantity":1000,
            pddSkuListOrigin.setQuantity(Long.valueOf(String.valueOf(map.get("quantity"))));
            //"skuExpansionPrice":"0",

            //"skuID":134218945776,
            pddSkuListOrigin.setOutSkuSn(String.valueOf(map.get("skuID")));
            //"soldQuantity":0,
            //"specs":[
            //    {
            //        "spec_key":"颜色",
            //        "spec_key_id":27205,
            //        "spec_value":"红精灵",
            //        "spec_value_id":17054783
            //    }
            //],
            StringBuffer specKeySu = new StringBuffer();
            StringBuffer specKeyIdSu = new StringBuffer();
            StringBuffer specValueSu = new StringBuffer();
            StringBuffer specValueIdSu = new StringBuffer();
            for (int j = 0; j < ((JSONArray)map.get("specs")).size(); j++) {
                Map<String,Object> specsMap = (Map)(((JSONArray)map.get("specs")).get(j));
                specKeySu.append(String.valueOf(specsMap.get("spec_key")));
                specKeySu.append("|");

                specKeyIdSu.append(specsMap.get("spec_key_id").toString());
                specKeyIdSu.append("|");

                specValueSu.append(String.valueOf(specsMap.get("spec_value")));
                specValueSu.append("|");

                specValueIdSu.append(specsMap.get("spec_value_id").toString());
                specValueIdSu.append("|");
            }

            pddSkuListOrigin.setSpecKey(StringUtils.lastNameBefore(specKeySu.toString(),"|"));
            pddSkuListOrigin.setSpecKeyId(StringUtils.lastNameBefore(specKeyIdSu.toString(),"|"));
            pddSkuListOrigin.setSpecValue(StringUtils.lastNameBefore(specValueSu.toString(),"|"));
            pddSkuListOrigin.setSpecValueId(StringUtils.lastNameBefore(specValueIdSu.toString(),"|"));
            //"thumbUrl":"//t00img.yangkeduo.com/goods/images/2018-12-27/0d0712db-90c4-4e92-b23e-397c30f4468d.jpg",
            pddSkuListOrigin.setThumbUrl(String.valueOf(map.get("thumbUrl")));
            //"unselectGroupPrice":"0"
            pddSkuListOriginList.add(pddSkuListOrigin);
        }
        return pddSkuListOriginList;
    }


}
