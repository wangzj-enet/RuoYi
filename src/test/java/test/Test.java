package test;


import com.ruoyi.project.pdd.util.PddMainStatusEnum;
import com.ruoyi.project.pdd.util.PddStatusEnum;

public class Test {

    public static void main(String[] args) throws Exception{

        System.out.println(PddMainStatusEnum.getEnum("00").getDesc());
        System.out.println(PddStatusEnum.getEnum("00").getDesc());


    }




}
