package com.gridview.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Adapter extends android.support.v7.widget.RecyclerView.Adapter<Adapter.ViewHolder> {
  private final Context context;

  public Adapter(Context context) {
    this.context=context;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item,viewGroup,false));
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

  }

  @Override
  public int getItemCount() {
    return 18;
  }

  class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder{
    View view;
    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      view=itemView;
    }
  }
}
