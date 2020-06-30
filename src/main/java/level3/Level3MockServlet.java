package level3;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/level3")
public class Level3MockServlet extends HttpServlet{

	private Level3Dao dao;

	public Level3MockServlet() {

		dao = new Level3Dao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Level3Dto> list = dao.getAll();

		req.setAttribute("list", list);

		req.getRequestDispatcher("/WEB-INF/jsp/level3.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String name = req.getParameter("name");

		Level3Dto dto = new Level3Dto();
		dto.setId(id);
		dto.setName(name);

		if (dao.insert(dto)) {
			// 成功した場合
			resp.sendRedirect("list");
		} else {
			// 失敗した場合
			req.setAttribute("error", "登録に失敗しました。");
			req.getRequestDispatcher("/WEB-INF/jsp/level3.jsp");
		}

	}
}
