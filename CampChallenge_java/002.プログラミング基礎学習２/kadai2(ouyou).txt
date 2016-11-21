<%

String param1 = request.getParameter("param1"); //渡す数値

int value = Integer.parseInt(param1);

out.println("元の値:"+value+"<br>");
out.println("結果:");

//素因数分解
while(value != 0){
	if(value%2==0){			//2での素因数分解
		out.println("2,");
		value /= 2;
	}else if(value%3==0){		//3での素因数分解
		out.println("3,");
		value /= 3;
	}else if(value%5==0){		//5での素因数分解		
		out.println("5,");
		value /= 5;
	}else if(value%7==0){		//7での素因数分解
		out.println("7,");
		value /= 7;
	}else if(value == 1){		//valueの結果が1になる
		break;
	}else{
		out.println(value);
		break;
	}
}

%>