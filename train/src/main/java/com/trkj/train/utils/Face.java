package com.trkj.train.utils;

import com.baidu.aip.face.AipFace;
import com.trkj.train.config.Result;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class Face {

//    1、创建java代码和百度云交互的client对象
    private AipFace face=new AipFace("25105403","Id5yogqBTAaqttMZG9NkGd67","y4Q5RhU3XHu9KFer6PC32PTaOWsRxgSf");
    //人脸注册：向百度人脸库中添加一张图片
    public Result one(int staffId,String image) throws Exception {
//        2、参数设置
        HashMap<String,String> map=new HashMap<>();
        map.put("quality_control","NORMAL");//图片质量，四个等级 常规使用普通（NORMAL） NONE LOW NORMAL HIGH
        map.put("liveness_control","LOW");//是否活体检测，四个等级 常规使用普通（NORMAL） NONE LOW NORMAL HIGH
/*//        3、构造图片
        String path ="C:\\Users\\32105\\Pictures\\Saved Pictures\\aaa.jpg";
//        上传的图片 ，两种格式：URL地址，Base64字符串形式（readAllBytes有异常）
        byte[] bytes= Files.readAllBytes(Paths.get(path));
        String encode= Base64Util.encode(bytes);*/
//        4、调用api方法完成人脸注册
        /**
         * 参数一：（图片的URL或者图片的Base64字符串）
         * 参数二：图片形式（URL，BASE64)
         * 参数三：组ID（固定字符串）
         * 参数四：用户ID
         * 参数五：hashMap中的基本参数配置
         */
        JSONObject res=face.addUser(image,"BASE64","myImg",staffId+"",map);
//        输出是否上传成功
//        System.out.println(res.toString());
        int jg = Integer.parseInt(res.get("error_code").toString());
        if(jg==0){
            return Result.success("0","注册成功",null);
        }else {
            return Result.error("-1","注册失败");
        }
    }

    //    人脸检测：检测图片中是否有人脸信息
    public Result two(String image) throws Exception {
//        2.构造图片
//        String path = "C:\\Users\\32105\\Pictures\\Saved Pictures\\bbb.jpg";
////        上传的图片 ，两种格式：URL地址，Base64字符串形式（readAllBytes有异常）
//        byte[] bytes = Files.readAllBytes(Paths.get(path));
//        String image = Base64Util.encode(bytes);
//        3、调用api方法完成人脸检测
        /**
         * 参数一：（图片的URL或者图片的Base64字符串）
         * 参数二：图片形式（URL，BASE64）
         * 参数三：hashMap中的基本参数配置
         */
        JSONObject res = face.detect(image, "BASE64", null);

//        输出是否上传成功
//        System.out.println(res.toString());
        int jg = Integer.parseInt(res.get("error_code").toString());
        if(jg==0){
            return Result.success("0","检测到人脸",null);
        }else {
            return Result.error("-1","未检测到人脸");
        }
    }

    /**
     * 人脸搜索：根据用户上传的图片和指定人脸库中的所有人脸进行比较，
     * 获取相似度最高的一个或几个（默认为一个人）
     *
     * 返回值（数据，只取返回的第一条数据，查看对比评分，
     *        80分以上认定为同一个人）
     */
    public Result three(String imgurl){
/*
        System.out.println("图片："+imgurl);
//        2.构造图片
        String path ="C:\\Users\\32105\\Pictures\\Saved Pictures\\bbb.jpg";
//        上传的图片 ，两种格式：URL地址，Base64字符串形式（readAllBytes有异常）
        byte[] bytes= Files.readAllBytes(Paths.get(path));
        String image= Base64Util.encode(bytes);
*/
//        3.调用人脸aip的人脸搜索方法
        JSONObject res=face.search(imgurl,"BASE64","myImg",null);
//        System.out.println(res.toString());
        JSONObject result=res.getJSONObject("result");
        JSONArray list= result.getJSONArray("user_list");
        JSONObject user=list.getJSONObject(0);
//        System.out.println(user.get("score"));
        double jg=user.getDouble("score");
        int userID= user.getInt("user_id");
//        System.out.println(userID);
        if(jg>80){
            return Result.success("0","打卡成功",userID);
        }else {
            return Result.error("-1","啊哦！我不认识你哦！");
        }
    }

    //人脸更新：对百度人脸库中已有的照片进行更新
    public Result four(int userid,String image){
//        2、参数设置
        HashMap<String,String> map=new HashMap<>();
        map.put("quality_control","NORMAL");//图片质量，四个等级 常规使用普通（NORMAL） NONE LOW NORMAL HIGH
        map.put("liveness_control","LOW");//是否活体检测，四个等级 常规使用普通（NORMAL） NONE LOW NORMAL HIGH
/*//        3、构造图片
        String path ="C:\\Users\\32105\\Pictures\\Saved Pictures\\aaa.jpg";
//        上传的图片 ，两种格式：URL地址，Base64字符串形式（readAllBytes有异常）
        byte[] bytes= Files.readAllBytes(Paths.get(path));
        String encode= Base64Util.encode(bytes);*/
//        4、调用api方法完成人脸注册
        /**
         * 参数一：（图片的URL或者图片的Base64字符串）
         * 参数二：图片形式（URL，BASE64)
         * 参数三：组ID（固定字符串）
         * 参数四：用户ID
         * 参数五：hashMap中的基本参数配置
         */
//        int i=(int) (Math.random()*(9999-1000)+1000);//自动生成人脸库ID，范围可调
//        String id=i+"";//转换字符串
        JSONObject res=face.updateUser(image,"BASE64","myImg",userid+"",map);
//        输出是否上传成功
//        System.out.println(res.toString());
        int jg = Integer.parseInt(res.get("error_code").toString());
        if(jg==0){
            return Result.success("0","更新成功",null);
        }else {
            return Result.error("-1","更新失败,未检测到人脸");
        }
    }

    //获得用户
    public String staffFace(int userId){
        HashMap<String,String> map=new HashMap<>();
        map.put("quality_control","NORMAL");//图片质量，四个等级 常规使用普通（NORMAL） NONE LOW NORMAL HIGH
        map.put("liveness_control","LOW");//是否活体检测，四个等级 常规使用普通（NORMAL） NONE LOW NORMAL HIGH
        JSONObject obj=face.getUser(userId+"","myImg",map);
        System.out.println(obj.toString());
        return "";
    }


}
