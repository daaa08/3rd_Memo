package com.veryworks.android.memo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.veryworks.android.memo.domain.Memo;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Holder>{
    ArrayList<Memo> datas;

    public RecyclerAdapter(ArrayList<Memo> datas){
        this.datas = datas;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Memo memo = datas.get(position);
        // 스트링에서 한줄만 가져오기 --------------------
        String all = memo.getContent();
        int endOfLine = all.indexOf("\n");
        String oneLine = "";
        if(endOfLine == -1){
            oneLine = all;
        }else{
            oneLine = all.substring(0, endOfLine);
        }
        // ---------------------------------------------
        holder.setTitle(oneLine);
        holder.setDate(memo.getDate());
        holder.setId(memo.getId());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    // 상세보기 이동 - 리스트클릭
    public void goDetail(String id, Context context){
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(ListActivity.DOCUMENT_ID, id);
        context.startActivity(intent);
    }

    // 아답터(Presenter)의 뷰 클래스
    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textTitle;
        TextView textDate;
        String id;
        public Holder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            textTitle = (TextView) itemView.findViewById(R.id.textTitle);
            textDate  = (TextView) itemView.findViewById(R.id.textDate);
        }

        public void setId(String id){
            this.id = id;
        }

        public void setTitle(String title){
            textTitle.setText(title);
        }

        public void setDate(String date){
            textDate.setText(date);
        }

        @Override
        public void onClick(View v) {
            goDetail(id, v.getContext());
        }
    }
}
