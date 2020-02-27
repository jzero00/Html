package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.ZipVO;

/**
 * Servlet implementation class Zipcode
 */
@WebServlet("/Zipcode")
public class Zipcode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Zipcode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//0 요청시 클라이언트에서 값을 전달
		request.setCharacterEncoding("UTF-8");
		String dong = request.getParameter("dong");
		
		//1 service객체를 생성
		IMemberService service = MemberServiceImpl.getInstance();
		
		//2 service 메소드 호출 - 결과값 받기
		List<ZipVO> list = service.serachDong(dong);
		
		//3 결과값을 request에 저장
		request.setAttribute("list", list);
		
		//4 결과값을 출력(json 데이터로 이동) - view페이지로 이동
		request.getRequestDispatcher("HTML/0226/zipsearch.jsp").forward(request, response);
	}

}
