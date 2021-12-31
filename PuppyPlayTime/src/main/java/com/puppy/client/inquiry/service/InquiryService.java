package com.puppy.client.inquiry.service;

import java.util.List;

import com.puppy.client.inquiry.vo.InquiryVO;
import com.puppy.client.member.vo.MemberVO;

public interface InquiryService {

	public List<InquiryVO> inquiryList();

	public int inquiryInsert(InquiryVO ivo);

	public InquiryVO inquiryDetail(InquiryVO ivo);

	public int inquiryUpdate(InquiryVO ivo);

	public int inquiryDelete(int q_no);

	public int memberPw(String m_pw, int q_no);
}
