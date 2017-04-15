package com.bishe.yuanye.dao.mapper;

import com.bishe.yuanye.dao.dto.QuestionDTO;

/**
 * Created by yuanye on 2017/3/17.
 */
public interface InitDTOMapper {

    int insert(QuestionDTO questionDTO);

    QuestionDTO selectById(Integer questionId);
}
