package com.one.daggerdummy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.one.daggerdummy.Retrofit.Data;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<Data> items;

    public MyAdapter(Context context, List<Data> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.custom_layout, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Data curItem=items.get(position);
        holder.title.setText(curItem.getTitle());
        holder.user_id.setText(""+curItem.getId());
        holder.id.setText(""+curItem.getId());
        if(curItem.getStatus()){
            holder.background.setBackground(ContextCompat.getDrawable(context, R.drawable.if_true));
        }else{
            holder.background.setBackground(ContextCompat.getDrawable(context, R.drawable.if_false));
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView user_id;
        private TextView id;
        private TextView title;
        private boolean is_completed;
        private ConstraintLayout background;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            user_id=itemView.findViewById(R.id.userID);
            id=itemView.findViewById(R.id.ID);
            title=itemView.findViewById(R.id.des);
            background=itemView.findViewById(R.id.background);
        }
    }
}
