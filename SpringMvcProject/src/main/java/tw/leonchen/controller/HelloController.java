package tw.leonchen.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class HelloController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String userName = request.getParameter("userName");

		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("errors", errors);

		if (userName == null || userName.length() == 0) {
			errors.put("name", "name is required");
		}

		if (errors != null && !errors.isEmpty()) {
			return new ModelAndView("/form.jsp");
		}

		HttpSession session = request.getSession();
		session.setAttribute("userName", userName);
		return new ModelAndView("/success.jsp");
	}

}
