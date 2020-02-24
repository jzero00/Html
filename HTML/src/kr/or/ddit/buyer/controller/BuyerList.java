package kr.or.ddit.buyer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.buyer.service.IBuyerService;
import kr.or.ddit.buyer.vo.BuyerVO;


/**
 * Servlet implementation class BuyerList
 */
@WebServlet("/BuyerList")
public class BuyerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyerList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//0. 클라이언트 요청시 전달되는 값을 받는다 없다

		//1. service객체 얻는다.
		IBuyerService service = BuyerServiceImpl.getInstance();
		
		//2. service메소드를 호출한다. 결과값을 받는다.
		List<BuyerVO> list = service.nameList();
		
		//3. 결과값을 request에 저장
		request.setAttribute("nameList", list);
		
		//4. 출력을 위해 view페이지(jsp)로 이동 -
		// redirect : 한번 서버 밖으로 응답한 후 새로운 request로 재요청하기 때문
		//			controller, view가 request, response를 공유하지 못한다
		// forward : controller, view가 request, response를 공유한다
		
		// request에 저장된 결과값을 jsp페이지로 넘겨준다.
		RequestDispatcher disp = request.getRequestDispatcher("HTML/0221/nameList.jsp");
		
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//0. 클라이언트 요청시 전달되는 값을 받는다
		String vid = request.getParameter("id");
		
		//1. service객체 얻는다.
		IBuyerService service = BuyerServiceImpl.getInstance();
		
		//2. service메소드를 호출한다. 결과값을 받는다.
		BuyerVO vo = service.buyerDetail(vid);
		
		//3. 결과값을 request에 저장
		request.setAttribute("buyerVO", vo);		
		
		//4. 출력을 위해 view페이지(jsp)로 이동
		RequestDispatcher disp = 
				request.getRequestDispatcher("HTML/0224/detail.jsp");
		disp.forward(request,response);
	}

}
