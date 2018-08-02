package com.bap.persistence;

import java.util.List;

import com.bap.domain.DocAttachVO;
import com.bap.domain.DocVO;
import com.bap.domain.SearchCriteria;
import com.bap.dto.DoclistDTO;

public interface DocDAO {
	
	//게시판등록
   public void createDoc(DocVO docVO) throws Exception;
   
   //게시판에 파일첨부
   public void createDocAttach(String file_route) throws Exception;
   
   //상세보기
   public DocVO selectDoc(int doc_no) throws Exception;
   
   //상세보기에서 파일리스트
   public List<DocAttachVO> detailViewFileData(int doc_no) throws Exception;
   
   
   
   //list검색
   public List<DoclistDTO> listSearch(SearchCriteria cri) throws Exception;
   
   public int listSearchCount(SearchCriteria cri) throws Exception;
   
   
   
}