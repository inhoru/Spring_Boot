package gg.lolco.model.service;

import java.util.List;
import java.util.Map;

public interface SampleService {

	List<Map<String, Object>> selectAll();
	int playerInsertTop(Map<String, Object> param);
	
}
