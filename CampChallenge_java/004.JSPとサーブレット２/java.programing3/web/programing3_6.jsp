<%-- 
    Document   : programing3_6
    Created on : 2016/10/03, 10:56:57
    Author     : tomoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*" %>

<%!
    public int getID(){
        return 20161003; 
}

    public String getMyName(){
        if(getID() == 20161003){
            return "名前1";
        }else if(getID() == 20130401){
            return "名前2";
        }else if(getID() == 20170401){
            return "名前3";
    }
    return "名前";
}

    public String getBirth(){
        if(getID() == 20161003){
            return "誕生日1";
        }else if(getID() == 20130401){
            return "誕生日2";
        }else if(getID() == 20170401){
            return "誕生日3";
    }
    return "誕生日";
}

    public String getAdd(){
        if(getID() == 20161003){
            return "住所1";
        }else if(getID() == 20130401){
            return "住所2";
        }else if(getID() == 20170401){
            return "住所3";
    }
    return "住所";
}
%>

<%
    int ID = this.getID();

    if(ID==20161003 || ID==20130401 || ID==20170401){
        out.println(getMyName()+"<br>");
        out.println(getBirth()+"<br>");
        out.println(getAdd()+"<br>");
    }else{
        out.println("IDが違います。<br>");
  }
%>