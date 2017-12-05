package com.za.example;

/**
 * Created by ZD on 2017/10/18.
 */
public class Game {


    private int itscurrentFrame = 0;//当前投掷轮
    private Scorer itsScorer = new Scorer();
    private boolean firstThrowInFrame = true;


    public void add(int pines) {
        itsScorer.addThrow(pines);
        adjustCurrentFrame(pines);
    }

    /**
     * 调整当前轮数
     */
    private void adjustCurrentFrame(int pines) {
        if (lastBallInframe(pines)){
            advanceFrame();
        }
        else {
            firstThrowInFrame = false;
        }
    }

    private boolean lastBallInframe(int pines) {
        return strike(pines) || !firstThrowInFrame;
    }

    private boolean strike(int pines) {
        return (firstThrowInFrame && pines == 10);
    }

    private boolean adjustFrameForStrike(int pines) {
        if (pines == 10){
            advanceFrame();
            return true;
        }
        return false;
    }

    private void advanceFrame() {
        itscurrentFrame = Math.min(10,itscurrentFrame+1);
    }

    public int score() {
        return scoreForFrame(itscurrentFrame);
    }

    public int scoreForFrame(int frame) {
        return itsScorer.scoreForFrame(frame);
    }

    public int getCurrentFrame() {
        return itscurrentFrame;
    }
}
