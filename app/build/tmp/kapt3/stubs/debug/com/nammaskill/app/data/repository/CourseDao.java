package com.nammaskill.app.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0018\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0011\u001a\u00020\u0012H\'J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0014\u001a\u00020\u0012H\'J$\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\'J\u0016\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0018\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u00a7@\u00a2\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u001c"}, d2 = {"Lcom/nammaskill/app/data/repository/CourseDao;", "", "delete", "", "course", "Lcom/nammaskill/app/data/model/Course;", "(Lcom/nammaskill/app/data/model/Course;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllCourses", "Landroidx/lifecycle/LiveData;", "", "getCourseById", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCourseCount", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCoursesByDuration", "type", "", "getCoursesByTrade", "trade", "getCoursesByTradeAndDuration", "duration", "insert", "insertAll", "courses", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "app_debug"})
@androidx.room.Dao()
public abstract interface CourseDao {
    
    @androidx.room.Query(value = "SELECT * FROM courses WHERE isActive = 1 ORDER BY startDate ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.nammaskill.app.data.model.Course>> getAllCourses();
    
    @androidx.room.Query(value = "SELECT * FROM courses WHERE isActive = 1 AND durationType = :type ORDER BY startDate ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.nammaskill.app.data.model.Course>> getCoursesByDuration(@org.jetbrains.annotations.NotNull()
    java.lang.String type);
    
    @androidx.room.Query(value = "SELECT * FROM courses WHERE isActive = 1 AND trade LIKE \'%\' || :trade || \'%\' ORDER BY startDate ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.nammaskill.app.data.model.Course>> getCoursesByTrade(@org.jetbrains.annotations.NotNull()
    java.lang.String trade);
    
    @androidx.room.Query(value = "SELECT * FROM courses WHERE isActive = 1 AND trade LIKE \'%\' || :trade || \'%\' AND durationType = :duration ORDER BY startDate ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.nammaskill.app.data.model.Course>> getCoursesByTradeAndDuration(@org.jetbrains.annotations.NotNull()
    java.lang.String trade, @org.jetbrains.annotations.NotNull()
    java.lang.String duration);
    
    @androidx.room.Query(value = "SELECT * FROM courses WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCourseById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.nammaskill.app.data.model.Course> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertAll(@org.jetbrains.annotations.NotNull()
    java.util.List<com.nammaskill.app.data.model.Course> courses, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.nammaskill.app.data.model.Course course, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object update(@org.jetbrains.annotations.NotNull()
    com.nammaskill.app.data.model.Course course, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.nammaskill.app.data.model.Course course, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM courses WHERE isActive = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCourseCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
}