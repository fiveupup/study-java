package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CardGameStarter {

    /**
     * 一副牌
     */
    private List<Card> cards;
    /**
     * 所有玩家
     */
    private List<Player> players;
    /**
     * 队伍1、队伍2
     */
    private Team team1, team2;

    /**
     * 所有轮出牌情况
     */
    List<List<Card>> allRoundCards = new ArrayList<>();
    /**
     * 所有轮的胜者
     */
    List<Player> roundWinners = new ArrayList<>();
    /**
     * 每轮胜出的牌
     */
    List<Card> roundWinnerCards = new ArrayList<>();

    public CardGameStarter() {
        // 初始化牌数据
        initCards();
        // 初始化玩家
        players = new ArrayList<>(Arrays.asList(
                new Player("甲"), new Player("乙"), new Player("丙"), new Player("丁")
        ));
        // 玩家随机组合
        Collections.shuffle(players);
        team1 = new Team(players.get(0), players.get(1));
        team2 = new Team(players.get(2), players.get(3));
    }

    private void initCards() {
        cards = new ArrayList<>();
        // 四种花色
        String[] suits = {"A", "B", "C", "D"};
        for (int i = 1; i <= 13; i++) {
            for (String suit : suits) {
                cards.add(new Card(i, suit));
            }
        }
        // 大王
        cards.add(new Card(20, "K"));
        // 小王
        cards.add(new Card(20, "Q"));
        // 再次打乱
        Collections.shuffle(cards);
    }

    /**
     * 发牌
     */
    public void dealCards() {
        for (int i = 0; i < 13; i++) {
            for (Player player : players) {
                player.addCard(cards.remove(0));
            }
        }
    }

    /**
     * 出牌 13轮
     */
    public void playRounds() {
        // 四个人，出13轮牌
        for (int i = 0; i < 13; i++) {
            List<Card> roundCards = new ArrayList<>();
            // 本轮赢家
            Player roundWinner = null;
            // 本轮最大的牌
            Card winningCard = null;

            List<Card> roundPlayCards = new ArrayList<>();
            for (Player player : players) {
                Card playedCard = player.playCard();
                roundCards.add(playedCard);
                if (winningCard == null || Card.compare(playedCard, winningCard) > 0) {
                    winningCard = playedCard;
                    roundWinner = player;
                }
                roundPlayCards.add(playedCard);
            }
            allRoundCards.add(roundCards);
            roundWinnerCards.add(winningCard);

            if (roundWinner != null) {
                roundWinner.addScore(
                        roundCards.stream().mapToInt(Card::getNo).sum()
                );
                roundWinners.add(roundWinner);
            }
        }
    }

    public void showResults() {
        System.out.println("==============================");
        System.out.printf("玩 家:   ");
        for (Player player : players) {
            System.out.printf("%-5s", player.getName());
        }
        System.out.println();
        for (int i = 0; i < allRoundCards.size(); i++) {
            System.out.printf("第%2d轮   ", i + 1);
            // 当前轮胜出的牌
            Card card = roundWinnerCards.get(i);
            allRoundCards.get(i).forEach(x -> {
                if (x.equals(card)) {
                    // 红色文本标记胜出的牌
                    System.out.printf("\033[31m%-6s\033[0m", x);
                } else {
                    System.out.printf("%-6s", x);
                }
            });
            System.out.println();
        }

        System.out.println("==============================");
        for (Player player : players) {
            System.out.println(player.getName() + " 得分: " + player.getScore());
        }
        System.out.println("==============================");
        System.out.println(team1 + " 总得分: " + team1.getTeamScore());
        System.out.println(team2 + " 总得分: " + team2.getTeamScore());
    }

    public static void main(String[] args) {
        CardGameStarter cardGameStarter = new CardGameStarter();
        // 1、发牌
        cardGameStarter.dealCards();
        // 2、出牌
        cardGameStarter.playRounds();
        // 3、展示结果
        cardGameStarter.showResults();
    }
}
