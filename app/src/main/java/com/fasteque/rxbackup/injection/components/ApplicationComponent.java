package com.fasteque.rxbackup.injection.components;

/**
 * Created by danielealtomare on 03/08/15.
 * Project: RxBackup
 */

import com.fasteque.rxbackup.RxBackupApplication;
import com.fasteque.rxbackup.injection.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Components are interfaces (or abstract classes) defined by the developer.
 * Such interface may contain two types of methods:
 * - methods which return object and have no parameters
 *      > instances created by Dagger2
 * - methods which return void but have one argument
 *      > allow injecting non-private field members to provided object as argument
 */
@Singleton  // Constraints this component to one-per-application or un-scoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    RxBackupApplication application();
}
