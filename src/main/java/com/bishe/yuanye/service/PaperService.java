package com.bishe.yuanye.service;

import java.util.List;

import com.bishe.yuanye.dao.dto.PaperDTO;
import com.bishe.yuanye.dao.dto.StudentAnswerMapDTO;

/**
 * Created by sober on 2017/4/14.
 *
 * @author sober
 * @date 2017/04/14
 */

public interface PaperService {

     List<PaperDTO> getPaperByTeacherId(int id);

     List<StudentAnswerMapDTO> getStudentAnswerRelation(Integer studentId);
}
