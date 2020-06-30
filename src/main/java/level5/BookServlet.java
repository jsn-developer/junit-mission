package level5;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/level5")
public class BookServlet extends HttpServlet{

    /**
     * データベースアクセスクラス
     */
    private DatabaseService service;

    /**
     * コンストラクタ
     */
    public BookServlet() {
        this.service = new DatabaseService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");

        List<BookDto> list = null;

        if (name != null && !name.equals("")) {
            list = this.service.searchBooks(name);
        } else {
            list = this.service.getAllBooks();
        }

        // 取得結果のセット
        req.setAttribute("list", list);

        // 画面の表示
        // ※本来はjspファイルのパスが必要だが説明のため省略しています。
        req.getRequestDispatcher("index").forward(req, resp);
    }
}
