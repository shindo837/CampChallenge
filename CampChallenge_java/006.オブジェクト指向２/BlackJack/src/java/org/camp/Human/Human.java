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
    abstract public ArrayList<Integer> setCard(/*ArrayList<Integer> D_firstcards, ArrayList<Integer> D_hitcard*/);
//    abstract public ArrayList<Integer> setCard(ArrayList<Integer> U_firstcards);
    abstract public boolean checkSum();
    abstract public Integer open();
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
        if(D_sum1 <= 11 && D_num != -1){
           D_getHand.set(D_num,10);
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
    public ArrayList<Integer> setCard(/*ArrayList<Integer> D_firstcards, ArrayList<Integer> D_hitcard*/){    //setCardメソッド   <-ここ
        ArrayList<Integer> D_getHand = this.deal();
        ArrayList<Integer> D_getCard = this.hit();
        for(int i=0; i<D_getHand.size(); i++){
            myCards.add(D_getHand.get(i));
        }
        for(int x=0; x<D_getCard.size(); x++){
            myCards.add(D_getCard.get(x));
        }
        return myCards;
    }

    @Override
    public boolean checkSum(){      //checkSumメソッド
        int D_check = 0;
        ArrayList<Integer> D_allHand = this.myCards;
        for(int i=0; i<D_allHand.size(); i++){
            D_check = D_check + D_allHand.get(i);
        }
        if(D_check >= 17){
            return false;
        }else{
            return true;
        }
    }

    public ArrayList<Integer> finishHand(){
        int D_sum2 = 0;
        ArrayList<Integer> cards = this.Trump();
        ArrayList<Integer> D_allHand = this.myCards;
        if(checkSum() == true){     //checkSumメソッドの返り値がtrue
            for(int i=0; i<D_allHand.size(); i++){
                D_sum2 = D_sum2 + D_allHand.get(i);
            }
//            if(17<=D_sum2 && D_sum2<=21){
              while(17<=D_sum2 && D_sum2<=21){
                Random D_rand3 = new Random();
                Integer D_index3 = D_rand3.nextInt(cards.size());
                if(cards.get(D_index3) > 10){
                    cards.set(D_index3,10);
                }
                D_allHand.add(cards.get(D_index3));
                D_sum2 = D_sum2 + cards.get(D_index3);
              }
//            }
        }else{}     //checkSumメソッドの返り値がfalse
        return D_allHand;
    }

    @Override
    public Integer open(){      //openメソッド
        int D_total = 0;
        ArrayList<Integer> DealerHand = finishHand();
        for(int i=0; i<DealerHand.size(); i++){
            D_total = D_total + DealerHand.get(i);
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
        int U_num = U_getHand.indexOf(1);   //１がある要素を検索(無いとき戻り値は-1)
        if(U_sum1 <= 11 && U_num != -1){
           U_getHand.set(U_num,10);
        }
        return U_getHand;
    }

/*    public ArrayList<Integer> hit(){       //hitメソッド
        ArrayList<Integer> U_cards = U_tramp();
        ArrayList<Integer> U_getCard = new ArrayList<Integer>();
        Random U_rand2 = new Random();
        Integer U_index2 = U_rand2.nextInt(U_cards.size());
        if(U_index2 > 10){
            U_index2 = 10;
        }
        U_getCard.add(U_index2);
        return U_getCard;
    }*/

    @Override
    public ArrayList<Integer> setCard(/*ArrayList<Integer> U_firstcards*/){    //setCardメソッド
        ArrayList<Integer> U_getHand = this.deal();
//        ArrayList<Integer> U_addCard = hit();
          for(int i=0; i<U_getHand.size(); i++){
            myCards.add(U_getHand.get(i));
        }
/*        for(int x=0; x<U_addCard.size(); x++){
            myCards.add(U_addCard.get(x));
        }*/
        return myCards;
    } 
    
    @Override
    public boolean checkSum(){      //checkSumメソッド
        int U_check = 0;
        ArrayList<Integer> U_allHand = this.myCards;
        for(int x=0; x<U_allHand.size(); x++){
            U_check = U_check + U_allHand.get(x);
        }
        if(U_check >= 21){
            return false;
        }else{
            return true;
        }
    }

    public ArrayList<Integer> finishHand(){
//        int U_sum2 = 0;
        Dealer User = new Dealer();
        ArrayList<Integer> cards = User.Trump();
//        ArrayList<Integer> U_cards = U_tramp();
        ArrayList<Integer> U_allHand = this.myCards;
        if(checkSum() == true){     //checkSumメソッドの返り値がtrue
//            for(int i=0; i<U_allHand.size(); i++){
//                U_sum2 = U_sum2 + U_allHand.get(i);
//            }
//            if(18<=U_sum2 && U_sum2<=21){
//            while(18<=U_sum2 && U_sum2<=21){
                Random U_rand3 = new Random();
                Integer U_index3 = U_rand3.nextInt(cards.size());
                if(cards.get(U_index3) > 10){
                    cards.set(U_index3,10);
                }
                U_allHand.add(cards.get(U_index3));
//                U_sum2 = U_sum2 + cards.get(U_index3);
//            }
//            }
        }else{}     //checkSumメソッドの返り値がfalse
        return U_allHand;
    }
    
    @Override
    public Integer open(){      //openメソッド
        int U_total = 0;
        ArrayList<Integer> UserHand = finishHand();
        for(int i=0; i<UserHand.size(); i++){
            U_total = U_total + UserHand.get(i);    //最後の要素まで計算していない(後ろの６つ)
        }
        return U_total;
    }
    
    public String Victory_or_Defeat(){      //ユーザーの勝敗メソッド
        Integer U_total = open();
        Dealer Dealer = new Dealer();   //Humanクラスを継承したDealerクラスのインスタンス生成
        Integer D_total = Dealer.open();   //インスタンスされたオブジェクトの利用
/*-------------------------------------ここから------------------------------------------*/
        if(U_total>D_total && U_total<=21 || D_total>21){
            return "Win!!";
        }else if(U_total<D_total && D_total<=21 || U_total>21){
            return "Lose!!";
        }else{
            return "Drow!!";
        }
/*--------------------------------------------------------------------------------------*/
    }
}