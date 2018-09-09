package com.londonappbrewery.destini;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView currText;
    private Button topBtn;
    private Button btmBtn;
    private Page[] pageList = {
            new Page(R.string.T1_Story, R.string.T1_Ans1,
                    2, R.string.T1_Ans2, 1),
            new Page(R.string.T2_Story, R.string.T2_Ans1,
                    2, R.string.T2_Ans2, 3),
            new Page(R.string.T3_Story, R.string.T3_Ans1,
                    5, R.string.T3_Ans2, 4),
            new Page(R.string.T4_End),
            new Page(R.string.T5_End),
            new Page(R.string.T6_End)
    };
    private int pageNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            pageNum = savedInstanceState.getInt("currPage");
        } else {
            pageNum = 0;
        }

        currText = findViewById(R.id.storyTextView);
        topBtn = findViewById(R.id.buttonTop);
        btmBtn = findViewById(R.id.buttonBottom);
        renderPage();

        topBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pageList[pageNum].getTopBtnId() == -1) {
                    pageNum = 0;
                } else {
                    pageNum = pageList[pageNum].getTopLink();
                }
                renderPage();
            }
        });
        btmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pageList[pageNum].getTopBtnId() == -1) {
                    buildAlert();
                } else {
                    pageNum = pageList[pageNum].getBtmLink();
                }
                renderPage();
            }
        });
    }

    public void renderPage() {
        currText.setText(pageList[pageNum].getTextId());
        if (pageList[pageNum].getTopBtnId() == -1) {
            topBtn.setText(R.string.restart);
            btmBtn.setText(R.string.exit);
        } else {
            topBtn.setText(pageList[pageNum].getTopBtnId());
            btmBtn.setText(pageList[pageNum].getBtmBtnId());
        }
    }

    public void buildAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.exitTitle)
                .setMessage(R.string.exitText)
                .setPositiveButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // User Cancels
                    }
                })
                .setNegativeButton(R.string.exit, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // User exits Application
                        finish();
                    }
                });
        builder.show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("currPage", pageNum);
    }
}
