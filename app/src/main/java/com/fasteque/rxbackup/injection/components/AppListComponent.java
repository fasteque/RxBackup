package com.fasteque.rxbackup.injection.components;

import android.support.annotation.NonNull;

import com.fasteque.rxbackup.injection.PerActivity;
import com.fasteque.rxbackup.injection.modules.ActivityModule;
import com.fasteque.rxbackup.views.activities.MainActivity;

import dagger.Component;

/**
 * Created by danielealtomare on 06/08/15.
 * Project: RxBackup
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = { ActivityModule.class })
public interface AppListComponent {
    void inject(@NonNull MainActivity mainActivity);
}
