package com.fasteque.rxbackup.views;

import com.fasteque.rxbackup.model.entities.ApplicationInfo;

import java.util.List;

/**
 * Created by danielealtomare on 05/08/15.
 * Project: RxBackup
 */
public interface AppListView extends View {
    void refreshAppList(List<ApplicationInfo> applicationInfoList);
}
