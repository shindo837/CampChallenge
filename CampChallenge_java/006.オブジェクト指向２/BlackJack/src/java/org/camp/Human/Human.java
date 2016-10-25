/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.Human;

import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author tomoya
 */
abstract class Human{   //Humanという抽象クラス
    public ArrayList<Integer> myCards = new ArrayList<Integer>();
    abstract public ArrayList<Integer> setCard(ArrayList<Integer> Servlet_info1);
    abstract public boolean checkSum(ArrayList<Integer> Servlet_info2);
    abstract public Integer open(ArrayList<Integer> Servlet_info3);
}

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
        int D_sum2 = 0;
        int D_num1 = myCards.indexOf(1);   //1がある要素を検索(無いとき戻り値は-1)
        for(int x=0; x<Servlet_info2.size(); x++){
            D_sum2 = D_sum2 + Servlet_info2.get(x);
        }
        if(D_num1!=-1 && D_sum2<=10){
            myCards.set(D_num1,11);
        }
        for(int i=0; i<Servlet_info2.size(); i++){
            D_check = D_check + Servlet_info2.get(i);
        }
        if(D_check > 16){
            return false;
        }else{
            return true;
        }
    }

    public ArrayList<Integer> finishHand(ArrayList<Integer> Servlet_info2, ArrayList<Integer> Servlet_info1){
        int D_sum3 = 0;
        int D_sum4 = 0;
        ArrayList<Integer> cards = this.Trump();
        if(checkSum(Servlet_info2) == true){     //checkSumメソッドの返り値がtrue
            while(D_sum3<21){
                Random D_rand3 = new Random();
                Integer D_index3 = D_rand3.nextInt(cards.size());
                if(cards.get(D_index3) > 10){
                    cards.set(D_index3,10);
                }
                myCards.add(cards.get(D_index3));
                D_sum3 = D_sum3 + cards.get(D_index3);
                int D_num = myCards.indexOf(1);   //1がある要素を検索(無いとき戻り値は-1)
                if(D_sum3<=10 && D_num!=-1){
                    myCards.set(D_num,11);
                }
                for(int i=0; i<myCards.size(); i++){
                    D_sum3 = D_sum3 + myCards.get(i);
                }
            }
        }else{      //checkSumメソッドの返り値がtrue以外
            for(int x=0; x<myCards.size()-1; x++){
                D_sum4 = D_sum4 + myCards.get(x);
            }
            if(D_sum4 > 16){
                myCards.remove(Servlet_info1.get(0));
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
        int D_num = myCards.indexOf(11);   //11がある要素を検索(無いとき戻り値は-1)
        if(D_total>21 && D_num!=-1){
            myCards.set(D_num,1);
            D_total = 0;
            for(int x=0; x<Servlet_info3.size(); x++){
                D_total = D_total + Servlet_info3.get(x);
            }
        }
        return D_total;
    }
}

class User extends Human{     //Humanクラスを継承したUserクラス

    public ArrayList<Integer> deal(){    //dealメソッド
        int U_sum1 = 0;
        Dealer User = new Dealer();
        ArrayList<Integer> cards = User.Trump();
        ArrayList<Integer> U_getHand = new ArrayList<Integer>();
        for(int i=0; i<2; i++){
            Random U_rand1 = new Random();
            Integer U_index1 = U_rand1.nextInt(cards.size());
            if(cards.get(U_index1) > 10){
                cards.set(U_index1,10);
            }
            U_getHand.add(cards.get(U_index1));
            U_sum1 = U_sum1 + U_getHand.get(i);
        }
        int U_num1 = U_getHand.indexOf(1);   //1がある要素を検索(無いとき戻り値は-1)
        if(U_sum1<=11 && U_num1!=-1){
           U_getHand.set(U_num1,11);
        }
        return U_getHand;
    }

    public ArrayList<Integer> hit(){       //hitメソッド
        Dealer User = new Dealer();
        ArrayList<Integer> cards = User.Trump();
        ArrayList<Integer> U_getCard = new ArrayList<Integer>();
        Random U_rand2 = new Random();
        Integer U_index2 = U_rand2.nextInt(cards.size());
        if(cards.get(U_index2) > 10){
            cards.set(U_index2,10);
        }
        U_getCard.add(cards.get(U_index2));
        return U_getCard;
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
        int U_check = 0;
        int U_sum2 = 0;
        int U_num2 = myCards.indexOf(1);    //1がある要素を検索(無いとき戻り値は-1)
        for(int x=0; x<Servlet_info2.size(); x++){
            U_sum2 = U_sum2 + Servlet_info2.get(x);
        }
        if(U_num2!=-1 && U_sum2<=10){
            myCards.set(U_num2,11);
        }
        for(int i=0; i<Servlet_info2.size(); i++){
            U_check = U_check + Servlet_info2.get(i);
        }
        if(U_check > 17){
            return false;
        }else{
            return true;
        }
    }

    public ArrayList<Integer> finishHand(ArrayList<Integer> Servlet_info2, ArrayList<Integer> Servlet_info1){
        int U_sum3 = 0;
        int U_sum4 =0;
        Dealer User = new Dealer();
        ArrayList<Integer> cards = User.Trump();
        if(checkSum(Servlet_info2) == true){     //checkSumメソッドの返り値がtrue
            while(U_sum3 < 21){
                Random U_rand3 = new Random();
                Integer U_index3 = U_rand3.nextInt(cards.size());
                if(cards.get(U_index3) > 10){
                    cards.set(U_index3,10);
                }
                myCards.add(cards.get(U_index3));
                U_sum3 = U_sum3 + cards.get(U_index3);
                int U_num = myCards.indexOf(1);   //１がある要素を検索(無いとき戻り値は-1)
                if(U_sum3<=10 && U_num!=-1){
                    myCards.set(U_num,11);
                }
                for(int i=0; i<myCards.size(); i++){
                    U_sum3 = U_sum3 + myCards.get(i);
                }
            }
        }else{      //checkSumメソッドの返り値がtrue以外
            for(int x=0; x<myCards.size()-1; x++){
                U_sum4 = U_sum4 + myCards.get(x);
            }
            if(U_sum3 > 17){
                myCards.remove(Servlet_info1.get(0));
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
        int D_num = myCards.indexOf(11);   //11がある要素を検索(無いとき戻り値は-1)
        if(U_total>21 && D_num!=-1){
            myCards.set(D_num,1);
            U_total = 0;
            for(int x=0; x<Servlet_info3.size(); x++){
                U_total = U_total + Servlet_info3.get(x);
            }
        }
        return U_total;
    }
    
    public String Victory_or_Defeat(Integer Servlet_info4, Integer Servlet_info5){      //ユーザーの勝敗メソッド
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