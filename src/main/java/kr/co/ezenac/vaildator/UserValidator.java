package kr.co.ezenac.vaildator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.co.ezenac.beans.UserBean;

//유효성 검사 처리하는곳
public class UserValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return UserBean.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target,Errors errors) {
		UserBean userBean=(UserBean)target;
		
		if(userBean.getUser_pw().equals(userBean.getUser_pw2()) == false) {
			errors.rejectValue("user_pw", "NotEquals");
			errors.rejectValue("user_pw2", "NotEquals");
		}
	}
}
