package com.fasteque.rxbackup;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.fasteque.rxbackup.injection.components.ApplicationComponent;
import com.fasteque.rxbackup.injection.components.DaggerApplicationComponent;
import com.fasteque.rxbackup.injection.modules.ApplicationModule;

/**
 * Created by danielealtomare on 28/07/15.
 * Project: RxBackup
 */
public class RxBackupApplication extends Application {

    private ApplicationComponent applicationComponent;

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }
}
