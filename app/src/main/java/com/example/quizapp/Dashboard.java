package com.example.quizapp;

import static com.example.quizapp.MainActivity.listOfQ;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.progressindicator.LinearProgressIndicator;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Dashboard extends AppCompatActivity {

    CountDownTimer countDownTimer;
    int timerValue = 20;
    LinearProgressIndicator progressBar;
    List <Modelclass> allQuestionsList;
    Modelclass modelclass;
    int index = 0;
    TextView card_question, optiona, optionb, optionc, optiond;
    CardView cardOA, cardOB, cardOC, cardOD;
    int correctCount = 0;
    int wrongCount = 0;
    LinearLayout nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

//        progressBar = findViewById(R.id.quiz_timer);

        Hooks();

        allQuestionsList = listOfQ;
        Collections.shuffle(allQuestionsList);
        modelclass = listOfQ.get(index);

        cardOA.setBackgroundColor(getResources().getColor(R.color.white));
        cardOB.setBackgroundColor(getResources().getColor(R.color.white));
        cardOC.setBackgroundColor(getResources().getColor(R.color.white));
        cardOD.setBackgroundColor(getResources().getColor(R.color.white));

        nextBtn.setClickable(false);

        setAllData();

        countDownTimer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long l) {
                timerValue = timerValue - 1;
                progressBar.setProgress(timerValue);
            }

            @Override
            public void onFinish() {
                Dialog dialog = new Dialog(Dashboard.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.time_out_dialog);

                dialog.findViewById(R.id.btn_tryAgain).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Dashboard.this, MainActivity.class);
                        startActivity(intent);
                    }
                });

                dialog.show();
            }
        }.start();
    }

    private void setAllData() {

        card_question.setText(modelclass.getQuestion());
        optiona.setText(modelclass.getoA());
        optionb.setText(modelclass.getoB());
        optionc.setText(modelclass.getoC());
        optiond.setText(modelclass.getoD());

    }

    private void Hooks() {
        progressBar = findViewById(R.id.quiz_timer);
        card_question = findViewById(R.id.card_question);
        optiona = findViewById(R.id.card_optiona);
        optionb = findViewById(R.id.card_optionb);
        optionc = findViewById(R.id.card_optionc);
        optiond = findViewById(R.id.card_optiond);

        cardOA = findViewById(R.id.cardA);
        cardOB = findViewById(R.id.cardB);
        cardOC = findViewById(R.id.cardC);
        cardOD = findViewById(R.id.cardD);

        nextBtn = findViewById(R.id.next_btn);
    }

    public void Correct(CardView cardView) {
        cardView.setBackgroundColor(getResources().getColor(R.color.green));

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correctCount++;
                index++;
                modelclass = listOfQ.get(index);
                setAllData();
            }
        });

    }

    public void Wrong(CardView cardView) {

        cardView.setBackgroundColor(getResources().getColor(R.color.red));

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wrongCount++;
                if (index < listOfQ.size()-1){
                    index++;
                    modelclass = listOfQ.get(index);
                    setAllData();
                    resetColor();
                } else {
                    GameWon();
                }
            }
        });

    }

    private void GameWon() {
        Intent intent = new Intent(Dashboard.this, WonActivity.class);
        startActivity(intent);
    }

    public void enableButton(){
        cardOA.setClickable(true);
        cardOB.setClickable(true);
        cardOC.setClickable(true);
        cardOD.setClickable(true);
    }

    public void disableButton(){
        cardOA.setClickable(false);
        cardOB.setClickable(false);
        cardOC.setClickable(false);
        cardOD.setClickable(false);
    }

    public void resetColor() {
        cardOA.setBackgroundColor(getResources().getColor(R.color.white));
        cardOB.setBackgroundColor(getResources().getColor(R.color.white));
        cardOC.setBackgroundColor(getResources().getColor(R.color.white));
        cardOD.setBackgroundColor(getResources().getColor(R.color.white));
    }


    public void OptionAClick(View view) {
        disableButton();
        nextBtn.setClickable(true);
        if (modelclass.getoA().equals(modelclass.getAns())){
            cardOA.setBackgroundColor(getResources().getColor(R.color.green));

            if (index < listOfQ.size()-1){
                Correct(cardOA);
            } else {
                GameWon();
            }

        }
        else {
            Wrong(cardOA);
        }
    }


    public void OptionBClick(View view) {
        disableButton();
        nextBtn.setClickable(true);
        if (modelclass.getoB().equals(modelclass.getAns())){
            cardOB.setBackgroundColor(getResources().getColor(R.color.green));

            if (index < listOfQ.size()-1){
                Correct(cardOB);
            } else {
                GameWon();
            }

        }
        else {
            Wrong(cardOB);
        }
    }

    public void OptionCClick(View view) {
        disableButton();
        nextBtn.setClickable(true);
        if (modelclass.getoC().equals(modelclass.getAns())){
            cardOC.setBackgroundColor(getResources().getColor(R.color.green));

            if (index < listOfQ.size()-1){
                Correct(cardOC);
            } else {
                GameWon();
            }

        }
        else {
            Wrong(cardOC);
        }
    }

    public void OptionDClick(View view) {
        disableButton();
        nextBtn.setClickable(true);
        if (modelclass.getoD().equals(modelclass.getAns())){
            cardOD.setBackgroundColor(getResources().getColor(R.color.green));

            if (index < listOfQ.size()-1){
                Correct(cardOD);
            } else {
                GameWon();
            }

        }
        else {
            Wrong(cardOD);
        }
    }
}