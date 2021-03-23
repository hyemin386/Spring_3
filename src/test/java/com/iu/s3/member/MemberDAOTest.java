package com.iu.s3.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s3.MyAbstractTest;

public class MemberDAOTest extends MyAbstractTest {

	@Autowired
	private MemberDAO memberDAO;
	
	//@Test
	public void memberJoinTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("test1");
		memberDTO.setPw("test1");
		memberDTO.setName("test");
		memberDTO.setPhone("01012341234");
		memberDTO.setEmail("test1@naver.com");
		int result = memberDAO.memberJoin(memberDTO);
		
		assertEquals(1, result);
	}
	
	//@Test
	public void memberUpdateTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("test1");
		memberDTO.setPw("id8");
		memberDTO.setName("id8");
		memberDTO.setPhone("01055555555");
		memberDTO.setEmail("id8@naver.com");
		
		int result = memberDAO.memberUpdate(memberDTO);
		assertEquals(1, result);
	}
	
	//@Test
	public void memberDeleteTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("test1");
		int result = memberDAO.memberDelete(memberDTO);
		
		assertEquals(1, result);
	}
	
	@Test
	public void memberLoginTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("iu");
		memberDTO.setPw("pw1");
		
		memberDTO = memberDAO.memberLogin(memberDTO);
		assertNotNull(memberDTO);
	}

}
