package com.waitsober.mapper;

import com.waitsober.pojo.Image;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by sober on 2017/3/2.
 */
public interface ImageUploadMapper {
    List<String> getAllImagePath();

    void insertImagePath(@Param("name") String name,@Param("url")String url,@Param("title")String title,@Param("description")String description);

    void deleteImageById(int id);

    Image selectImageById(int id);

    void updateImageById(Image image);
}
