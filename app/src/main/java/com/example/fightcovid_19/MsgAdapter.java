package com.example.fightcovid_19;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/*
 *RecyclerView的适配类
 */
public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {
    private List<Msg> mMsgList;

    static class ViewHolder extends RecyclerView.ViewHolder{


        LinearLayout leftLayout;
        TextView leftMsg;

        public ViewHolder(View view){
            super(view);
            leftLayout = (LinearLayout) view.findViewById(R.id.left_layout);
            leftMsg = (TextView) view.findViewById(R.id.msg);
        }
    }

    public MsgAdapter(List<Msg> msgList){
        mMsgList = msgList;
    }

    public void onBindViewHolder(ViewHolder holder,int position){
        Msg msg = mMsgList.get(position);
        holder.leftLayout.setVisibility(View.VISIBLE);
        holder.leftMsg.setText(msg.getContent());
    }


    public ViewHolder onCreateViewHolder(ViewGroup parent, int ViewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item,parent,false);
        return new ViewHolder(view);
    }

    public int getItemCount() {
        return mMsgList.size();
    }

}

