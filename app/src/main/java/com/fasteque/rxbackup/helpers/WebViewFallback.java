package com.fasteque.rxbackup.helpers;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by danielealtomare on 25/11/15.
 * Project: RxBackup
 */
public class WebViewFallback implements CustomTabActivityHelper.CustomTabFallback {
    @Override
    public void openUri(Activity activity, Uri uri) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(uri);
        activity.startActivity(intent);
    }
}
