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
		//��sql����ռλ���������ж�̬��ֵ
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getSex());
		ps.setString(4, user.getTel());
		ps.setString(5, user.getPhoto());
		ps.setString(6, user.getEmail());
		
		//ִ�и��²���
		ps.executeUpdate();
		//�ͷŴ�PreparedStatement��������ݿ��JDBC��Դ
		ps.close();
		}catch (Exception e) {
            e.printStackTrace();
        }finally{
            // �ر����ݿ�����
            ConnectDB.closeConnection(conn);
        }
	}
	
	/**
     * �û���¼
     * @param username �û���
     * @param password ����
     * @return �û�����
	 * @throws SQLException 
     */
	public User login (String username, String password){
		User user = null;
		Connection conn = ConnectDB.getConnection();
		String sql = "select * from tb_user where username = ? and password = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			//��sql����ռλ���������ж�̬��ֵ
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				//�û��������Ը�ֵ
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
	     * �ж��û��������ݿ����Ƿ����
	     * @param username �û���
	     * @return ����ֵ
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
