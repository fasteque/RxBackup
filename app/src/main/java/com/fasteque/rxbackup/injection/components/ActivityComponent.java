package com.fasteque.rxbackup.injection.components;

import android.content.Context;

import com.fasteque.rxbackup.injection.PerActivity;
import com.fasteque.rxbackup.injection.modules.ActivityModule;

import dagger.Component;

/**
 * Created by danielealtomare on 03/08/15.
 * Project: RxBackup
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Context context();
}
