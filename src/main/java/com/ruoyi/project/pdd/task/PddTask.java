package com.ruoyi.project.pdd.task;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.pdd.pddExtent.service.IPddExtentService;
import com.ruoyi.project.pdd.pddGoodsDataAdd.domain.PddGoodsDataAdd;
import com.ruoyi.project.pdd.pddGoodsDataAdd.service.IPddGoodsDataAddService;
import com.ruoyi.project.pdd.pddGoodsDataOrigin.domain.PddGoodsDataOrigin;
import com.ruoyi.project.pdd.pddGoodsDataOrigin.service.IPddGoodsDataOriginService;
import com.ruoyi.project.pdd.pddGoodsDownload.domain.PddGoodsDownload;
import com.ruoyi.project.pdd.pddGoodsDownload.service.IPddGoodsDownloadService;
import com.ruoyi.project.pdd.pddGoodsMain.domain.PddGoodsMain;
import com.ruoyi.project.pdd.pddGoodsMain.service.IPddGoodsMainService;
import com.ruoyi.project.pdd.pddGoodsPropertiesAdd.domain.PddGoodsPropertiesAdd;
import com.ruoyi.project.pdd.pddGoodsPropertiesAdd.service.IPddGoodsPropertiesAddService;
import com.ruoyi.project.pdd.pddGoodsPropertiesOrigin.domain.PddGoodsPropertiesOrigin;
import com.ruoyi.project.pdd.pddGoodsPropertiesOrigin.service.IPddGoodsPropertiesOriginService;
import com.ruoyi.project.pdd.pddSkuListAdd.domain.PddSkuListAdd;
import com.ruoyi.project.pdd.pddSkuListAdd.service.IPddSkuListAddService;
import com.ruoyi.project.pdd.pddSkuListOrigin.domain.PddSkuListOrigin;
import com.ruoyi.project.pdd.pddSkuListOrigin.service.IPddSkuListOriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 定时任务调度测试
 * 
 * @author ruoyi
 */
@Component("pddTask")
public class PddTask {

    @Autowired
    private IPddGoodsMainService pddGoodsMainService;

    @Autowired
    private IPddGoodsDownloadService pddGoodsDownloadService;
    @Autowired
    private IPddExtentService pddExtentService;
    @Autowired
    private IPddGoodsDataOriginService pddGoodsDataOriginService;
    @Autowired
    private IPddGoodsPropertiesOriginService pddGoodsPropertiesOriginService;
    @Autowired
    private IPddSkuListOriginService pddSkuListOriginService;

    @Autowired
    private IPddGoodsDataAddService pddGoodsDataAddService;
    @Autowired
    private IPddGoodsPropertiesAddService pddGoodsPropertiesAddService;
    @Autowired
    private IPddSkuListAddService pddSkuListAddService;


    public void ryMultipleParams(String s, Boolean b, Long l, Double d, Integer i)
    {
        System.out.println(StringUtils.format("执行多参方法： 字符串类型{}，布尔类型{}，长整型{}，浮点型{}，整形{}", s, b, l, d, i));
    }

    public void ryParams(String params)
    {
        System.out.println("执行有参方法：" + params);
    }

    public void ryNoParams()
    {
        System.out.println("执行无参方法");
    }

    //    标记，下载，解析，复制，本地化，规则化，结束，作废
    public void downLoad(String params)
    {
        System.out.println("执行下载有参方法：" + params);
        PddGoodsMain pddGoodsMain = new PddGoodsMain();
        pddGoodsMain.setStatus("00");
        pddGoodsMain.setMainId(Long.parseLong(params));
        List<PddGoodsMain> list =  pddGoodsMainService.selectPddGoodsMainList(pddGoodsMain);
        for(PddGoodsMain pddGoodsMain2 : list){
            System.out.println(pddGoodsMain2.toString());
            //添加status表记录
            //添加download表记录
            //修改主表记录状态
        }
    }

    public void downLoad()
    {
        System.out.println("执行下载无参方法");
        PddGoodsMain pddGoodsMain = new PddGoodsMain();
        pddGoodsMain.setStatus("00");
        List<PddGoodsMain> list =  pddGoodsMainService.selectPddGoodsMainList(pddGoodsMain);
        for(PddGoodsMain pddGoodsMain2 : list){
            System.out.println(pddGoodsMain2.toString());
            //添加status表记录
            //添加download表记录
            //修改主表记录状态
        }
    }


