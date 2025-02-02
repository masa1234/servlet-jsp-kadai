package forms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfirmServlet extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // リクエスト・レスポンスの設定
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");

    // JSPからのリクエストデータ取得
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String address = request.getParameter("address");
    String phone = request.getParameter("phone_number");
    String message = request.getParameter("message");

    // リクエストスコープにデータ保存
    request.setAttribute("name", name);
    request.setAttribute("email", email);
    request.setAttribute("address", address);
    request.setAttribute("phone_number", phone);
    request.setAttribute("message", message);

    // データが存在しない場合は空文字に置き換え
    name = Objects.toString(name, "");
    email = Objects.toString(email, "");
    address = Objects.toString(address, "");
    phone = Objects.toString(phone, "");
    message = Objects.toString(message, "");

    // バリデーションNG時のメッセージを格納するリスト
    ArrayList<String> errorList = new ArrayList<String>();

    // 氏名のバリデーション
    if ("".equals(name.trim())) { // 未入力
      // 氏名が未入力の場合
      errorList.add("氏名を入力してください。");
    }

    // メールアドレスのバリデーション
    if ("".equals(email.trim())) { // 未入力
      errorList.add("メールアドレスを入力してください。");
    } else if (!email.matches("^[a-zA-Z0-9.]+@[a-zA-Z0-9.]+$")) { // 入力形式
      errorList.add("メールアドレスの入力形式が正しくありません。");
    }


    // エラーリストが空かどうか
    if (!errorList.isEmpty()) {
      // エラーがある場合はリストをリクエストスコープに登録
      request.setAttribute("errorList", errorList);
    }

    // フォワードによる画面遷移
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/confirmPage.jsp");
    dispatcher.forward(request, response);
  }

  // POSTメソッドのリクエスト受信時に実行されるメソッド
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
