package com.puppy.client.inquiry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.puppy.client.inquiry.dao.InquiryDao;
import com.puppy.client.inquiry.vo.InquiryVO;

@Service
@Transactional
public class InquiryServiceImpl implements InquiryService {

	@Autowired
	private InquiryDao inquiryDao;
	
	// 리스트
	@Override
	public List<InquiryVO> inquiryList() {
		List<InquiryVO> myList = null;
		myList = inquiryDao.inquiryList();
		
		return myList;
	}

	// 글입력
	@Override
	public int inquiryInsert(InquiryVO ivo) {
		
		int result = 0;
		try {
			result = inquiryDao.inquiryInsert(ivo);
		} catch(Exception e) {
			e.printStackTrace();
			result = 0;
		}
		
		return result;
	}

	// 글 상세
	@Override
	public InquiryVO inquiryDetail(InquiryVO ivo) {
		InquiryVO detail = null;
		detail = inquiryDao.inquiryDetail(ivo);
		
		return detail;
	}

}
