package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public interface IMemberDao {

	public String idCheck(String id) throws SQLException;
	
	public List<ZipVO> serachDong(String dong) throws SQLException;
	
	public String insertMember(MemberVO vo) throws SQLException;
}
