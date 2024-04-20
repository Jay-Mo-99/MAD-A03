package com.example.a01_travel;

import android.appwidget.AppWidgetProvider;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.widget.RemoteViews;

public class MyAppWidgetProvider extends AppWidgetProvider {

    //Widget update method
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        //Loop for widget
        final int N = appWidgetIds.length;
        for (int i = 0; i < N; i++) {
            int appWidgetId = appWidgetIds[i];
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    // Update Widget method
    void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.activity_widget_layout);
        //update Widget
        views.setTextViewText(R.id.widget_text_view, "Travel Tip: Always Keep your Passport!");
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }
}