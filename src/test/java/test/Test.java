package test;


import com.ruoyi.common.utils.StringUtils;

public class Test {

    public static void main(String[] args) throws Exception{

        /*String httpUrl = "//t00img.yangkeduo.com/goods/images/2018-12-27/ed260dc2-b9eb-459b-b015-6379c4aafcb1.jpg";

        httpUrl = httpUrl.split("\\?")[0];
        httpUrl = httpUrl.replace("//","http://");
        //httpUrl = "http://pvvi.cn//profile/upload/2019/08/13/87d5e42ee7fd18d663fd3196593ffff0.jpg";
        URL urll = new URL(httpUrl);
        File file = new File("D:/ruoyi/uploadPath"+File.separator+"temp"+File.separator+urll.getFile());
        HttpUtil.downloadFile(httpUrl,file);
        System.out.println(file.getAbsoluteFile());
        //2447641266
        //2447641266
        //2821531811
        //2821531811
        System.out.println(FileUtil.checksumCRC32(file));*/

        System.out.println(StringUtils.lastName("|aaa123","|"));
        System.out.println(StringUtils.lastNameBefore("aaa|123|","|"));



    }




}
