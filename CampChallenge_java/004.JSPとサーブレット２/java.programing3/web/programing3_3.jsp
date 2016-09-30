<%-- 
    Document   : programing3_3
    Created on : 2016/09/30, 14:50:24
    Author     : tomoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*" %>

<%!
    public Integer sample(int A, int B, boolean type){

        int C = A * B;
        
        if(type == false){
            return C;
        }else{
            int D = C * C;
            return D;
        }
}
%>

<%
    int i = this.sample(2, 2, true);
    out.println(i);
%>