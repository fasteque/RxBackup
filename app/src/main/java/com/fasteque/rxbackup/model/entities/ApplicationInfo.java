package com.fasteque.rxbackup.model.entities;

import android.support.annotation.NonNull;

/**
 * Created by danielealtomare on 29/07/15.
 * Project: RxBackup
 */
public class ApplicationInfo implements Comparable<Object> {
    private String packageName;
    private String name;
    private long size;
    private long lastUpdateTime;
    private String icon;
    private String versionName;

    public ApplicationInfo(String packageName, String name, long size, long lastUpdateTime, String icon, String
            versionName) {
        this.packageName = packageName;
        this.name = name;
        this.size = size;
        this.lastUpdateTime = lastUpdateTime;
        this.icon = icon;
        this.versionName = versionName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    @Override
    public int compareTo(@NonNull Object another) {
        ApplicationInfo f = (ApplicationInfo) another;
        return getName().compareTo(f.getName());
    }
}
