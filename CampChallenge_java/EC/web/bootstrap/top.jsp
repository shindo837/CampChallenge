<%-- 
    Document   : top
    Created on : 2016/12/05, 10:13:22
    Author     : tomoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="ja">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ECサイトトップページ</title>
    <!-- BootstrapのCSS読み込み -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery読み込み -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- BootstrapのJS読み込み -->
    <script src="js/bootstrap.min.js"></script>
  </head>
  <body>
    <h1><font color = blue><b>かごいっぱいのゆめ</b></font></h1>
    <h5>ここは、<font color = red><u>『金銭取引が絶対に発生しない』『いくらでも、どんなものでも
        購入できる(気分になれる)』</u></font>『ECサイト』です。</h5>
    <form class="navbar-form pull-left" action="../../kagoyume/Search" method="GET">
        <input type="text" class="span2" name="search">
        <button type="submit" class="btn">検索</button>
    </form>
  </body>
</html>