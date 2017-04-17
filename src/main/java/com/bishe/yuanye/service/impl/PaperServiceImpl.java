package com.bishe.yuanye.service.impl;

import com.bishe.yuanye.dao.mapper.PaperDTOMapper;
import com.bishe.yuanye.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sober on 2017/4/14.
 *
 * @author sober
 * @date 2017/04/14
 */
@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
	private PaperDTOMapper paperMapper;
}
