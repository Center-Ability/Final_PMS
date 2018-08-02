package com.bap.service;

import java.util.List;

import com.bap.domain.UnitTeam;
import com.bap.domain.UnitVO;
import com.bap.dto.UnitDTO;

public interface UnitService {

		
	public List<UnitVO> getUnitList() throws Exception;

	public void create(UnitVO unitVO) throws Exception;

	public List<UnitTeam> getUnitTeamList(int pro_num) throws Exception;
	
	public void delete(int unit_no) throws Exception;

	public List<UnitDTO> getUnitDTOList(int pro_num) throws Exception;
	
	// 내가 만든 것
	public String searchPro_titleById(int pro_num) throws Exception;
}
