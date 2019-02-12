package com.vino.raven.kaathalaara.adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.vino.raven.kaathalaara.R;
import com.vino.raven.kaathalaara.activities.Details_Page;
import com.vino.raven.kaathalaara.model.ContentTitles;

import java.util.List;

/**
 * Created by RAVEN on 7/25/2018.
 */

public class Adap_Contents extends RecyclerView.Adapter<Adap_Contents.ViewHolder> {

    private List<ContentTitles> contentTitles;
    public Adap_Contents(List<ContentTitles> contentTitles) {
        this.contentTitles=contentTitles;
    }

    @NonNull
    @Override
    public Adap_Contents.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_content,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Adap_Contents.ViewHolder holder, int position) {
        holder.id.setText(contentTitles.get(position).getId());
        holder.title.setText(contentTitles.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return contentTitles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        AppCompatTextView id,title;

        ViewHolder(View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.tv_title_no);
            title=itemView.findViewById(R.id.tv_title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int posi=getAdapterPosition();
            Toast.makeText(itemView.getContext(),"YOU SELECTED"+contentTitles.get(getAdapterPosition()),Toast.LENGTH_SHORT).show();
            Intent details=new Intent(itemView.getContext(), Details_Page.class);
            details.putExtra("title",contentTitles.get(posi).getTitle());
            details.putExtra("kavithai",contentTitles.get(posi).getKavithai());
            itemView.getContext().startActivity(details);
        }
    }
}
