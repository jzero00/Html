package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.prod.vo.ProdVO;

/**
 * Servlet implementation class ProdList
 */
@WebServlet("/p.do")
public class ProdList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProdList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0. 요청시 클라이언트에서 값을 받는다. lprod_gu값을 받는다.
		String lgu = request.getParameter("lprod_gu"); 

		//1. service객체를 생성
		IProdService service = ProdServiceImpl.getInstance();
		
		//2. service 메소드 호출 - 결과값 받기
		List<ProdVO> list = service.prodNames(lgu);
		
		//3. 결과값을 request에 저장
		request.setAttribute("list", list);
		
		//4. 결과값을 출력(json 데이터로 이동) - view페이지로 이동
		RequestDispatcher disp = request.getRequestDispatcher("HTML/0224/prodNoName.jsp");

		disp.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pid = request.getParameter("prod_id");
		System.out.println(pid);
		// 1. service객체를 생성
		IProdService service = ProdServiceImpl.getInstance();
		
		// 2. service 메소드 호출 - 결과값 받기
		ProdVO vo = service.prodDetail(pid);
		
		// 3. 결과값을 request에 저장
		request.setAttribute("prodVO", vo);
		
		// 4. 결과값을 출력(json 데이터로 이동) - view페이지로 이동
		RequestDispatcher disp = request.getRequestDispatcher("HTML/0224/prodDetail.jsp");

		disp.forward(request, response);
	}

}
