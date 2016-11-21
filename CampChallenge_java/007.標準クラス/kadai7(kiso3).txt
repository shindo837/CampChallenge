<%@page import = "java.util.*"%>
<%@page import = "java.text.*"%>

<%
 SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分ss秒");
 Calendar cal = Calendar.getInstance();

 cal.set(2016,10,4,10,0,0);

 Date calpast = cal.getTime();

 String sdate = sdf.format(calpast.getTime());

 out.println(sdate);
%>