package com.unistmo.edu.a8_puzzle;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;

/**
 * Created by cosijopii on 11/03/17.
 */

public class Astart {



    private static Integer[] GOAL={1,2,3,4,5,6,7,8,9};
    private static List<Integer> go= Arrays.asList(GOAL);
    private List<Puzzle> puzzleListOpen=new ArrayList<>();
    private List<Puzzle> puzzleListClosed=new ArrayList<>();
    private Puzzle nodeInit;


    public Astart(Puzzle puzzle){
        nodeInit=puzzle;
    }

    public void Search(){
        nodeInit.setF_score(nodeInit.getG_score()+ManhattanDistanceH(nodeInit.getStates()));
        puzzleListOpen.add(nodeInit);
        while (puzzleListOpen.size()!=0){
            Puzzle current=puzzleListOpen.get(0);
            int currentIndex=0;

            for (int i = 0; i < puzzleListOpen.size(); i++) {
                if (puzzleListOpen.get(i).getF_score()<current.getF_score()){
                    current=puzzleListOpen.get(i);
                    currentIndex=i;
                }
            }

            if (current.getStates().equals(go)){

                Puzzle node=current;

                List<Puzzle> path=new ArrayList<>();
                while (node.getParent()!=null){
                    node=node.getParent();
                    path.add(node);
                }
                String a="";
                for (Puzzle p:path ) {
                    for (Integer i:p.getStates()) {
                       a=a+i;
                    }
                    Log.d("A*", "Search: "+" "+a);
                    a="";
                }

                break;
            }
            puzzleListOpen.set(currentIndex,null);
            puzzleListClosed.add(current);
            List<Puzzle> neighbors=new ArrayList<>();


            boolean vneig=true;
            Puzzle nodemoveLeft=Puzzle.moveBlankLeft(current);
            for (int i = 0; i < puzzleListClosed.size(); i++)
                if (nodemoveLeft.getStates().equals(current.getStates())) {
                    vneig = false;
                    break;
                }

            if (vneig){
                nodemoveLeft.setParent(current);
                nodemoveLeft.setG_score(current.getG_score()+1);
                neighbors.add(nodemoveLeft);
            }
            vneig=true;
            Puzzle nodemoveRight=Puzzle.moveBlankRight(current);
            for (int i = 0; i < puzzleListClosed.size(); i++)
                if (nodemoveRight.getStates().equals(current.getStates())) {
                    vneig = false;
                    break;
                }

            if (vneig){
                nodemoveRight.setParent(current);
                nodemoveRight.setG_score(current.getG_score()+1);
                neighbors.add(nodemoveRight);
            }
            vneig=true;
            Puzzle nodemoveDown=Puzzle.moveBlankDown(current);
            for (int i = 0; i < puzzleListClosed.size(); i++)
                if (nodemoveDown.getStates().equals(current.getStates())) {
                    vneig = false;
                    break;
                }

            if (vneig){
                nodemoveDown.setParent(current);
                nodemoveDown.setG_score(current.getG_score()+1);
                neighbors.add(nodemoveDown);
            }
            vneig=true;
            Puzzle nodemoveUp=Puzzle.moveBlankUp(current);
            for (int i = 0; i < puzzleListClosed.size(); i++)
                if (nodemoveUp.getStates().equals(current.getStates())) {
                    vneig = false;
                    break;
                }

            if (vneig){
                nodemoveUp.setParent(current);
                nodemoveUp.setG_score(current.getG_score()+1);
                neighbors.add(nodemoveUp);
            }

            for (int i = 0; i < neighbors.size(); i++) {

                Puzzle ineig=neighbors.get(i);
                boolean inOp=false;
                for (Puzzle jneig:puzzleListOpen) {
                    if (ineig.getStates().equals(jneig.getStates()))
                    inOp=true;
                }
                if (!inOp){
                    Puzzle neigbor=neighbors.get(i);
                    neighbors.get(i).setF_score(neigbor.getG_score()+ManhattanDistanceH(neigbor.getStates()));
                    puzzleListOpen.add(neighbors.get(i));
                }
            }
        }
    }

    private int ManhattanDistanceH(List<Integer> states) {
        int [] xidata={1,2,3,1,2,3,1,2,3};
        int [] yidata={1,1,1,2,2,2,3,3,3};

        int distance=0;
        for (int i = 0; i<9; i++) {
            int x,y,xi,yi;
            xi =xidata[i];
            yi =yidata[i];
            x=xidata[states.get(i)-1];
            y=yidata[states.get(i)-1];
            distance=distance+(Math.abs(xi-x)+Math.abs(yi-y));
        }
        return distance;
    }


}
