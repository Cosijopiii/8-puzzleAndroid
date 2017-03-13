package com.unistmo.edu.a8_puzzle;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by cosijopii on 12/03/17.
 */

public class Controller {

    MainActivity mainActivity;
    public Controller(MainActivity mainActivity){

        this.mainActivity=mainActivity;

    }

//    public void move(){
//
//        mainActivity.b1.setOnTouchListener(new OnSwipeTouchListener(mainActivity.getBaseContext()){
//            @Override
//            public void onSwipeRight() {
//                Toast.makeText(mainActivity, "right", Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onSwipeLeft() {
//                Toast.makeText(mainActivity, "left", Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onSwipeTop() {
//                Toast.makeText(mainActivity, "top", Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onSwipeBottom() {
//
//                Toast.makeText(mainActivity, "bottom", Toast.LENGTH_SHORT).show();
//            }
//        });
//        mainActivity.b2.setOnTouchListener(new OnSwipeTouchListener(mainActivity.getBaseContext()){
//            @Override
//            public void onSwipeRight() {
//                Toast.makeText(mainActivity, "right", Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onSwipeLeft() {
//                Toast.makeText(mainActivity, "left", Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onSwipeTop() {
//                Toast.makeText(mainActivity, "top", Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onSwipeBottom() {
//
//                Toast.makeText(mainActivity, "bottom", Toast.LENGTH_SHORT).show();
//            }
//        });
//        mainActivity.b3.setOnTouchListener(new OnSwipeTouchListener(mainActivity.getBaseContext()){
//            @Override
//            public void onSwipeRight() {
//                Toast.makeText(mainActivity, "right", Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onSwipeLeft() {
//                Toast.makeText(mainActivity, "left", Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onSwipeTop() {
//                Toast.makeText(mainActivity, "top", Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onSwipeBottom() {
//
//                Toast.makeText(mainActivity, "bottom", Toast.LENGTH_SHORT).show();
//            }
//        });
//        mainActivity.b4.setOnTouchListener(new OnSwipeTouchListener(mainActivity.getBaseContext()){
//            @Override
//            public void onSwipeRight() {
//                Toast.makeText(mainActivity, "right", Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onSwipeLeft() {
//                Toast.makeText(mainActivity, "left", Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onSwipeTop() {
//                Toast.makeText(mainActivity, "top", Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onSwipeBottom() {
//
//                Toast.makeText(mainActivity, "bottom", Toast.LENGTH_SHORT).show();
//            }
//        });
//        mainActivity.b5.setOnTouchListener(new OnSwipeTouchListener(mainActivity.getBaseContext()){
//            @Override
//            public void onSwipeRight() {
//                Toast.makeText(mainActivity, "right", Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onSwipeLeft() {
//                Toast.makeText(mainActivity, "left", Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onSwipeTop() {
//                Toast.makeText(mainActivity, "top", Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onSwipeBottom() {
//
//                Toast.makeText(mainActivity, "bottom", Toast.LENGTH_SHORT).show();
//            }
//        });
//        mainActivity.b6.setOnTouchListener(new OnSwipeTouchListener(mainActivity.getBaseContext()){
//            @Override
//            public void onSwipeRight() {
//                Toast.makeText(mainActivity, "right", Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onSwipeLeft() {
//                Toast.makeText(mainActivity, "left", Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onSwipeTop() {
//                Toast.makeText(mainActivity, "top", Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onSwipeBottom() {
//            }
//        });
//        mainActivity.b7.setOnTouchListener(new OnSwipeTouchListener(mainActivity.getBaseContext()){
//            @Override
//            public void onSwipeRight() {
//                Toast.makeText(mainActivity, "right", Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onSwipeLeft() {
//                Toast.makeText(mainActivity, "left", Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onSwipeTop() {
//                Toast.makeText(mainActivity, "top", Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onSwipeBottom() {
//
//                Toast.makeText(mainActivity, "bottom", Toast.LENGTH_SHORT).show();
//            }
//        });
//        mainActivity.b8.setOnTouchListener(new OnSwipeTouchListener(mainActivity.getBaseContext()){
//            @Override
//            public void onSwipeRight() {
//                Toast.makeText(mainActivity, "right", Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onSwipeLeft() {
//                Toast.makeText(mainActivity, "left", Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onSwipeTop() {
//                Toast.makeText(mainActivity, "top", Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onSwipeBottom() {
//
//                Toast.makeText(mainActivity, "bottom", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//    }
/*
    @Override
    public void onSwipeRight() {
        Toast.makeText(mainActivity, "right", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSwipeLeft() {
        Toast.makeText(mainActivity, "left", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onSwipeTop() {
        Toast.makeText(mainActivity, "top", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onSwipeBottom() {
        Toast.makeText(mainActivity, "bottom", Toast.LENGTH_SHORT).show();

    }*/
}
