<%

String param1 = request.getParameter("param1"); //商品の種類
String param2 = request.getParameter("param2"); //商品の個数
String param3 = request.getParameter("param3"); //商品の総額

int syouhin = Integer.parseInt(param1);
int kosuu = Integer.parseInt(param2);
int sougaku = Integer.parseInt(param3);


//商品の種類
if(syouhin == 1){
	out.println("雑貨<br>");
}else if(syouhin == 2){
	out.println("生鮮食品<br>");
}else if(syouhin == 3){
	out.println("その他<br>");
}


//一個あたりの値段
int wari = sougaku/kosuu;
out.println("総額"+sougaku+"円<br>");
out.println("一個あたり"+wari+"円<br>");


//3000円以上購入で4%のポイントが付く
if(sougaku >= 3000){
	double point1 = sougaku * 0.04;
	out.println(point1+"ポイント付きます。<br>");
}

//5000円以上購入で5%のポイントが付く
else if(sougaku >= 5000){
	double point2 = sougaku * 0.05;
	out.println(point2+"ポイント付きます。<br>");
}

%>