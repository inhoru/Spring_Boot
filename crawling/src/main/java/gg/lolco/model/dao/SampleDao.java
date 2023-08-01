package gg.lolco.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public interface SampleDao {

	List<Map<String, Object>> selectAll(SqlSession session);
	int playerInsertTop(Map<String, Object> param,SqlSession session);
}
