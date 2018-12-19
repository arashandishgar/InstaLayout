package com.gridview.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class Adapter extends android.support.v7.widget.RecyclerView.Adapter<Adapter.ViewHolder> {
  private final Context context;
  private  ArrayList<String> arrayList;
  private  int type=0;
  public Adapter(Context context) {
    this.context=context;
    this.arrayList=arrayList;
  }
  public Adapter(Context context,int type) {
    this.type=type;
    this.context=context;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    if(type==1){
    return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.sas,viewGroup,false));
    }
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
    ImageView view;
    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      if(type==1){
      view=itemView.findViewById(R.id.image);
      }
      view=itemView.findViewById(R.id.image1);
    }
  }
}
