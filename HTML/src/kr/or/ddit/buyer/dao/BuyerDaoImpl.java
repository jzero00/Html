package kr.or.ddit.buyer.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.ibatis.config.SqlMapClientFactory;

public class BuyerDaoImpl implements IBuyerDao{

	private SqlMapClient client;
	private static IBuyerDao dao;
	
	private BuyerDaoImpl() {
		client = SqlMapClientFactory.getSMCliet();
	}
	
	public static IBuyerDao getInstance() {
		if(dao == null) dao = new BuyerDaoImpl();
		return dao;
	}
	@Override
	public List<BuyerVO> nameList() throws SQLException {
		
		return client.queryForList("buyer.nameList");
	}

	@Override
	public BuyerVO buyerDetail(String id) throws SQLException {
		return (BuyerVO) client.queryForObject("buyer.buyerDetail", id);
	}

}
