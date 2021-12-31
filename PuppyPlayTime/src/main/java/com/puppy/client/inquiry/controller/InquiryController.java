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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.puppy.client.inquiry.service.InquiryService;
import com.puppy.client.inquiry.vo.InquiryVO;
import com.puppy.client.member.vo.MemberVO;


@Controller
@RequestMapping(value="/inquiry")
public class InquiryController {

	private Logger log = LoggerFactory.getLogger(InquiryController.class);
	
	@Autowired
	private InquiryService inquiryService;
	
	
	// 리스트
	@RequestMapping(value="/inquiryList", method=RequestMethod.GET)
	public String inquiryList(Model model) {
		log.info("inquiryList 호출 성공");
		
		List<InquiryVO> inquiryList = inquiryService.inquiryList();
		model.addAttribute("inquiryList", inquiryList);
		model.addAttribute("data");
		
		return "/client/inquiry/inquiryList";
	}
	
	// 글쓰기 폼
	@RequestMapping(value="/inquiryWrite")
	public String inquiryWrite() {
		log.info("inquiryList 호출 성공");
		
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
			url = "/inquiry/inquiryWrite";
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
	
	//글수정 폼
	@RequestMapping(value="/inquiryUpdate", method=RequestMethod.GET)
	public String inquiryUpdateForm(InquiryVO ivo, Model model) {
		
		model.addAttribute("updateData", inquiryService.inquiryDetail(ivo));
		
		System.out.println(ivo.getQ_no());
		return "/client/inquiry/inquiryUpdate";
	}
	
	// 글수정 구현
	@RequestMapping(value="/inquiryUpdate", method=RequestMethod.POST)
	public String inquiryUpdate(@ModelAttribute InquiryVO ivo) {
		log.info("inquiryUpdate 호출 성공");
		
		int result = 0;
		String url = "";
		
		result = inquiryService.inquiryUpdate(ivo);
		
		if(result == 1) {
			url="/inquiry/inquiryDetail?q_no="+ivo.getQ_no();
		} else {
			url="/inquiry/inquiryUpdate?q_no="+ivo.getQ_no();
		}
		
		return "redirect:"+url;
	}
	
	// 글삭제 구현
	@RequestMapping(value="/inquiryDelete")
	public String inquiryDelete(@ModelAttribute InquiryVO ivo) {
		log.info("inquiryDelete 호출 성공");
		
		int result = 0;
		String url = "";
		
		result = inquiryService.inquiryDelete(ivo.getQ_no());
		
		if(result==1) {
			url="/inquiry/inquiryList";
		} else {
			url = "/inquiry/inquiryDetail?q_no=" + ivo.getQ_no();
		}
		return "redirect:" + url;
	}
	
}
