package com.waitsober.controller;

import com.waitsober.pojo.Image;
import com.waitsober.service.ImageUploadService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by sober on 2017/3/2.
 */
@Controller
public class AuthController {


    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(AuthController.class);
    @Value(value = "${imageFolder}")
    private String folder;


    @Autowired
    ImageUploadService imageUploadService;

    /**
     * 图片文件上传
     */
    @RequestMapping(value = "/image/upload", produces = MediaType.TEXT_PLAIN_VALUE + ";charset=utf-8")
    @ResponseBody
    public String fileUpload(@RequestParam MultipartFile[] uploadFile, HttpServletRequest request) {

        File f=new File(folder);
        if (!f.exists()) {
            f.mkdirs();
           LOGGER.info("文件夹创建成功");
        }
        //判断file数组不能为空并且长度大于0
        if(uploadFile!=null&&uploadFile.length>0){
            //循环获取file数组中得文件
            for(int i = 0;i<uploadFile.length;i++){
                MultipartFile file = uploadFile[i];
                //保存文件
                saveFile(file,request);
            }
        }
        return "success";
    }


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        List<String> paths = imageUploadService.getAllImagePath();
        modelAndView.addObject("imageList", paths);
        return modelAndView;
    }

    //delete图片
    @RequestMapping(value = "/image/delete", method = RequestMethod.GET)
    public void deleteImage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Image image = imageUploadService.selectImageById(id);
        //从image文件夹中删除
        File file = new File(image.getUrl().substring(1, image.getUrl().length()));
        String absolutePath = file.getAbsolutePath();
        File dir = new File(absolutePath);
        if (dir.exists()) {
            dir.delete();
        }
        //从DB中删除
        imageUploadService.deleteImageByid(id);
        request.getRequestDispatcher("/image/manager").forward(request, response);
    }


    //获取图片列表
    @RequestMapping(value = "/image/manager", method = RequestMethod.GET)
    public ModelAndView getImageList(ModelAndView modelAndView) {
        modelAndView.setViewName("manager");
        List<String> paths = imageUploadService.getAllImagePath();
        modelAndView.addObject("imageList", paths);
        return modelAndView;
    }


    //update图片
    @RequestMapping(value = "/image/update")
    public void updateImage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        //从图片库查找图片并改名
        Image image1 = imageUploadService.selectImageById(id);
        image1.setDescription(description);
        image1.setTitle(title);
        imageUploadService.updateImageById(image1);
        boolean imageChange = renameFile(folder, image1.getName(), name);
        //更新image信息到DB
        if (imageChange) {
            image1.setName(name);
            image1.setUrl(folder + "/" + name);
            imageUploadService.updateImageById(image1);
            request.getRequestDispatcher("/image/manager").forward(request, response);
        } else {
            response.setCharacterEncoding("utf-8");
            response.getWriter().print("重命名失敗!其他信息保存成功");

        }
    }


    private boolean renameFile(String path, String oldname, String newname) {
        boolean b = false;
        try {

            if (!oldname.equals(newname)) {//新的文件名和以前文件名不同时,才有必要进行重命名
                File oldfile = new File(new File(path+"/"+oldname).getAbsolutePath());
                File newfile = new File(new File(path+"/"+newname).getAbsolutePath());
                if (!oldfile.exists()) {
                    return false;//重命名文件不存在
                }
                if (newfile.exists())//若在该目录下已经有一个文件和新文件名相同，则不允许重命名
                    LOGGER.info("已經存在");
                else {
                    oldfile.renameTo(newfile);
                    b = true;
                }
            } else {
                LOGGER.info("新文件夾和就文件夾名稱重複");
            }
        } catch (Exception e) {
            b = false;
        }
        return b;
    }




    /***
     * 保存文件
     * @param file
     * @return
     */
    private boolean saveFile(MultipartFile file,HttpServletRequest request) {
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                // 文件保存路径
                String filePath = request.getSession().getServletContext().getRealPath(folder) + "/"
                        + file.getOriginalFilename();
                String title = request.getParameter("title");
                String description = request.getParameter("description");
                String originalFilename = file.getOriginalFilename();
                // 转存文件
                file.transferTo(new File(filePath));
                imageUploadService.insertImagePath(originalFilename,folder+"/"+originalFilename,title,description);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }


}
