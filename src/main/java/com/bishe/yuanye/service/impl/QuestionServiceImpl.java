package com.bishe.yuanye.service.impl;

import com.alibaba.fastjson.JSON;
import com.bishe.yuanye.common.BuilderHelper;
import com.bishe.yuanye.dao.dto.QueryConditionDTO;
import com.bishe.yuanye.dao.dto.QuestionDTO;
import com.bishe.yuanye.dao.mapper.QuestionDTOMapper;
import com.bishe.yuanye.entity.request.QueryQuestionRequest;
import com.bishe.yuanye.entity.response.QueryQuestionResponse;
import com.bishe.yuanye.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

/**
 * Created by yuanye on 2017/4/24.
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionDTOMapper questionDTOMapper;

    private static final Logger logger = LoggerFactory.getLogger(QuestionServiceImpl.class);

    @Override
    public QueryQuestionResponse queryQuestion(QueryQuestionRequest request) {
        try {
            QueryQuestionResponse response = new QueryQuestionResponse();
            QueryConditionDTO queryConditionDTO = BuilderHelper.buildQueryCondition(request.questionQueryCondition);
            queryConditionDTO.setPageSize(request.pageSize);
            queryConditionDTO.setOffset((request.pageIndex - 1) * request.pageSize);
            List<QuestionDTO> questionDTOList = questionDTOMapper.queryQuestionByCondition(queryConditionDTO);

            return null;
        } catch (ParseException pe) {
            logger.error("查询题库时转化时间格式失败,查询条件:{}", JSON.toJSONString(request), pe);
            return new QueryQuestionResponse("查询条件异常");
        } catch (Exception e) {
            logger.error("题库查询失败,查询条件:{}", JSON.toJSONString(request), e);
            return new QueryQuestionResponse("查询失败");
        }
    }
}
