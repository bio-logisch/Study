package com.cafe.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileDataUtil {
	
	private ArrayList<String> extNameArray = new ArrayList<String>() // 허용하는 확장자 정의를 한 것.
	{
		{
			add("gif");
			add("jpg");
			add("png");
		}
	};     //<-- 현재 코드는 활용하지는 않는다.. 얘는 선언이지 기능이 동작하지는 않는다. 절대 미리 예측 금지..
	
	//첨부파일 업로드 경로 변수값으로 가져옴(주입받는 것) 자바파일을 최대한 건들지 않기 위해서 스프링에서는 이렇게 많이 한다.
	@Resource(name="uploadPath") //이름으로 주입받기, 먼저 객체가 있어야 한다. servlet-context.xml에서 생성
	private String uploadPath; 
	
	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	/**
	 * 게시물 상세보기에서 첨부파일 다운로드 메서드 구현(공통)
	 */
	//Controller에서의 매핑역할을 한다. 왜 이걸 컨트롤러로 등록했냐면 다운로드 기능을 구현하려고!
	@RequestMapping(value="/download", method=RequestMethod.GET)
	@ResponseBody   // 어떤 데이터를 포함하여 전송하는 어노테이션.. return 다음 오는 데이터로 
	//view를 지정하지 않고 return 옆에 붙은 string값을 바로 클라이언트 요청으로 응답.
	//@RequestMapping + @ResponseBody = @Restcontroller
	public FileSystemResource fileDownload(@RequestParam("filename") String fileName, HttpServletResponse response) {
		File file = new File(uploadPath + "/" + fileName);
		response.setContentType("application/download; utf-8");
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		return new FileSystemResource(file);
	}
	
	/**
	 * 파일 업로드 메서드(공통)
	 * @throws IOException 
	 */
	public String[] fileUpload(MultipartFile[] file) throws IOException {
	//접근제어자 리턴타입 메서드명 (매개변수)	
		String[] files = new String[file.length]; //file.length는 여기서 배열의 길이
		for(int i=0; i < file.length; i++) {
			if(file[i].getOriginalFilename()!="") {  //실제 file객체가 존재한다면 // getOriginalFilename()는 클라이언트가 보낸 파일명
				String originalName = file[i].getOriginalFilename();//확장자가져오기 위해서 전체파일명을 가져옴.
				UUID uid = UUID.randomUUID();//랜덤문자 구하기 맘에안든다. 
				String saveName = uid.toString() + "." + originalName.split("\\.")[1];//한글 파일명 처리 때문//파일명.확장자
				// String[] files = new String[] {saveName}; //형변환  files[0] 파일명이 들어 간다..
				byte[] fileData = file[i].getBytes(); 
				//클라이언트가 보낸 파일인 fileData를 바이트로 변환시킨다. getBytes가 1바이트씩 자르라는 의미
				
				File target = new File(uploadPath, saveName); //uploadPath위치에 saveName을 저장해라
				FileCopyUtils.copy(fileData, target); 
				files[i]=saveName; //랜덤으로 만든 파일명을 배열에 저장한다.
			}			
		}		
		return files; //랜덤으로 만든 파일명을 리턴해준다. 
	}

	public ArrayList<String> getExtNameArray() {
		return extNameArray;
	}

	public void setExtNameArray(ArrayList<String> extNameArray) {
		this.extNameArray = extNameArray;
	}
}
