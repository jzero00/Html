package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.vo.BoardVO;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/BoardList")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 0. 
		String page = request.getParameter("page");
		

		// 1. service 객체 얻기
		BoardService service = BoardServiceImpl.getInstance();
				
		// 2. service 메소드 호출하기
		List<BoardVO> list = service.selectAll();

		// 3. 결과값을 request.에 저장
		request.setAttribute("list", list);

		// 4. view페이지로 forward
		request.getRequestDispatcher("board/list.jsp").forward(request, response);
	}

}
