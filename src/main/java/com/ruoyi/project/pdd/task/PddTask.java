package com.ruoyi.project.pdd.task;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.pdd.task.service.IPddTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 定时任务调度测试
 * 标记，下载，解析，复制，本地化，规则化，结束，作废
 * @author ruoyi
 */
@Component("pddTask")
public class PddTask {


    @Autowired
    private IPddTaskService pddTaskService;


    public void ryMultipleParams(String s, Boolean b, Long l, Double d, Integer i) {
        System.out.println(StringUtils.format("执行多参方法： 字符串类型{}，布尔类型{}，长整型{}，浮点型{}，整形{}", s, b, l, d, i));
    }

    public void ryParams(String params) {
        System.out.println("执行有参方法：" + params);
    }

    public void ryNoParams() {
        System.out.println("执行无参方法");
    }


    public void downLoad(String params) {
        System.out.println("执行下载有参方法：" + params);
        pddTaskService.downLoadByParams(params);
    }


    public void downLoad() {
        System.out.println("执行下载无参方法");
        pddTaskService.downLoadByNoParams();
    }


    public void analysis(String params) {
        System.out.println("执行解析有参方法：" + params);
        pddTaskService.analysisByParams(params);
    }


    public void analysis() {
        System.out.println("执行解析无参方法");
        pddTaskService.analysisByNoParams();


    }


    public void copy(String params) {
        System.out.println("执行复制有参方法：" + params);
        pddTaskService.copyByParams(params);
    }

    public void copy() {
        System.out.println("执行复制无参方法");
        pddTaskService.copyByNoParams();
    }


    public void local(String params) {
        System.out.println("执行本地化有参方法：" + params);
        pddTaskService.localByParams(params);

    }


    public void local() {
        System.out.println("执行本地化无参方法");
        pddTaskService.localByNoParams();

    }


    public void rule(String params) {
        System.out.println("执行规则化有参方法：" + params);
        pddTaskService.ruleByParams(params);
    }

    public void rule() {
        System.out.println("执行规则化无参方法");
        pddTaskService.ruleByNoParams();
    }

    public void end(String params) {
        System.out.println("执行结束有参方法：" + params);
    }

    public void end() {
        System.out.println("执行结束无参方法");
    }

}
