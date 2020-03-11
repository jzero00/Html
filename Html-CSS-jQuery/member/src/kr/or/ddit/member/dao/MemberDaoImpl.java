package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public class MemberDaoImpl implements IMemberDao{

	private SqlMapClient client;
	public static IMemberDao dao;
	
	private MemberDaoImpl() {
		client = SqlMapClientFactory.getSMCliet();
	}
	
	public static IMemberDao getInstance() {
		if(dao == null) dao = new MemberDaoImpl();
		return dao;
	}
	
	@Override
	public String idCheck(String id) throws SQLException {

		//id값이 파라미터라 쿼리 실행할때도 파라미터 값을 입력한다.
		return (String) client.queryForObject("member.idCheck", id);
	}

	@Override
	public List<ZipVO> serachDong(String dong) throws SQLException {

		return client.queryForList("member.serachDong", dong);
	}

	@Override
	public String insertMember(MemberVO vo) throws SQLException {

		return (String) client.insert("member.insertMember", vo);
	}

}
