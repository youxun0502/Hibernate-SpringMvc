package tw.leonchen.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

@Repository("houseDao")
public class HouseDao {

	@Autowired
	private DataSource dataSource;

	public House selectById(int houseid) throws SQLException {
		Connection conn = dataSource.getConnection();

		String sqlstr = "select * from House where houseid=?";
		PreparedStatement state = conn.prepareStatement(sqlstr);
		state.setInt(1, houseid);
		ResultSet rs = state.executeQuery();

		House hBean = null;

		if (rs.next()) {
			hBean = new House();
			hBean.setHouseid(rs.getInt(1));
			hBean.setHousename(rs.getString(2));
		}

		rs.close();
		state.close();
		conn.close();

		return hBean;
	}

	public House selectById2(int houseid) {
		
		String sqlstr = "select * from House where houseid=?";
		JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
		
		House resultBean = jdbcTemp.query(sqlstr, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, houseid);
			}
		}, new ResultSetExtractor<House>() {

			@Override
			public House extractData(ResultSet rs) throws SQLException, DataAccessException {
				House hBean = null;

				if (rs.next()) {
					hBean = new House();
					hBean.setHouseid(rs.getInt(1));
					hBean.setHousename(rs.getString(2));
				}

				return hBean;
			}
		});
		
		return resultBean;
	}

}
