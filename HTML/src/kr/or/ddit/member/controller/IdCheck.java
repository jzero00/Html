package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;


/**
 * Servlet implementation class IdCheck
 */
@WebServlet("/IdCheck")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//0. 요청시 클라이언트에서 값을 전달 - 입력한 id
		String inId = request.getParameter("id");
		
		//1. service객체를 생성
		IMemberService service = MemberServiceImpl.getInstance();
		
		//2. service 메소드 호출 - 결과값 받기

		String resId = service.idCheck(inId);

		
		//3. 결과값을 request에 저장
		request.setAttribute("resId", resId);
		request.setAttribute("inId", inId);
	
		//4. 결과값을 출력(json 데이터로 이동) - view페이지로 이동
		RequestDispatcher disp = request.getRequestDispatcher("HTML/0226/idCheck.jsp");
		disp.forward(request, response);
	}

}
