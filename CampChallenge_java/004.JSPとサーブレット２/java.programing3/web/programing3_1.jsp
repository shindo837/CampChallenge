<%-- 
    Document   : programing3
    Created on : 2016/09/29, 15:01:20
    Author     : tomoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.ArrayList"%>

<%!
    public ArrayList getProfile(){     //getProfileメソッド
        ArrayList<String> mine = new ArrayList<String>();

        mine.add("進藤友弥<br>");
        mine.add("1994年08月18日<br>");
        mine.add("趣味は料理です。<br>");

        return mine;
}
%>

<%
    ArrayList<String> mine = this.getProfile();
        for(int x=1; x<=10; x++){
            
            if(x != 1){
                out.println("<br>");
            }
            
            out.println(x+"回目<br>"+mine.get(0)+mine.get(1)+mine.get(2));
        }
%>