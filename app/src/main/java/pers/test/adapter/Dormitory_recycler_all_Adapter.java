package pers.test.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import pers.test.R;
import pers.test.model.Dormitory_all;

/**
 * Created by 丿丶祥灬少 on 2018/4/16.
 */

public class Dormitory_recycler_all_Adapter extends RecyclerView.Adapter<Dormitory_recycler_all_Adapter.ViewHold> {

    private List<Dormitory_all> dormitory_all_List;

    static class ViewHold extends RecyclerView.ViewHolder{
        public ViewHold(View itemView) {
            super(itemView);

        }
    }

    @Override
    public ViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dormitory_recycler_all_item,null);
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHold holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 0;
    }
}
