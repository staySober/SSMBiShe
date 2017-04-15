package com.bishe.yuanye.service.impl;

import com.bishe.yuanye.dao.mapper.PaperDTOMapper;
import com.bishe.yuanye.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sober on 2017/4/14.
 *
 * @author sober
 * @date 2017/04/14
 */
public class PaperServiceImpl implements PaperService {

    @Autowired
	private PaperDTOMapper paperMapper;
}
