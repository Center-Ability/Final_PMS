package com.bap.service;

import java.sql.SQLException;
import java.util.List;

import com.bap.domain.SnsVO;
import com.bap.dto.SnsDTO;

public interface SnsService {

	public void snsInsert(SnsVO snsVO) throws SQLException;
	
	public List<SnsDTO> snsSelectList(int pro_num) throws SQLException;
	
	public void snsDelete(int sns_no) throws SQLException;
	
}
