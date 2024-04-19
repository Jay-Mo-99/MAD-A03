package com.example.a01_travel;

import android.appwidget.AppWidgetProvider;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.widget.RemoteViews;

public class MyAppWidgetProvider extends AppWidgetProvider {

    // 위젯 업데이트 시 호출되는 메서드
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // 모든 위젯 인스턴스에 대해 반복
        final int N = appWidgetIds.length;
        for (int i = 0; i < N; i++) {
            int appWidgetId = appWidgetIds[i];
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    // 위젯을 업데이트하는 도우미 메서드
    void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
        // 위젯의 레이아웃을 정의하는 RemoteViews 객체 생성
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.activity_widget_layout);

        // 여기에 위젯의 뷰를 업데이트하는 코드 추가 (예: 텍스트 뷰 설정)
        views.setTextViewText(R.id.widget_text_view, "I am Widget");

        // 위젯 매니저를 통해 위젯 업데이트
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }
}