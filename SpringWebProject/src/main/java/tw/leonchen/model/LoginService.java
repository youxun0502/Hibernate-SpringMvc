package tw.leonchen.model;

public class LoginService {
	
	private LoginDao loginDao;

	public LoginService() {
	}

	//constructor dependency injection
	public LoginService(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	//Setter Dependency Injection 一定要有不帶參數的建構子
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	public boolean checkLogin(String user, String pwd) {
		return loginDao.checkLogin(user, pwd);
	}
	
}
