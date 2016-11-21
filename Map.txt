<%@page import="java.util.HashMap"%>
<%
HashMap<String, String> hMap = new HashMap<String, String>();

hMap.put("AAA","1111"); //追加
hMap.put("BBB","soeda");

out.println(hMap.get("AAA")+"<br>"); //Key"AAA"を参照して"1111"を表示

hMap.put("AAA","2222");

out.println(hMap.get("AAA")+"<br>");

out.println(hMap);
%>