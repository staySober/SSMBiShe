package com.waitsober.service;

import com.waitsober.mapper.ImageUploadMapper;
import com.waitsober.pojo.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by sober on 2017/3/2.
 */
@Service
public class ImageUploadService {

    @Autowired
    ImageUploadMapper imageUploadMapper;

    public List<String> getAllImagePath() {
        return  imageUploadMapper.getAllImagePath();
    }

    public void insertImagePath(String name,String url,String title,String description) {
        imageUploadMapper.insertImagePath(name,url,title,description);
    }

    public void deleteImageByid(String id) {
        imageUploadMapper.deleteImageById(Integer.parseInt(id));
    }

    public Image selectImageById(String id) {
        return imageUploadMapper.selectImageById(Integer.parseInt(id));
    }

    public void updateImageById(Image image) {
        imageUploadMapper.updateImageById(image);
    }
}
