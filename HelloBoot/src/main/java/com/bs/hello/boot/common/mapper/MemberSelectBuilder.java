package com.bs.hello.boot.common.mapper;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class MemberSelectBuilder {
	public static String selectMemberByWhere (Map<String,Object> param) {
		return new SQL() {{
			SELECT("*");
			FROM("MEMBER");
			if(param.get("userName")!=null && !param.get("userName").equals("")) {
				WHERE("USERNAME LIKE '%'||#{userName}||'%'");
			}
		}}.toString();
	}
}
