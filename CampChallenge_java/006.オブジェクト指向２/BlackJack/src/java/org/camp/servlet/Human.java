/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.util.ArrayList;
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