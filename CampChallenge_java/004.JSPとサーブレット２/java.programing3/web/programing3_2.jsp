<%-- 
    Document   : programing3_2
    Created on : 2016/09/30, 14:04:23
    Author     : tomoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*"%>

<%!
    public String getValue(int x){
        if(x==0 && x%2==0){
            return "偶数";
        }else{
            return "奇数";
        }
}
%>

<%
    int x = 2;
    String y = this.getValue(x);
    out.println(y);
%>