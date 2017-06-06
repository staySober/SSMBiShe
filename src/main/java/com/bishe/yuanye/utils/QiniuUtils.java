package com.bishe.yuanye.utils;

import java.io.IOException;
import java.util.Properties;


import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sober on 2017/3/10.
 */

public class QiniuUtils {

      private static final Logger logger = LoggerFactory.getLogger(QiniuUtils.class);
      //设置好账号的ACCESS_KEY和SECRET_KEY
      private String ACCESS_KEY; //这两个登录七牛 账号里面可以找到
      private String SECRET_KEY;
      //要上传的空间
      private String bucketname ; //对应要上传到七牛上 你的那个路径（自己建文件夹 注意设置公开)

      //密钥配置
      Auth auth ;
      //创建上传对象
      UploadManager uploadManager = new UploadManager();

      //简单上传，使用默认策略，只需要设置上传的空间名就可以了
      public String getUpToken(){
          return auth.uploadToken(bucketname);
      }
      //普通上传
      public boolean upload(byte[] file,String fileName) throws IOException {
          boolean flag;
        try {
          //调用put方法上传
          Response res = uploadManager.put(file, fileName, auth.uploadToken("waitsober"));
          //打印返回的信息
          logger.info("上传图片至七牛云成功,文件名:"+fileName);
          flag=true;
          } catch (QiniuException e) {
              Response r = e.response;
              // 请求失败时打印的异常的信息
              logger.info("上传图片失败:   Exception:"+r.bodyString());
               flag=false;
              try {
                  //响应的文本信息
                logger.info(r.bodyString());
              } catch (QiniuException e1) {
                  //ignore
              }
          }
          return flag;
      }


      public QiniuUtils() throws Exception {
          Properties properties = new Properties();
          ClassLoader classLoader = getClass().getClassLoader();
          properties.load(this.getClass().getClassLoader().getResourceAsStream("properties/resource.properties"));
          ACCESS_KEY= (String) properties.get("ACCESS_KEY");
          SECRET_KEY= (String) properties.get("SECRET_KEY");
          bucketname= (String) properties.get("bucketname");
          auth = Auth.create(ACCESS_KEY, SECRET_KEY);

      }

}