    public void analysis(String params)
    {
        System.out.println("执行解析有参方法：" + params);
        PddGoodsMain pddGoodsMain = pddGoodsMainService.selectPddGoodsMainById(Long.valueOf(params));

        if ("01".equals(pddGoodsMain.getStatus())) {
            PddGoodsDownload pddGoodsDownload = new PddGoodsDownload();
            pddGoodsDownload.setMainId(pddGoodsMain.getMainId());
            pddGoodsDownload.setStatus("00");
            List<PddGoodsDownload> pddGoodsDownloadList = pddGoodsDownloadService.selectPddGoodsDownloadList(pddGoodsDownload);
            if(pddGoodsDownloadList.size() > 0){
                pddGoodsDownload = pddGoodsDownloadList.get(0);
                //数据映射开始
                String jsonData = pddGoodsDownload.getGoodsJson();
                JsonToBeanToInsert(jsonData,pddGoodsDownload);
            }

        }
    }

    public void analysis()
    {
        System.out.println("执行解析无参方法");
        PddGoodsMain pddGoodsMain = new PddGoodsMain();
        pddGoodsMain.setStatus("01");
        List<PddGoodsMain> pddGoodsMainList = pddGoodsMainService.selectPddGoodsMainList(pddGoodsMain);
        for (PddGoodsMain pddGoodsMain2:pddGoodsMainList) {
            PddGoodsDownload pddGoodsDownload = new PddGoodsDownload();
            pddGoodsDownload.setStatus("00");
            pddGoodsDownload.setMainId(pddGoodsMain2.getMainId());
            List<PddGoodsDownload>  list = pddGoodsDownloadService.selectPddGoodsDownloadList(pddGoodsDownload);
            if (list.size() > 0) {
                pddGoodsDownload = list.get(0);
                //数据映射开始
                String jsonData = pddGoodsDownload.getGoodsJson();
                JsonToBeanToInsert(jsonData,pddGoodsDownload);

            }
        }


    }

    private void JsonToBeanToInsert(String jsonData,PddGoodsDownload pddGoodsDownload) {
        JSONObject obj = JSONUtil.parseObj(jsonData);
        PddGoodsDataOrigin pddGoodsDataOrigin = JsonToBeanPddGoodsDataOrigin(obj);
        List<PddSkuListOrigin> pddSkuListOriginList = JsonToBeanPddSkuListOriginList(obj);
        List<PddGoodsPropertiesOrigin> pddGoodsPropertiesOriginList = JsonToBeanPddGoodsPropertiesOriginList(obj);
        pddExtentService.insertPddGoodsOrigin(pddGoodsDataOrigin, pddSkuListOriginList, pddGoodsPropertiesOriginList,pddGoodsDownload);
    }

    private PddGoodsDataOrigin JsonToBeanPddGoodsDataOrigin(JSONObject obj) {
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
        pddGoodsDataOrigin.setCarouselGallery(topGallerySu.toString());
        //`detail_gallery` varchar(255)  '商品详情图',
        //详情图
        List<Map<String,String>> detailGallery = (List) obj.get("detailGallery");
        StringBuffer detailGallerySu = new StringBuffer();
        for (Map map :detailGallery) {
            detailGallerySu.append(map.get("url"));
            detailGallerySu.append("|");
        }
        pddGoodsDataOrigin.setDetailGallery(detailGallerySu.toString());
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
        pddGoodsDataOrigin.setCarouselVideoOrigin(videoGallerySu.toString());
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
        pddGoodsDataOrigin.setMallService(mallServiceSu.toString());

        //`status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '00' COMMENT '状态',
        //`create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '创建者',
        //`create_time` datetime DEFAULT NULL COMMENT '创建时间',
        //`update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '更新者',
        //`update_time` datetime DEFAULT NULL COMMENT '更新时间',
        //`remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '备注信息',

        return  pddGoodsDataOrigin;
    }

