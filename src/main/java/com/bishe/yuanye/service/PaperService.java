package com.bishe.yuanye.service;

import java.util.List;

import com.bishe.yuanye.dao.dto.PaperDTO;
import com.bishe.yuanye.dao.dto.StudentAnswerMapDTO;
import com.bishe.yuanye.dao.dto.StudentCompletePaperDTO;
import com.bishe.yuanye.entity.Paper;
import com.bishe.yuanye.entity.Question;
import com.bishe.yuanye.entity.response.CreatePaperResponse;
import com.bishe.yuanye.entity.response.QuestionWithDetail;

/**
 * Created by sober on 2017/4/14.
 *
 * @author sober
 * @date 2017/04/14
 */

public interface PaperService {

     List<PaperDTO> getPaperByTeacherId(int id);

     List<StudentAnswerMapDTO> getStudentAnswerRelation(Integer studentId);

     List<Question> getQuestionByPaperId(Integer teacherId,Integer paperId);

    void submitPaper(Integer studentId, Integer paperId);

    List<StudentCompletePaperDTO> getPaperCompleteInfo(Integer studentId);

    List<Paper> getOtherPaper(int teacherId);

    void setShared(int paperId, int isShared);

    void setVisible(int paperId, int isVisible);

    List<QuestionWithDetail> getPaperQuestion(int paperId);

    CreatePaperResponse createPaper(String paperName, int teacherId);
}
