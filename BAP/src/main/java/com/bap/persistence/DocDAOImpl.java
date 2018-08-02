package com.bap.persistence;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.bap.domain.DocAttachVO;
import com.bap.domain.DocVO;
import com.bap.domain.SearchCriteria;
import com.bap.dto.DoclistDTO;

public class DocDAOImpl implements DocDAO {

private SqlSession session;
   
   public void setSqlSession(SqlSession session) {
      this.session=session;
   }
   
   private static String namespace = "com.bap.mappers.doc-Mapper";
   
   @Override
   public void createDoc(DocVO docVO) throws Exception {
      int pro_num = (int)session.selectOne("com.bap.mappers.sns-Mapper.search_pro_num",docVO.getMem_id());
      docVO.setPro_num(pro_num);
      session.insert(namespace + ".createDoc", docVO);
   }

   @Override
   public void createDocAttach(String file_route) throws Exception {
      int doc_no = (int)session.selectOne(namespace + ".search_latest_doc_no");
      
      DocAttachVO docAttachVO = new DocAttachVO();
      docAttachVO.setDoc_attach_title(file_route);
      docAttachVO.setDoc_no(doc_no);
      
      session.insert(namespace + ".createDocAttach", docAttachVO);
   }

   @Override
   public DocVO selectDoc(int doc_no) throws Exception {
	   
      return (DocVO)session.selectOne(namespace + ".selectDoc", doc_no);
   }

   @Override
   public List<DocAttachVO> detailViewFileData(int doc_no) throws Exception {
	   
      return (List<DocAttachVO>)session.selectList(namespace + ".detailViewFileData", doc_no);
   }



   @Override
   public List<DoclistDTO> listSearch(SearchCriteria cri) throws Exception {
	   // TODO Auto-generated method stub
	
	   int offset = (cri.getPage() - 1) * 10;
	   int limit = 10;
	
	   RowBounds rowbounds = new RowBounds(offset, limit);
	   return session.selectList(namespace + ".listSearch", cri, rowbounds);
   }

   @Override
   public int listSearchCount(SearchCriteria cri) throws Exception {
	   // TODO Auto-generated method stub
	   return (int) session.selectOne(namespace + ".listSearchCount", cri);
   }

}