package com.bs.hello.boot.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.bs.hello.boot.dao.MemberDao;
import com.bs.hello.boot.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {
	
	private MemberDao dao;
	private SqlSession session;
	
	public MemberServiceImpl(MemberDao dao,SqlSession session) {
		this.dao=dao;
		this.session=session;
	}
	
	@Override
	public List<MemberDto> selectMemberAll() {
		return dao.selectMemberAll(session);
		
	}

	@Override
	public int insertMember(MemberDto m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberDto selectMemberById(String userId) {
	
		return dao.selectMemberById(userId);
	}

	@Override
	public List<MemberDto> selectMemberByName(Map<String, Object> param) {
		
		return dao.selectMemberByName(param);
	}

}
