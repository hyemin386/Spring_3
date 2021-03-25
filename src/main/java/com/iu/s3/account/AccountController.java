package com.iu.s3.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account/**")
public class AccountController {

	@RequestMapping("accountList")
	public void getList() throws Exception {
	}
}
