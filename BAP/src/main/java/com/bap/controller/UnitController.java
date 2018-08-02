package com.bap.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bap.domain.UnitDTOJson;
import com.bap.domain.UnitTeam;
import com.bap.domain.UnitTeamListJson;
import com.bap.domain.UnitVO;
import com.bap.dto.UnitDTO;
import com.bap.service.UnitService;

@Controller
@RequestMapping("/project")
public class UnitController {

	@Inject
	UnitService unitService;

	@RequestMapping(value = "/unit", method = RequestMethod.GET)
	public String unitCreate(HttpSession session, Model model) throws Exception {
		// 세션에서 현재 선택된 프로젝트 번호 가져오기
		int pro_num = (int)session.getAttribute("nowProject");
		
		// 프로젝트 번호로 프로젝트 이름 가져오기
		String pro_name = unitService.searchPro_titleById(pro_num);
		
		// 모델에 담아주기
		model.addAttribute("pro_name", pro_name);
		
		return "project/unit";
	}
	
	@RequestMapping(value = "/unit/create", method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String createUnit(String unit_title, String unit_start, String mem_id, String unit_content,
			String unit_end, HttpSession session) throws Exception {
		
		int pro_num = (int)session.getAttribute("nowProject");
		
		UnitVO unitVO = new UnitVO();
		unitVO.setMem_id(mem_id);
		unitVO.setPro_num(pro_num);
		unitVO.setUnit_content(unit_content);
		
		Date end = new SimpleDateFormat("yyyy-MM-dd").parse(unit_end);
		unitVO.setUnit_end(end);
		
		Date start = new SimpleDateFormat("yyyy-MM-dd").parse(unit_start);
		unitVO.setUnit_start(start);
		
		unitVO.setUnit_title(unit_title);
		
		unitService.create(unitVO);
		
		return "업무등록 완료";
	}

	@RequestMapping(value = "/unit/create", method = RequestMethod.GET)
	@ResponseBody
	public UnitTeamListJson unitTeam(HttpSession session) throws Exception {
		UnitTeamListJson unitTeamListJson = new UnitTeamListJson();
		int pro_num = (int)session.getAttribute("nowProject");
		List<UnitTeam> unitTeamList = unitService.getUnitTeamList(pro_num);
		System.out.println(unitTeamList);

		unitTeamListJson.setUnitTeamList(unitTeamList);

		return unitTeamListJson;
	}

	@RequestMapping(value = "/unit/delete", method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String delete(String unit_no_str) throws Exception {
		
		int unit_no = Integer.parseInt(unit_no_str);
		
		unitService.delete(unit_no);
		
		return "삭제되었습니다.";
	}

	@RequestMapping(value = "/unit", method = RequestMethod.POST)
	@ResponseBody
	public UnitDTOJson unitdetail(HttpSession session) throws Exception {
		
		UnitDTOJson unitDTOJson = new UnitDTOJson();
		
		int pro_num = (int)session.getAttribute("nowProject");
		List<UnitDTO> unitDTO = unitService.getUnitDTOList(pro_num);

		unitDTOJson.setUnitDTOList(unitDTO);
		System.out.println(unitDTOJson);
		
		return unitDTOJson;

	}
	

	
		
	/*@RequestMapping(value = "/unit2", method = RequestMethod.POST)
	@ResponseBody
	public UnitListJson unitJson() throws Exception {

		UnitListJson unitListJson = new UnitListJson();

		List<UnitVO> unitList = service.getUnitList();

		
		 * UnitVO unit01=new UnitVO("1111", "1111", "1111", new Date(), new Date(),
		 * "1111", "1111", 1111,1111); UnitVO unit02=new UnitVO("2222", "2222", "2222",
		 * new Date(), new Date(), "2222", "2222", 2222,2222);
		 * 
		 * unitList.add(unit01); unitList.add(unit02);
		 

		unitListJson.setUnitList(unitList);

		return unitListJson;

	}*/
	

}
