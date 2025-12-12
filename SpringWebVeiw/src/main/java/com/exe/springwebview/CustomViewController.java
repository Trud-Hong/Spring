package com.exe.springwebview;

import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomViewController {

	@RequestMapping(value = "/simpleCustomView.action")
	public ModelAndView customView() {

		ModelAndView mav = new ModelAndView();

		// JSP파일로 데이터 보내서 view로 사용함
		// WEB-INF/view/simpleCustomView.jsp
		// mav.setViewName("simpleCustomView");

		// Class파일로 데이터 보내고 view로 사용함...Servlet이 필요하다
		mav.setView(new SimpleCustomView());
		mav.addObject("message", "SimpleCustomView Class 입니다");

		return mav;

	}

	@RequestMapping(value = "/pdfView.action")
	public ModelAndView getPdfView() {

		ModelAndView mav = new ModelAndView();

		mav.setView(new CustomPdfView());
		mav.addObject("message", "PDF File");

		return mav;
	}

	@RequestMapping(value = "/excelView.action")
	public ModelAndView getexcelView() {

		ModelAndView mav = new ModelAndView();

		mav.setView(new CustomExcelView());

		return mav;
	}

	@RequestMapping(value = "/upload.action", method = { RequestMethod.POST })
	public String upload(MultipartHttpServletRequest request) {

		String path = 
				request.getSession()
				.getServletContext().getRealPath("/WEB-INF/files");

		// WEB-INF는 외부에서 접근 금지 영역이기때문에
		// 이미지를 보기위해서는 webapp 폴더밑에 폴더(image)를 만들거나
		// 또는 resources에 만들어줌
		// 그리고 위의 저장 경로를 다음과 같이 바꿔줌
		// .getServletContext().getRealPath("/resources/image");
		// .getServletContext().getRealPath("/image")

		// webapp/image에 폴더를 만든경우 servlet-context.xml 에서
		// <resources mapping="/resources/**" location="/resources/" />를
		// <resources mapping="/**" location="/" />로 수정
		
		// webapp/resources/image에 폴더를 만든경우 servlet-context.xml 에서
		// <resources mapping="/resources/image/**" location="/resources/" />를

		// String path = cp + "/resources/image" 로 넘김
		
		MultipartFile file = request.getFile("upload");
		
		if(file!=null && file.getSize()>0) {
			
			try {
				
				InputStream is = file.getInputStream();
				
				FileOutputStream fos = 
						new FileOutputStream(path + "/" +
								file.getOriginalFilename());
				/*
				int data;
				byte[] buffer = new byte[4096];
				while((data=is.read(buffer, 0, buffer.length))!=-1) {
					fos.write(buffer, 0, data);
				}
				*/
				
				FileCopyUtils.copy(is, fos);
				
				is.close();
				fos.close();
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		return "uploadResult";
	}
	
	@RequestMapping(value = "/download.action")
	public ModelAndView download() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setView(new DownloadView());
		
		return mav;
	}

}
