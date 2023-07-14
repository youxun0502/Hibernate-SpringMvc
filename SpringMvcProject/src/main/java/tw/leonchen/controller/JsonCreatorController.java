package tw.leonchen.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.leonchen.model.House;

@Controller
public class JsonCreatorController {
	
	@GetMapping("/jsoncreate.controller")
	@ResponseBody
	public String processJsonAction1() throws JsonProcessingException {
		House hBean1 = new House();
		hBean1.setHouseid(1000);
		hBean1.setHousename("Nice House");
		
		ObjectMapper om = new ObjectMapper();
		String jsonStr = om.writeValueAsString(hBean1);
		
		House resultBean = om.readValue(jsonStr, House.class);
		System.out.println(resultBean.getHouseid() + ":" + resultBean.getHousename());
		
		return "jsonStr=" + jsonStr;
	}
	
	@GetMapping("/jsoncreate2.controller")
	@ResponseBody   //application/json
	public House processJsonAction2() throws JsonProcessingException {
		
		House hBean1 = new House();
		hBean1.setHouseid(1001);
		hBean1.setHousename("Happy House");
		
		return hBean1;
	}
	
	@GetMapping("/jsoncreate2_1.controller")
	@ResponseBody   //application/json
	public House processJsonAction2_1(@RequestBody House requestBean) throws JsonProcessingException {
		
		House hBean1 = new House();
		hBean1.setHouseid(1001);
		hBean1.setHousename("Happy House");
		
		return hBean1;
	}
	
	@GetMapping("/jsoncreate3.controller")
	@ResponseBody   //application/json
	public ArrayList<House> processJsonAction3() throws JsonProcessingException {
		
		House hBean1 = new House();
		hBean1.setHouseid(1001);
		hBean1.setHousename("Beautiful House");
		
		House hBean2 = new House();
		hBean2.setHouseid(1002);
		hBean2.setHousename("Modern House");
		
		ArrayList<House> houses = new ArrayList<House>();
		houses.add(hBean1);
		houses.add(hBean2);
		
		return houses;
	}
	
	@GetMapping("/jsoncreate4.controller")
	@ResponseBody   //application/json
	public ArrayList<House> processJsonAction4(@RequestBody ArrayList<House> myRequestHouses) throws JsonProcessingException {
		
		House hBean1 = new House();
		hBean1.setHouseid(1001);
		hBean1.setHousename("Beautiful House");
		
		House hBean2 = new House();
		hBean2.setHouseid(1002);
		hBean2.setHousename("Modern House");
		
		ArrayList<House> houses = new ArrayList<House>();
		houses.add(hBean1);
		houses.add(hBean2);
		
		return houses;
	}

}
