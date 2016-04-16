package com.wdn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wdn.user.User;

public class UserDao {

	public void saveUser(User user){
		Connection conn = ConnectDB.getConnection();
		
		String sql = "insert into tb_user(username,password,sex,tel,photo,email) values(?,?,?,?,?,?)";
		try{
		PreparedStatement ps = conn.prepareStatement(sql);
		//对sql语句的占位符参数进行动态赋值
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getSex());
		ps.setString(4, user.getTel());
		ps.setString(5, user.getPhoto());
		ps.setString(6, user.getEmail());
		
		//执行更新操作
		ps.executeUpdate();
		//释放此PreparedStatement对象的数据库和JDBC资源
		ps.close();
		}catch (Exception e) {
            e.printStackTrace();
        }finally{
            // 关闭数据库连接
            ConnectDB.closeConnection(conn);
        }
	}
	
	/**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 用户对象
	 * @throws SQLException 
     */
	public User login (String username, String password){
		User user = null;
		Connection conn = ConnectDB.getConnection();
		String sql = "select * from tb_user where username = ? and password = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			//对sql语句的占位符参数进行动态赋值
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				//用户对象属性赋值
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setSex(rs.getString("sex"));
                user.setTel(rs.getString("tel"));
                user.setPhoto(rs.getString("photo"));
                user.setEmail(rs.getString("email"));			
				
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			ConnectDB.closeConnection(conn);
		}
		return user;	
		
		/**
	     * 判断用户名在数据库中是否存在
	     * @param username 用户名
	     * @return 布尔值
	     */
			
			
		}
	public boolean userIsExist(String username){
		Connection conn = ConnectDB.getConnection();
		String sql = "select * from tb_user where username = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return true;		
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectDB.closeConnection(conn);
		}
		return false;
	}
}
