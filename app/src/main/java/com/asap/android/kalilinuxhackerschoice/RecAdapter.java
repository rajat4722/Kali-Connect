package com.asap.android.kalilinuxhackerschoice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asap.android.kalilinuxhackerschoice.R;

import java.util.Arrays;
import java.util.List;
//implements Filterable

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.MyHolder>{

    Context context;
    String rtitle[];
    String rmain[];
    List<String> rdesc;
    List<String> filter;
    //String[] descall;


    public RecAdapter(Context c, String[] rtitle, String[] rmain, String[] rdesc) {
        this.rtitle = rtitle;
        this.rmain = rmain;
        this.rdesc = Arrays.asList(rdesc);
        this.filter = Arrays.asList(rdesc);
        // this.rdescall =new String rdesc[];
        //  rdescall = new ArrayList<>(rdesc);
        //   this.descall = rdesc;

    }

    // public static Locale getFilter() {
    //}

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.newrow,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.txt1.setText(rtitle[position]);
        holder.txt2.setText(rmain[position]);
        holder.txt3.setText(rdesc.get(position));

    }

    @Override
    public int getItemCount() {
        return rtitle.length;
    }
/**
 @Override
 public android.widget.Filter getFilter() {
 return new Filter() {
 @Override
 protected FilterResults performFiltering(CharSequence constraint) {

 String charcater = constraint.toString();
 if (charcater.isEmpty()){
 filter = rdesc;
 }else {
 List<String> filterlist = new ArrayList<>();
 for (String row: rdesc){
 if (row.toLowerCase().contains(charcater.toLowerCase())){
 filterlist.add(row);
 }
 }
 filter = filterlist ;
 }
 FilterResults filterResults = new FilterResults();
 filterResults.values = filter;
 return filterResults;
 }

 @SuppressLint("NotifyDataSetChanged")
 @Override
 protected void publishResults(CharSequence constraint, FilterResults results) {
 filter = (List<String>) results.values;
 notifyDataSetChanged();

 }
 };

 }
 **/
    /**
     @Override
     public Filter getFilter() {
     return filter;
     }

     Filter filter = new Filter() {
     @Override
     protected FilterResults performFiltering(CharSequence constraint) {

     List<String> filtered = new ArrayList<>();

     if (constraint.toString().isEmpty()){
     filtered.addAll(Arrays.asList(descall));
     }else {
     for (String movie:descall) {
     if (movie.toLowerCase().contains(constraint.toString().toLowerCase())) {
     filtered.add(movie);
     }
     }
     }

     FilterResults Results = new FilterResults();
     Results.values = Results;

     return Results;
     }

     @Override
     protected void publishResults(CharSequence constraint, FilterResults results) {

     notifyDataSetChanged();

     }
     };

     **/

    static class MyHolder extends RecyclerView.ViewHolder{
        TextView txt1,txt2,txt3;

        public MyHolder(@NonNull View itemView){
            super(itemView);

            txt1 = itemView.findViewById(R.id.title_txtvw);
            txt2 = itemView.findViewById(R.id.main_txtvw);
            txt3 = itemView.findViewById(R.id.desc_txtvw);
        }

    }
}