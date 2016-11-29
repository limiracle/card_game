package main.java.card_game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by lizhi on 2016/11/14.
 */
public class Main {

    public static void main(String args[]){
        List<Player> playerList=new ArrayList();
        List<Player> winPlayerList=new ArrayList();
        int computerType=1;
        int compareType=0;
        Scanner in = new Scanner(System.in);
//        System.out.println("请输入需要参与的玩家数量: ");
        System.out.println("please enter player numbers: ");
        int playerNums = Integer.parseInt(in.nextLine());
//        System.out.println("请输入每个玩家牌的数量: ");
        System.out.println("please enter card numbers: ");
        int cardNums = Integer.parseInt(in.nextLine());
//        System.out.println("请输入计算机玩家类型:1 普通电脑 2 高级电脑");
        System.out.println("please choose computer type : 1 normal computer 2 high computer");
        computerType=Integer.parseInt(in.nextLine());
//        System.out.println("请输入玩家的名称用英文逗号分隔：");
        System.out.println("please enter the player name:");
        String playerNames=in.nextLine();
        String[] playerNameArr=playerNames.split(",");
//        System.out.println("正在给玩家发牌，请稍后。。。");
        System.out.println("Being issued please waiting...");
        for(int i=0;i<playerNums-1;i++){
            Player player=new HumanPlayer(playerNameArr[i],cardNums);
            playerList.add(player);
        }
//        Player player=new ComputerPlayer("电脑玩家",cardNums);
        Player player=new ComputerPlayer("computer",cardNums);
        playerList.add(player);


        int winPlayerNums=playerNums;

//        System.out.println("游戏开始。。。");
        System.out.println("game begin...");
        Game game=new Game();
        game.setList(playerList);
        game.setLastList(playerList);
        int turn=1;
//        Sygame.playOneTurn(turn,compareType);
        while(winPlayerNums!=1){
//            System.out.println("第"+turn+"轮游戏开始：");
            System.out.println("in "+turn+" turn begin：");
            winPlayerList=game.getLastList();
//            System.out.println(winPlayerList.get(0).getPlayerString());
            System.out.println(winPlayerList.get(0).getPlayerEngString());
            if(winPlayerList.get(0) instanceof HumanPlayer){
//                System.out.println("请"+winPlayerList.get(0).getName()+"输入需要比较的属性 ：0 生命属性 1 防御属性 2 魔法属性 3 攻击属性");
                System.out.println("please "+winPlayerList.get(0).getName()+" enter the compare attribute ：0 life attribute 1 defense attribute 2 magic attribute 3 attack attribute");
                compareType=Integer.parseInt(in.nextLine());
            }else{
                if(computerType==1){
                    compareType=1;
                }else{
                    Random random=new Random();
                    compareType=random.nextInt(4);
                }
//                System.out.println("电脑选择比较的属性为："+Utils.getAttributeName(compareType));
                System.out.println("computer chose attribute is ："+Utils.getAttributeEName(compareType));
            }
            winPlayerNums=game.playOneTurn(turn,compareType);
            turn++;
        }
//        System.out.println("游戏完成！最终胜利者为:"+winPlayerList.get(0).getName());
        System.out.println("game over the winner is:"+winPlayerList.get(0).getName());
    }


}
