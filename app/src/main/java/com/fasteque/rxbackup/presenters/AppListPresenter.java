package com.fasteque.rxbackup.presenters;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import com.fasteque.rxbackup.R;
import com.fasteque.rxbackup.model.entities.ApplicationInfo;
import com.fasteque.rxbackup.model.entities.ApplicationInfoRich;
import com.fasteque.rxbackup.views.AppListView;
import com.fasteque.rxbackup.views.View;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * Created by danielealtomare on 02/08/15.
 * Project: RxBackup
 */
public class AppListPresenter implements Presenter {

    private AppListView appListView;

    @Inject
    public AppListPresenter() {

    }

    @Override
    public void onPresenterStart() {
        refreshAppList();
    }

    @Override
    public void onPresenterStop() {

    }

    @Override
    public void attachView(@NonNull View view) {
        appListView = (AppListView) view;
    }

    public void refreshAppList() {
        getApps()
                .toSortedList()
                .subscribe(new Observer<List<ApplicationInfo>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        appListView.displayError(R.string.error_retrieve_applications);
                    }

                    @Override
                    public void onNext(List<ApplicationInfo> applicationInfoList) {
                        appListView.refreshAppList(applicationInfoList);
                    }
                });
    }

    private Observable<ApplicationInfo> getApps() {
        return Observable.create(new Observable.OnSubscribe<ApplicationInfo>() {
            @Override
            public void call(Subscriber<? super ApplicationInfo> subscriber) {
                List<ApplicationInfoRich> apps = new ArrayList<>();

                final Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
                mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);

                List<ResolveInfo> infos = ((Activity) appListView).getPackageManager().queryIntentActivities
                        (mainIntent, 0);

                for (ResolveInfo info : infos) {
                    apps.add(new ApplicationInfoRich(((Activity) appListView), info));
                }

                for (ApplicationInfoRich appInfo : apps) {
                    // TODO: get application icon

                    if (subscriber.isUnsubscribed()) {
                        return;
                    }
                    subscriber.onNext(new ApplicationInfo(appInfo.getPackageName(), appInfo.getName(), 0, appInfo
                            .getLastUpdateTime(),
                            null));
                }
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onCompleted();
                }
            }
        });
    }
}
