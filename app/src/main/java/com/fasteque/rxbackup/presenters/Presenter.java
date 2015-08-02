package com.fasteque.rxbackup.presenters;

import android.support.annotation.NonNull;
import android.view.View;

/**
 * Created by danielealtomare on 02/08/15.
 * Project: RxBackup
 */
public interface Presenter {
    void onPresenterStart();
    void onPresenterStop();
    void attachView(@NonNull View view);
}
