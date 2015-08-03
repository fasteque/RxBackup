package com.fasteque.rxbackup.injection.modules;

import com.fasteque.rxbackup.RxBackupApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by danielealtomare on 03/08/15.
 * Project: RxBackup
 */

/**
 * It defines provider methods for any injectable dependency.
 * It encapsulates knowledge of how to construct the objects to inject.
 */
@Module
public class ApplicationModule {
    private final RxBackupApplication rxBackupApplication;

    public ApplicationModule(RxBackupApplication rxBackupApplication) {
        this.rxBackupApplication = rxBackupApplication;
    }

    @Provides
    @Singleton
    RxBackupApplication provideRxBackupApplication() {
        return rxBackupApplication;
    }
}
