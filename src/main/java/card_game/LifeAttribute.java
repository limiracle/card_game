package main.java.card_game;

/**
 * 生命属性
 */
public class LifeAttribute extends Attribute{

    public LifeAttribute() {
        super("生命属性", Utils.getIntRandom());
    }
}
