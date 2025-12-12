package com.boot.board.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService{
	
	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		//아이디 비교작업해주는 메소드
		
		//사용자 이름으로 SiteUser 객체를 조회
		Optional<SiteUser> searchUser =
				userRepository.findByUserName(userName);
		
		if(!searchUser.isPresent()) {
			throw new UsernameNotFoundException("사용자를 찾을수 없습니다.");
		}
		
		SiteUser siteUser = searchUser.get();
		
		List<GrantedAuthority> authorities = 
				new ArrayList<GrantedAuthority>();
		
		if("admin".equals(userName)) {
			authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
			//Role_ADMIN이 들어온다
		}else {
			authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
			//Role_User이들어온다 (일반사용자)
		}
		
		//사용자명,비밀번호,권한을 스프링 Security의 User객체로 생성해서 반환
		return new User(siteUser.getUserName(), siteUser.getPassword(), authorities);
	}
}
