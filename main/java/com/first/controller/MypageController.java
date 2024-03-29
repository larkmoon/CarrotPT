package com.first.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSenderImpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.first.biz.CslBiz;
import com.first.biz.TraineeBiz;
import com.first.biz.TrainerBiz;
import com.first.frame.Util;
import com.first.vo.CslVO;
import com.first.vo.MajorVO;
import com.first.vo.TraineeVO;
import com.first.vo.TrainerVO;

@Controller
public class MypageController {

	@Autowired
	TraineeBiz traineebiz;

	@Autowired
	TrainerBiz trainerbiz;
	
	@Autowired
	CslBiz cslbiz;

	@Value("${dir1}")
	String dir1;

	@Value("${dir2}")
	String dir2;

	@Value("${dir3}")
	String dir3;
	
	@Value("${dir4}")
	String dir4;
	
	@Value("${dir5}")
	String dir5;
	
	@Value("${dir6}")
	String dir6;

	// 트레이너 마이페이지: 메인
	@RequestMapping("/trmypage")
	public String trmypage(Model m, HttpSession session) {
		try {
			TrainerVO trainer = (TrainerVO) session.getAttribute("logincust");
			m.addAttribute("center", "mypage/trmypage");
			m.addAttribute("trainer", trainer);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		m.addAttribute("trainercenter", "mypage/trprofile");
		return "index";
	}

	// 트레이너 대표프로필 변경
//		@RequestMapping("/updateprofile1")
//		public RedirectView updateprofile1(Model m, TrainerVO trainer) {
//			String profile1 = trainer.getPf1().getOriginalFilename();
//			if(!(profile1.equals(""))) {
//				trainer.setProfile1(profile1);
//				Util.saveFile(trainer.getPf1(),dir1);
//				}
//			try {
//				trainerbiz.modifyProfile1(trainer);
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return new RedirectView("/trmypage");
//		}

	// 트레이너 프로필 업데이트
	@RequestMapping("/trprofile_update")
	public RedirectView trprofile_update(Model m, TrainerVO vo) {
		String profile1 = vo.getPf1().getOriginalFilename();
		String profile2 = vo.getPf2().getOriginalFilename();
		String profile3 = vo.getPf3().getOriginalFilename();
		String license1 = vo.getLc1().getOriginalFilename();
		String license2 = vo.getLc2().getOriginalFilename(); 
		String license3 = vo.getLc3().getOriginalFilename(); 

		if (!(profile1.equals(""))) {
			vo.setProfile1(profile1);
			Util.saveFile1(vo.getPf1(), dir1);
		}
		if (!(profile2.equals(""))) {
			vo.setProfile2(profile2);
			Util.saveFile2(vo.getPf2(), dir2);

		}
		if (!(profile3.equals(""))) {
			vo.setProfile3(profile3);
			Util.saveFile3(vo.getPf3(), dir3);
		}
		if (!(license1.equals(""))) {
			vo.setLicense1(license1);
			Util.saveFile4(vo.getLc1(), dir4);
		}
		if (!(license2.equals(""))) {
			vo.setLicense2(license2);
			Util.saveFile5(vo.getLc2(), dir5);

		}
		if (!(license3.equals(""))) {
			vo.setLicense3(license3);
			Util.saveFile6(vo.getLc3(), dir6);
		}

//		vo.setProfile1(profile1);
//		Util.saveFile1(vo.getPf1(), dir1); 
//
//		vo.setProfile2(profile2);
//		Util.saveFile2(vo.getPf2(), dir2);
//
//		vo.setProfile3(profile3);
//		Util.saveFile3(vo.getPf3(), dir3);

		try {
			trainerbiz.modifyProfile(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new RedirectView("/trmypage");
	}

	// 트레이너 마이페이지: 경력 및 수상
	@RequestMapping("/traccount")
	public String trprofile(Model m, HttpSession session) {
		try {
			TrainerVO trainer = (TrainerVO) session.getAttribute("logincust");
			m.addAttribute("center", "mypage/trmypage");
			m.addAttribute("trainercenter", "mypage/traccount");
			m.addAttribute("trainer", trainer);
			List<MajorVO> majorList = trainerbiz.getmajor();
			m.addAttribute("majorlist", majorList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "index";
	}

	// 트레이너 계정정보 업데이트 : 정보 업데이트 후 404error
	/*
	 * @RequestMapping("/traccount_update") public RedirectView
	 * traccount_update(Model m, TrainerVO vo) { try { trainerbiz.modifyAccount(vo);
	 * System.out.println("성공" + vo); } catch (Exception e) { e.printStackTrace(); }
	 * return new RedirectView("index"); }
	 */
	
	// 트레이너 계정정보 업데이트
	@RequestMapping("/traccount_update")
	public String traccount_update(Model m, TrainerVO vo) {
		try {
			trainerbiz.modifyAccount(vo);
			System.out.println("업데이트 성공" + vo);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return "index";
	}

	// 트레이너 마이페이지: 매칭신청
	@RequestMapping("/trmatching")
	public String trmatching(Model m, HttpSession session) {
		try {
			TrainerVO trainer = (TrainerVO) session.getAttribute("logincust");
			m.addAttribute("center", "mypage/trmypage");
			m.addAttribute("trainercenter", "mypage/trmatching");
			m.addAttribute("trainer", trainer);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "index";
	}

	// 비번 변경 페이지로 이동
	@RequestMapping("/changepwd")
	public String changepwd(Model m, HttpSession session) {
		try {
			TrainerVO trainer = (TrainerVO) session.getAttribute("logincust");
			m.addAttribute("center", "mypage/changepwd");
			m.addAttribute("trainer", trainer);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	// 트레이너 계정정보 업데이트
	@RequestMapping("/trpassword_update")
	public String trpassword_update(Model m, TrainerVO vo, HttpSession session) {
		try {
			trainerbiz.modifyPassword(vo);
			System.out.println("비밀번호 변경 성공" + vo);
			if (session != null) {
				session.invalidate();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("비밀번호 변경 실패");
		}
		return "redirect:/";
	}

	// 트레이너 마이페이지: 이용내역
	@RequestMapping("/trhistory")
	public String trhistory(Model m, HttpSession session, String tid) {
		try {
			TrainerVO trainer = (TrainerVO) session.getAttribute("logincust");
			List<CslVO> csl = cslbiz.getlistbyid(tid);
			m.addAttribute("center", "mypage/trmypage");
			m.addAttribute("trainercenter", "mypage/trhistory");
			m.addAttribute("trainer", trainer);
			m.addAttribute("csl", csl);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "index";
	}

	// 일반회원 마이페이지: 메인
	/*
	 * @RequestMapping("/mypage") public String mypage(Model m, String id) { try {
	 * TraineeVO trainee = traineebiz.get(id); m.addAttribute("trainee", trainee);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } m.addAttribute("center",
	 * "mypage/mypage"); return "index"; }
	 */
	
	// 트레이니 마이페이지: 메인(프로필)
	@RequestMapping("/mypage")
	public String mypage(Model m, HttpSession session) {
		try {
			TraineeVO trainee = (TraineeVO) session.getAttribute("logincust");
			m.addAttribute("center", "mypage/mypage");
			m.addAttribute("trainee", trainee);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "index";
	}

	// 일반회원 마이페이지 업데이트
	@RequestMapping("/updateimpl")
	public String updateimpl(Model m, TraineeVO trainee) {
		try {
			traineebiz.modify(trainee);
			System.out.println("업데이트 성공");
		} catch (Exception e) {

			e.printStackTrace();
		}

		return "index";
	}

	// 트레이니 비번 변경 페이지로 이동
	@RequestMapping("/techangepwd")
	public String techangepwd(Model m, HttpSession session) {
		try {
			TraineeVO trainee = (TraineeVO) session.getAttribute("logincust");
			m.addAttribute("center", "mypage/techangepwd");
			m.addAttribute("trainee", trainee);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	// 트레이니 계정정보 업데이트 :password
	@RequestMapping("/tepassword_update")
	public String tepassword_update(Model m, TraineeVO vo, HttpSession session) {
		try {
			traineebiz.modifypassword(vo);
			System.out.println("비밀번호 변경 성공" + vo);
			if (session != null) {
				session.invalidate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	// 트레이니 마이페이지: 이용내역
	@RequestMapping("/tehistory")
	public String tehistory(Model m, HttpSession session, String tid) {
		try {
			TraineeVO trainee = (TraineeVO) session.getAttribute("logincust");
			List<CslVO> csl = cslbiz.getlistbyid(tid);
			m.addAttribute("center", "mypage/tehistory");
			/* m.addAttribute("trainercenter", "mypage/trmatching"); */
			m.addAttribute("trainee", trainee);
			m.addAttribute("csl", csl);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "index";
	}


}
