package com.bap.dao;

import java.util.List;

import com.bap.domain.UserListVO;

public interface UserListDAO {
	
	
	//신입사원등록
	public void create(UserListVO vo)throws Exception;
	
	//사원상세보기
	public UserListVO read(String mem_id)throws Exception;
	
	
	
	//사원수정(직급, 재직여부)
	public void update(UserListVO vo)throws Exception;
	
	//사원 전체보기
	public List<UserListVO> listAll() throws Exception;
	
	

}
