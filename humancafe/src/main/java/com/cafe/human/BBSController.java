 package com.cafe.human;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cafe.service.IF_bbsService;
import com.cafe.util.FileDataUtil;
import com.cafe.vo.BBSVO;
import com.cafe.vo.PageVO;

@Controller
public class BBSController {
	@Inject
	IF_bbsService bbsservice; // 컨테이너로 부터 객체의 주소를 주입 받는다.
	
	@Inject
	FileDataUtil filedataUtil;
	
	//게시글 목록 보기
	@RequestMapping(value = "bbsview", method = RequestMethod.GET)
	public String join(Model model, @ModelAttribute PageVO pagevo) {
		if(pagevo.getPage() == null) {
			pagevo.setPage(1);
		}
		pagevo.setTotalCount(bbsservice.getTotalcnt());  //select count(*) from bbs  결과를 받아온다. 파라미터 필요x		
		pagevo.prt();
		System.out.println(pagevo.getStartNo()+"/"+pagevo.getEndNo());		
		// selectAll 메서드를 호출할때 pagevo를 매개변수로 넘겨 주면 됨.
		List<BBSVO> bbslist = bbsservice.selectAll(pagevo);
		model.addAttribute("blist", bbslist); //모든 자료형이 추상화 되있어서
		model.addAttribute("pagevo", pagevo);	
		return "bbslist";   
	}
	
	//게시글 입력폼 열기
	@RequestMapping(value = "bbswr" , method = RequestMethod.GET)
	public String bbswr(Model model, HttpSession session) {
		String viewName = "wrform"; //세션체크를 통해 로그인했으면 글쓰기 작성 가능하도록
		if(session.getAttribute("userid")== null) {
			viewName="home";
		}
		return viewName;   // forwarding 방식
	} 	
	
	//게시글 입력폼 DB에 저장하기 실행
	@RequestMapping(value = "bbswrpro" , method = RequestMethod.POST)
	public String bbswrpro(Model model, BBSVO bbsvo, MultipartFile[] file) throws Exception{ 
		//MultipartFile에 배열로 표시한 건 클라이언트가 2개의 파일을 보낼 예정이라서
		//for문으로 파일정보 체크하기
//		for(int i=0; i<file.length; i++) {
//			System.out.println(i + "번 파일이름 : " + file[i].getOriginalFilename());
//			System.out.println(i + "번 파일크기(용량) : " + file[i].getSize());
//			System.out.println(i + "번 파일이름(view) : " + file[i].getName());
//			//파일에 대한 정보를 받아온다. 바이러니로 보낸 파일의 정보를 확인하려고 sysout하는 것임
//			//db에는 파일정보만 보내고 용량문제로 이미지파일은 임시공간에만 둔다.
//		}	
		String[] fileNames = filedataUtil.fileUpload(file); //첨부파일을 저정하고 새로 만든 파일명을 리턴
		bbsvo.setFiles(fileNames); //새로 만든 파일명을 vo객체에 저장
		bbsservice.insertline(bbsvo); //서비스단에 넘김
		
		return "redirect:bbsview";
	}
	
	//게시글 수정폼 열기
	@RequestMapping(value = "bbsmod" , method = RequestMethod.GET)
	public String bbsmod(Model model, @RequestParam("mno") String mno) {
		// 의도가 작성한 글 가져오기.. 서비스단이 필요하다..
		BBSVO bvo = bbsservice.selectOne(mno);
		model.addAttribute("mbvo", bvo);
		return "bbsmodform";   // forwarding 방식
	} 
	
	//게시글 DB에서 수정하기 실행(문의분류, 비밀번호, 제목, 내용)
	@RequestMapping(value = "bbsmodpro" , method = RequestMethod.POST)
	public String bbmodpro(Model model, @ModelAttribute BBSVO bvo) {

		bbsservice.update(bvo);
		return "redirect:bbsview";
	}
	
	//상세보기 실행
	@RequestMapping(value = "bbsdetail" , method = RequestMethod.GET)
	public String bbsdetail(Model model, @RequestParam("vno") String vno) {
		//첨부파일 가져오기
		//쿼리문 select * from bbs_files ~~~
		List<String> files = bbsservice.getFileNames(vno); //받은 vno를 가지고 filename가져오기
		model.addAttribute("files", files);
		model.addAttribute("nowvo", bbsservice.detailview(vno));
		//vno보내면 튜플 하나만 불러와서  수정하기 폼으로 보내주는 메서드가 필요함... 
		//selectOne으로 (상세보기 아래 수정하기/삭제하기 실행위해)
	
		return "view";   // forwarding 방식
	} 
	//삭제하기 실행
	@RequestMapping(value = "bbsdel" , method = RequestMethod.GET)
	public String bbsdel(Model model, @RequestParam("dno") String ddno) {
		System.out.println(ddno);
		bbsservice.deleteNum(ddno); //서비스단에 삭제요청		
		return "redirect:bbsview";
	}
}
