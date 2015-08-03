package com.fasteque.rxbackup.injection.modules;

import android.content.Context;
import android.support.annotation.NonNull;

import com.fasteque.rxbackup.injection.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by danielealtomare on 03/08/15.
 * Project: RxBackup
 */
@Module
public class ActivityModule {

    private final Context context;

    public ActivityModule(@NonNull Context context) {
        this.context = context;
    }

    @Provides
    @PerActivity
    Context provideActivityContext() {
        return context;
    }
}
