package com.fasteque.rxbackup;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by danielealtomare on 28/07/15.
 * Project: RxBackup
 */
public class RxBackupApplication extends Application {

    private RefWatcher refWatcher;

    public static RefWatcher getRefWatcher(@NonNull Context context) {
        RxBackupApplication application = (RxBackupApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        refWatcher = LeakCanary.install(this);
    }
}
