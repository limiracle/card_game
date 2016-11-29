package main.java.card_game;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 玩家抽象类
 */
public class Player {
    private String name;
    private Queue<Card> cardQueue=null;

    public Player(String name,int cardNums){
        this.name=name;
        cardQueue=new LinkedBlockingQueue();
        for(int i=0;i<cardNums;i++){
            Card card=new Card();
            cardQueue.add(card);
        }
    }

    /**
     * @return 玩家名字
  */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return 玩家卡牌队列
     */
    public Queue<Card> getCardQueue() {
        return cardQueue;
    }

    /**
     * @param cardQueue
     */
    public void setCardQueue(Queue<Card> cardQueue) {
        this.cardQueue = cardQueue;
    }

    /**
     * @param card
     */
    public void removeCard(Card card){
        cardQueue.remove(card);
    }

    /**
     * @param card
     */
    public void addCard(Card card){
        cardQueue.add(card);
    }

    public String getPlayerString(){
        return name+"各个属性值为："+cardQueue.peek().getCardString();
    }

    public String getPlayerEngString(){
        return name+"'s every attribute is："+cardQueue.peek().getCardEString();
    }
}