    private  List<PddGoodsPropertiesOrigin> JsonToBeanPddGoodsPropertiesOriginList(JSONObject obj) {
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
            pddGoodsPropertiesOrigin.setValue(valuesSu.toString());
            pddGoodsPropertiesOriginList.add(pddGoodsPropertiesOrigin);
        }
        return  pddGoodsPropertiesOriginList;
    }

    private List<PddSkuListOrigin> JsonToBeanPddSkuListOriginList(JSONObject obj) {
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

            pddSkuListOrigin.setSpecKey(specKeySu.toString());
            pddSkuListOrigin.setSpecKeyId(specKeyIdSu.toString());
            pddSkuListOrigin.setSpecValue(specValueSu.toString());
            pddSkuListOrigin.setSpecValueId(specValueIdSu.toString());
            //"thumbUrl":"//t00img.yangkeduo.com/goods/images/2018-12-27/0d0712db-90c4-4e92-b23e-397c30f4468d.jpg",
            pddSkuListOrigin.setThumbUrl(String.valueOf(map.get("thumbUrl")));
            //"unselectGroupPrice":"0"
            pddSkuListOriginList.add(pddSkuListOrigin);
        }
        return pddSkuListOriginList;
    }

    public void copy(String params)
    {
        System.out.println("执行复制有参方法：" + params);
        //根据main查找数据，根据状态判断，关联到解析主表，解析主表到copy主表，sku表，属性表，添加状态表，修改主表状态,修改原始数据状态
        PddGoodsMain pddGoodsMain = pddGoodsMainService.selectPddGoodsMainById(Long.valueOf(params));
        if("02".equals(pddGoodsMain.getStatus())){
            copyFromGoodsMain(pddGoodsMain);
        }
    }




    public void copy()
    {
        System.out.println("执行复制无参方法");
        //根据状态查找主表，关联到解析主表，解析主表到copy主表，sku表，属性表，添加状态表，修改主表状态
        PddGoodsMain pddGoodsMain = new PddGoodsMain();
        pddGoodsMain.setStatus("02");
        List<PddGoodsMain> pddGoodsMainList = pddGoodsMainService.selectPddGoodsMainList(pddGoodsMain);
        for (PddGoodsMain pddGoodsMain2:pddGoodsMainList) {
            copyFromGoodsMain(pddGoodsMain2);
        }
    }

    /**
     * 根据pddGoodsMain 数据进行复制
     * @param pddGoodsMain
     */
    private void copyFromGoodsMain(PddGoodsMain pddGoodsMain) {
        PddGoodsDataOrigin pddGoodsDataOrigin = new PddGoodsDataOrigin();
        pddGoodsDataOrigin.setMainId(pddGoodsMain.getMainId());
        pddGoodsDataOrigin.setStatus("00");
        List<PddGoodsDataOrigin> pddGoodsDataOriginList = pddGoodsDataOriginService.selectPddGoodsDataOriginList(pddGoodsDataOrigin);
        if(pddGoodsDataOriginList.size() == 1){
            pddGoodsDataOrigin = pddGoodsDataOriginList.get(0);
            Long mainId = pddGoodsDataOrigin.getMainId();
            Long goodsDataOriginId = pddGoodsDataOrigin.getGoodsDataOriginId();

            PddGoodsDataAdd pddGoodsDataAdd = originToAddForData(pddGoodsDataOrigin);
            List<PddGoodsPropertiesAdd> pddGoodsPropertiesAddList = originToAddForProperties(mainId, goodsDataOriginId);
            List<PddSkuListAdd> pddSkuListAddList = originToAddForSkuList(mainId, goodsDataOriginId);
            //插入动作
            pddExtentService.insertPddGoodsAdd(pddGoodsDataAdd,pddSkuListAddList,pddGoodsPropertiesAddList);

        }
    }

    /**
     * 根据Origin生成add for PddGoodsDataAdd
     * @param pddGoodsDataOrigin
     * @return
     */
    private PddGoodsDataAdd originToAddForData(PddGoodsDataOrigin pddGoodsDataOrigin) {
        PddGoodsDataAdd pddGoodsDataAdd = new PddGoodsDataAdd();
        BeanUtil.copyProperties(pddGoodsDataOrigin,pddGoodsDataAdd);
        //传递修改id
        pddGoodsDataAdd.setGoodsDataAddId(pddGoodsDataOrigin.getGoodsDataOriginId());
        return pddGoodsDataAdd;
    }

    /**
     * 根据Origin生成add for Properties
     * @param mainId
     * @param goodsDataOriginId
     * @return
     */
    private List<PddGoodsPropertiesAdd> originToAddForProperties(Long mainId, Long goodsDataOriginId) {
        List<PddGoodsPropertiesAdd> pddGoodsPropertiesAddList = new ArrayList<>();
        PddGoodsPropertiesOrigin pddGoodsPropertiesOrigin = new PddGoodsPropertiesOrigin();
        pddGoodsPropertiesOrigin.setMainId(mainId);
        pddGoodsPropertiesOrigin.setGoodsDataOriginId(goodsDataOriginId);
        pddGoodsPropertiesOrigin.setStatus("00");
        List<PddGoodsPropertiesOrigin> pddGoodsPropertiesOriginList = pddGoodsPropertiesOriginService.selectPddGoodsPropertiesOriginList(pddGoodsPropertiesOrigin);
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
     * 根据Origin生成add for skuList
     * @param mainId
     * @param goodsDataOriginId
     * @return
     */
    private List<PddSkuListAdd> originToAddForSkuList(Long mainId, Long goodsDataOriginId) {
        List<PddSkuListAdd> pddSkuListAddList = new ArrayList<>();
        PddSkuListOrigin pddSkuListOrigin = new PddSkuListOrigin();
        pddSkuListOrigin.setMainId(mainId);
        pddSkuListOrigin.setGoodsDataOriginId(goodsDataOriginId);
        pddSkuListOrigin.setStatus("00");
        List<PddSkuListOrigin> pddSkuListOriginList = pddSkuListOriginService.selectPddSkuListOriginList(pddSkuListOrigin);
        for (PddSkuListOrigin pddSkuListOrigin2:pddSkuListOriginList) {
            PddSkuListAdd pddSkuListAdd = new PddSkuListAdd();
            BeanUtil.copyProperties(pddSkuListOrigin2,pddSkuListAdd);
            //传递修改id
            pddSkuListAdd.setSkuListAddId(pddSkuListOrigin2.getSkuListOriginId());
            pddSkuListAddList.add(pddSkuListAdd);
        }
        return pddSkuListAddList;
    }
    public void local(String params)
    {
        System.out.println("执行本地化有参方法：" + params);
        //查询主记录，判断主记录状态是否可用，查询copy主表，sku表，properties表，生成本地化url，保存
        PddGoodsMain pddGoodsMain = pddGoodsMainService.selectPddGoodsMainById(Long.valueOf(params));
        if("03".equals(pddGoodsMain.getStatus())){
            PddGoodsDataAdd pddGoodsDataAdd = new PddGoodsDataAdd();
            pddGoodsDataAdd.setStatus("00");
            pddGoodsDataAdd.setMainId(pddGoodsMain.getMainId());
            List<PddGoodsDataAdd> pddGoodsDataAddList = pddGoodsDataAddService.selectPddGoodsDataAddList(pddGoodsDataAdd);
            if(pddGoodsDataAddList.size() == 1){
                pddGoodsDataAdd = pddGoodsDataAddList.get(0);


                PddGoodsPropertiesAdd pddGoodsPropertiesAdd = new PddGoodsPropertiesAdd();
                pddGoodsPropertiesAdd.setStatus("00");
                pddGoodsPropertiesAdd.setMainId(pddGoodsDataAdd.getMainId());
                pddGoodsPropertiesAdd.setGoodsDataAddId(pddGoodsDataAdd.getGoodsDataAddId());
                List<PddGoodsPropertiesAdd> pddGoodsPropertiesAddList = pddGoodsPropertiesAddService.selectPddGoodsPropertiesAddList(pddGoodsPropertiesAdd);


                PddSkuListAdd pddSkuListAdd = new PddSkuListAdd();
                pddSkuListAdd.setStatus("00");
                pddSkuListAdd.setGoodsDataAddId(pddGoodsDataAdd.getGoodsDataAddId());
                pddSkuListAdd.setMainId(pddGoodsDataAdd.getMainId());
                List<PddSkuListAdd> pddSkuListAddList = pddSkuListAddService.selectPddSkuListAddList(pddSkuListAdd);
            }

        }

    }

    public void local()
    {
        System.out.println("执行本地化无参方法");
    }

    public void rule(String params)
    {
        System.out.println("执行规则化有参方法：" + params);
    }

    public void rule()
    {
        System.out.println("执行规则化无参方法");
    }

    public void end(String params)
    {
        System.out.println("执行结束有参方法：" + params);
    }

    public void end()
    {
        System.out.println("执行结束无参方法");
    }

}
