package com.example.clonningubereats.utils.history_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.clonningubereats.R;
import com.example.clonningubereats.modelClass.HistoryRvPosition;
import com.nshmura.recyclertablayout.RecyclerTabLayout;

public class HistoryRTLAdapter extends RecyclerTabLayout.Adapter<HistoryRTLAdapter.HistoryHolder> {

    private HistoryPagerAdapter adapter;
    private LinearLayout mLL;
    private HistoryRvPosition position;
    private Context context;

    public HistoryRTLAdapter(ViewPager viewPager) {
        super(viewPager);
        adapter = (HistoryPagerAdapter) mViewPager.getAdapter();
        position = (HistoryRvPosition) context;
    }

    @NonNull
    @Override
    public HistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_rtl_text, parent, false);
        return new HistoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryHolder holder, int position) {
        holder.mTv.setText(adapter.getTabTitle(position).getHistoryTitle());
    }

    @Override
    public int getItemCount() {
        return adapter.getCount();
    }

    public class HistoryHolder extends RecyclerView.ViewHolder {
        private TextView mTv;

        public HistoryHolder(@NonNull View itemView) {
            super(itemView);
            mTv = itemView.findViewById(R.id.RTLText);
            position.hPostion(getAdapterPosition());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getViewPager().setCurrentItem(getAdapterPosition());

                }
            });
        }
    }
}
