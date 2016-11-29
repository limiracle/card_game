package main.java.card_game;

/**
 * 攻击属性
 */
public class AttackAttribute extends Attribute{

    public AttackAttribute() {
        super("攻击属性", Utils.getIntRandom());
    }
}
