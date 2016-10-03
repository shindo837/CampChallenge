<%-- 
    Document   : programing3_7
    Created on : 2016/10/03, 11:38:05
    Author     : tomoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.ArrayList"%>

<%!
    public ArrayList getProfile(int ID){
        ArrayList<String> Pro = new ArrayList<String>();
        switch(ID){
            case 1:
                Pro.add("名前1");
                Pro.add("誕生日1");
                Pro.add(null);
                break;
            case 2:
                Pro.add("名前2");
                Pro.add("誕生日2");
                Pro.add("住所2");
                break;
            case 3:
                Pro.add("名前3");
                Pro.add("誕生日3");
                Pro.add("住所3");
                break;
            default:
                Pro.add(" ");
                Pro.add(" ");
                Pro.add(" ");
                break;
        }
    return Pro;
}
%>

<%
    int ID = 1;

    if(ID==1 || ID==2 || ID==3){
        for(int x=1; x<=3; x++){
            ArrayList Pro = this.getProfile(ID);
//          out.println("要素数"+Pro.size()+"<br>");
            ID += 1;
            for(int i=0; i<3; i++){
                if(Pro.get(i) == null){
                    continue;
                }else{
                    out.println(Pro.get(i)+"<br>");
                }
            }
        }
    }else{
        out.println("IDが違います。");
    }
%>