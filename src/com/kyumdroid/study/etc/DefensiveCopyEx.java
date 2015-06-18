package com.kyumdroid.study.etc;

import java.util.Date;

public class DefensiveCopyEx
{
    public static void main(String[] args)
    {
        DefensiveCopyEx ex = new DefensiveCopyEx();
        ex.testScoreManager(new FoolishScoreManager(new Date(), new int[]{1,2,3,4,5}));
        
        System.out.println();
        
        ex.testScoreManager(new SmartScoreManager(new Date(), new int[]{1,2,3,4,5}));
        
        DefensiveDataManager manager = new DefensiveDataManager(new int[]{1,2}, new Day(10));
        System.out.println("날짜 : " + manager.getDay().getDay());
        System.out.println("점수 : " + manager.getValues()[0]);
        
        manager.getDay().setDay(20);
        manager.getValues()[0] = 100;
        System.out.println("날짜 : " + manager.getDay().getDay());
        System.out.println("점수 : " + manager.getValues()[0]);
    }
    
    private void testScoreManager(final ScoreManager manager)
    {
        System.out.println("날짜 : " + manager.getDate());
        print(manager.getScores());
        
        attack(manager);
        
        System.out.println("날짜 : " + manager.getDate());
        print(manager.getScores());
    }
    
    private void attack(final ScoreManager manager)
    {
        manager.getDate().setDate(manager.getDate().getDate() + 1);
        manager.getScores()[0] = 11;
        manager.getScores()[1] = 12;
        manager.getScores()[2] = 13;
        manager.getScores()[3] = 14;
        manager.getScores()[4] = 15;
    }
    
    private void print(int[] scores)
    {
        System.out.print("score : ");
        for(int score : scores)
        {
            System.out.print(score +", ");
        }
        System.out.println();
    }
}


class FoolishScoreManager implements ScoreManager{
    private final Date date;
    private final int[] scores;
    
    public FoolishScoreManager(Date date, int[] scores){
        this.date = date;
        this.scores = scores;
    }
    
    @Override
    public Date getDate(){
        return date;
    }
    
    @Override
    public int[] getScores(){
        return scores;
    }
}

class SmartScoreManager implements ScoreManager{
    private final Date date;
    private final int[] scores;
    
    public SmartScoreManager(Date date, int[] scores){
        
        this.scores = new int[scores.length];
        System.arraycopy(scores, 0, this.scores, 0, scores.length);
        
        this.date = new Date(date.getTime());
    }
    
    @Override
    public Date getDate(){
        return new Date(date.getTime());
    }
    
    @Override
    public int[] getScores(){
        return scores.clone();
    }
}

interface ScoreManager{
    public Date getDate();
    public int[] getScores();
}


class DataManager{
    int[] values;
    Day day;
    
    public DataManager(int[] values,Day day){
        this.values = values;
        this.day = day;
    }
    
    public Day getDay(){
        return day;
    }
    
    public int[] getValues(){
        return values;
    }
}

class DefensiveDataManager{
    int[] values;
    Day day;
    
    public DefensiveDataManager(int[] values,Day day){
        this.values = new int[values.length];
        System.arraycopy(values, 0, this.values, 0, values.length);
        
        this.day = new Day(day.getDay());
    }
    
    public Day getDay(){
        return new Day(day.getDay());
    }
    
    public int[] getValues(){
        return values.clone();
    }
}

class Day{
    int day;
    
    public Day(int day){
        this.day = day;
    }
    
    public void setDay(int day){
        this.day = day;
    }
    
    public int getDay(){
        return day;
    }
}


