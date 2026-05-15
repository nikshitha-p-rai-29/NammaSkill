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
import com.nammaskill.app.data.model.UserProfile;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UserProfileDao_Impl implements UserProfileDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserProfile> __insertionAdapterOfUserProfile;

  public UserProfileDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserProfile = new EntityInsertionAdapter<UserProfile>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `user_profile` (`id`,`fullName`,`age`,`gender`,`phone`,`district`,`village`,`education`,`preferredTrades`,`aadhaarLast4`,`isProfileComplete`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserProfile entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getFullName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getFullName());
        }
        if (entity.getAge() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getAge());
        }
        if (entity.getGender() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getGender());
        }
        if (entity.getPhone() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getPhone());
        }
        if (entity.getDistrict() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getDistrict());
        }
        if (entity.getVillage() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getVillage());
        }
        if (entity.getEducation() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getEducation());
        }
        if (entity.getPreferredTrades() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getPreferredTrades());
        }
        if (entity.getAadhaarLast4() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getAadhaarLast4());
        }
        final int _tmp = entity.isProfileComplete() ? 1 : 0;
        statement.bindLong(11, _tmp);
      }
    };
  }

  @Override
  public Object insertOrUpdate(final UserProfile profile,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUserProfile.insert(profile);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<UserProfile> getProfile() {
    final String _sql = "SELECT * FROM user_profile WHERE id = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"user_profile"}, false, new Callable<UserProfile>() {
      @Override
      @Nullable
      public UserProfile call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "fullName");
          final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfDistrict = CursorUtil.getColumnIndexOrThrow(_cursor, "district");
          final int _cursorIndexOfVillage = CursorUtil.getColumnIndexOrThrow(_cursor, "village");
          final int _cursorIndexOfEducation = CursorUtil.getColumnIndexOrThrow(_cursor, "education");
          final int _cursorIndexOfPreferredTrades = CursorUtil.getColumnIndexOrThrow(_cursor, "preferredTrades");
          final int _cursorIndexOfAadhaarLast4 = CursorUtil.getColumnIndexOrThrow(_cursor, "aadhaarLast4");
          final int _cursorIndexOfIsProfileComplete = CursorUtil.getColumnIndexOrThrow(_cursor, "isProfileComplete");
          final UserProfile _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpFullName;
            if (_cursor.isNull(_cursorIndexOfFullName)) {
              _tmpFullName = null;
            } else {
              _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
            }
            final String _tmpAge;
            if (_cursor.isNull(_cursorIndexOfAge)) {
              _tmpAge = null;
            } else {
              _tmpAge = _cursor.getString(_cursorIndexOfAge);
            }
            final String _tmpGender;
            if (_cursor.isNull(_cursorIndexOfGender)) {
              _tmpGender = null;
            } else {
              _tmpGender = _cursor.getString(_cursorIndexOfGender);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpDistrict;
            if (_cursor.isNull(_cursorIndexOfDistrict)) {
              _tmpDistrict = null;
            } else {
              _tmpDistrict = _cursor.getString(_cursorIndexOfDistrict);
            }
            final String _tmpVillage;
            if (_cursor.isNull(_cursorIndexOfVillage)) {
              _tmpVillage = null;
            } else {
              _tmpVillage = _cursor.getString(_cursorIndexOfVillage);
            }
            final String _tmpEducation;
            if (_cursor.isNull(_cursorIndexOfEducation)) {
              _tmpEducation = null;
            } else {
              _tmpEducation = _cursor.getString(_cursorIndexOfEducation);
            }
            final String _tmpPreferredTrades;
            if (_cursor.isNull(_cursorIndexOfPreferredTrades)) {
              _tmpPreferredTrades = null;
            } else {
              _tmpPreferredTrades = _cursor.getString(_cursorIndexOfPreferredTrades);
            }
            final String _tmpAadhaarLast4;
            if (_cursor.isNull(_cursorIndexOfAadhaarLast4)) {
              _tmpAadhaarLast4 = null;
            } else {
              _tmpAadhaarLast4 = _cursor.getString(_cursorIndexOfAadhaarLast4);
            }
            final boolean _tmpIsProfileComplete;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsProfileComplete);
            _tmpIsProfileComplete = _tmp != 0;
            _result = new UserProfile(_tmpId,_tmpFullName,_tmpAge,_tmpGender,_tmpPhone,_tmpDistrict,_tmpVillage,_tmpEducation,_tmpPreferredTrades,_tmpAadhaarLast4,_tmpIsProfileComplete);
          } else {
            _result = null;
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
  public Object getProfileOnce(final Continuation<? super UserProfile> $completion) {
    final String _sql = "SELECT * FROM user_profile WHERE id = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<UserProfile>() {
      @Override
      @Nullable
      public UserProfile call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "fullName");
          final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfDistrict = CursorUtil.getColumnIndexOrThrow(_cursor, "district");
          final int _cursorIndexOfVillage = CursorUtil.getColumnIndexOrThrow(_cursor, "village");
          final int _cursorIndexOfEducation = CursorUtil.getColumnIndexOrThrow(_cursor, "education");
          final int _cursorIndexOfPreferredTrades = CursorUtil.getColumnIndexOrThrow(_cursor, "preferredTrades");
          final int _cursorIndexOfAadhaarLast4 = CursorUtil.getColumnIndexOrThrow(_cursor, "aadhaarLast4");
          final int _cursorIndexOfIsProfileComplete = CursorUtil.getColumnIndexOrThrow(_cursor, "isProfileComplete");
          final UserProfile _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpFullName;
            if (_cursor.isNull(_cursorIndexOfFullName)) {
              _tmpFullName = null;
            } else {
              _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
            }
            final String _tmpAge;
            if (_cursor.isNull(_cursorIndexOfAge)) {
              _tmpAge = null;
            } else {
              _tmpAge = _cursor.getString(_cursorIndexOfAge);
            }
            final String _tmpGender;
            if (_cursor.isNull(_cursorIndexOfGender)) {
              _tmpGender = null;
            } else {
              _tmpGender = _cursor.getString(_cursorIndexOfGender);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpDistrict;
            if (_cursor.isNull(_cursorIndexOfDistrict)) {
              _tmpDistrict = null;
            } else {
              _tmpDistrict = _cursor.getString(_cursorIndexOfDistrict);
            }
            final String _tmpVillage;
            if (_cursor.isNull(_cursorIndexOfVillage)) {
              _tmpVillage = null;
            } else {
              _tmpVillage = _cursor.getString(_cursorIndexOfVillage);
            }
            final String _tmpEducation;
            if (_cursor.isNull(_cursorIndexOfEducation)) {
              _tmpEducation = null;
            } else {
              _tmpEducation = _cursor.getString(_cursorIndexOfEducation);
            }
            final String _tmpPreferredTrades;
            if (_cursor.isNull(_cursorIndexOfPreferredTrades)) {
              _tmpPreferredTrades = null;
            } else {
              _tmpPreferredTrades = _cursor.getString(_cursorIndexOfPreferredTrades);
            }
            final String _tmpAadhaarLast4;
            if (_cursor.isNull(_cursorIndexOfAadhaarLast4)) {
              _tmpAadhaarLast4 = null;
            } else {
              _tmpAadhaarLast4 = _cursor.getString(_cursorIndexOfAadhaarLast4);
            }
            final boolean _tmpIsProfileComplete;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsProfileComplete);
            _tmpIsProfileComplete = _tmp != 0;
            _result = new UserProfile(_tmpId,_tmpFullName,_tmpAge,_tmpGender,_tmpPhone,_tmpDistrict,_tmpVillage,_tmpEducation,_tmpPreferredTrades,_tmpAadhaarLast4,_tmpIsProfileComplete);
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
