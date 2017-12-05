package com.za.example;

/**
 * 分数统计
 * Created by ZD on 2017/10/19.
 */
public class Scorer {

    private int ball;
    private int[] itsThrow = new int[21];
    private int itsCurrentThrow = 0;


    public void addThrow(int pines){
        itsThrow[itsCurrentThrow++] = pines;
    }

    public int scoreForFrame(int theFrame){
        ball = 0;
        int score = 0;
        for (int currentFrame = 0; currentFrame < theFrame; currentFrame++){
            if (strike()){
                score += 10 + nextTwoBallsForStrike();
                ball++;
            }
            else if (spare()){
                score += 10 + nextBallForSpare();
                ball+=2;
            }
            else {
                score += towBallsInFrame();
                ball+=2;
            }
        }
        return score;
    }

    private int towBallsInFrame() {
        return itsThrow[ball]+itsThrow[ball+1];
    }

    private int nextBallForSpare() {
        return itsThrow[ball+2];
    }

    private int nextTwoBallsForStrike() {
        return itsThrow[ball+1]+itsThrow[ball+2];
    }

    private boolean spare() {
        return (itsThrow[ball] + itsThrow[ball+1]) == 10;
    }

    private boolean strike() {
        return itsThrow[ball] == 10;
    }



}
