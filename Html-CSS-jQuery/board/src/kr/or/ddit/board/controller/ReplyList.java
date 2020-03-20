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
import kr.or.ddit.board.vo.ReplyVO;

/**
 * Servlet implementation class ReplyList
 */
@WebServlet("/ReplyList")
public class ReplyList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 0.
		int bonum = Integer.parseInt(request.getParameter("bonum"));
		System.out.println(bonum);
		
		// 1.
		BoardService service = BoardServiceImpl.getInstance();
		
		// 2.
		List<ReplyVO> list = service.replyList(bonum);
		System.out.println(list);
		
		// 3.
		request.setAttribute("list", list);
		
		// 4.
		request.getRequestDispatcher("board/replylist.jsp").forward(request, response);
	}

}
