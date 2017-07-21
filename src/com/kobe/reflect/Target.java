package com.kobe.reflect;

/**
 * Created by I047580 on 3/25/2017.
 */
public class Target {
    private int score;
    private String name;

    public Target(int score, String name) {
        this.score = score;
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
