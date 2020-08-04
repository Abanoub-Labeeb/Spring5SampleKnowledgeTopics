package org.spring5samples.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.spring5samples.models.User;

public class SecurityDAOImpl implements ISecurityDAO {

	private DataSource dataSource;
	
	
	public SecurityDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> userList = new ArrayList<User>();
		String SQL = "select * from User";
		Connection conn = null; 
		PreparedStatement ps;
		ResultSet         rs;
		
		try {
			conn = dataSource.getConnection();
		    ps   = conn.prepareStatement(SQL);
		    rs   = ps.executeQuery();
		    
		    while (rs.next()) {
				User user = new User(rs.getInt("user_id"), rs.getString("name"), rs.getString("email"));
				userList.add(user);
			}
		    
		    ps.close();
		    rs.close();
		    
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return userList;
	}

}
