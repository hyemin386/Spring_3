package com.iu.s3.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	public void save(String name, MultipartFile multipartFile, HttpSession session) throws Exception {
		//1. 경로 설정 
		String path = session.getServletContext().getRealPath("resources/upload/"+name);
		System.out.println(path);
		
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
		}	
		
		//2. 저장할 파일명 생성(중복X)
		String fileName =""; //실제 저장할 파일명 담는 변수
		/* 첫번째 방법
		Calendar ca = Calendar.getInstance(); 
		long time = ca.getTimeInMillis();
		fileName = time+"_"+multipartFile.getOriginalFilename();
		 */	
		fileName = UUID.randomUUID().toString()+"_"+multipartFile.getOriginalFilename();
		
		//3. HDD에 저장 (copy, transferTo)
		file = new File(file, fileName);
		/* 첫번째 방법
		FileCopyUtils.copy(multipartFile.getBytes(), file);*/
		multipartFile.transferTo(file);
	}
	
	
	public File makePath(HttpSession session) throws Exception {
		//1. 저장할 폴더 지정 resources/upload/member
		//2. os에서 인식할 수 있는 실제 경로 찾기
		//jsp -> application / server -> ServletContext
		String path = session.getServletContext().getRealPath("resources/upload/member");
		System.out.println(path);
		//avatar.getBytes(); //파일을 구성하는 이진비트가 담겨져 있음

		//3. 실제 경로에 폴더가 없으면 파일 저장시 에러가 발생함
		File file = new File(path);
		if(!file.exists()) {
			//존재하지않으면 해당 경로의 폴더를 생성 
			file.mkdirs();
		}
		
		return file;
	}
	
	//4. 파일 생성
	public String makeTimeFileName() throws Exception {
		Calendar ca = Calendar.getInstance();
		long time = ca.getTimeInMillis();
		return String.valueOf(time); //숫자를 string으로 변환해서 리턴
	}
	
	public String makeUUIDFileName() throws Exception {
		return UUID.randomUUID().toString(); //중복되지 않는 랜덤한 이름 리턴
	}
	
	//5. HDD에 파일 저장
	public void saveUseCopy(MultipartFile multipartFile, File file) throws Exception {
		FileCopyUtils.copy(multipartFile.getBytes(), file);
	}
	
	public void saveUseTransfer(MultipartFile multipartFile, File file) throws Exception {
		multipartFile.transferTo(file);
	}
}
