package sj;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinkServlet extends HttpServlet {
  // GETメソッドのリクエスト受信時に実行されるメソッド
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // リクエストのエンコード設定
    request.setCharacterEncoding("UTF-8");
    // JSPからのリクエストデータ取得
    String name = request.getParameter("name");
    request.setAttribute("name", name);
    RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
    dispatcher.forward(request, response);
  }

}
