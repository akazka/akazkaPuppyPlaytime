package com.puppy.client.inquiry.dao;

import java.util.List;

import com.puppy.client.inquiry.vo.InquiryVO;

public interface InquiryDao {

	public List<InquiryVO> inquiryList();

	public int inquiryInsert(InquiryVO ivo);

	public InquiryVO inquiryDetail(InquiryVO ivo);

}
