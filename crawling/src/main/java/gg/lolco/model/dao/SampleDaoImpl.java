package gg.lolco.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class SampleDaoImpl implements SampleDao {

	@Override
	public List<Map<String, Object>> selectAll(SqlSession session) {
		return session.selectList("sample.selectAll");
	}

	@Override
	public int playerInsertTop(Map<String, Object> param, SqlSession session) {
		
		return session.insert("sample.playerInsertTop",param);
	}
	
}
