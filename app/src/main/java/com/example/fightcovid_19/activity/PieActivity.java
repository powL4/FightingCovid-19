package com.example.fightcovid_19.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.example.fightcovid_19.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

import java.util.ArrayList;

/**
 * 饼状图
 */
public class PieActivity extends AppCompatActivity {
    public PieChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie);
        myInit();
    }

    //初始化
    private void myInit() {
        mChart = (PieChart) findViewById(R.id.pie_chart);

        PieData mPieData = getPieData();
        showChart(mChart, mPieData);
    }

    private void showChart(PieChart pieChart, PieData pieData) {
        pieChart.setHoleColor(Color.TRANSPARENT);
        pieChart.setHoleRadius(60f);  //半径
        pieChart.setTransparentCircleRadius(64f); // 半透明圈
        pieChart.setDrawCenterText(false);  //饼状图中间可以添加文字
        pieChart.setDrawHoleEnabled(true);
        pieChart.setRotationAngle(90); // 初始旋转角度
        pieChart.setCenterTextSize(20);
        pieChart.setDescriptionTextSize(20);
        pieChart.setRotationEnabled(true); // 可以手动旋转
        pieChart.setUsePercentValues(true);  //显示成百分比
//        pieChart.setCenterText("Quarterly Revenue");  //饼状图中间的文字
        //pieChart.setHoleRadius(0)  //实心圆
        pieChart.setDescription("");

        //设置数据
        pieChart.setData(pieData);
        Legend mLegend = pieChart.getLegend();  //设置比例图

        mLegend.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);  //最右边显示
//      mLegend.setForm(LegendForm.LINE);  //设置比例图的形状，默认是方形
        mLegend.setXEntrySpace(5f);//设置距离饼图的距离，防止与饼图重合
        mLegend.setYEntrySpace(5f);


        pieChart.animateXY(1000, 1000);  //设置动画
        // mChart.spin(2000, 0, 360);
    }

    private PieData getPieData() {
        ArrayList<String> xValues = new ArrayList<String>();  //xVals用来表示每个饼块上的内容
        xValues.add("健康" );
        xValues.add("医学观察" );
        xValues.add("患病" );

        ArrayList<Entry> yValues = new ArrayList<Entry>();  //yVals用来表示封装每个饼块的实际数据
        // 饼图数据
        float quarterly1 = 14;
        float quarterly2 = 26;
        float quarterly3 = 60;

        yValues.add(new Entry(quarterly1, 0));
        yValues.add(new Entry(quarterly2, 1));
        yValues.add(new Entry(quarterly3, 2));

        //y轴的集合
        PieDataSet pieDataSet = new PieDataSet(yValues, ""/*显示在比例图上*/);
        pieDataSet.setSliceSpace(10f); //设置个饼状图之间的距离
        ArrayList<Integer> colors = new ArrayList<Integer>();
        // 饼图颜色
        colors.add(getResources().getColor(R.color.black_bar));
        colors.add(getResources().getColor(R.color.yellow_bar));
        colors.add(getResources().getColor(R.color.gray_bar));
        pieDataSet.setColors(colors);

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float px = 5 * (metrics.densityDpi / 160f);
        pieDataSet.setSelectionShift(px); // 选中态多出的长度
        PieData pieData = new PieData(xValues, pieDataSet);
        return pieData;
    }
}
