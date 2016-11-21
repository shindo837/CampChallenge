<%@page import = "java.util.*"%>
<%@page import = "java.text.*"%>
<%@page import = "java.io.*"%>
<%

 String str;

 File txt = new File(application.getRealPath("profile.txt"));

 FileReader fr = new FileReader(txt);

 BufferedReader br = new BufferedReader(fr);

 while((str = br.readLine()) != null){
    out.println(str);
    out.println("<br>");
 }

 fr.close();

%>