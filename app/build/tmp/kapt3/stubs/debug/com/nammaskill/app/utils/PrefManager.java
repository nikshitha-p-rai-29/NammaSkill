package com.nammaskill.app.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/nammaskill/app/utils/PrefManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "getNotifBatches", "", "getNotifJobs", "getNotifStatus", "isOnboardingDone", "isProfileDone", "setNotifBatches", "", "v", "setNotifJobs", "setNotifStatus", "setOnboardingDone", "setProfileDone", "app_debug"})
public final class PrefManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences prefs = null;
    
    public PrefManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final boolean isOnboardingDone() {
        return false;
    }
    
    public final void setOnboardingDone() {
    }
    
    public final boolean isProfileDone() {
        return false;
    }
    
    public final void setProfileDone() {
    }
    
    public final boolean getNotifBatches() {
        return false;
    }
    
    public final void setNotifBatches(boolean v) {
    }
    
    public final boolean getNotifStatus() {
        return false;
    }
    
    public final void setNotifStatus(boolean v) {
    }
    
    public final boolean getNotifJobs() {
        return false;
    }
    
    public final void setNotifJobs(boolean v) {
    }
}