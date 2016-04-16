package com.wdn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wdn.dao.UserDao;
import com.wdn.user.User;

/**
 *用户登录Servlet类
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDao userDao = new UserDao();
		User user = userDao.login(username, password);
		if(user != null){
			//将用户对象放入session中
			request.getSession().setAttribute("user", user);
			//转发到result.jsp页面
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}else{
			// 登录失败
			request.setAttribute("info", "错误：用户名或密码错误！");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
	}

}


