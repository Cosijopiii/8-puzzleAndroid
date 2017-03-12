package com.unistmo.edu.a8_puzzle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by COSI on 03/03/2017 For life.
 */
public class Puzzle{

    private List<Integer> states;
    private Puzzle parent;
    private int g_score;
    private int f_score;



    public Puzzle( List<Integer> states){
        this.states=new ArrayList<>(states);
    }
    public static Puzzle moveBlankUp(Puzzle puzzlein){
        Puzzle puzzle=new Puzzle(puzzlein.states);
        int idx= puzzle.states.indexOf(9);
        if (1+idx-3>=1){
            puzzle.states.set(idx,puzzle.states.get(idx-3));
            puzzle.states.set(idx-3,9);
        }
        return puzzle;
    }
    public static Puzzle moveBlankDown(Puzzle puzzlein){
        Puzzle puzzle=new Puzzle(puzzlein.states);
        int idx= puzzle.states.indexOf(9);
        if (1+idx+3<=9){
            puzzle.states.set(idx,puzzle.states.get(idx+3));
            puzzle.states.set(idx+3,9);
        }
        return puzzle;
    }
    public static Puzzle moveBlankLeft(Puzzle puzzlein){
        Puzzle puzzle=new Puzzle(puzzlein.states);
        int idx= puzzle.states.indexOf(9);
        int idy=idx+1;
        if (idy!=1 && idy!=4&&idy!=7){
            puzzle.states.set(idx,puzzle.states.get(idx-1));
            puzzle.states.set(idx-1,9);
        }
        return puzzle;
    }
    public static Puzzle moveBlankRight(Puzzle puzzlein){
        Puzzle puzzle=new Puzzle(puzzlein.states);
        int idx= puzzle.states.indexOf(9);
        if ((1+idx)%3!=0){
            puzzle.states.set(idx,puzzle.states.get(idx+1));
            puzzle.states.set(idx+1,9);
        }
        return puzzle;
    }
    public List<Integer> getStates() {
        return states;
    }
    public void setStates(List<Integer> states) {
        this.states = states;
    }
    public Puzzle getParent() {
        return parent;
    }
    public void setParent(Puzzle parent) {
        this.parent = parent;
    }
    public int getG_score() {return g_score;}
    public void setG_score(int g_score) {this.g_score = g_score;
    }

    public int getF_score() {
        return f_score;
    }

    public void setF_score(int f_score) {
        this.f_score = f_score;
    }

    @Override
    public String toString() {
        return "Puzzle{" +
                "states=" + states +
                ", parent=" + parent +
                ", g_score=" + g_score +
                ", f_score=" + f_score +
                '}';
    }
}
