package tw.leonchen.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.leonchen.model.House;
import tw.leonchen.model.HouseService;

@WebServlet("/DemoHouseJndiServlet.play")
public class DemoHouseJndiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private WebApplicationContext context;

	public void init() throws ServletException {
		ServletContext application = getServletContext();
		context = WebApplicationContextUtils.getWebApplicationContext(application);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HouseService houseService = context.getBean("houseService", HouseService.class);
		try {
			House resultBean = houseService.selectById(1002);
			if(resultBean!=null) {
				out.write(resultBean.getHouseid() + " " + resultBean.getHousename() + "<br/>");
			}else {
				out.write("No Result<br/>");
			}
			
			House mySaveBean = new House();
			mySaveBean.setHousename("Big house");
			
			houseService.insert(mySaveBean);
			
			out.write("<hr/>");
			
			List<House> lists = houseService.selectAll();
			for(House house:lists) {
				out.write(house.getHouseid() + " " + house.getHousename() + "<br/>");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		out.close();
	}

}
