package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public class MemberServiceImpl implements IMemberService {

	private static IMemberService service;
	private IMemberDao dao;
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	public static IMemberService getInstance() {
		if(service == null) service = new MemberServiceImpl();
		return service;
	}
	
	@Override
	public String idCheck(String id) throws SQLException {
		
		String idchk = dao.idCheck(id);
		
		return idchk;
	}

	@Override
	public List<ZipVO> serachDong(String dong) throws SQLException {
		
		List<ZipVO> list = null;
		
		list = dao.serachDong(dong);
		
		return list;
	}

	@Override
	public String insertMember(MemberVO vo) throws SQLException {
		
		String name = dao.insertMember(vo);
		
		return name;
	}

}
