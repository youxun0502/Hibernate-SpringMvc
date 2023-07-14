package tw.leonchen.model;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("houseService")
public class HouseService {
	
	@Autowired
	private HouseDao houseDao;
	
	public House selectById(int houseid) throws SQLException {
		return houseDao.selectById(houseid);
	}
	
	public List<House> selectAll() {
		return houseDao.selectAll();
	}
	
	public House insert(House saveBean) {
		return houseDao.insert(saveBean);
	}


}
