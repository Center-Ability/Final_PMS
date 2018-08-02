package com.bap.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bap.domain.UserListVO;

public class UserListDAOImpl implements UserListDAO {

	private SqlSession sqlSession;

	public void setSqlSession(SqlSession session) {
		this.sqlSession = session;
	}

	private static String namespace = "BAP";

	@Override
	public void create(UserListVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".create", vo);

	}

	@Override
	public UserListVO read(String mem_id) throws Exception {
		// TODO Auto-generated method stub
		return (UserListVO) sqlSession.selectOne(namespace + ".read", mem_id);
	}

	@Override
	public void update(UserListVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		sqlSession.update(namespace + ".update", vo);
		

	}

	@Override
	public List<UserListVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".listAll");
	}

	

}
