<%@page import = "java.util.*"%>
<%@page import = "java.text.*"%>
<%@page import = "java.io.*"%>
<%

 File txt = new File(application.getRealPath("profile.txt"));

 FileWriter fw = new FileWriter(txt);

 fw.write("進藤友弥です\r\n");
 fw.write("よろしくお願いします。\r\n");

 fw.close();

%>