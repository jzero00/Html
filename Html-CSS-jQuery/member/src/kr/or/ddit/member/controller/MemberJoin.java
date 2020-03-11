package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

/**
 * Servlet implementation class MemberJoin
 */
@WebServlet("/MemberJoin")
public class MemberJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberJoin() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0. 클라이언트에서 요청시 (전송) 전달값 받기

				MemberVO vo = new MemberVO();
				
				try {
					BeanUtils.populate(vo, request.getParameterMap());
				} catch (IllegalAccessException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
				//1. service 객체 얻기
				IMemberService service = MemberServiceImpl.getInstance();
				
				//2. service 메소드 호출 - 결과값 받기 (저장한 id)
				String resid = service.insertMember(vo);
				
				//3. 결과 값을 request에 저장
				request.setAttribute("mid", vo.getMem_id());
				request.setAttribute("resid", resid);

				
				//4. view페이지로 이동
				RequestDispatcher disp = request.getRequestDispatcher("member/insert.jsp");
				disp.forward(request, response);
	}

}
