package com.example.a01_travel;

import androidx.appcompat.app.AppCompatActivity;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private Button btn_where;
    private EditText et_where;
    private TextView tv_warning, tv_hyperLink;


    //Function about Application widget
    private void updateWidgets() {
        AppWidgetManager appWidgetManager;
        appWidgetManager = AppWidgetManager.getInstance(this);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(this, MyAppWidgetProvider.class));
        if (appWidgetIds.length > 0) {
            new MyAppWidgetProvider().onUpdate(this, appWidgetManager, appWidgetIds);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_where = findViewById(R.id.btn_where);
        et_where = findViewById(R.id.et_where);
        tv_warning = findViewById(R.id.tv_warning);
        tv_hyperLink = findViewById(R.id.tv_hyperlink);

        //Add the application widget
        updateWidgets();

        // Set the link text
        final String linkText = "The best places to travel in 2024";
        final String linkUrl = "https://www.cnn.com/travel/best-destinations-to-visit-2024/index.html";

        // Create a SpannableString with the link text
        SpannableString spannableString = new SpannableString(linkText);
        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                // Intent to open the link
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkUrl));
                startActivity(browserIntent);
            }
        }, 0, linkText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Set the SpannableString to the TextView and enable link movement method
        tv_hyperLink.setText(spannableString);
        tv_hyperLink.setMovementMethod(LinkMovementMethod.getInstance());

        btn_where.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String destination = et_where.getText().toString();
                if(destination.isEmpty()) {
                    tv_warning.setText("Please Enter your destination");
                } else {
                    Intent intent = new Intent(MainActivity.this, enterGroupMember2.class);
                    intent.putExtra("destination",destination);
                    startActivity(intent);
                }

            }
        });

    }
}