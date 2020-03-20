package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;
import kr.or.ddit.ibatis.config.SqlMapClientFactory;

public class BoardDaoImpl implements BoardDao {
	
	private SqlMapClient client;
	public static BoardDao dao;
	
	private BoardDaoImpl() {
		client = SqlMapClientFactory.getSMCliet();
	}
	
	public static BoardDao getInstance() {
		if(dao == null) dao = new BoardDaoImpl();
		return dao;
	}

	@Override
	public List<BoardVO> selectAll() {

		List<BoardVO> list = null;
		
		try {
			list = client.queryForList("board.selectAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int insertReply(ReplyVO vo) {
		
		int chk = 0;
		
		try {
			chk = (int)client.insert("board.insertReply", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return chk;
	}

	@Override
	public List<ReplyVO> replyList(int bonum) {
		
		List<ReplyVO> replyList = null;
		
		try {
			replyList = client.queryForList("board.replyList", bonum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return replyList;
	}

	@Override
	public List<BoardVO> listPage(Map<String, Integer> map) throws SQLException {

		return client.queryForList("board.listPage", map);
	}

	@Override
	public int totalList() throws SQLException {
		
		return (int) client.queryForObject("board.totalList");
	}

}
