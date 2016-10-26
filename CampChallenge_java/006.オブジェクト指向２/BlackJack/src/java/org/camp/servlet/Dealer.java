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
class Dealer extends Human{     //Humanクラスを継承したDealerクラス

    public ArrayList<Integer> Trump(){      //Trumpメソッド
        ArrayList<Integer> cards = new ArrayList<Integer>();
        for(int i=0; i<13; i++){
            cards.add(i+1);
        }
        return cards;
    }

    public ArrayList<Integer> deal(){    //dealメソッド
        int D_sum1 = 0;
        ArrayList<Integer> cards = this.Trump();
        ArrayList<Integer> D_getHand = new ArrayList<Integer>();
        for(int i=0; i<2; i++){
            Random D_rand1 = new Random();
            Integer D_index1 = D_rand1.nextInt(cards.size());
            if(cards.get(D_index1) > 10){
                cards.set(D_index1,10);
            }
            D_getHand.add(cards.get(D_index1));
            D_sum1 = D_sum1 + D_getHand.get(i);
        }
        int D_num = D_getHand.indexOf(1);   //１がある要素を検索(無いとき戻り値は-1)
        if(D_sum1<=11 && D_num!=-1){
           D_getHand.set(D_num,11);
        }
        return D_getHand;
    }

    public ArrayList<Integer> hit(){       //hitメソッド
        ArrayList<Integer> cards = this.Trump();
        ArrayList<Integer> D_getCard = new ArrayList<Integer>();
        Random D_rand2 = new Random();
        Integer D_index2 = D_rand2.nextInt(cards.size());
        if(cards.get(D_index2) > 10){
            cards.set(D_index2,10);
        }
        D_getCard.add(cards.get(D_index2));
        return D_getCard;
    }

    @Override
    public ArrayList<Integer> setCard(ArrayList<Integer> Servlet_info1){    //setCardメソッド
        for(int i=0; i<Servlet_info1.size(); i++){
            myCards.add(Servlet_info1.get(i));
        }
        return myCards;
    }

    @Override
    public boolean checkSum(ArrayList<Integer> Servlet_info2){      //checkSumメソッド
        int D_check = 0;
        for(int i=0; i<Servlet_info2.size(); i++){
            D_check = D_check + Servlet_info2.get(i);
        }
        if(D_check > 16){
            return false;
        }else{
            return true;
        }
    }

    public ArrayList<Integer> finishHand(ArrayList<Integer> Servlet_info1, ArrayList<Integer> Servlet_info2){
        int D_sum2 = 0;
        int D_sum3 = 0;
        ArrayList<Integer> cards = this.Trump();
        if(checkSum(Servlet_info1) == true){     //checkSumメソッドの返り値がtrue
            while(D_sum2 < 21){
                Random D_rand3 = new Random();
                Integer D_index3 = D_rand3.nextInt(cards.size());
                if(cards.get(D_index3) > 10){
                    cards.set(D_index3,10);
                }
                myCards.add(cards.get(D_index3));
                D_sum2 = D_sum2 + cards.get(D_index3);
                int D_num = myCards.indexOf(1);   //1がある要素を検索(無いとき戻り値は-1)
                if(D_sum2<=10 && D_num!=-1){
                    myCards.set(D_num,11);
                }
                for(int i=0; i<myCards.size(); i++){
                    D_sum2 = D_sum2 + myCards.get(i);
                }
            }
        }else{      //checkSumメソッドの返り値がtrue以外
            for(int x=0; x<myCards.size()-1; x++){
                D_sum3 = D_sum3 + myCards.get(x);
            }
            if(D_sum3 > 16){
                myCards.remove(Servlet_info2.get(0));
            }else{}
        }
        return myCards;
    }

    @Override
    public Integer open(ArrayList<Integer> Servlet_info3){      //openメソッド
        int D_total = 0;
        for(int i=0; i<Servlet_info3.size(); i++){
            D_total = D_total + Servlet_info3.get(i);
        }
        return D_total;
    }
    
    public String Victory_or_Defeat(Integer Servlet_info4, Integer Servlet_info5){      //勝敗メソッド
        if((Servlet_info4==21 && Servlet_info5!=21) || (Servlet_info5>21 && Servlet_info4<21)){
                return "Win!!";
        }else if((Servlet_info4<21 && Servlet_info5<21) && Servlet_info4>Servlet_info5){
            return "Win!!";
        }
        if((Servlet_info5==21 && Servlet_info4!=21) || (Servlet_info4>21 && Servlet_info5<21)){
                return "Lose!!";
        }else if((Servlet_info5<21 && Servlet_info4<21) && Servlet_info5>Servlet_info4){
            return "Lose!!";
        }
        if(Servlet_info4==Servlet_info5 || (Servlet_info4>21 && Servlet_info5>21)){
            return "Drow!!";
        }else{
            return "Drow!!";
        }
    }
}
