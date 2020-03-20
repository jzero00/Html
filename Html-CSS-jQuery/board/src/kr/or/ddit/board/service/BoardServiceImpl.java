package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public class BoardServiceImpl implements BoardService {

	private static BoardService service;
	private BoardDao dao;
	
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getInstance();
	}
	
	public static BoardService getInstance() {
		if(service == null) service = new BoardServiceImpl();
		return service;
	}
	
	@Override
	public List<BoardVO> selectAll() {

		return dao.selectAll();
	}

	@Override
	public int insertReply(ReplyVO vo) {

		return dao.insertReply(vo);
	}

	@Override
	public List<ReplyVO> replyList(int bonum) {

		return dao.replyList(bonum);
	}

	@Override
	public List<BoardVO> listPage(Map<String, Integer> map) {
		List<BoardVO> list = null;
		
		try {
			list = dao.listPage(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int totalList() {
		int count = 0;
		
		try {
			count = dao.totalList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

}
