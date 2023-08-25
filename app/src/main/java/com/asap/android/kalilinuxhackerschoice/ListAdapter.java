package com.asap.android.kalilinuxhackerschoice;

//package com.kalilinuxhackerschoice.android.card;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asap.android.kalilinuxhackerschoice.R;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyHolder> {

    Context context;
    String rname[];
    RecyclerView recyclerView;
    public ListAdapter(Context context, String[] rname) {
        this.context = context;
        this.rname = rname;
    }

    // ActionBar actionBar = getSupportActionBar();

    // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        holder.txt.setText(rname[position]);

    }

    @Override
    public int getItemCount() {

        return rname.length;
    }





    class MyHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView txt;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.image1);
            txt = itemView.findViewById(R.id.titleview);
            recyclerView = itemView.findViewById(R.id.recycleview);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(context , Kaliitems_Activity.class);
                    intent.putExtra("title", rname[getAdapterPosition()]);
                    context.startActivity(intent);

                }
            });
        }
    }


}
