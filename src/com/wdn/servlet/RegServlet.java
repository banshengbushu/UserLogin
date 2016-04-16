package com.wdn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wdn.dao.UserDao;
import com.wdn.user.User;

/**
 * Servlet implementation class RegServlet
 */
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String photo = request.getParameter("photo");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		UserDao userDao = new UserDao();
		if(username != null & !username.isEmpty()){
			if(userDao.userIsExist(username)){
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				user.setSex(sex);
				user.setPhoto(photo);
				user.setTel(tel);
				user.setEmail(email);
				//�����û�ע����Ϣ
				userDao.saveUser(user);
				request.setAttribute("info", "��ϲ��ע��ɹ���<br>");
			}else{
				request.setAttribute("info", "���󣺴��û����Ѵ��ڣ�");
			}
		}
		// ת����message.jspҳ��
		request.getRequestDispatcher("message.jsp").forward(request, response);
		
		doGet(request, response);
	}

}
