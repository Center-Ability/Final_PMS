package com.bap.service;

import java.util.List;

import com.bap.domain.DocAttachVO;
import com.bap.domain.DocVO;
import com.bap.domain.SearchCriteria;
import com.bap.dto.DoclistDTO;

public interface RefService {

   public void createReference(DocVO docVO) throws Exception;
   
   public void createReferenceAttach(String file_route) throws Exception;
   
   public DocVO detailViewData(int doc_no) throws Exception;
   
   public String searchNameById(String mem_id) throws Exception;
   
   public List<DocAttachVO> detailViewFileData(int doc_no) throws Exception;
   
   public List<DoclistDTO> listSearch(SearchCriteria cri) throws Exception;
   
   public int listSearchCount(SearchCriteria cri) throws Exception;
   
}