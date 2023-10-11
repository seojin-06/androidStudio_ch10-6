package com.cookandroid.project10_6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표 결과");

        ViewFlipper resultView = (ViewFlipper) findViewById(R.id.resultView);
        resultView.setFlipInterval(1000);
        Button btnStart = (Button) findViewById(R.id.btnStart);
        Button btnStop = (Button) findViewById(R.id.btnStop);

        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");


        Integer imageFileId[] = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
                R.drawable.pic4, R.drawable.pic5, R.drawable.pic6,
                R.drawable.pic7, R.drawable.pic8, R.drawable.pic9};
        Integer tvId[] = {R.id.imgView1, R.id.imgView2, R.id.imgView3,
                R.id.imgView4, R.id.imgView5, R.id.imgView6,
                R.id.imgView7, R.id.imgView8, R.id.imgView9};
        Integer imageResult[] = new Integer[9];

        for (int i = 0; i < 9; i++) {
            int max = 0;
            int maxIndex = 0;
            for (int j = 0; j < 9; j++) {
                if (max < voteResult[j]) {
                    max = voteResult[j];
                    maxIndex = j;
                }
            }
            imageResult[i] = imageFileId[maxIndex];
            voteResult[maxIndex] = 0;
        }

        for (int i = 0; i < tvId.length; i++) {
            ImageView imgView = (ImageView) findViewById(tvId[i]);
            imgView.setImageResource(imageResult[i]);
        }

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultView.startFlipping();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultView.stopFlipping();
            }
        });

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
