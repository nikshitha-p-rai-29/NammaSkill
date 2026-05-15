package com.nammaskill.app.data.repository;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.nammaskill.app.data.model.Application;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ApplicationDao_Impl implements ApplicationDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Application> __insertionAdapterOfApplication;

  public ApplicationDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfApplication = new EntityInsertionAdapter<Application>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `applications` (`id`,`courseId`,`courseTitle`,`centerName`,`appliedDate`,`status`,`referenceId`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Application entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getCourseId());
        if (entity.getCourseTitle() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getCourseTitle());
        }
        if (entity.getCenterName() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getCenterName());
        }
        if (entity.getAppliedDate() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getAppliedDate());
        }
        if (entity.getStatus() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getStatus());
        }
        if (entity.getReferenceId() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getReferenceId());
        }
      }
    };
  }

  @Override
  public Object insert(final Application application,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfApplication.insert(application);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<Application>> getAllApplications() {
    final String _sql = "SELECT * FROM applications ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"applications"}, false, new Callable<List<Application>>() {
      @Override
      @Nullable
      public List<Application> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCourseId = CursorUtil.getColumnIndexOrThrow(_cursor, "courseId");
          final int _cursorIndexOfCourseTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "courseTitle");
          final int _cursorIndexOfCenterName = CursorUtil.getColumnIndexOrThrow(_cursor, "centerName");
          final int _cursorIndexOfAppliedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "appliedDate");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfReferenceId = CursorUtil.getColumnIndexOrThrow(_cursor, "referenceId");
          final List<Application> _result = new ArrayList<Application>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Application _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpCourseId;
            _tmpCourseId = _cursor.getInt(_cursorIndexOfCourseId);
            final String _tmpCourseTitle;
            if (_cursor.isNull(_cursorIndexOfCourseTitle)) {
              _tmpCourseTitle = null;
            } else {
              _tmpCourseTitle = _cursor.getString(_cursorIndexOfCourseTitle);
            }
            final String _tmpCenterName;
            if (_cursor.isNull(_cursorIndexOfCenterName)) {
              _tmpCenterName = null;
            } else {
              _tmpCenterName = _cursor.getString(_cursorIndexOfCenterName);
            }
            final String _tmpAppliedDate;
            if (_cursor.isNull(_cursorIndexOfAppliedDate)) {
              _tmpAppliedDate = null;
            } else {
              _tmpAppliedDate = _cursor.getString(_cursorIndexOfAppliedDate);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final String _tmpReferenceId;
            if (_cursor.isNull(_cursorIndexOfReferenceId)) {
              _tmpReferenceId = null;
            } else {
              _tmpReferenceId = _cursor.getString(_cursorIndexOfReferenceId);
            }
            _item = new Application(_tmpId,_tmpCourseId,_tmpCourseTitle,_tmpCenterName,_tmpAppliedDate,_tmpStatus,_tmpReferenceId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM applications";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
