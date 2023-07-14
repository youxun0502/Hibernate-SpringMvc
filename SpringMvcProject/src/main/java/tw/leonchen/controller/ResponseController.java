package tw.leonchen.controller;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ResponseController {
	
	//@GetMapping(path = "/response1.controller", produces = "text/html;charset=UTF-8")
	@GetMapping(path = "/response1.controller", produces = "application/json;charset=UTF-8")
	@ResponseBody   // defualt: application/json  setting:text/html;charset=UTF-8, text/plain;charset=UTF-8
	public String processResponseAction1() {
		return "how are u2?你好";
	}
	
	@GetMapping("/response.status.controller")
	public ResponseEntity<String> processResponseStatusAction(){
		return new ResponseEntity<String>("custom status code(403 Forbidden)", HttpStatus.FORBIDDEN);
	}
	
	@GetMapping(path = "/responsebytearray.controller", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public byte[] processByteArrayAction(HttpServletRequest request) throws IOException {
		InputStream is = request.getServletContext().getResourceAsStream("/WEB-INF/resources/images/gameclass4.jpg");
		return IOUtils.toByteArray(is);
	}

}
