<%@page import = "java.util.*"%>

<%
  
 Calendar cal = Calendar.getInstance();

 cal.set(2016,0,1,0,0,0);

 Date calpast = cal.getTime();

 out.print(calpast.getTime());

%>