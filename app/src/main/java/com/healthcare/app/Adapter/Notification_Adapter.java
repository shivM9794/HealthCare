package com.healthcare.app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.healthcare.app.R;

import java.util.ArrayList;

public class Notification_Adapter extends RecyclerView.Adapter<Notification_Adapter.ViewHolder> {


    Context context;
    ArrayList<String> bookinglist;

    public Notification_Adapter(Context context, ArrayList<String> bookinglist) {
        this.context = context;
        this.bookinglist = bookinglist;

    }


    @Override
    public Notification_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_notification, parent, false);
        return new Notification_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Notification_Adapter.ViewHolder holder, int position) {

        holder.truck_com.setText(bookinglist.get(position));

    }


    @Override
    public int getItemCount() {
        return bookinglist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView truck_com;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            truck_com=itemView.findViewById(R.id.truck_com);


        }
    }
}
