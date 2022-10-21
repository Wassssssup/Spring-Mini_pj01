package kr.co.ezenac.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.ezenac.beans.BoardInfoBean;
import kr.co.ezenac.service.TopMenuService;

//Controller로 가기전 처리하는 곳 (interceptor)
public class TopMenuInterceptor implements HandlerInterceptor{

	private kr.co.ezenac.service.TopMenuService topMenuService;
	
	public TopMenuInterceptor(TopMenuService topMenuService) {
		this.topMenuService = topMenuService;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		List<BoardInfoBean> topMenuList = topMenuService.getTopMenuList();
		request.setAttribute("topMenuList", topMenuList);
		
		return true;
	}
}
