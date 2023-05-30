package jp.co.aforce.Login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login/loginservlet")
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
		request.getRequestDispatcher("../jsp/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String userId = request.getParameter("user_id");
	    String password = request.getParameter("password");

	   
	    String path = "";

	    try {
	        String url = "jdbc:mysql://localhost:3306/login";
	        String user = "root";
	        String pass = "Kaziwara926";

	        String sql = "SELECT id FROM login WHERE id=? AND password=?";

	        
	        Class.forName("org.login_db.Driver");
	        try (Connection con = DriverManager.getConnection(url, user, pass);
	                PreparedStatement pstmt = con.prepareStatement(sql)) {

	            pstmt.setString(1, userId);
	            pstmt.setString(2, password);

	            ResultSet res = pstmt.executeQuery();

	            if (res.next()) {
	                
	                request.setAttribute("user_id", res.getString("id"));

	                // ログイン成功画面に遷移する
	                path = "../jsp/loginSuccess.jsp";
	            } else {
	                request.setAttribute("loginFailure", "ログインに失敗しました");

	                // ログインに失敗したときはもう一度ログイン画面を表示する
	                path = "../jsp/login.jsp";
	            }
	        }
	    }catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }

	    RequestDispatcher rd = request.getRequestDispatcher(path);
	    rd.forward(request, response);
	}

}
