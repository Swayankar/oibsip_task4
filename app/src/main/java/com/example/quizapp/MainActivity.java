package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList <Modelclass> listOfQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listOfQ = new ArrayList<>();

        listOfQ.add(new Modelclass("Under which of the following Android is licensed?", "OSS", "Sourceforge", "Apache/MIT", "None of the above", "Apache/MIT"));
        listOfQ.add(new Modelclass("For which of the following Android is mainly developed?", "Servers", "Desktops", "Laptops", "Mobile devices", "Mobile devices"));
        listOfQ.add(new Modelclass("Which of the following is the first mobile phone released that ran the Android OS?", "HTC Hero", "Google gPhone", "T - Mobile G1", "None of the above", "T - Mobile G1"));
        listOfQ.add(new Modelclass("Which of the following virtual machine is used by the Android operating system?", "JVM", "Dalvik virtual machine", "Simple virtual machine", "None of the above", "Dalvik virtual machine"));
        listOfQ.add(new Modelclass("Android is based on which of the following language?", "Java", "C++", "C", "None of the above", "Java"));
        listOfQ.add(new Modelclass("APK stands for -", "Android Phone Kit", "Android Page Kit", "Android Package Kit", "None of the above", "Android Package Kit"));
        listOfQ.add(new Modelclass("What does API stand for?", "Application Programming Interface", "Android Programming Interface", "Android Page Interface", "Application Page Interface", "Application Programming Interface"));
        listOfQ.add(new Modelclass("Which of the following converts Java byte code into Dalvik byte code?", "Dalvik converter", "Dex compiler", "Mobile interpretive compiler (MIC)", "None of the above", "Dex compiler"));
        listOfQ.add(new Modelclass("How can we stop the services in android?", "By using the stopSelf() and stopService() method", "By using the finish() method", "By using system.exit() method", "None of the above", "By using the stopSelf() and stopService() method"));
        listOfQ.add(new Modelclass("What is an activity in android?", "android class", "android package", "A single screen in an application with supporting java code", "None of the above", "A single screen in an application with supporting java code"));
        listOfQ.add(new Modelclass("Which of the following kernel is used in Android?", "MAC", "Windows", "Linux", "Redhat", "Linux"));
        listOfQ.add(new Modelclass("Which of the following is the first callback method that is invoked by the system during an activity life-cycle?", "onClick() method", "onCreate() method", "onStart() method", "onRestart() method", "onCreate() method"));
        listOfQ.add(new Modelclass("Which of the following is not an activity lifecycle callback method?", "onClick() method", "onCreate() method", "onStart() method", "onBackPressed() method", "onBackPressed() method"));
        listOfQ.add(new Modelclass("AAPT stands for -", "Android Activity Packaging Tool", "Android Asset Packaging Tool", "Android Action Packaging Tool", "None of the above", "Android Asset Packaging Tool"));
        listOfQ.add(new Modelclass("What is the use of content provider in Android?", "For storing the data in the database", "For sharing the data between applications", "For sending the data from an application to another application", "None of the above", "For sending the data from an application to another application"));
        listOfQ.add(new Modelclass("NDK stands for ", "Native Development Kit", "New Development kit", "Native Design Kit", "None of the above", "Native Development Kit"));
        listOfQ.add(new Modelclass("Which of the following android component displays the part of an activity on screen?", "View", "Manifest", "Intent", "Fragment", "Fragment"));
        listOfQ.add(new Modelclass("Which of the following is the parent class of Activity?", "Context", "Object", "contextThemeWrapper", "None of the above", "contextThemeWrapper"));
        listOfQ.add(new Modelclass("In which of the following tab an error is shown?", "CPU", "Memory", "ADB Logs", "Logcat", "Logcat"));
        listOfQ.add(new Modelclass("In which year OHA (Open Handset Alliance) is announced?", "2005", "2007", "2006", "d", "None of the above"));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                startActivity(intent);
            }
        }, 1500);

    }
}