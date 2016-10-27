<%@page import = "java.util.*"%>
<%

 Calendar cal1 = Calendar.getInstance();
 Calendar cal2 = Calendar.getInstance();

 cal1.set(2015,11,31,23,59,59);
 cal2.set(2015,0,1,0,0,0);

 Date calpast1 = cal1.getTime();
 Date calpast2 = cal2.getTime();

 out.println(calpast1.getTime() - calpast2.getTime());
%>