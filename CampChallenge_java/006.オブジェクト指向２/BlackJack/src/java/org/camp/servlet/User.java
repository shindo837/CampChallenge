/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author tomoya
 */
class User extends Human{     //Humanクラスを継承したUserクラス

    @Override
    public ArrayList<Integer> setCard(ArrayList<Integer> Servlet_info1){    //setCardメソッド
          for(int i=0; i<Servlet_info1.size(); i++){
            myCards.add(Servlet_info1.get(i));
        }
        return myCards;
    } 
    
    @Override
    public boolean checkSum(ArrayList<Integer> Servlet_info2){      //checkSumメソッド
        int U_check = 0;
        for(int i=0; i<Servlet_info2.size(); i++){
            U_check = U_check + Servlet_info2.get(i);
        }
        if(U_check > 17){
            return false;
        }else{
            return true;
        }
    }

    public ArrayList<Integer> finishHand(ArrayList<Integer> Servlet_info1, ArrayList<Integer> Servlet_info2){
        int U_sum1 = 0;
        int U_sum2 = 0;
        Dealer User = new Dealer();
        ArrayList<Integer> cards = User.Trump();
        if(checkSum(Servlet_info1) == true){     //checkSumメソッドの返り値がtrue
            while(U_sum1 < 21){
                Random U_rand3 = new Random();
                Integer U_index3 = U_rand3.nextInt(cards.size());
                if(cards.get(U_index3) > 10){
                    cards.set(U_index3,10);
                }
                myCards.add(cards.get(U_index3));
                U_sum1 = U_sum1 + cards.get(U_index3);
                int U_num = myCards.indexOf(1);   //１がある要素を検索(無いとき戻り値は-1)
                if(U_sum1<=10 && U_num!=-1){
                    myCards.set(U_num,11);
                }
                for(int i=0; i<myCards.size(); i++){
                    U_sum1 = U_sum1 + myCards.get(i);
                }
            }
        }else{      //checkSumメソッドの返り値がtrue以外
            for(int x=0; x<myCards.size()-1; x++){
                U_sum2 = U_sum2 + myCards.get(x);
            }
            if(U_sum2 > 17){
                myCards.remove(Servlet_info2.get(0));
            }else{}
        }
        return myCards;
    }
    
    @Override
    public Integer open(ArrayList<Integer> Servlet_info3){      //openメソッド
        int U_total = 0;
        for(int i=0; i<Servlet_info3.size(); i++){
            U_total = U_total + Servlet_info3.get(i);
        }
        return U_total;
    }
}
