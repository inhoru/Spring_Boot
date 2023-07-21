package com.bs.hello.boot.service;

import java.util.List;
import java.util.Map;

import com.bs.hello.boot.dto.MemberDto;

public interface MemberService {
	List<MemberDto> selectMemberAll();
	
	int insertMember(MemberDto m);
	
	MemberDto selectMemberById(String userId);
	
	List<MemberDto> selectMemberByName(Map<String,Object> param);
}
