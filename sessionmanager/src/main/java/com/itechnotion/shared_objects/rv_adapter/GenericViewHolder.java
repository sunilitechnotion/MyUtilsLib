package com.itechnotion.shared_objects.rv_adapter;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public abstract class GenericViewHolder<M> extends RecyclerView.ViewHolder {

   public GenericViewHolder(View itemView) {
      super(itemView);
   }

   public abstract void bindData(M element);

}
