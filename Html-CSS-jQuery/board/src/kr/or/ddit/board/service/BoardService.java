package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public interface BoardService {

	//게시글 전체 리스트
	public List<BoardVO> selectAll();
	
	//답글 저장
	public int insertReply(ReplyVO vo);
	
	//답글 리스트
	public List<ReplyVO> replyList(int bonum);
	
	//게시글 페이지 리스트
	public List<BoardVO> listPage(Map<String, Integer> map);
	
	public int totalList();
	
}
