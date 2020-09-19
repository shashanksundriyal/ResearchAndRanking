package com.researchandranking.learnr.model;

public class LeaderboardUser {

    private int rank;
    private int dp;
    private int points;
    private String name;

    public LeaderboardUser(int rank, int dp, int points, String name) {
        this.rank = rank;
        this.dp = dp;
        this.points = points;
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getDp() {
        return dp;
    }

    public void setDp(int dp) {
        this.dp = dp;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
