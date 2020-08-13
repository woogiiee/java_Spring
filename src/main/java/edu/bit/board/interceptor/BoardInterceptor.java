package edu.bit.board.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.bit.board.service.BoardService;
import edu.bit.board.service.LoginService;
import edu.bit.board.vo.BoardVO;
import edu.bit.board.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Log4j

public class BoardInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		
		log.info("preHandle 실행");
		
		//session객체를 가져옴
		HttpSession session = request.getSession();
		
		//login처리를 담당하는 사용자 정보를 담고있는 객체를 가져옴
		UserVO user = (UserVO) session.getAttribute("user");
		
		if(user==null) {
			log.info("user가 null");
			//로그인이 안되어 있는 상태이므로 로그인 폼으로 다시 돌려보냄(redirect)
			response.sendRedirect(request.getContextPath());
			
			return false;//더이상 컨트롤러 요청으로 가지 않도록 false로 반환됨
		}
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
		
		super.postHandle(request, response, handler, modelAndView);
		
		log.info("postHandle 실행");
	}
	
}

