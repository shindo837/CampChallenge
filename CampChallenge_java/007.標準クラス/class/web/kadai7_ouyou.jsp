<%-- 
    Document   : kadai7_ouyou
    Created on : 2016/10/28, 15:08:43
    Author     : tomoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page import="java.io.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        File txt = new File("C:\\Users\\tomoya\\Documents\\CampChallenge\\Challenge\\CampChallenge_java\\007.標準クラス\\logfile.txt");
        
        FileWriter sfw = new FileWriter(txt);
        
        BufferedWriter bw = new BufferedWriter(sfw);
        
        Date sdate = new Date();       //<-開始日時の取得
        bw.write("開始：" + sdate + "<br>");
        
        String param1 = request.getParameter("param1");
        String param2 = request.getParameter("param2");
        
        int i, tax_price = Integer.parseInt(param1), num = Integer.parseInt(param2);
        double tax = 1.08, tax_included_price;
        
        i = tax_price * num;
        tax_included_price = i * tax;
        
        out.println("税抜の合計価格は" + i + "円です<br>");
        out.println("税込の合計価格は" + Math.floor(tax_included_price) + "円です<br>");
        
        Date fdate = new Date();      //<-終了日時の取得
        bw.write("終了：" + fdate + "<br>");
        bw.close();
        
        //ログファイルの読み込み
        FileReader fr = new FileReader(txt);
        BufferedReader br = new BufferedReader(fr);
        String str;
        
        while((str = br.readLine()) != null){
            out.println(str);
        }
        
        br.close();
        %>
    </body>
</html>
