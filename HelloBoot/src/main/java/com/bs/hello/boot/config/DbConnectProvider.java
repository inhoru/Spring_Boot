package com.bs.hello.boot.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.bs.hello.boot.dao.MemberDao;
import com.bs.hello.boot.dto.MemberDto;

@Component//mvc가아닌것들에대한 빈등록
public class DbConnectProvider implements AuthenticationProvider{
	
	private MemberDao dao;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	
	public DbConnectProvider(MemberDao dao) {
		this.dao=dao;
		
	
			
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		//아이디비밀번호인증 직접구현
		String userId=authentication.getName();
		String password=(String)authentication.getCredentials();
		
		MemberDto loginMember=dao.selectMemberById(userId);
		if(loginMember==null||!encoder.matches(password, loginMember.getPassword())) {
			//로그인 실패 시 
			throw new BadCredentialsException("인증실패");
		}
		
		return new UsernamePasswordAuthenticationToken(loginMember, loginMember.getPassword(),loginMember.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
	
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
	
	
}
