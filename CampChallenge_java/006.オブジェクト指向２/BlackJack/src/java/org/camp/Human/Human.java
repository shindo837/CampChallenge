/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.Human;

import java.util.ArrayList;
/**
 *
 * @author tomoya
 */
abstract class Human{   //Humanという抽象クラス
    abstract protected void open();
    abstract protected void checkSum();
    abstract protected ArrayList setCard();
    protected String myCards[] = {"1","1","1","1","2","2","2","2","3","3","3","3","4","4","4","4","5","5","5","5","6","6","6","6","7","7","7","7","8","8","8","8","9","9","9","9","10","10","10","10","11","11","11","11","12","12","12","12","13","13","13","13"};
}
