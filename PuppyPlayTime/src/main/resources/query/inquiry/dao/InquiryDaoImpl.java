package com.puppy.client.inquiry.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.puppy.client.inquiry.vo.InquiryVO;

@Repository
public class InquiryDaoImpl implements InquiryDao {

	@Autowired
	private SqlSession session;
	
	// 리스트
	@Override
	public List<InquiryVO> inquiryList() {
		return session.selectList("inquiryList");
	}

	// 글쓰기
	@Override
	public int inquiryInsert(InquiryVO ivo) {
		return session.insert("inquiryInsert", ivo);
	}

	// 글상세
	@Override
	public InquiryVO inquiryDetail(InquiryVO ivo) {
		return (InquiryVO)session.selectOne("inquiryDetail", ivo);
	}

}
