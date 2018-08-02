package com.bap.service;

import java.sql.SQLException;
import java.util.List;

import com.bap.domain.SnsVO;
import com.bap.dto.SnsDTO;
import com.bap.persistence.SnsDAO;

public class SnsServiceImpl implements SnsService {

	private SnsDAO snsDAO;
	
	public void setSnsDAO(SnsDAO snsDAO) {
		this.snsDAO = snsDAO;
	}
	
	@Override
	public void snsInsert(SnsVO snsVO) throws SQLException {
		snsDAO.create(snsVO);
	}

	@Override
	public List<SnsDTO> snsSelectList(int pro_num) throws SQLException {
		return snsDAO.listAll(pro_num);
	}

	@Override
	public void snsDelete(int sns_no) throws SQLException {
		snsDAO.delete(sns_no);
	}
}
