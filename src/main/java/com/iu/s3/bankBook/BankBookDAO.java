package com.iu.s3.bankBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s3.util.Pager_backUp;

@Repository
public class BankBookDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.s3.bankBook.BankBookDAO"; 

	public int setUpdate(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.update(NAMESPACE+".setUpdate",bankBookDTO);
	}
	
	public int setDelete(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+".setDelete", bankBookDTO);
	}
	
	public List<BankBookDTO> getList () throws Exception {
		return sqlSession.selectList(NAMESPACE+".getList");
	}
	
	public Long getTotalCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE, ".getTotalCount");
	}

	public BankBookDTO getSelect(BankBookDTO bankBookDTO) throws Exception {
		bankBookDTO = sqlSession.selectOne(NAMESPACE+".getSelect", bankBookDTO);
		System.out.println(bankBookDTO.getBookNumber());
		return bankBookDTO;
	}	

	public int setWrite(BankBookDTO bankBookDTO) throws Exception {
		int result = sqlSession.insert(NAMESPACE+".setWrite", bankBookDTO);
		return result;				
	}
}
