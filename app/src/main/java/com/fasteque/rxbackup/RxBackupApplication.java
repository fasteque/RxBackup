package com.fasteque.rxbackup;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.fasteque.rxbackup.injection.components.ApplicationComponent;
import com.fasteque.rxbackup.injection.components.DaggerApplicationComponent;
import com.fasteque.rxbackup.injection.modules.ApplicationModule;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by danielealtomare on 28/07/15.
 * Project: RxBackup
 */
public class RxBackupApplication extends Application {

    private ApplicationComponent applicationComponent;
    private RefWatcher refWatcher;

    public static RefWatcher getRefWatcher(@NonNull Context context) {
        RxBackupApplication application = (RxBackupApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        refWatcher = LeakCanary.install(this);

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }
}
