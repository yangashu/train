package com.trkj.train.config.dto.controller;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.trkj.train.config.Result;
import com.trkj.train.utils.AliOssUtil;
import io.netty.util.internal.ResourcesUtil;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {
    @Value("${server.port}")
    private String port;

    private String ip="localhost";


    /**
     * 上传接口
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public Result<?> upload(MultipartFile file) throws IOException {
        if (file.isEmpty()){
            return Result.error("-1","上传错误！！！");
        }
        String originalFilename = file.getOriginalFilename();  // 获取源文件的名称
        // 定义文件的唯一标识（前缀）
        String flag = IdUtil.fastSimpleUUID();
        String rootFilePath = System.getProperty("user.dir") + "/files/" + flag + "_" + originalFilename;  // 获取上传的路径
        FileUtil.writeBytes(file.getBytes(), rootFilePath);  // 把文件写入到上传的路径
        return Result.success("http://" + ip + ":" + port + "/files/" + flag);  // 返回结果 url
    }
    /**
     * 到存放图片的文件夹下面删除图片
     *
     * @param fileName
     * @return
     */
    public static boolean deletePicture(String fileName) {
        if (fileName == null) {
            return false;
        }
        String rootFilePath = System.getProperty("user.dir") + "/files/";// 获取文件图片的基本目录
        try {
            FileUtils.forceDeleteOnExit(new File(rootFilePath + fileName));
//            FileUtils.deleteDirectory(new File(rootFilePath + fileName));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

//        D:\我的学习软件\Git\train\train\files
//        String rootFilePath = System.getProperty("user.dir") + "/train/files/";
//        System.out.println(rootFilePath);
//        File file=new File(rootFilePath+"6ceff007af97422a8520ed46e1458b7f_17e0de2a6b4_cd2.png");
//        if (file.exists()){
//            if (file.delete()){
//                System.out.println(1);
//            }else{
//                System.out.println(0);
//            }
//        }else{
//            System.out.println("文件不存在");
//        }


        System.out.println(deletePicture("1.png"));
    }

    /**
     * 富文本文件上传接口
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/editor/upload")
    public JSON editorUpload(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();  // 获取源文件的名称
        // 定义文件的唯一标识（前缀）
        String flag = IdUtil.fastSimpleUUID();
        String rootFilePath = System.getProperty("user.dir") + "/files/" + flag + "_" + originalFilename;  // 获取上传的路径
        FileUtil.writeBytes(file.getBytes(), rootFilePath);  // 把文件写入到上传的路径
        String url = "http://" + ip + ":" + port + "/files/" + flag;
        JSONObject json = new JSONObject();
        json.set("errno", 0);
        JSONArray arr = new JSONArray();
        JSONObject data = new JSONObject();
        arr.add(data);
        data.set("url", url);
        json.set("data", arr);
        return json;  // 返回结果 url
    }

    /**
     * 下载接口
     * @param flag
     * @param response
     */
    @GetMapping("/{flag}")
    public void getFiles(@PathVariable String flag, HttpServletResponse response) {
        OutputStream os;  // 新建一个输出流对象
        String basePath = System.getProperty("user.dir") + "/files/";  // 定于文件上传的根路径
        List<String> fileNames = FileUtil.listFileNames(basePath);  // 获取所有的文件名称
        String fileName = fileNames.stream().filter(name -> name.contains(flag)).findAny().orElse("");  // 找到跟参数一致的文件
        try {
            if (StrUtil.isNotEmpty(fileName)) {
                response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
                response.setContentType("application/octet-stream");
                byte[] bytes = FileUtil.readBytes(basePath + fileName);  // 通过文件的路径读取文件字节流
                os = response.getOutputStream();   // 通过输出流返回文件
                os.write(bytes);
                os.flush();
                os.close();
            }
        } catch (Exception e) {
            System.out.println("文件下载失败");
        }
    }

    /**
     * OSS文件上传
     * @param file
     * @return
     */
    @PostMapping("/upload/oss")
    public Result<?> ossUpload(MultipartFile file) {
        return Result.success(AliOssUtil.upload("test/", file));  // 返回结果 url
    }

    /**
     * OSS文件删除
     * @param fileVO 文件存储路径
     * @return

    @DeleteMapping("/delete/oss")
    public Result<?> ossUpload(@RequestBody FileVO fileVO) {
        AliOssUtil.delete(fileVO.getFilekey());
        return Result.success();
    } */
}

