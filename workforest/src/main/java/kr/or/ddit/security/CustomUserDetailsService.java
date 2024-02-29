package kr.or.ddit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.or.ddit.mapper.MemberMapper;
import kr.or.ddit.mapper.StudMapper;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.StudVO;
import lombok.extern.slf4j.Slf4j;
//security-context.xml에서 옴
//CustomUserDetailsService - 서비스
//UserDetailsService - 임플클래스
//MemberDao - 다오
//MemberMapper- 매퍼 인터페이스

@Slf4j
@Service
//UserDetailsService - 스프링 시큐리티에서 제공해주고 있는 사용자 상세 정보를 갖고 있는 인터페이스
public class CustomUserDetailsService implements UserDetailsService {

	//service -> mapper
	
	//IoC(Inversion of Control 제어의 역전)
	//DI(Dependency Injection 의존성 주입)
	@Autowired
	//private MemberMapper memberMapper; //bean이 root-context.xml에 있음
	private StudMapper studMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//1)사용자 정보를 검색
		//username: 로그인 시 입력받은 회원의 아이디 <input type="text" name="username"...>
		
		//MemberVO memberVO= this.studMapper.detail(username);
		StudVO studVO= this.studMapper.detail(username);
		log.info("studVO: "+studVO);
		
		//MVC에서는 Controller로 리턴하지 않고, CustomUser로 리턴함
	    //CustomUser : 사용자 정의 유저 정보. extends User를 상속받고 있음
	    //2) 스프링 시큐리티의 User 객체의 정보로 넣어줌 => 프링이가 이제부터 해당 유저를 관리
	    //User : 스프링 시큐리에서 제공해주는 사용자 정보 클래스
	    /*
	      memberVO(우리) -> user(시큐리티)
	      -----------------
	      userId        -> username
	      userPw        -> password
	      enabled       -> enabled
	      auth들                      -> authorities
	     */
		//return memberVO==null?null:new CustomUser(memberVO); 
		return studVO==null?null:new CustomUser(studVO); 
	}

}












