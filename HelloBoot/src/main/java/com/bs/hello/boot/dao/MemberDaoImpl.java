package com.bs.hello.boot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bs.hello.boot.common.mapper.MemberMapper;
import com.bs.hello.boot.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	private MemberMapper mapper;
	
	public MemberDaoImpl (MemberMapper mapper) {
		this.mapper=mapper;
	}

	@Override
	public List<MemberDto> selectMemberAll(SqlSession session) {
		// TODO Auto-generated method stub
		//return session.selectList("member.selectMemberAll");
		return mapper.selectMemberAll();
	}

	@Override
	public int insertMember(SqlSession session, MemberDto m) {
		// TODO Auto-generated method stub
		return session.insert("member.insertMember",m);
	}

	@Override
	public MemberDto selectMemberById(String userId) {
		
		return mapper.selectMemberById(userId);
	}

	@Override
	public List<MemberDto> selectMemberByName(Map<String, Object> param) {
		return  mapper.selectMemberByWhere(param);
	}

}
