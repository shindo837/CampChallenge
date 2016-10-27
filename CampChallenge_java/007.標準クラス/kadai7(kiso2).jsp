<%@page import = "java.util.*"%>
<%@page import = "java.text.*"%>
<%

 Date date = new Date();

 SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分ss秒");

 String sdate = sdf.format(date);

 out.println(sdate);

%>