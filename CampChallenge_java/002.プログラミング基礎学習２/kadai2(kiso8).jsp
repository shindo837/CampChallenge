<%@page import = "java.util.Arrays"%>
<%

String cArr[] = {"10","100","soeda","hayashi","-20","118","END"};

cArr[2] = "33"; //2番目を33に変更

out.println(Arrays.toString(cArr));

%>