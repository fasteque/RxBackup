package com.fasteque.rxbackup.presenters;

import android.support.annotation.NonNull;
import com.fasteque.rxbackup.views.View;

/**
 * Created by danielealtomare on 02/08/15.
 * Project: RxBackup
 */
public interface Presenter {
    void onPresenterStart();
    void onPresenterStop();
    void attachView(@NonNull View view);
}
