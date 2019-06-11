package com.osyunge.service;

import com.osyunge.dataobject.PictureResult;
import com.osyunge.utils.FastDFSClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class PictureServiceImpl implements PictureService {
    @Override
    public PictureResult uploadPic(MultipartFile picFile) {
        PictureResult result=new PictureResult();
        //判断图片是否为空
        if (picFile.isEmpty()){
            result.setError(1);
            result.setMessage("图片为空");
            return  result;
        }
        //上传图片到服务器
        try{
            //获取图片扩展名
            String originalFilename = picFile.getOriginalFilename();
            //截取图片的后缀,不需要“.”
            String exxtName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            FastDFSClient client=new FastDFSClient("classpath:Client.conf");
            String url=client.uploadFile(picFile.getBytes(),exxtName);
            String prexAddress="http://192.168.16.137/";
            String newurl=prexAddress+url;
            //将URL响应给客户端
            result.setError(0);
            result.setUrl(newurl);
        }catch (Exception e){
            e.printStackTrace();
            result.setError(1);
            result.setMessage("图片上传失败");
        }
        return result;
    }
}
