package main.java.card_game;

/**
 * 卡牌属性抽象类
 */
public class Attribute {
    private String attributeName;
    private int attributeValue;

    public Attribute(String attributeName,int attributeValue){
        this.attributeName=attributeName;
        this.attributeValue=attributeValue;
    }

    /**
     * @return 属性名称
     */
    public String getAttributeName() {
        return attributeName;
    }

    /**
     * @param attributeName
     */
    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    /**
     * @return 属性值
     */
    public int getAttributeValue() {
        return attributeValue;
    }

    /**
     * @param attributeValue
     */
    public void setAttributeValue(int attributeValue) {
        this.attributeValue = attributeValue;
    }
}
