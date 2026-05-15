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
import com.nammaskill.app.data.model.SuccessStory;
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
public final class StoryDao_Impl implements StoryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SuccessStory> __insertionAdapterOfSuccessStory;

  public StoryDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSuccessStory = new EntityInsertionAdapter<SuccessStory>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `success_stories` (`id`,`personName`,`age`,`location`,`trade`,`courseTaken`,`currentJob`,`monthlySalary`,`quote`,`iconEmoji`,`bannerColor`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final SuccessStory entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getPersonName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getPersonName());
        }
        statement.bindLong(3, entity.getAge());
        if (entity.getLocation() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getLocation());
        }
        if (entity.getTrade() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getTrade());
        }
        if (entity.getCourseTaken() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getCourseTaken());
        }
        if (entity.getCurrentJob() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getCurrentJob());
        }
        if (entity.getMonthlySalary() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getMonthlySalary());
        }
        if (entity.getQuote() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getQuote());
        }
        if (entity.getIconEmoji() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getIconEmoji());
        }
        if (entity.getBannerColor() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getBannerColor());
        }
      }
    };
  }

  @Override
  public Object insertAll(final List<SuccessStory> stories,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfSuccessStory.insert(stories);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<SuccessStory>> getAllStories() {
    final String _sql = "SELECT * FROM success_stories ORDER BY id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"success_stories"}, false, new Callable<List<SuccessStory>>() {
      @Override
      @Nullable
      public List<SuccessStory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPersonName = CursorUtil.getColumnIndexOrThrow(_cursor, "personName");
          final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfTrade = CursorUtil.getColumnIndexOrThrow(_cursor, "trade");
          final int _cursorIndexOfCourseTaken = CursorUtil.getColumnIndexOrThrow(_cursor, "courseTaken");
          final int _cursorIndexOfCurrentJob = CursorUtil.getColumnIndexOrThrow(_cursor, "currentJob");
          final int _cursorIndexOfMonthlySalary = CursorUtil.getColumnIndexOrThrow(_cursor, "monthlySalary");
          final int _cursorIndexOfQuote = CursorUtil.getColumnIndexOrThrow(_cursor, "quote");
          final int _cursorIndexOfIconEmoji = CursorUtil.getColumnIndexOrThrow(_cursor, "iconEmoji");
          final int _cursorIndexOfBannerColor = CursorUtil.getColumnIndexOrThrow(_cursor, "bannerColor");
          final List<SuccessStory> _result = new ArrayList<SuccessStory>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final SuccessStory _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpPersonName;
            if (_cursor.isNull(_cursorIndexOfPersonName)) {
              _tmpPersonName = null;
            } else {
              _tmpPersonName = _cursor.getString(_cursorIndexOfPersonName);
            }
            final int _tmpAge;
            _tmpAge = _cursor.getInt(_cursorIndexOfAge);
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            final String _tmpTrade;
            if (_cursor.isNull(_cursorIndexOfTrade)) {
              _tmpTrade = null;
            } else {
              _tmpTrade = _cursor.getString(_cursorIndexOfTrade);
            }
            final String _tmpCourseTaken;
            if (_cursor.isNull(_cursorIndexOfCourseTaken)) {
              _tmpCourseTaken = null;
            } else {
              _tmpCourseTaken = _cursor.getString(_cursorIndexOfCourseTaken);
            }
            final String _tmpCurrentJob;
            if (_cursor.isNull(_cursorIndexOfCurrentJob)) {
              _tmpCurrentJob = null;
            } else {
              _tmpCurrentJob = _cursor.getString(_cursorIndexOfCurrentJob);
            }
            final String _tmpMonthlySalary;
            if (_cursor.isNull(_cursorIndexOfMonthlySalary)) {
              _tmpMonthlySalary = null;
            } else {
              _tmpMonthlySalary = _cursor.getString(_cursorIndexOfMonthlySalary);
            }
            final String _tmpQuote;
            if (_cursor.isNull(_cursorIndexOfQuote)) {
              _tmpQuote = null;
            } else {
              _tmpQuote = _cursor.getString(_cursorIndexOfQuote);
            }
            final String _tmpIconEmoji;
            if (_cursor.isNull(_cursorIndexOfIconEmoji)) {
              _tmpIconEmoji = null;
            } else {
              _tmpIconEmoji = _cursor.getString(_cursorIndexOfIconEmoji);
            }
            final String _tmpBannerColor;
            if (_cursor.isNull(_cursorIndexOfBannerColor)) {
              _tmpBannerColor = null;
            } else {
              _tmpBannerColor = _cursor.getString(_cursorIndexOfBannerColor);
            }
            _item = new SuccessStory(_tmpId,_tmpPersonName,_tmpAge,_tmpLocation,_tmpTrade,_tmpCourseTaken,_tmpCurrentJob,_tmpMonthlySalary,_tmpQuote,_tmpIconEmoji,_tmpBannerColor);
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
    final String _sql = "SELECT COUNT(*) FROM success_stories";
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
