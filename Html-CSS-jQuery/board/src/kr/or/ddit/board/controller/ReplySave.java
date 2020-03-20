package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.vo.ReplyVO;

/**
 * Servlet implementation class ReplySave
 */
@WebServlet("/ReplySave")
public class ReplySave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplySave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. 요청시 값 전달받기
		request.setCharacterEncoding("UTF-8");
		
		int bonum = Integer.parseInt(request.getParameter("bonum"));
		String name = request.getParameter("name");
		String cont = request.getParameter("cont");
		
		ReplyVO vo = new ReplyVO();
		
		vo.setBonum(bonum);
		vo.setName(name);
		vo.setCont(cont);
		
		// 1. service
		BoardService service = BoardServiceImpl.getInstance();
		
		// 2. 메소드 호출
		int renum = service.insertReply(vo);
		System.out.println("renum = " + renum );
		// 3. 결과값 저장
		request.setAttribute("renum", renum);
		
		// 4. view 페이지
		request.getRequestDispatcher("board/replySave.jsp").forward(request, response);
	}

}
