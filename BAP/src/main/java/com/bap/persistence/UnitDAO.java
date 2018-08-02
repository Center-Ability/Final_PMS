package com.bap.persistence;

import java.sql.SQLException;
import java.util.List;

import com.bap.domain.UnitTeam;
import com.bap.domain.UnitVO;
import com.bap.dto.UnitDTO;

public interface UnitDAO {

	public List<UnitVO> getUnitList() throws SQLException;

	public void create(UnitVO unitVO) throws SQLException;

	public List<UnitTeam> getUnitTeamList(int pro_num) throws SQLException;

	public void delete(int unit_no) throws SQLException;

	public List<UnitDTO> getUnitDTOList(int pro_num) throws SQLException;
	
	// 내가 만든것
	public String searchPro_titleById(int pro_num) throws SQLException;
	
	
}
