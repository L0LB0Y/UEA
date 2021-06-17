package com.example.uaenew;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Myholder> {
    List<UAEData> list;
    Context context;

    public Adapter(List<UAEData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new Myholder(view);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        holder.setData(list.get(position), context);

    }

    static class Myholder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView author;
        TextView title;
        public Myholder(@NonNull View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.image);
            author = (TextView)itemView.findViewById(R.id.author);
            title = (TextView)itemView.findViewById(R.id.title_);
        }

        public void setData(UAEData restData, Context context) {
            Picasso.get().load(restData.getUrlToImage()).into(image);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nextActivity(restData, context);
                }
            });
            title.setText(restData.getTitle());
            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nextActivity(restData, context);
                }
            });
            author.setText(restData.getAuthor());
            author.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nextActivity(restData, context);
                }
            });
        }
        public void nextActivity(UAEData restData, Context context){
            Intent intent = new Intent(context, DisplayData.class);
            intent.putExtra("imgUrl",restData.getUrlToImage());
            intent.putExtra("author",restData.getAuthor());
            intent.putExtra("title",restData.getTitle());
            intent.putExtra("description",restData.getDescription());
            context.startActivity(intent);

        }


    }
}
