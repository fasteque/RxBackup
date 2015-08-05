package com.fasteque.rxbackup.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fasteque.rxbackup.R;

import butterknife.Bind;

/**
 * Created by danielealtomare on 05/08/15.
 * Project: RxBackup
 */
public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.AppListViewHolder> {
    @Override
    public AppListAdapter.AppListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // TODO
        return null;
    }

    @Override
    public void onBindViewHolder(AppListAdapter.AppListViewHolder holder, int position) {
        // TODO
    }

    @Override
    public int getItemCount() {
        // TODO
        return 0;
    }

    class AppListViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.app_icon)
        ImageView appIcon;


        @Bind(R.id.app_name)
        TextView appName;

        public AppListViewHolder(View itemView) {
            super(itemView);
        }

        // TODO
    }
}
