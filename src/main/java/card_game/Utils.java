package main.java.card_game;

import java.util.Random;

/**
 * 公用方法类
 */
public class Utils {
    public static int getIntRandom(){
        Random random=new Random();
        int value=random.nextInt(10);
        return value;
    }

    public static String getAttributeName(int attributeIndex){
        String attributeName="";
        if(attributeIndex==0){
            attributeName="生命属性";
        }else if(attributeIndex==1){
            attributeName="防御属性";
        }else if(attributeIndex==2){
            attributeName="魔法属性";
        }else if(attributeIndex==3){
            attributeName="进攻属性";
        }
        return attributeName;
    }
    public static String getAttributeEName(int attributeIndex){
        String attributeName="";
        if(attributeIndex==0){
            attributeName="lifeAttribute";
        }else if(attributeIndex==1){
            attributeName="defenseAttribute";
        }else if(attributeIndex==2){
            attributeName="magicAttribute";
        }else if(attributeIndex==3){
            attributeName="attackAttribute";
        }
        return attributeName;
    }
}
