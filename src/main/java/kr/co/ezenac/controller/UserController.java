package kr.co.ezenac.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.ezenac.beans.UserBean;
import kr.co.ezenac.vaildator.UserValidator;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	@GetMapping("/join")
	public String join(@ModelAttribute("joinUserBean")UserBean joinUserMean) {
		return "user/join";
	}
	
	@PostMapping("/join_pro")
	//joinUserBean 이라는 이름으로 유효성 검사를 하고 그 결과를 BindingResult에 저장
	public String join_pro(@Valid @ModelAttribute("joinUserBean") UserBean joinUserBean,BindingResult result) {
		if(result.hasErrors()) {
			return "user/join";
		}
		
		return "user/join_success";
	}
	
	@GetMapping("/modify")
	public String modify() {
		return "user/modify";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "user/logout";
	}
	
	//@Valid 어노테이션으로 검증이 필요한 객체를 가져오기 전에 수행할 method를 지정해주는 어노테이션
	@InitBinder
	//WebDataBinder 는 HTTP 요청정보를 컨트롤러 메소드의 파라미터나 모델에 바인딩할 때 사용되는 바인딩 오브젝트
	public void initBinder(WebDataBinder binder) {
		UserValidator validator1=new UserValidator();
		binder.addValidators(validator1);
	}
}








