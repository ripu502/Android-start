package com.example.rec;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// adaper ka name . ViewHolder
//and  public class ViewHolder extends RecyclerView.ViewHolderd/**/er



public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {

// list.java wlla file main model
    private List<list> mylist;
    private Context context;

    public adapter(List<list> mylist, Context context) {
        this.mylist = mylist;
        this.context = context;
    }

    @NonNull
    @Override
    public adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent , false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter.ViewHolder holder, int position) {
// model clas ml
        // holder . model jo getter banane waha ki name or yaha ki name same list.java nad adapter.java
        list ml = mylist.get(position);
        holder.name.setText(ml.getName());
        holder.password.setText(ml.getPassword());

    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private TextView password;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.textView);
            password = (TextView) itemView.findViewById(R.id.textView2);
        }
    }
}
