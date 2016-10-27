<%
 String name = "進藤友弥";

 //文字列長
 out.println(name.length());

 out.println("<br>");

 //バイト数
 out.println(name.getBytes().length);

 out.println("<br>");

 //UTF-8の場合
 out.println(name.getBytes("UTF-8").length);
%>