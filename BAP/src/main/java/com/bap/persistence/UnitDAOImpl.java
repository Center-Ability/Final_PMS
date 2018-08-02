package com.bap.persistence;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bap.domain.UnitTeam;
import com.bap.domain.UnitVO;
import com.bap.dto.UnitDTO;


public class UnitDAOImpl implements UnitDAO {
private SqlSession session;
	
	public void setSqlSession(SqlSession session)
	{
		this.session=session;
	}

	private static final String namespace = "com.bap.mappers.unit-Mapper";
	
	
	@Override
	public List<UnitVO> getUnitList() throws SQLException {
		// TODO Auto-generated method stub
		List<UnitVO> unitList=session.selectList(namespace + ".list", null);
		return unitList;
	}


	@Override
	public void create(UnitVO unitVO) throws SQLException {
		System.out.println("시작");
		session.insert(namespace + ".create", unitVO);
		System.out.println("끝");
	}


	@Override
	public List<UnitTeam> getUnitTeamList(int pro_num) throws SQLException {
		// TODO Auto-generated method stub
		List<UnitTeam> unitTeamList = session.selectList(namespace + ".team", pro_num);
		return unitTeamList;
	}
	
	public void delete(int unit_no) throws SQLException {
		System.out.println("no : " + unit_no);
		System.out.println("삭제 시작");
		session.delete(namespace + ".deleteUnit", unit_no);
		System.out.println("삭제 끝");
	}


	@Override
	public List<UnitDTO> getUnitDTOList(int pro_num) throws SQLException {

		List<UnitDTO> unitDTOList = session.selectList(namespace + ".detail", pro_num);
		
		return unitDTOList;
		
	}


	// 내가 만든 것
	@Override
	public String searchPro_titleById(int pro_num) throws SQLException {
		return (String)session.selectOne(namespace + ".searchPro_titleById", pro_num);
	}
	
}
