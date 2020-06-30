package level5;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BookServletTest {

    // *********************
    // (1) スタブの作成
    // *********************

    @Mock
    DatabaseService service;

    @InjectMocks
    BookServlet target = new BookServlet();

    // List<BookDto>に関するキャプチャを行う
    @Captor
    ArgumentCaptor<List<BookDto>> listCapture;

    @Before
    public void setUp() {
        // スタブを設定する
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void 全件取得を行うテスト() {


        // *************************************
        // (2) ドライバとして利用するための準備
        // *************************************

        // doGetに対する引数のモック化
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);

        // getAttributeでnullを返却するように設定
        doReturn(null).when(req).getAttribute(eq("name"));

        List<BookDto> actualList = new ArrayList<>();
        actualList.add(new BookDto("1", "よく分かるJava", 1900));
        actualList.add(new BookDto("2", "15分で理解するオブジェクト思考", 2100));
        actualList.add(new BookDto("3", "スッキリしたい人へのデータベース基礎", 2980));
        doReturn(actualList).when(service).getAllBooks();

        // HttpServletRequest.getRequestDispatcherのモック化
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        // "index"という引数があった場合にのみ、モック化したdispatcherを返却する
        doReturn(dispatcher).when(req).getRequestDispatcher(eq("index"));

        try {

            // テスト実施
            this.target.doGet(req, resp);

            // ****************************************
            // (3) 結果の確認
            // ****************************************

            // 一回のみ実施されたことの確認と、その際の引数を取得する
            verify(req, times(1)).setAttribute(eq("list"), listCapture.capture());

            // HttpServletRequest.setAttributeに渡されたリストを取得
            List<BookDto> returnedList = listCapture.getValue();

            // 3件取得されている事を確認
            assertEquals(3, returnedList.size());

            // 例として一部のみチェック(実際の単体テストでは各項目のチェックが必要)
            assertEquals(actualList.get(0).getId(), returnedList.get(0).getId());

        } catch (ServletException e) {
            e.printStackTrace();
            fail();
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }

    }
}