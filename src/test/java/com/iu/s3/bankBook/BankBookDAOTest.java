package com.iu.s3.bankBook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s3.MyAbstractTest;

public class BankBookDAOTest extends MyAbstractTest {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	@Test
	public void setUpdateTest() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(5);
		
		bankBookDTO = bankBookDAO.getSelect(bankBookDTO);
		
		bankBookDTO.setBookName("new Product");

		int result = bankBookDAO.setUpdate(bankBookDTO);
		assertEquals(1, result);
	}
	
	/*@Test
	public void setDeleteTest() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(6);
		int result = bankBookDAO.setDelete(bankBookDTO);
		
		assertEquals(1, result);
	}
	
	@Test
	public void getListTest() throws Exception {
		List<BankBookDTO> ar = bankBookDAO.getList();
		assertNotEquals(0, ar.size());
	}
	
	@Test
	public void getSelectTest() throws Exception {
		BankBookDTO bankBookDTO = bankBookDAO.getSelect(null);
		assertNotNull(bankBookDTO);
	}
	
	@Test
	public void setWriteTest() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookName("Test");
		bankBookDTO.setBookRate(0.12);
		bankBookDTO.setBookSale("Y");
		int result = bankBookDAO.setWrite(bankBookDTO);
		
		assertEquals(1, result);
	}*/
	
}
