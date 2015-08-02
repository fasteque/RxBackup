package com.fasteque.rxbackup.injection;

/**
 * Created by danielealtomare on 02/08/15.
 * Project: RxBackup
 */

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import javax.inject.Scope;

/**
 * This is a custom scoping annotation to permit objects whose lifetime should conform to the life
 * of the Activity to be memorized in the correct component.
 *
 * Advantages:
 * - the ability to inject objects where an activity is required to be constructed
 * - the use of singletons on a per-activity basis
 * - the global object graph is kept clear of things that can be used only in activities
 */


@Scope
@Retention(RUNTIME)
public @interface PerActivity {}