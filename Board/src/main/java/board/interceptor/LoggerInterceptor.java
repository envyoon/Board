package board.interceptor;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class LoggerInterceptor implements HandlerInterceptor{

	// Alt + Shift + S -> V 후 원하는 메서드 선택 후 적용
	
	@Override
	public boolean preHandle(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, Object handler) throws Exception {
		
		log.debug("======================================          START         ======================================");
		log.debug(" Request URI \t:  " + request.getRequestURI());
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(jakarta.servlet.http.HttpServletRequest request,	jakarta.servlet.http.HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
		
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
		
		log.debug("======================================           END          ======================================\n");
	}


}