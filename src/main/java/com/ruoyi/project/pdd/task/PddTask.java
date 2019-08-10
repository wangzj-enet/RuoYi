package com.ruoyi.project.pdd.task;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.pdd.pddGoodsDataOrigin.domain.PddGoodsDataOrigin;
import com.ruoyi.project.pdd.pddGoodsDataOrigin.service.IPddGoodsDataOriginService;
import com.ruoyi.project.pdd.pddGoodsDownload.domain.PddGoodsDownload;
import com.ruoyi.project.pdd.pddGoodsDownload.service.IPddGoodsDownloadService;
import com.ruoyi.project.pdd.pddGoodsMain.domain.PddGoodsMain;
import com.ruoyi.project.pdd.pddGoodsMain.service.IPddGoodsMainService;
import com.ruoyi.project.pdd.pddGoodsMainStatus.domain.PddGoodsMainStatus;
import com.ruoyi.project.pdd.pddGoodsMainStatus.service.IPddGoodsMainStatusService;
import com.ruoyi.project.pdd.pddGoodsPropertiesOrigin.service.IPddGoodsPropertiesOriginService;
import com.ruoyi.project.pdd.pddSkuListOrigin.domain.PddSkuListOrigin;
import com.ruoyi.project.pdd.pddSkuListOrigin.service.IPddSkuListOriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    private IPddGoodsMainStatusService pddGoodsMainStatusService;
    @Autowired
    private IPddGoodsDownloadService pddGoodsDownloadService;
    @Autowired
    private IPddGoodsDataOriginService pddGoodsDataOriginService;

    @Autowired
    private IPddGoodsPropertiesOriginService pddGoodsPropertiesOriginService;
    @Autowired
    private IPddSkuListOriginService pddSkuListOriginService;

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

        PddGoodsDownload pddGoodsDownload = pddGoodsDownloadService.selectPddGoodsDownloadById(Long.parseLong(params));
        if ("00".equals(pddGoodsDownload.getStatus())) {
            //数据映射开始
            String jsonData = pddGoodsDownload.getGoodsJson();
            JSONObject obj = JSONUtil.parseObj(jsonData);
            String goodsName = (String) obj.get("goodsName");
            List<Map<String,String>> goodsProperty = (List) obj.get("goodsProperty");
            String goodsDesc = (String) obj.get("goodsDesc");
            List<String> topGallery = (List) obj.get("topGallery");

            List<Map<String,String>> detailGallery = (List) obj.get("detailGallery");

            List<Map<String,String>> skus = (List) obj.get("skus");
            String maxGroupPrice = (String) obj.get("maxGroupPrice");//最大团买价格
            String maxNormalPrice = (String) obj.get("maxNormalPrice");//最大单买价格

            //{'1': '普通商品','2':'进口商品','3':'直供商品','4':'直邮商品'}
            String goodsType = (String) obj.get("goodsType");
            //{'0': '非二手','1':'二手'}
            String isSecondHand = (String) obj.get("isSecondHand");
            //服务 退货包运费 极速退款 全场包邮 7天退换 48小时发货
            Map<String,List<Map<String,String>>> mallService = (Map) obj.get("mallService");


            //数据映射结束
            //数据转换成数据库对应对象，必填字段，页面填写使用字段，其他字段留后

            //插入原商品表主表
            //插入原商品表属性表
            //插入原商品表sku表
            //插入原商品表其他表



        }
    }

    public void analysis()
    {
        System.out.println("执行解析无参方法");
        PddGoodsDownload pddGoodsDownload = new PddGoodsDownload();
        pddGoodsDownload.setStatus("00");
        List<PddGoodsDownload>  list = pddGoodsDownloadService.selectPddGoodsDownloadList(pddGoodsDownload);
        for (PddGoodsDownload pddGoodsDownload2 : list) {
            //数据映射开始
            String jsonData = pddGoodsDownload2.getGoodsJson();
            JSONObject obj = JSONUtil.parseObj(jsonData);
            String goodsName = (String) obj.get("goodsName");
            List<Map<String,String>> goodsProperty = (List) obj.get("goodsProperty");
            String goodsDesc = (String) obj.get("goodsDesc");
            List<String> topGallery = (List) obj.get("topGallery");//轮播图

            List<Map<String,String>> detailGallery = (List) obj.get("detailGallery");//详情图

            List<Map<String,String>> skus = (List) obj.get("skus");
            Long maxGroupPrice = (Long) obj.get("maxGroupPrice");//最大团买价格
            Long maxNormalPrice = (Long) obj.get("maxNormalPrice");//最大单买价格

            //{'1': '普通商品','2':'进口商品','3':'直供商品','4':'直邮商品'}
            Long goodsType = (Long) obj.get("goodsType");
            //{'0': '非二手','1':'二手'}
            String isSecondHand = (String) obj.get("isSecondHand");
            //服务 退货包运费 极速退款 全场包邮 7天退换 48小时发货
            Map<String,List<Map<String,String>>> mallService = (Map) obj.get("mallService");

            String country = (String) obj.get("country");



            //数据映射结束
            //数据转换成数据库对应对象，必填字段，页面填写使用字段，其他字段留后
            PddGoodsDataOrigin pddGoodsDataOrigin = new PddGoodsDataOrigin();
            //`main_id` bigint(20) DEFAULT NULL COMMENT '主记录id',
            pddGoodsDataOrigin.setMainId(pddGoodsDownload2.getMainId());
            //`goods_id` bigint(20) DEFAULT NULL COMMENT '商品id',
            pddGoodsDataOrigin.setGoodsId(pddGoodsDownload2.getGoodsId());
            //`third_id` bigint(20) DEFAULT NULL COMMENT '三方id',
            //`goods_name` varchar(255)  '商品标题',
            pddGoodsDataOrigin.setGoodsName(goodsName);
            //`goods_type` bigint(20) DEFAULT NULL COMMENT '商品类型',
            pddGoodsDataOrigin.setGoodsType(goodsType);
            //`goods_desc` varchar(255)  '商品描述',
            pddGoodsDataOrigin.setGoodsDesc(goodsDesc);
            //`cat_id` bigint(20) DEFAULT NULL COMMENT '叶子类目ID',
            //update
            //`tiny_name` varchar(255)  '商品短标题',
            //`country_id` bigint(20) DEFAULT NULL COMMENT '国家ID',
            if(StringUtils.isNotEmpty(country)){
                pddGoodsDataOrigin.setCountryId(Long.parseLong(country));
            }
            //`warehouse` varchar(255)  '保税仓',
            //`customs` varchar(255)  '报关海关',
            //`is_customs` char(1)  '是否上报海关',
            //`market_price` bigint(20) DEFAULT NULL COMMENT '市场价格',
            pddGoodsDataOrigin.setMarketPrice(maxNormalPrice);
            //`is_pre_sale` char(1)  '是否预售',
            //`pre_sale_time` bigint(20) DEFAULT NULL COMMENT '预售时间',
            //`shipment_limit_second` bigint(20) DEFAULT NULL COMMENT '承诺发货时间（ 秒）',
            //update
            //`cost_template_id` bigint(20) DEFAULT NULL COMMENT '物流运费模板ID',
            //update
            //`customer_num` bigint(20) DEFAULT NULL COMMENT '团购人数',
            List<Map<String,Long>> groupTypes = (List) obj.get("groupTypes");
            Long customerNum1 = groupTypes.get(1).get("requireNum");
            pddGoodsDataOrigin.setCustomerNum(customerNum1);
            //`buy_limit` bigint(20) DEFAULT NULL COMMENT '限购次数',
            Long orderLimit1 = groupTypes.get(1).get("orderLimit");
            pddGoodsDataOrigin.setBuyLimit(orderLimit1);
            //`order_limit` bigint(20) DEFAULT NULL COMMENT '单次限量',
            Long orderLimit0 = groupTypes.get(0).get("orderLimit");
            pddGoodsDataOrigin.setOrderLimit(orderLimit0);
            //`is_refundable` char(1)  '是否7天无理由退换货',
            //update
            //`second_hand` char(1)  '是否二手商品',
            pddGoodsDataOrigin.setSecondHand(isSecondHand);
            //`is_folt` char(1)  '是否支持假一赔十',

            //`warm_tips` varchar(255)  '水果类目温馨提示',
            //`out_goods_id` varchar(255)  '商品goods外部编码',
            //`image_url` varchar(255)  '商品活动主图',

            //`carousel_gallery` varchar(255)  '商品轮播图',
            StringBuffer topGallerySu = new StringBuffer();
            for (String img :topGallery) {
                topGallerySu.append(img);
                topGallerySu.append("|");
            }
            pddGoodsDataOrigin.setCarouselGallery(topGallerySu.toString());
            //`detail_gallery` varchar(255)  '商品详情图',

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
            //`sku_list_origin_id` bigint(20) DEFAULT NULL COMMENT 'sku对象列表',
            PddSkuListOrigin pddSkuListOrigin = new PddSkuListOrigin();

            //`goods_properties_origin_id` bigint(20) DEFAULT NULL COMMENT '商品属性列表',
            //`oversea_goods_origin_id` bigint(20) DEFAULT NULL COMMENT '海外原id',
            //`carousel_video_origin_id` bigint(20) DEFAULT NULL COMMENT '商品视频',
            //`status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '00' COMMENT '状态',
            //`create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '创建者',
            //`create_time` datetime DEFAULT NULL COMMENT '创建时间',
            //`update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '更新者',
            //`update_time` datetime DEFAULT NULL COMMENT '更新时间',
            //`remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '备注信息',

            //插入原商品表主表
            //插入原商品表属性表
            //插入原商品表sku表
            //插入原商品表其他表



        }
    }

    public void copy(String params)
    {
        System.out.println("执行复制有参方法：" + params);
    }

    public void copy()
    {
        System.out.println("执行复制无参方法");
    }
    public void local(String params)
    {
        System.out.println("执行本地化有参方法：" + params);
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
