package com.iu.s3.account;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	@Autowired
	private AccountDAO accountDAO;
	
	public List<AccountDTO> getList(AccountDTO accountDTO) throws Exception {
		return accountDAO.getList(accountDTO);
	}
	
	public int setInsert(AccountDTO accountDTO) throws Exception {
		//중복되지않은 계좌번호 개설하기 
		//1. Random
		//2. Time
		Calendar ca = Calendar.getInstance();
		long time = ca.getTimeInMillis(); 
		System.out.println(time);
		//숫자를 문자열로 변경하기
		String t = time+""; 
		t = String.valueOf(time);
		//숫자 사이에 - 추가하기
		String result = t.substring(0,4)+"-"; 
		result = result + t.substring(4,8)+"-";
		result = result + t.substring(8);
		System.out.println(result);
		//3. Java API;
		String name = UUID.randomUUID().toString();
		System.out.println(name);
		//4. SimpleDateFormat
		SimpleDateFormat sd = new SimpleDateFormat("ddyyyyMM-HHmmss-S");
		String r = sd.format(ca.getTime());
		System.out.println(r);
		
		//위의 방법중 하나 선택해서 넣기
		accountDTO.setAccountNumber(result);
		return accountDAO.setInsert(accountDTO);		
	}
}
