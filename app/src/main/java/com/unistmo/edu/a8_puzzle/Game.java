package com.unistmo.edu.a8_puzzle;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Random;
import java.util.zip.Inflater;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Build;
import android.os.Bundle;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import android.widget.Toast;


public class Game extends Activity {
   
	//private TextView moveCounter;
 	//private TextView feedbackText;
    private Button btnRevolver,btnResolver;
 	private Button[] buttons;
    private Boolean bad_move=false;
    private Astart star;
   	private static final Integer[] goal = new Integer[] {1,2,3,4,5,6,7,8,0};
   	private  ArrayList<Puzzle> path;
	private ArrayList<Integer> cells = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        buttons=findButtons();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setNavigationBarColor(getColor(R.color.colorPrimary));
        }
        btnRevolver= (Button) findViewById(R.id.btnRevolver);
        btnRevolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cells=shuffle(cells);
                cells.set(cells.indexOf(9),0);
                fill_grid();
            }
        });
        btnResolver= (Button) findViewById(R.id.btnResolver);

        btnResolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            cells.set(cells.indexOf(0),9);
                Puzzle p=new Puzzle(cells);
                star=new Astart(p);
                path=star.Search();
                ArrayList<ArrayList<Integer>> temp=new ArrayList<ArrayList<Integer>>();
                for (Puzzle pz:path) {
                   temp.add(pz.getStates());
                }


                initPaht();

            }
        });
        
        

        for(int i=0;i<9;i++)
        {
            this.cells.add(i);
        }
       this.cells=shuffle(cells);
        cells.set(cells.indexOf(9),0);

        fill_grid();
       
        
      // moveCounter = (TextView) findViewById(R.id.MoveCounter);
	   //feedbackText = (TextView) findViewById(R.id.FeedbackText);
		
		for (int i = 1; i < 9; i++) {
			buttons[i].setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					makeMove((Button) v);
				}
			});
		}
		
		
		//moveCounter.setText("0");
		//feedbackText.setText(R.string.game_feedback_text);
    
}

    private void initPaht() {




  new Thread(new Runnable() {
            @Override
            public void run() {

                for (Puzzle pz:path) {
                    try {

                        ArrayList<Integer> temp=pz.getStates();
                        temp.set(temp.indexOf(9),0);
                        cells=temp;

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                fill_grid();
                            }
                        });

                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }


            }
        }).start();



    }

    public ArrayList<Integer> shuffle(ArrayList<Integer> state){

       int ix= state.indexOf(0);
        state.set(ix,9);
        Puzzle p=new Puzzle(state);
        Random r=new Random();
        for (int i = 0; i < 10; i++) {
           boolean b= r.nextBoolean();
            if (b){
                p= Puzzle.moveBlankDown(p);
                p =Puzzle.moveBlankLeft(p);
            }else{
                p= Puzzle.moveBlankUp(p);
                p =Puzzle.moveBlankRight(p);
            }

        }
        
     return  p.getStates();
        
    }


    public Button[] findButtons() {
		Button[] b = new Button[9];
		
		b[0] = (Button) findViewById(R.id.Button00);
		b[1] = (Button) findViewById(R.id.Button01);
		b[2] = (Button) findViewById(R.id.Button02);
		b[3] = (Button) findViewById(R.id.Button03);
		b[4] = (Button) findViewById(R.id.Button04);
		b[5] = (Button) findViewById(R.id.Button05);
		b[6] = (Button) findViewById(R.id.Button06);
		b[7] = (Button) findViewById(R.id.Button07);
		b[8] = (Button) findViewById(R.id.Button08);
		return b;
	}
   
	public void makeMove(final Button b) {
        bad_move=true;
		int b_text,b_pos,zuk_pos;
		b_text=Integer.parseInt((String) b.getText());
     	b_pos=find_pos(b_text);
   		zuk_pos=find_pos(0);
   		switch(zuk_pos)
   		{
   		case(0):
   			if(b_pos==1||b_pos==3)
   		    bad_move=false;
   		    break;
   		case(1):
   			if(b_pos==0||b_pos==2||b_pos==4)
   		    bad_move=false;
   		    break;
   		case(2):
   			if(b_pos==1||b_pos==5)
   		    bad_move=false;
   		    break;
   		case(3):
   			if(b_pos==0||b_pos==4||b_pos==6)
   		    bad_move=false;
   		    break;
   		case(4):
   			if(b_pos==1||b_pos==3||b_pos==5||b_pos==7)
   		    bad_move=false;
   		    break;
   		case(5):
   			if(b_pos==2||b_pos==4||b_pos==8)
   		    bad_move=false;
   		    break;
   		case(6):
   			if(b_pos==3||b_pos==7)
   		    bad_move=false;
   		    break;
   		case(7):
   			if(b_pos==4||b_pos==6||b_pos==8)
   		    bad_move=false;
   		    break;
   		case(8):
   			if(b_pos==5||b_pos==7)
   		    bad_move=false;
   		    break;
   		}
   		
   		if(bad_move==true)
   		{
   			//feedbackText.setText("Move Not Allowed");
   			return;
   		}
   		//feedbackText.setText("Move OK");
   		cells.remove(b_pos);
   		cells.add(b_pos, 0);
   		cells.remove(zuk_pos);
   		cells.add(zuk_pos,b_text);
   		
	
    	fill_grid();
		//moveCounter.setText(Integer.toString(Integer.parseInt((String) moveCounter.getText())+1));

		 for(int i=0;i<9;i++)
	        {
	           if(cells.get(i)!=goal[i])
	           {
	        	        	   return;
	           }
	        }
        Toast.makeText(this, "Ganaste", Toast.LENGTH_SHORT).show();
        //feedbackText.setText("we have a winner");
	}
	
	public void fill_grid()
    {
	 for(int i=0;i<9;i++)
	 {
		 int text=cells.get(i);
		 FrameLayout.LayoutParams absParams = (FrameLayout.LayoutParams)buttons[text].getLayoutParams();
		 switch(i) {

		 case(0):
			absParams.leftMargin = 5;
			absParams.topMargin = 5;
			buttons[text].setLayoutParams(absParams);
			break;
		 case(1):

				absParams.leftMargin = 110;
				absParams.topMargin = 5;
				buttons[text].setLayoutParams(absParams);
				break;
		 case(2):
			
				absParams.leftMargin = 215;
				absParams.topMargin = 5;
				buttons[text].setLayoutParams(absParams);
				break;
		 case(3):
			
				absParams.leftMargin = 5;
				absParams.topMargin = 110;
				buttons[text].setLayoutParams(absParams);
				break;
		 case(4):
			
				absParams.leftMargin =110;
				absParams.topMargin =110;
				buttons[text].setLayoutParams(absParams);
				break;
		 case(5):
			 
				absParams.leftMargin = 215;
				absParams.topMargin =110;
				buttons[text].setLayoutParams(absParams);
				break;
		 case(6):
			 
				absParams.leftMargin = 5;
				absParams.topMargin = 215;
				buttons[text].setLayoutParams(absParams);
				break;
		 case(7):
			 
				absParams.leftMargin = 110;
				absParams.topMargin = 215;
				buttons[text].setLayoutParams(absParams);
				break;
		 case(8):
			 
				absParams.leftMargin = 215;
				absParams.topMargin = 215;
				buttons[text].setLayoutParams(absParams);
				break;
		 
		 
		 }
		
		 
		}
		
	}
	
	public int find_pos(int element)
	{
		int i=0;
		 for(i=0;i<9;i++)
	        {
	           if(cells.get(i)==element)
	           {
	        	        	   break;
	           }
	        }
		 return i;
	}
	}

    