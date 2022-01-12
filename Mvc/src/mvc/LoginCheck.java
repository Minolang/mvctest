package mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCheck implements Action {
//dao.infoUser(id);
	MemberDao dao = new MemberDao();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id =request.getParameter("id");
		String pw =request.getParameter("pw");
		
		if(dao.LoginCheck(new MemberDto(id,pw,"",0))) {
			request.getRequestDispatcher("login_success.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("login_failure.jsp").forward(request, response);
		}
		
		
	}

}
