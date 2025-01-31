package com.demo;

/**
 * 队伍
 */
public class Team {
    /**
     * 玩家1
     */
    private Player player1;
    /**
     * 玩家2
     */
    private Player player2;

    public Team(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * 队伍总分
     *
     * @return
     */
    public int getTeamScore() {
        return player1.getScore() + player2.getScore();
    }

    @Override
    public String toString() {
        return player1.getName() + " & " + player2.getName();
    }
}
