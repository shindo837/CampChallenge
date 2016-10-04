/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.object1;

/**
 *
 * @author tomoya
 */
public class object1 {  //object1クラス
    public String name;     //パブリックな2つの変数を定義
    public Integer num;

    //2つの変数に値を設定するパブリックなメソッド    
    public String setName(){
        this.name = "shindo";
        return name;
    }
    public Integer setNum(){
        this.num = 100;
        return num;
    }
    
    //2つの変数の中身をprintするためのパブリックなメソッド
    public String showName(){
        return this.name;
    }
    public Integer showNum(){
        return this.num;
    }
}

class Clear extends object1{  //object1クラスを継承
    //2つの変数の中身をクリアするパブリックなメソッド
    public String clearsetName(){
        this.name = null;
        return name;
    }
    public Integer clearsetNum(){
        this.num = 0;
        return num;
    }
    
    //クリアにした2つの変数の中身をprintするためのパブリックなメソッド
    public String clearshowName(){
        return this.name;
    }
    public Integer clearshowNum(){
        return this.num;
    }
}