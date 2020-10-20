package com.sanketindia.customcalendar;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder> {
    Activity activity;
    ArrayList<ModelDay> data;
    CalenderDateSelectedListener calenderDateSelectedListener;
    public CalendarAdapter(Activity mainActivity, ArrayList<ModelDay> data, CalenderDateSelectedListener calenderDateSelectedListener) {
        this.activity = mainActivity;
        this.data = data;
        this.calenderDateSelectedListener = calenderDateSelectedListener;
    }

    @NonNull
    @Override
    public CalendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CalendarViewHolder(activity.getLayoutInflater().inflate(R.layout.row_day_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final CalendarViewHolder holder, int position) {


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectItem(holder.getAdapterPosition());
            }
        });
        holder.textView.setText(data.get(position).getDay());
        holder.textView.setTextColor(activity.getResources().getColor(data.get(position).getColor()));




    }

    public ArrayList<ModelDay> getData(){
        return this.data;
    }
    @Override
    public int getItemCount() {
        Log.d("VALUE", String.valueOf(data.size()));
        return data.size();
    }

    public void selectItem(int index){
        for(int i=0 ;i<data.size();i++){
            if(i==index){
                data.get(i).setSelected(true);
            }else{
                data.get(i).setSelected(false);
            }
        }

        calenderDateSelectedListener.OnDateSelected(data.get(index));
        notifyDataSetChanged();
    }

    public class CalendarViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView halfday,full_leave;
        public CalendarViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            halfday = itemView.findViewById(R.id.halfday);
            full_leave = itemView.findViewById(R.id.full_leave);
        }
    }
}
