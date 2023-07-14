package tw.leonchen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path="/shoppingmall")
public class PathVariableController {

	@RequestMapping(path = "/members/{mid}", method = RequestMethod.GET)
	public String processAction(@PathVariable("mid") String memberId, Model m) {
		m.addAttribute("memberId", memberId);
		return "memResult";
		
	}

}
