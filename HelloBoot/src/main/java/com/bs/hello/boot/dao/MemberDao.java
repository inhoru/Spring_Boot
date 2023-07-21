package com.bs.hello.boot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bs.hello.boot.dto.MemberDto;

public interface MemberDao {
	List<MemberDto> selectMemberAll(SqlSession session);
	int insertMember(SqlSession session,MemberDto m);
	MemberDto selectMemberById(String userId);
	List<MemberDto> selectMemberByName(Map<String,Object> param);
}
