package com.bs.hello.boot.common.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.bs.hello.boot.dto.MemberDto;

@Mapper
public interface MemberMapper {
	
	@Select("SELECT * FROM MEMBER")
	List<MemberDto> selectMemberAll();
	
	@Select("SELECT * FROM MEMBER WHERE USERID=#{id}")
	MemberDto selectMemberById(String id);
	
	@SelectProvider(type=MemberSelectBuilder.class,method="selectMemberByWhere")
	List<MemberDto> selectMemberByWhere(Map<String,Object> param);
	
}
