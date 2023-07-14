package tw.leonchen.model;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("houseService")
public class HouseService {
	
	@Autowired
	private HouseDao houseDao;
	
	public House selectById(int houseid) throws SQLException {
		return houseDao.selectById(houseid);
	}
	
	public House selectById2(int houseid) {
		return houseDao.selectById2(houseid);
	}

}
