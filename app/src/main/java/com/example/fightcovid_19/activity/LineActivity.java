package com.example.fightcovid_19.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.example.fightcovid_19.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

/**
 * 折线图
 */
public class LineActivity extends AppCompatActivity {
    public LineChart lineChart;
    public ArrayList<String> x = new ArrayList<String>();
    public ArrayList<Entry> y = new ArrayList<Entry>();
    public ArrayList<String> x1 = new ArrayList<String>();
    public ArrayList<Entry> y1 = new ArrayList<Entry>();
    public ArrayList<String> x2 = new ArrayList<String>();
    public ArrayList<Entry> y2 = new ArrayList<Entry>();
    public ArrayList<LineDataSet> lineDataSets = new ArrayList<LineDataSet>();
    public ArrayList<LineDataSet> lineDataSets1 = new ArrayList<LineDataSet>();
    public ArrayList<LineDataSet> lineDataSets2 = new ArrayList<LineDataSet>();
    public LineData lineData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line);
        lineChart = (LineChart) findViewById(R.id.spread_line_chart);
        getLineData(16, 10);
        getLineData1(16, 10);
        getLineData2(16, 10);
        showChart();
        showChart1();
        showChart2();
    }

    /**
     * 初始化数据
     * count 表示坐标点个数，range表示等下y值生成的范围
     */
    public LineData getLineData(int count, float range) {
        for (int i = 1; i < count; i++) {  //X轴显示的数据
            x.add("4月"+i + "日");
        }
        for (int i = 1; i < count; i++) {//y轴的数据
            float result = (float) (Math.random() * range) + 3;
            y.add(new Entry(result, i));
        }
        LineDataSet lineDataSet = new LineDataSet(y, "健康");//y轴数据集合
        lineDataSet.setLineWidth(2f);//线宽
        lineDataSet.setCircleSize(Color.RED);//圆形颜色
        lineDataSet.setCircleSize(3f);//现实圆形大小
        lineDataSet.setColor(R.color.black_bar);//现实颜色
        lineDataSet.setHighLightColor(Color.BLACK);//高度线的颜色
        lineDataSets.add(lineDataSet);
        lineData = new LineData(x, lineDataSet);
        return lineData;
    }

    /**
     * 设置样式
     */
    public void showChart() {
        lineChart.setDrawBorders(false);//是否添加边框
        lineChart.setDescription("");//数据描述
        lineChart.setNoDataTextDescription("");//没数据显示
        lineChart.setDrawGridBackground(false);//是否显示表格颜色
        lineChart.setBackgroundColor(Color.WHITE);//背景颜色
//        lineChart.setData(lineData);//设置数据

        Legend legend = lineChart.getLegend();//设置比例图片标示，就是那一组Y的value
        legend.setForm(Legend.LegendForm.SQUARE);//样式
        legend.setFormSize(12f);//字体
        legend.setTextColor(Color.BLACK);//设置颜色
        lineChart.animateX(2000);//X轴的动画
    }


    /**
     * 初始化数据
     * count 表示坐标点个数，range表示等下y值生成的范围
     */
    public LineData getLineData1(int count, float range) {
        for (int i = 1; i < count; i++) {  //X轴显示的数据
            x1.add(i + "");
        }
        for (int i = 1; i < count; i++) {//y轴的数据
            float result = (float) (Math.random() * range) + 3;
            y1.add(new Entry(result, i));
        }
        LineDataSet lineDataSet = new LineDataSet(y1, "医学观察");//y轴数据集合
        lineDataSet.setLineWidth(2f);//线宽
        lineDataSet.setCircleSize(Color.RED);//圆形颜色
        lineDataSet.setCircleSize(3f);//现实圆形大小
        lineDataSet.setColor(R.color.yellow_bar);//现实颜色
        lineDataSet.setHighLightColor(Color.BLACK);//高度线的颜色
        lineDataSets1.add(lineDataSet);
        lineData.addDataSet(lineDataSet);
        return lineData;
    }

    /**
     * 设置样式
     */
    public void showChart1() {
        lineChart.setDrawBorders(false);//是否添加边框
        lineChart.setDescription("");//数据描述
        lineChart.setNoDataTextDescription("");//没数据显示
        lineChart.setDrawGridBackground(false);//是否显示表格颜色
        lineChart.setBackgroundColor(Color.WHITE);//背景颜色
//        lineChart.set(lineData1);//设置数据

        Legend legend = lineChart.getLegend();//设置比例图片标示，就是那一组Y的value
        legend.setForm(Legend.LegendForm.SQUARE);//样式
        legend.setFormSize(12f);//字体
        legend.setTextColor(Color.BLACK);//设置颜色
        lineChart.animateX(2000);//X轴的动画
    }

    /**
     * 初始化数据
     * count 表示坐标点个数，range表示等下y值生成的范围
     */
    public LineData getLineData2(int count, float range) {
        for (int i = 1; i < count; i++) {  //X轴显示的数据
            x2.add(i + "");
        }
        for (int i = 1; i < count; i++) {//y轴的数据
            float result = (float) (Math.random() * range) + 3;
            y2.add(new Entry(result, i));
        }
        LineDataSet lineDataSet = new LineDataSet(y2, "患病");//y轴数据集合
        lineDataSet.setLineWidth(2f);//线宽
        lineDataSet.setCircleSize(Color.RED);//圆形颜色
        lineDataSet.setCircleSize(3f);//现实圆形大小
        lineDataSet.setColor(R.color.gray_bar);//现实颜色
        lineDataSet.setHighLightColor(Color.BLACK);//高度线的颜色
        lineDataSets2.add(lineDataSet);
        lineData.addDataSet(lineDataSet);
        return lineData;
    }

    /**
     * 设置样式
     */
    public void showChart2() {
        lineChart.setDrawBorders(false);//是否添加边框
        lineChart.setDescription("");//数据描述
        lineChart.setNoDataTextDescription("");//没数据显示
        lineChart.setDrawGridBackground(false);//是否显示表格颜色
        lineChart.setBackgroundColor(Color.WHITE);//背景颜色

        lineChart.setData(lineData);//设置数据

        Legend legend = lineChart.getLegend();//设置比例图片标示，就是那一组Y的value
        legend.setForm(Legend.LegendForm.SQUARE);//样式
        legend.setFormSize(12f);//字体
        legend.setTextColor(Color.BLACK);//设置颜色
        lineChart.animateX(2000);//X轴的动画
    }


}
