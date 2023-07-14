package tw.leonchen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyExceptionController {
	
	@GetMapping("/myexcept.controller")
	public void processAction() throws Exception {
		throw new Exception();
	}

}
