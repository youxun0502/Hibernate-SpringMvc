package tw.leonchen.action;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.leonchen.util.LogProvider;

public class DemoLogProviderAction {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		LogProvider logProvider = (LogProvider)context.getBean("logProvider");
		logProvider.log("have a nice day!!");
		context.close();
	}

}
