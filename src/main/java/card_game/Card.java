package main.java.card_game;


import java.util.ArrayList;
import java.util.List;

public class Card {
    public List<Attribute> list =new ArrayList();

    public Card(){
        Attribute lifeAttribute=new LifeAttribute();
        Attribute DefenseAttribute=new DefenseAttribute();
        Attribute MagicAttribute=new MagicAttribute();
        Attribute attackAttribute=new AttackAttribute();
        list.add(lifeAttribute);
        list.add(DefenseAttribute);
        list.add(MagicAttribute);
        list.add(attackAttribute);
    }

    /**
     * @return card 属性
     */
    public List<Attribute> getList() {
        return list;
    }

    /**
     * @param list
     */
    public void setList(List<Attribute> list) {
        this.list = list;
    }

    public String getCardString(){
        return "生命属性值为"+list.get(0).getAttributeValue()+";"+"防御属性值为"+list.get(1).getAttributeValue()
                +";魔法属性值为"+list.get(2).getAttributeValue()+";"+"攻击属性值为"+list.get(3).getAttributeValue()+";";
    }

    public String getCardEString(){
        return "lifeAttribute is "+list.get(0).getAttributeValue()+";"+"defenseAttribute is "+list.get(1).getAttributeValue()
                +";magicAttribute is "+list.get(2).getAttributeValue()+";"+"attackAttribute is "+list.get(3).getAttributeValue()+";";
    }
}
