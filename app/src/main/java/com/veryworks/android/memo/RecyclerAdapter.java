package com.veryworks.android.memo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.veryworks.android.memo.domain.Memo;

import java.util.ArrayList;

/**
 * Created by pc on 5/29/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Holder>{
    ArrayList<Memo> datas;

    public RecyclerAdapter(ArrayList<Memo> datas){
        this.datas = datas;
    }
    // Recycler 위젯을 받아서 아답터를 세팅한다.
    public void setView(RecyclerView view) {
        view.setAdapter(this);
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Holder extends RecyclerView.ViewHolder {
        public Holder(View itemView) {
            super(itemView);
        }
    }
}
