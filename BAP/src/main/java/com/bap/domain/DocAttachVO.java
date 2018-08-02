package com.bap.domain;

import java.util.Date;

public class DocAttachVO {
   
   private String doc_attach_title;
   private Date doc_attach_date;
   private int doc_no;
   
   public String getDoc_attach_title() {
      return doc_attach_title;
   }
   public void setDoc_attach_title(String doc_attach_title) {
      this.doc_attach_title = doc_attach_title;
   }
   public Date getDoc_attach_date() {
      return doc_attach_date;
   }
   public void setDoc_attach_date(Date doc_attach_date) {
      this.doc_attach_date = doc_attach_date;
   }
   public int getDoc_no() {
      return doc_no;
   }
   public void setDoc_no(int doc_no) {
      this.doc_no = doc_no;
   }
   
   @Override
   public String toString() {
      return "DocAttachVO [doc_attach_title=" + doc_attach_title + ", doc_attach_date=" + doc_attach_date
            + ", doc_no=" + doc_no + "]";
   }
   
}