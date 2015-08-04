package com.fasteque.rxbackup.domain;

import rx.Observable;

/**
 * Created by danielealtomare on 04/08/15.
 * Project: RxBackup
 */
public interface UseCase<T> {
    Observable<T> execute();
}
