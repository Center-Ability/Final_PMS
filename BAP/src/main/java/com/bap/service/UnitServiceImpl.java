package com.bap.service;

import java.util.List;

import com.bap.domain.UnitTeam;
import com.bap.domain.UnitVO;
import com.bap.dto.UnitDTO;
import com.bap.persistence.UnitDAO;

public class UnitServiceImpl implements UnitService {

	private UnitDAO unitDao;
			
	public void setUnitDAO(UnitDAO unitDAO) {
		this.unitDao = unitDAO;
	}

	@Override
	public List<UnitVO> getUnitList() throws Exception {
		List<UnitVO> unitList=unitDao.getUnitList();
		return unitList;
	}

	@Override
	public void create(UnitVO unitVO) throws Exception {
		unitDao.create(unitVO);
		
	}

	@Override
	public List<UnitTeam> getUnitTeamList(int pro_num) throws Exception {
		
		List<UnitTeam> unitteamList = unitDao.getUnitTeamList(pro_num);
		
		return unitteamList;
	}

	@Override
	public void delete(int unit_no) throws Exception {

		unitDao.delete(unit_no);
	}

	@Override
	public List<UnitDTO> getUnitDTOList(int pro_num) throws Exception {

		List<UnitDTO> unitDTOList = unitDao.getUnitDTOList(pro_num);
		
		return unitDTOList;
	}

	@Override
	public String searchPro_titleById(int pro_num) throws Exception {
		return unitDao.searchPro_titleById(pro_num);
	}
	

	


	
}
