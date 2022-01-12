package mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertMember implements Action {
	MemberDao dao = new MemberDao();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		if(dao.InsertMember(new MemberDto(id,pw,name,1000))) {
			request.getRequestDispatcher("insertMember_success.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("").forward(request, response);
		}
	}

}
