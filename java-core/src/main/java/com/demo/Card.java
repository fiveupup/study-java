package com.demo;

/**
 * 牌对象
 */
public class Card {
    /**
     * 牌的数字
     */
    private int no;
    /**
     * 花色
     */
    private String suit;

    public Card(int no, String suit) {
        this.no = no;
        this.suit = suit;
    }

    public int getNo() {
        return no;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return no + suit;
    }

    /**
     * 比较牌大小
     *
     * @param c1
     * @param c2
     * @return
     */
    public static int compare(Card c1, Card c2) {
        if (c1.getNo() != c2.getNo()) {
            return c1.getNo() - c2.getNo();
        }
        return buildSuitOrder(c1.getSuit()) - buildSuitOrder(c2.getSuit());
    }

    /**
     * 各个花色指定顺序
     *
     * @param suit
     * @return
     */
    private static int buildSuitOrder(String suit) {
        return switch (suit) {
            // 方片
            case "D" -> 1;
            // 梅花
            case "C" -> 2;
            // 红桃
            case "H" -> 3;
            // 黑桃
            case "S" -> 4;
            default -> 0;
        };
    }
}
