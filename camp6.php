<?php
$a=0;
$b=0;
for($i=1;$i<4001;$i++){
	echo "$i:";
		if((strpos($i,'3')!==false || $i%3==0) && $i%5==0){
			$c=$a+$b;
			echo "[アホ犬になる,アホ犬度$c]";
		}
		else if($i%5==0){
			$b++;
			echo "[犬っぽくなる,犬度$b]";
		}
		else if(strpos($i,'3')!==false || $i%3==0){
			$a++;
			echo "[アホになる,アホ度$a]";
		}
/*		else if($i%5 != 0){
			echo " ";
	}*/
	echo "<br />";
}
?>