package com.iu.s3.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberDAOTest {

	@Autowired
	private MemberDAO memberDAO;
	
	@Test
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

}
