package com.fasteque.rxbackup.views.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fasteque.rxbackup.R;
import com.fasteque.rxbackup.model.entities.ApplicationInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by danielealtomare on 05/08/15.
 * Project: RxBackup
 */
public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.AppListViewHolder> {

    private List<ApplicationInfo> applicationInfoList = new ArrayList<>();

    @Override
    public AppListAdapter.AppListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.application_list_item, parent, false);

        // TODO: managed view clicks.

        return new AppListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AppListAdapter.AppListViewHolder holder, int position) {
        holder.bindApplication(applicationInfoList.get(position));
    }

    @Override
    public int getItemCount() {
        return applicationInfoList == null ? 0 : applicationInfoList.size();
    }

    public void addApplications(List<ApplicationInfo> applications) {
        applicationInfoList.clear();
        applicationInfoList.addAll(applications);
        notifyDataSetChanged();
    }

    public void addApplication(int position, ApplicationInfo appInfo) {
        if (position < 0) {
            position = 0;
        }
        applicationInfoList.add(position, appInfo);
        notifyItemInserted(position);
    }

    class AppListViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.app_icon)
        ImageView appIcon;

        @Bind(R.id.app_name)
        TextView appName;

        @Bind(R.id.app_version)
        TextView appVersion;

        public AppListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindApplication(ApplicationInfo applicationInfo) {
            appName.setText(applicationInfo.getName());
            appVersion.setText("v" + applicationInfo.getVersionName());

            getIconBitmap(applicationInfo.getIcon())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<Bitmap>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(Bitmap bitmap) {
                            appIcon.setImageBitmap(bitmap);
                        }
                    });
        }

        private Observable<Bitmap> getIconBitmap(final String icon) {
            return Observable.create(new Observable.OnSubscribe<Bitmap>() {
                @Override
                public void call(Subscriber<? super Bitmap> subscriber) {
                    subscriber.onNext(BitmapFactory.decodeFile(icon));
                    subscriber.onCompleted();
                }
            });
        }
    }
}
