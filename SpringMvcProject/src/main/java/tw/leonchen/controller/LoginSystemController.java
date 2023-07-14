package tw.leonchen.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.leonchen.model.Account;
import tw.leonchen.model.AccountService;

@Controller
public class LoginSystemController {
	
//	@RequestMapping(path = "/loginsystemmain.controller", method = RequestMethod.GET)
//	@GetMapping(path = "/loginsystemmain.controller")
	@GetMapping("/loginsystemmain.controller")
	public String processMainAction() {
		return "loginSystem";
	}

	@Autowired
	private AccountService accountService;
	
	@PostMapping("/checklogin.controller")
	public String processAction(@RequestParam("userName") String user, @RequestParam("userPwd") String pwd, Model m) {
		Map<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
		
		if(user==null || user.length()==0) {
			errors.put("name", "name is required");
		}
		
		if(pwd==null || pwd.length()==0) {
			errors.put("pwd", "user password is required");
		}
		
		if(errors!=null && !errors.isEmpty()) {
			return "loginSystem";
		}
		
		boolean result = accountService.checkLogin(new Account(user, pwd));
		
		if(result) {
			m.addAttribute("user", user);
			m.addAttribute("pwd", pwd);
			return "loginSuccess";
		}
		
		errors.put("msg", "please input username or password correctly");
		return "loginSystem";
	
	}
	
}
