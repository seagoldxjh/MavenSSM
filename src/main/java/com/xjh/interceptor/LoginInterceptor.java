package com.xjh.interceptor;/*package com.xjh.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
		//获取请求的RUi:去除http:localhost:8080这部分剩下的
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
		System.out.println(basePath);
		//UTL:除了index.jsp是可以公开访问的，其他的URL都进行拦截控制
		if(basePath.indexOf("index") >= 0) {
			System.out.println("包含login");
			return true;
		}
		HttpSession session = request.getSession();
		String loginStuNo = (String) session.getAttribute("loginStuNo");
		
		if(loginStuNo != null) {
			System.out.println(loginStuNo);
			return true;
		}else {
			System.out.println("跳转");
			response.sendRedirect("/Studio/views/index.jsp");
			return false;
		}
	}

}
*/