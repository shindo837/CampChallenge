/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.sql.Timestamp;
import java.util.*;
/**
 *
 * @author tomoya
 */
public class UserDataList {
    private final ArrayList<Integer> userIDList;
    private final ArrayList<String> NameList;
    private final ArrayList<Date> BirthdayList;
    private final ArrayList<String> TellList;
    private final ArrayList<Integer> TypeList;
    private final ArrayList<String> CommentList;
    private final ArrayList<Timestamp> newDateList;
    
    public UserDataList(){
        this.userIDList = new ArrayList();
        this.NameList = new ArrayList();
        this.BirthdayList = new ArrayList();
        this.TellList = new ArrayList();
        this.TypeList = new ArrayList();
        this.CommentList = new ArrayList();
        this.newDateList = new ArrayList();
    }
    
    public int userIDListSize(){
        return this.userIDList.size();
    }
    
    public int getUserIDList(int i){
        return this.userIDList.get(i);
    }
    public void addUserIDList(int i){
        this.userIDList.add(i);
    }
    
    public String getNameList(int i){
        return this.NameList.get(i);
    }
    public void addNameList(String s){
        this.NameList.add(s);
    }
    
    public Date getBirthdayList(int i){
        return this.BirthdayList.get(i);
    }
    public void addBirthdayList(Date d){
        this.BirthdayList.add(d);
    }
    
    public String getTellList(int i){
        return this.TellList.get(i);
    }
    public void addTellList(String s){
        this.TellList.add(s);
    }
    
    public int getTypeList(int i){
        return this.TypeList.get(i);
    }
    public void addTypeList(int i){
        this.TypeList.add(i);
    }
    
    public String getCommentList(int i){
        return this.CommentList.get(i);
    }
    public void addCommentList(String s){
        this.CommentList.add(s);
    }
    
    public Timestamp getNewDateList(int i){
        return this.newDateList.get(i);
    }
    public void addNewDateList(Timestamp t){
        this.newDateList.add(t);
    }
    
    //年のみ表示するためのメソッド
    public int getYear(int i){
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.BirthdayList.get(i));
        int year = cal.get(Calendar.YEAR);
        return year;
    }
}
