package com.bap.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bap.domain.DocAttachVO;
import com.bap.domain.DocVO;
import com.bap.domain.PageMaker;
import com.bap.domain.SearchCriteria;
import com.bap.service.RefService;

@Controller
@RequestMapping("/ref")
public class RefController {
   private String baseDir = "c:" + File.separator + "temp" + File.separator; // c:\temp 디렉토리를 미리 만들어둔다.

   @Autowired
   RefService refService;

   @RequestMapping(value = "/create", method = RequestMethod.GET)
   public String createGET() {
      return "reference/create";
   }

   @RequestMapping(value = "/create", method = RequestMethod.POST)
   public String createPOST(@RequestParam("doc_title") String doc_title,
         @RequestParam("doc_content") String doc_content,
         @RequestParam("mem_id") String mem_id,
         @RequestParam("file_name") String[] file_names,
         @RequestParam("file") MultipartFile[] files) throws Exception {
      
      DocVO docVO = new DocVO();
      docVO.setDoc_title(doc_title);
      docVO.setDoc_content(doc_content);
      docVO.setMem_id(mem_id);
      
      refService.createReference(docVO);
      
      if (files != null && files.length > 0) {
         // windows 사용자라면 "c:\temp\년도\월\일" 형태의 문자열을 구한다.
         String formattedDate = baseDir
               + new SimpleDateFormat("yyyy" + File.separator + "MM" + File.separator + "dd").format(new Date());
         File f = new File(formattedDate);
         if (!f.exists()) { // 파일이 존재하지 않는다면
            f.mkdirs(); // 해당 디렉토리를 만든다. 하위폴더까지 한꺼번에 만든다.
         }
         
         int index = 0;
         
         for (MultipartFile file : files) {
            String contentType = file.getContentType();
            String name = file.getName();
            String originalFilename = file.getOriginalFilename();
            long size = file.getSize();

            String uuid = UUID.randomUUID().toString() + "_" + file_names[index]; // 중복될 일이 거의 없다.
            String saveFileName = formattedDate + File.separator + uuid; // 실제 저장되는 파일의 절대 경로

            refService.createReferenceAttach(saveFileName);
            
            // pk 값은 자동으로 생성되도록 한다.
            System.out.println("title :" + doc_title);
            System.out.println("contentType :" + contentType);
            System.out.println("name :" + name);
            System.out.println("originalFilename : " + originalFilename);
            System.out.println("size : " + size);
            System.out.println("saveFileName : " + saveFileName);

            // 실제 파일을 저장함.
            // try-with-resource 구문. close()를 할 필요가 없다. java 7 이상에서 가능
            try (InputStream in = file.getInputStream();
                  FileOutputStream fos = new FileOutputStream(saveFileName)) {
               int readCount = 0;
               byte[] buffer = new byte[512];
               while ((readCount = in.read(buffer)) != -1) {
                  fos.write(buffer, 0, readCount);
               }
            } catch (Exception ex) {
               ex.printStackTrace();
            }
            index++;
         } // for
      } // if

      return "redirect:/ref/create";
   }
   
   @RequestMapping(value = "/detail", method = RequestMethod.GET)
   public String detailGET( Model model, @RequestParam("doc_no") int doc_no, @ModelAttribute("cri") SearchCriteria cri) throws Exception {
      
      
      DocVO docVO = refService.detailViewData(doc_no);
      System.out.println(docVO);
      String mem_name = refService.searchNameById(docVO.getMem_id());
      System.out.println(mem_name);
      model.addAttribute(docVO);
      model.addAttribute("mem_name", mem_name);
      List<DocAttachVO> list = refService.detailViewFileData(doc_no);
      model.addAttribute("fileInfoSize", list.size());
      model.addAttribute("fileInfo", list);
      System.out.println(list);
      
      return "reference/detail";
      
   }
   
   @RequestMapping(value = "/list", method = RequestMethod.GET)
   public String list(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{
	   
	   model.addAttribute("docDTO", refService.listSearch(cri));
	   
	   PageMaker pageMaker = new PageMaker();
	   
	   pageMaker.setCri(cri);
	   pageMaker.setTotalCount(refService.listSearchCount(cri));
	   
	   model.addAttribute("pageMaker", pageMaker);
	   
	   return "reference/list";
	   
   }
   

   
   
   
   @RequestMapping(value = "/download/{filePath}", method = RequestMethod.GET)
   public void download(@PathVariable("filePath") String filePath, HttpServletResponse response) throws Exception{
      
      // 해당 파일이 이미 존재해야한다.
      String str = filePath.substring(56);
      StringBuffer sb = new StringBuffer();

      for ( int i = 0; i < str.length(); i++ ) {
         char c = str.charAt( i );
         if ( c > '~' ) {
            sb.append( URLEncoder.encode( "" + c, "UTF-8" ) );
         }
         else {
            sb.append( c );
         }
      }

      String encodedFilename = sb.toString();
      
      response.setContentType("application/download; UTF-8");
      response.setCharacterEncoding("UTF-8");
      response.setHeader("Content-Disposition", "attachment; filename=\"" + encodedFilename + "\";");
      response.setHeader("Content-Transfer-Encoding", "binary");
      response.setHeader("Pragma", "no-cache;");
      response.setHeader("Expires", "-1;");
      
      java.io.File readFile = new java.io.File(filePath);
      if (!readFile.exists()) { // 파일이 존재하지 않다면
         throw new RuntimeException("file not found");
      }

      FileInputStream fis = null;
      try {
         fis = new FileInputStream(readFile);
         FileCopyUtils.copy(fis, response.getOutputStream()); // 파일을 저장할때도 사용할 수 있다.
         response.getOutputStream().flush();
      } catch (Exception ex) {
         throw new RuntimeException(ex);
      } finally {
         try {
            fis.close();
         } catch (Exception ex) {
            // 아무것도 하지 않음 (필요한 로그를 남기는 정도의 작업만 함.)
         }
      }
   }
}