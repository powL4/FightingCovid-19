package com.example.fightcovid_19.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.fightcovid_19.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * 条形图
 */
public class BarActivity extends AppCompatActivity {

    //显示的图表
    public BarChart barChart;
    //保存数据的实体（下面定义了两组数据集合）
    public ArrayList<BarEntry> entries = new ArrayList<BarEntry>();
    public ArrayList<BarEntry> entries1 = new ArrayList<>();
    public ArrayList<BarEntry> entries2 = new ArrayList<>();
    //数据的集合（每组数据都需要一个数据集合存放数据实体和该组的样式）
    public BarDataSet dataset;
    public BarDataSet dataSet1;
    public BarDataSet dataSet2;
    //表格下方的文字
    public ArrayList<String> labels = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);
        barChart = (BarChart) findViewById(R.id.bar_chart);
        myData();
        myInit();
    }

    /**
     * 初始化
     */
    private void myInit() {
        //设置单个点击事件
        barChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry entry, int i, Highlight highlight) {
                Toast.makeText(getApplicationContext(), entry.getVal() + "", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });
        //设置显示动画效果
        barChart.animateY(2000);
        barChart.setDescription("");
    }

    /**
     * 初始数据
     */
    private void myData() {
        entries.add(new BarEntry(4f, 0));
        entries.add(new BarEntry(8f, 1));
        entries.add(new BarEntry(6f, 2));

        entries1.add(new BarEntry(7f, 0));
        entries1.add(new BarEntry(3f, 1));
        entries1.add(new BarEntry(15f, 2));

        entries2.add(new BarEntry(12f, 0));
        entries2.add(new BarEntry(18f, 1));
        entries2.add(new BarEntry(9f, 2));

        labels.add("健康");
        labels.add("医学观察");
        labels.add("患病");

        //设置数据组的数据
        dataset = new BarDataSet(entries, "本科生");
        //设置数据组的样式（参数是显示颜色的数组）
        dataset.setColors(new int[]{getResources().getColor(R.color.black_bar)});

        dataSet1 = new BarDataSet(entries1, "研究生");
        dataSet1.setColors(new int[]{getResources().getColor(R.color.yellow_bar)});

        dataSet2 = new BarDataSet(entries2, "博士生及以上");
        dataSet2.setColors(new int[]{getResources().getColor(R.color.gray_bar)});

        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataset);
        dataSets.add(dataSet1);
        dataSets.add(dataSet2);
        BarData data = new BarData(labels, dataSets);
        barChart.setData(data);
    }

}
