package com.bap.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bap.domain.MemVO;
import com.bap.domain.SnsVO;
import com.bap.dto.SnsDTO;
import com.bap.service.SnsService;

@Controller
@RequestMapping("/sns")
public class SnsController {

	@Autowired
	private SnsService service;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void snsGet(HttpSession session, Model model) throws Exception {
		int pro_num = (int)session.getAttribute("nowProject");
		List<SnsDTO> snsList = service.snsSelectList(pro_num);
		System.out.println(snsList);

		model.addAttribute("snsList", snsList);
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String snsPost(@ModelAttribute("sns_content") String sns_content, HttpSession session,
			RedirectAttributes redirectAttr) throws Exception {
		MemVO memVO = (MemVO) session.getAttribute("loginUser");
		SnsVO snsVO = new SnsVO();
		snsVO.setMem_id(memVO.getMem_id());
		snsVO.setPro_num((int)session.getAttribute("nowProject"));
		snsVO.setSns_content(sns_content);
		
		service.snsInsert(snsVO);

		redirectAttr.addFlashAttribute("vo", memVO);
		return "redirect:/sns/list";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String snsDelete(String sns_no) throws Exception {
		int sns_no_int = Integer.parseInt(sns_no);

		service.snsDelete(sns_no_int);

		return "redirect:/sns/list";
	}
}
