package com.bap.domain;

import java.util.Date;

public class DocVO {

   private int doc_no;
   private String doc_title;
   private String mem_id;
   private Date doc_date;
   private String doc_content;
   private int pro_num;
   
   public int getDoc_no() {
      return doc_no;
   }
   public void setDoc_no(int doc_no) {
      this.doc_no = doc_no;
   }
   public String getDoc_title() {
      return doc_title;
   }
   public void setDoc_title(String doc_title) {
      this.doc_title = doc_title;
   }
   public String getMem_id() {
      return mem_id;
   }
   public void setMem_id(String mem_id) {
      this.mem_id = mem_id;
   }
   public Date getDoc_date() {
      return doc_date;
   }
   public void setDoc_date(Date doc_date) {
      this.doc_date = doc_date;
   }
   public String getDoc_content() {
      return doc_content;
   }
   public void setDoc_content(String doc_content) {
      this.doc_content = doc_content;
   }
   public int getPro_num() {
      return pro_num;
   }
   public void setPro_num(int pro_num) {
      this.pro_num = pro_num;
   }
   
   @Override
   public String toString() {
      return "DocVO [doc_no=" + doc_no + ", doc_title=" + doc_title + ", mem_id=" + mem_id + ", doc_date=" + doc_date
            + ", doc_content=" + doc_content + ", pro_num=" + pro_num + "]";
   }
   
}