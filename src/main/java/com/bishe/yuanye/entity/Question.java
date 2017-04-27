package com.bishe.yuanye.entity;

import java.io.Serializable;

/**
 * Created by yuanye on 2017/3/18.
 */
public class Question implements Serializable{

    public int id;

    public int chapterId;

    public String keywordOne;

    public String keywordTwo;

    public String type;

    public String questionText;

    public String picOneUrl;

    public String picTwoUrl;

    public String answer;

    public int teacherId;
    
}
