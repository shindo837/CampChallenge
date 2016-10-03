<%-- 
    Document   : programing3_5
    Created on : 2016/10/03, 10:25:32
    Author     : tomoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*" %>

<%!
   public int getID(){
        return 20161003;
}
   public String getMyName(){
        return "名前";
}
   public String getBirth(){
        return "誕生日";
}
   public String getAdd(){
        return "住所";
}
%>

<%
    int ID = this.getID();

    if(ID == 20161003){
        out.println(getMyName()+"<br>");
        out.println(getBirth()+"<br>");
        out.println(getAdd()+"<br>");
    }else{
        out.println("IDが違います。<br>");
    }
%>