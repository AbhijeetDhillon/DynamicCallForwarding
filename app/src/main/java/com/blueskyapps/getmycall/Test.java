package com.blueskyapps.getmycall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

public class Test extends AppCompatActivity {

    LinearLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
    }
//        mainGrid = (GridLayout) findViewById(R.id.mainGrid);
//
//        //Set Event
//        setSingleEvent(mainGrid);
//        //setToggleEvent(mainGrid);
//    }
//
//    private void setToggleEvent(GridLayout mainGrid) {
//        //Loop all child item of Main Grid
//        for (int i = 0; i < mainGrid.getChildCount(); i++) {
//            //You can see , all child item is CardView , so we just cast object to CardView
//            final CardView cardView = (CardView) mainGrid.getChildAt(i);
//            cardView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
//                        //Change background color
//                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
//                        Toast.makeText(Test.this, "State : True", Toast.LENGTH_SHORT).show();
//
//                    } else {
//                        //Change background color
//                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
//                        Toast.makeText(Test.this, "State : False", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
//        }
//    }
//
//    private void setSingleEvent(GridLayout mainGrid) {
//        //Loop all child item of Main Grid
//        for (int i = 0; i < mainGrid.getChildCount(); i++) {
//            //You can see , all child item is CardView , so we just cast object to CardView
//            CardView cardView = (CardView) mainGrid.getChildAt(i);
//            final int finalI = i;
//            cardView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    Intent intent = new Intent(Test.this,activity_one.class);
//                    intent.putExtra("info","This is activity from card item index  "+finalI);
//                    startActivity(intent);
//
//                }
//            });
//        }
//    }
}