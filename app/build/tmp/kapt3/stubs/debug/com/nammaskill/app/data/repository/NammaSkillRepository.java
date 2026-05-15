package com.nammaskill.app.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u0010\u0015J\u000e\u0010\u0017\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\u0018J\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u001aJ\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u001b0\u001aJ\u0012\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001b0\u001aJ\u0018\u0010 \u001a\u0004\u0018\u00010\u00142\u0006\u0010!\u001a\u00020\"H\u0086@\u00a2\u0006\u0002\u0010#J\u001a\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u001b0\u001a2\u0006\u0010%\u001a\u00020&J\u000e\u0010\'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0\u001aJ\u0010\u0010)\u001a\u0004\u0018\u00010(H\u0086@\u00a2\u0006\u0002\u0010\u0018J\u0016\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020(H\u0086@\u00a2\u0006\u0002\u0010,J\u0016\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u001cH\u0086@\u00a2\u0006\u0002\u0010/J\u000e\u00100\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\u0018J\u0016\u00101\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u0010\u0015R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2 = {"Lcom/nammaskill/app/data/repository/NammaSkillRepository;", "", "db", "Lcom/nammaskill/app/data/repository/NammaSkillDatabase;", "courseDao", "Lcom/nammaskill/app/data/repository/CourseDao;", "profileDao", "Lcom/nammaskill/app/data/repository/UserProfileDao;", "appDao", "Lcom/nammaskill/app/data/repository/ApplicationDao;", "storyDao", "Lcom/nammaskill/app/data/repository/StoryDao;", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "(Lcom/nammaskill/app/data/repository/NammaSkillDatabase;Lcom/nammaskill/app/data/repository/CourseDao;Lcom/nammaskill/app/data/repository/UserProfileDao;Lcom/nammaskill/app/data/repository/ApplicationDao;Lcom/nammaskill/app/data/repository/StoryDao;Lcom/google/firebase/firestore/FirebaseFirestore;Lcom/google/firebase/auth/FirebaseAuth;)V", "addCourse", "", "course", "Lcom/nammaskill/app/data/model/Course;", "(Lcom/nammaskill/app/data/model/Course;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCourse", "ensureSeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllApplications", "Landroidx/lifecycle/LiveData;", "", "Lcom/nammaskill/app/data/model/Application;", "getAllCourses", "getAllStories", "Lcom/nammaskill/app/data/model/SuccessStory;", "getCourseById", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCoursesByTrade", "trade", "", "getProfile", "Lcom/nammaskill/app/data/model/UserProfile;", "getProfileOnce", "saveProfile", "profile", "(Lcom/nammaskill/app/data/model/UserProfile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitApplication", "application", "(Lcom/nammaskill/app/data/model/Application;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncCoursesFromFirestore", "updateCourse", "app_debug"})
public final class NammaSkillRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.nammaskill.app.data.repository.NammaSkillDatabase db = null;
    @org.jetbrains.annotations.NotNull()
    private final com.nammaskill.app.data.repository.CourseDao courseDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.nammaskill.app.data.repository.UserProfileDao profileDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.nammaskill.app.data.repository.ApplicationDao appDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.nammaskill.app.data.repository.StoryDao storyDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.FirebaseFirestore firestore = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.auth.FirebaseAuth auth = null;
    
    @javax.inject.Inject()
    public NammaSkillRepository(@org.jetbrains.annotations.NotNull()
    com.nammaskill.app.data.repository.NammaSkillDatabase db, @org.jetbrains.annotations.NotNull()
    com.nammaskill.app.data.repository.CourseDao courseDao, @org.jetbrains.annotations.NotNull()
    com.nammaskill.app.data.repository.UserProfileDao profileDao, @org.jetbrains.annotations.NotNull()
    com.nammaskill.app.data.repository.ApplicationDao appDao, @org.jetbrains.annotations.NotNull()
    com.nammaskill.app.data.repository.StoryDao storyDao, @org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.FirebaseFirestore firestore, @org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth auth) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.nammaskill.app.data.model.Course>> getAllCourses() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getCourseById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.nammaskill.app.data.model.Course> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addCourse(@org.jetbrains.annotations.NotNull()
    com.nammaskill.app.data.model.Course course, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateCourse(@org.jetbrains.annotations.NotNull()
    com.nammaskill.app.data.model.Course course, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteCourse(@org.jetbrains.annotations.NotNull()
    com.nammaskill.app.data.model.Course course, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.nammaskill.app.data.model.UserProfile> getProfile() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getProfileOnce(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.nammaskill.app.data.model.UserProfile> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveProfile(@org.jetbrains.annotations.NotNull()
    com.nammaskill.app.data.model.UserProfile profile, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.nammaskill.app.data.model.Application>> getAllApplications() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object submitApplication(@org.jetbrains.annotations.NotNull()
    com.nammaskill.app.data.model.Application application, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.nammaskill.app.data.model.SuccessStory>> getAllStories() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object syncCoursesFromFirestore(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object ensureSeeded(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.nammaskill.app.data.model.Course>> getCoursesByTrade(@org.jetbrains.annotations.NotNull()
    java.lang.String trade) {
        return null;
    }
}