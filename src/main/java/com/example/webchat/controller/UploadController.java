package com.example.webchat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Author:   chenfeiliang
 * Description:
 */
@Controller
public class UploadController {

    public String filePath = "F:\\files\\";

    //上传图片跳转路径
    @RequestMapping("/uploadPage")
    public String upload(){
        return "uploadPage";
    }

    //跳转页面
    @RequestMapping("/fileUpload")
    public String fileUpload(){
        return "fileUpload";
    }
    //跳转页面
    @RequestMapping("/fileDownload")
    public String fileDownload(){
        return "download";
    }

    //文件上传处理器
    @RequestMapping(value = "uploadController",method = RequestMethod.POST)
    @ResponseBody
    public String fileUploadController(HttpServletRequest request, @RequestParam("file") MultipartFile file){

        //判断文件是否为空
        if(file.isEmpty()){
            return "请不要上传空文件!";
        }
        try {
            //获得文件的字节流
            byte[] bytes=file.getBytes();
            System.out.println("bytes:"+bytes);
            String fileName = System.currentTimeMillis()+file.getOriginalFilename();
            //获取文件保存的路径对象
            Path path = Paths.get(filePath+fileName);
            System.out.println("path:"+path);
            //将文件写入到目标路径中
            Files.write(path,bytes);
            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "文件上传失败！";
    }

    //文件下载处理器
    @RequestMapping("/download")
    @ResponseBody
    public void download(@RequestParam("fileName") String fileName, HttpServletResponse response){
        //下载文件名??不能固定死文件名
        //通过文件的保存文件夹路径加上文件的名字来获得文件
        File file=new File(filePath,fileName);
        System.out.println("file:"+file);

        if(file.exists()){  //判断文件是否存在
            //设置响应的内容格式，force-download表示只要点击下载按钮就会自动下载文件
            response.setContentType("application/octet-stream");
            //设置头信息，filename表示前端下载时的文件名
            response.addHeader("Content-Disposition",String.format("attachment; filename=\"%s\"", file.getName()));
            //进行读写操作
            byte[] buffer=new byte[2048];
            FileInputStream fileInputStream=null;
            BufferedInputStream bufferedInputStream=null;
            try{
                fileInputStream=new FileInputStream(file);
                bufferedInputStream=new BufferedInputStream(fileInputStream);
                //获取输出流
                OutputStream os=response.getOutputStream();
                //读取并且写入文件到输出流
                int i=bufferedInputStream.read(buffer);
                while(i!=-1){
                    os.write(buffer,0,i);
                    i=bufferedInputStream.read(buffer);
                }
                os.flush();
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                //关闭输入输出流
                try {
                    if(bufferedInputStream!=null){
                        bufferedInputStream.close();
                    }
                    if(fileInputStream!=null){
                        fileInputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //处理图片的控制器
    /*
     * 功能描述: 处理图片的控制器
     * @RequestParam("file")MultipartFile file 接受从前端thymeleaf上传的文件
     *
     * @param:   [req, file, m]
     * @return : java.lang.String
     * @author : chenfeiliang
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
            //变量，初始化为空
        String fileName = null;
        try {
            //根据“时间戳+文件名”创建新的文件名，这样即便是第二次上传相同名称的文件，也不会把第一次的文件覆盖了
            fileName = System.currentTimeMillis()+file.getOriginalFilename();
            // 通过req.getServletContext().getRealPath("") 获取当前项目的真实路径，然后拼接前面的文件名
            String realFileName=request.getServletContext().getRealPath("")+"uploaded"+ File.separator+fileName;
            //System.out.println("realFileName:"+realFileName);

            //第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录
           File realFile = new File(realFileName);
           realFile.getParentFile().mkdirs();
            //把浏览器上传的文件复制到希望的位置
           file.transferTo(realFile);
            //把文件名放在model里，以便后续显示用
            // model.addAttribute("fileName",fileName);
            // System.out.println("图片的存储地址为："+realFileName);

        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        }
        System.out.println("fileName:"+fileName);
        return "uploaded"+"/"+fileName;
    }
}