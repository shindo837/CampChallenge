<%@page import="java.util.ArrayList"%>
<%
ArrayList<String> al = new ArrayList<String>();

//al.add("GEEK CAMP");
//al.add("転職エージェント");
al.add("プログラミングキャンプ");

//out.println(al.get(1));

//al.set(1,"TENSYOKU AGENT");

//out.println(al.get(1)+"<br>");
out.println(Arrays.toString(al));
%>