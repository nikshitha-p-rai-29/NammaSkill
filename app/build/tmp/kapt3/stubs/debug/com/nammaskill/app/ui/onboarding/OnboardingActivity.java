package com.nammaskill.app.ui.onboarding;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/nammaskill/app/ui/onboarding/OnboardingActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "pages", "", "Lcom/nammaskill/app/ui/onboarding/OnboardPage;", "prefManager", "Lcom/nammaskill/app/utils/PrefManager;", "getPrefManager", "()Lcom/nammaskill/app/utils/PrefManager;", "setPrefManager", "(Lcom/nammaskill/app/utils/PrefManager;)V", "finishOnboarding", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class OnboardingActivity extends androidx.appcompat.app.AppCompatActivity {
    @javax.inject.Inject()
    public com.nammaskill.app.utils.PrefManager prefManager;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.nammaskill.app.ui.onboarding.OnboardPage> pages = null;
    
    public OnboardingActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.nammaskill.app.utils.PrefManager getPrefManager() {
        return null;
    }
    
    public final void setPrefManager(@org.jetbrains.annotations.NotNull()
    com.nammaskill.app.utils.PrefManager p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void finishOnboarding() {
    }
}