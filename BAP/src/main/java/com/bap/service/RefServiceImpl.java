package com.bap.service;

import java.util.List;

import com.bap.domain.DocAttachVO;
import com.bap.domain.DocVO;
import com.bap.domain.SearchCriteria;
import com.bap.dto.DoclistDTO;
import com.bap.persistence.DocDAO;
import com.bap.persistence.MemDAO;

public class RefServiceImpl implements RefService {

   private DocDAO docDAO;
   private MemDAO memDAO;
   
   public void setDocDAO(DocDAO docDAO) {
      this.docDAO = docDAO;
   }
   
   public void setMemDAO(MemDAO memDAO) {
      this.memDAO = memDAO;
   }
   
   @Override
   public void createReference(DocVO docVO) throws Exception {
      docDAO.createDoc(docVO);
   }

   @Override
   public void createReferenceAttach(String file_route) throws Exception {
      docDAO.createDocAttach(file_route);
   }

   @Override
   public DocVO detailViewData(int doc_no) throws Exception {
      return docDAO.selectDoc(doc_no);
   }

   @Override
   public String searchNameById(String mem_id) throws Exception {
      return memDAO.searchNameById(mem_id);
   }

   @Override
   public List<DocAttachVO> detailViewFileData(int doc_no) throws Exception {
      return docDAO.detailViewFileData(doc_no);
   }

   @Override
   public List<DoclistDTO> listSearch(SearchCriteria cri) throws Exception {
	   // TODO Auto-generated method stub
	   return docDAO.listSearch(cri);
   }

   @Override
   public int listSearchCount(SearchCriteria cri) throws Exception {
	   // TODO Auto-generated method stub
	   return docDAO.listSearchCount(cri);
   }

}