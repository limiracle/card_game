package main.java.card_game;

import java.util.ArrayList;
import java.util.List;

/**
 * 卡牌游戏基本规则
 */
public class Game {

    public List<Player> list;
    public List<Player> lastList;

    /**
     * 比较card1 和card2 属性值的大小，card1>=card2 返回true，否则，返回false
     * @param card1
     * @param card2
     * @param attributeIndex
     * @return
     */
    public boolean compare(Card card1,Card card2,int attributeIndex){

        Attribute attribute1=card1.getList().get(attributeIndex);
        Attribute attribute2=card2.getList().get(attributeIndex);
        return attribute1.getAttributeValue()>=attribute2.getAttributeValue()?true:false;
    }



    /**
     * 一个回合游戏，比较属性大小，将牌移到赢的player的card list中
     * @param turn
     * @param attributeIndex
     * @return
     */
    public int playOneTurn(int turn,int attributeIndex){

        //System.out.println("此轮游戏中，需要比较的属性为："+Utils.getAttributeName(attributeIndex));
        System.out.println("in this turn compare："+Utils.getAttributeEName(attributeIndex));
        int win=getWinPlayer(list,attributeIndex);
        Player winer=list.get(win);
//        System.out.println("此轮游戏中赢家为："+winer.getName());
//        System.out.println("赢家收牌，请稍后。。。");
        System.out.println("in this turn the winner is："+winer.getName());
        System.out.println("winner is getting card ,please waiting...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dealOneTurn(list,win);
        list=lastList;
        return list.size();
    }


    /**
     * 比较得到赢的玩家的list index
     * @param list
     * @param attributeIndex
     * @return
     */
    public int getWinPlayer(List<Player> list,int attributeIndex){
        int win=0;
//        System.out.println("此回合中各个玩家手中的牌为：");
        System.out.println("in this turn the player's card is：");
        Card card=list.get(0).getCardQueue().peek();
//        System.out.println("    "+list.get(0).getPlayerString());
        System.out.println("    "+list.get(0).getPlayerEngString());
        for(int i=1;i<list.size();i++){
//            System.out.println("    "+list.get(i).getPlayerString());
            System.out.println("    "+list.get(i).getPlayerEngString());
            Card card1=list.get(i).getCardQueue().peek();
            if(!compare(card,card1,attributeIndex)){
                card=card1;
                win=i;
            }
        }
        return win;
    }


    /**
     * 处理某一轮的牌 将其他玩家的牌收起来置于赢的区域牌堆底部
     * @param list
     * @param winIndex
     */
    public void dealOneTurn(List<Player> list,int winIndex){
        Player winPlayer=list.get(winIndex);
        lastList=new ArrayList();
        lastList.add(winPlayer);
        for(int i=0;i<list.size();i++){
            Player player=list.get(i);
            Card card1=player.getCardQueue().poll();
            winPlayer.getCardQueue().add(card1);
            if(player.getCardQueue().size()>0&&winIndex!=i){
                lastList.add(player);
            }
        }
    }

    public List<Player> getList() {
        return list;
    }

    public void setList(List<Player> list) {
        this.list = list;
    }

    public List<Player> getLastList() {
        return lastList;
    }

    public void setLastList(List<Player> lastList) {
        this.lastList = lastList;
    }
}
