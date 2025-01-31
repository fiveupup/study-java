package com.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 玩家
 */
public class Player {
    /**
     * 玩家名称
     */
    private String name;
    /**
     * 手上的牌
     */
    private List<Card> cards;
    /**
     * 得分
     */
    private int score;

    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
        this.score = 0;
    }

    /**
     * 取牌
     *
     * @param card
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * 累加分
     *
     * @param score
     */
    public void addScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return score;
    }

    /**
     * 出牌
     * @return
     */
    public Card playCard() {
        // 随机出一张牌
        return cards.remove(new Random().nextInt(cards.size()));
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return name + " " + cards.toString();
    }
}
