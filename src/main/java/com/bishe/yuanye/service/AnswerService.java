package com.bishe.yuanye.service;

/**
 * Created by sober on 2017/4/14.
 *
 * @author sober
 * @date 2017/04/14
 */
public interface AnswerService {

    public void setAnswer(Integer studentId,Integer paperId,Integer questionId,String answer);

    public void delAnswer(Integer studentId,Integer paperId,Integer questionId);

    String queryAnswer(Integer questionId, Integer paperId, Integer studentId);
}
