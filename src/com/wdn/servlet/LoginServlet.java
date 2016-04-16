package com.wdn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wdn.dao.UserDao;
import com.wdn.user.User;

/**
 *�û���¼Servlet��
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
			//���û��������session��
			request.getSession().setAttribute("user", user);
			//ת����result.jspҳ��
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}else{
			// ��¼ʧ��
			request.setAttribute("info", "�����û������������");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
	}

}


