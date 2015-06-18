package com.kyumdroid.study.pattern;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *  Decorator Pattern(데코레이터 패턴)
 * 
 *  설명 :  객체에 추가적인 요소를 첨가하여 객체의 기능을 설정하거나 변경 할 수 있는 패턴이다.
 *          대표적인 예로 자바의 기본 입/출력 클래스는 데코레이터 패턴을 확장한 예이다.
 *
 */
public class DecoratorPatternEx
{
    public static void main(String[] args) throws IOException
    {
        /** 예제1 */
        HeroSkill skill = new RunSkill(new FlySkill(new WalkSkill()));
        System.out.println("skill : " + skill.getSkill());
        
        /** 예제 2*/
        FileOutputStream fos = new FileOutputStream(new File("test.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        
        oos.writeBoolean(true);
        oos.writeInt(100);
        oos.flush();
        
        if(oos != null) oos.close();
        if(bos != null) bos.close();
        if(fos != null) fos.close();
        
        
    }
}


abstract class HeroSkill
{    
    String detail = "BASIC";
    public abstract String getSkill();
}

class WalkSkill extends HeroSkill
{
    public WalkSkill()
    {
        detail = "WALK";
    }
    @Override
    public String getSkill()
    {
        return detail;
    }
}

class FlySkill extends HeroSkill
{
    private HeroSkill skill;
    
    public FlySkill(HeroSkill skill)
    {
        this.skill = skill;
    }
    @Override
    public String getSkill()
    {
        return skill.getSkill() + ", FLY";
    }
}

class RunSkill extends HeroSkill
{
    private HeroSkill skill;
    
    public RunSkill(HeroSkill skill)
    {
        this.skill = skill;
    }
    @Override
    public String getSkill()
    {
        return skill.getSkill() + ", RUN";
    }
}

