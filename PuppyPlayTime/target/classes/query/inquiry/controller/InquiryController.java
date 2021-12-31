package com.puppy.client.inquiry.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.puppy.client.inquiry.service.InquiryService;
import com.puppy.client.inquiry.vo.InquiryVO;

@Controller
@RequestMapping(value="/inquiry")
public class InquiryController {

	private Logger log = LoggerFactory.getLogger(InquiryController.class);
	
	@Autowired
	private InquiryService inquiryService;
	
	// 리스트 구현하기
	@RequestMapping(value="/inquiryList", method=RequestMethod.GET)
	public String inquiryList(Model model) {
		log.info("inquiryList 호출 성공");
		
		List<InquiryVO> inquiryList = inquiryService.inquiryList();
		
		model.addAttribute("inquiryList", inquiryList);
		model.addAttribute("data");
		
		return "client/inquiry/inquiryList";
	}
	
	// 글쓰기 출력
	@RequestMapping(value="/inquiryWrite")
	public String inquiryWrite() {
		log.info("inquiryWrite 호출 성공");
		
		return "/client/inquiry/inquiryWrite";
	}
	
	// 글쓰기 구현
	@RequestMapping(value="/inquiryInsert", method=RequestMethod.POST)
	public String inquiryInsert(@ModelAttribute InquiryVO ivo, Model model) {
		log.info("inquiryInsert 호출 성공");
		
		int result = 0;
		String url = "";
		
		result = inquiryService.inquiryInsert(ivo);
		
		if(result == 1) {
			url = "/inquiry/inquiryList";
		} else {
			model.addAttribute("code", 1);
			url = "/inquiry/inquiryList";
		}
		
		return "redirect:" + url;
	}
	
	// 글 상세보기
	@RequestMapping(value="/inquiryDetail", method=RequestMethod.GET)
	public String inquiryDetail(@ModelAttribute InquiryVO ivo, Model model) {
		log.info("inquiryDetail 호출 성공");
		log.info("q_no = " + ivo.getQ_no());
		
		InquiryVO detail = new InquiryVO();
		detail = inquiryService.inquiryDetail(ivo);
		
		if(detail != null) {
			detail.setQ_content(detail.getQ_content().toString().replaceAll("\n", "<br>"));
		}
		model.addAttribute("detail", detail);
		
		return "client/inquiry/inquiryDetail";
	}
}
