package com.nammaskill.app.data.repository;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.nammaskill.app.data.model.Course;
import com.nammaskill.app.utils.Converters;
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
public final class CourseDao_Impl implements CourseDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Course> __insertionAdapterOfCourse;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<Course> __deletionAdapterOfCourse;

  private final EntityDeletionOrUpdateAdapter<Course> __updateAdapterOfCourse;

  public CourseDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCourse = new EntityInsertionAdapter<Course>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `courses` (`id`,`title`,`centerName`,`trade`,`duration`,`durationType`,`fee`,`eligibility`,`startDate`,`seatsLeft`,`totalSeats`,`jobGuarantee`,`language`,`description`,`syllabus`,`trainerName`,`trainerPhone`,`districtName`,`centerAddress`,`iconEmoji`,`bannerColor`,`isActive`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Course entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        if (entity.getCenterName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getCenterName());
        }
        if (entity.getTrade() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getTrade());
        }
        if (entity.getDuration() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getDuration());
        }
        if (entity.getDurationType() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getDurationType());
        }
        if (entity.getFee() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getFee());
        }
        if (entity.getEligibility() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getEligibility());
        }
        if (entity.getStartDate() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getStartDate());
        }
        statement.bindLong(10, entity.getSeatsLeft());
        statement.bindLong(11, entity.getTotalSeats());
        if (entity.getJobGuarantee() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getJobGuarantee());
        }
        if (entity.getLanguage() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getLanguage());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.getDescription());
        }
        final String _tmp = __converters.fromStringList(entity.getSyllabus());
        if (_tmp == null) {
          statement.bindNull(15);
        } else {
          statement.bindString(15, _tmp);
        }
        if (entity.getTrainerName() == null) {
          statement.bindNull(16);
        } else {
          statement.bindString(16, entity.getTrainerName());
        }
        if (entity.getTrainerPhone() == null) {
          statement.bindNull(17);
        } else {
          statement.bindString(17, entity.getTrainerPhone());
        }
        if (entity.getDistrictName() == null) {
          statement.bindNull(18);
        } else {
          statement.bindString(18, entity.getDistrictName());
        }
        if (entity.getCenterAddress() == null) {
          statement.bindNull(19);
        } else {
          statement.bindString(19, entity.getCenterAddress());
        }
        if (entity.getIconEmoji() == null) {
          statement.bindNull(20);
        } else {
          statement.bindString(20, entity.getIconEmoji());
        }
        if (entity.getBannerColor() == null) {
          statement.bindNull(21);
        } else {
          statement.bindString(21, entity.getBannerColor());
        }
        final int _tmp_1 = entity.isActive() ? 1 : 0;
        statement.bindLong(22, _tmp_1);
      }
    };
    this.__deletionAdapterOfCourse = new EntityDeletionOrUpdateAdapter<Course>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `courses` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Course entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfCourse = new EntityDeletionOrUpdateAdapter<Course>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `courses` SET `id` = ?,`title` = ?,`centerName` = ?,`trade` = ?,`duration` = ?,`durationType` = ?,`fee` = ?,`eligibility` = ?,`startDate` = ?,`seatsLeft` = ?,`totalSeats` = ?,`jobGuarantee` = ?,`language` = ?,`description` = ?,`syllabus` = ?,`trainerName` = ?,`trainerPhone` = ?,`districtName` = ?,`centerAddress` = ?,`iconEmoji` = ?,`bannerColor` = ?,`isActive` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Course entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        if (entity.getCenterName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getCenterName());
        }
        if (entity.getTrade() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getTrade());
        }
        if (entity.getDuration() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getDuration());
        }
        if (entity.getDurationType() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getDurationType());
        }
        if (entity.getFee() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getFee());
        }
        if (entity.getEligibility() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getEligibility());
        }
        if (entity.getStartDate() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getStartDate());
        }
        statement.bindLong(10, entity.getSeatsLeft());
        statement.bindLong(11, entity.getTotalSeats());
        if (entity.getJobGuarantee() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getJobGuarantee());
        }
        if (entity.getLanguage() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getLanguage());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.getDescription());
        }
        final String _tmp = __converters.fromStringList(entity.getSyllabus());
        if (_tmp == null) {
          statement.bindNull(15);
        } else {
          statement.bindString(15, _tmp);
        }
        if (entity.getTrainerName() == null) {
          statement.bindNull(16);
        } else {
          statement.bindString(16, entity.getTrainerName());
        }
        if (entity.getTrainerPhone() == null) {
          statement.bindNull(17);
        } else {
          statement.bindString(17, entity.getTrainerPhone());
        }
        if (entity.getDistrictName() == null) {
          statement.bindNull(18);
        } else {
          statement.bindString(18, entity.getDistrictName());
        }
        if (entity.getCenterAddress() == null) {
          statement.bindNull(19);
        } else {
          statement.bindString(19, entity.getCenterAddress());
        }
        if (entity.getIconEmoji() == null) {
          statement.bindNull(20);
        } else {
          statement.bindString(20, entity.getIconEmoji());
        }
        if (entity.getBannerColor() == null) {
          statement.bindNull(21);
        } else {
          statement.bindString(21, entity.getBannerColor());
        }
        final int _tmp_1 = entity.isActive() ? 1 : 0;
        statement.bindLong(22, _tmp_1);
        statement.bindLong(23, entity.getId());
      }
    };
  }

  @Override
  public Object insertAll(final List<Course> courses,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCourse.insert(courses);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insert(final Course course, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCourse.insert(course);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final Course course, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfCourse.handle(course);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final Course course, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfCourse.handle(course);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<Course>> getAllCourses() {
    final String _sql = "SELECT * FROM courses WHERE isActive = 1 ORDER BY startDate ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"courses"}, false, new Callable<List<Course>>() {
      @Override
      @Nullable
      public List<Course> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfCenterName = CursorUtil.getColumnIndexOrThrow(_cursor, "centerName");
          final int _cursorIndexOfTrade = CursorUtil.getColumnIndexOrThrow(_cursor, "trade");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfDurationType = CursorUtil.getColumnIndexOrThrow(_cursor, "durationType");
          final int _cursorIndexOfFee = CursorUtil.getColumnIndexOrThrow(_cursor, "fee");
          final int _cursorIndexOfEligibility = CursorUtil.getColumnIndexOrThrow(_cursor, "eligibility");
          final int _cursorIndexOfStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "startDate");
          final int _cursorIndexOfSeatsLeft = CursorUtil.getColumnIndexOrThrow(_cursor, "seatsLeft");
          final int _cursorIndexOfTotalSeats = CursorUtil.getColumnIndexOrThrow(_cursor, "totalSeats");
          final int _cursorIndexOfJobGuarantee = CursorUtil.getColumnIndexOrThrow(_cursor, "jobGuarantee");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfSyllabus = CursorUtil.getColumnIndexOrThrow(_cursor, "syllabus");
          final int _cursorIndexOfTrainerName = CursorUtil.getColumnIndexOrThrow(_cursor, "trainerName");
          final int _cursorIndexOfTrainerPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "trainerPhone");
          final int _cursorIndexOfDistrictName = CursorUtil.getColumnIndexOrThrow(_cursor, "districtName");
          final int _cursorIndexOfCenterAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "centerAddress");
          final int _cursorIndexOfIconEmoji = CursorUtil.getColumnIndexOrThrow(_cursor, "iconEmoji");
          final int _cursorIndexOfBannerColor = CursorUtil.getColumnIndexOrThrow(_cursor, "bannerColor");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final List<Course> _result = new ArrayList<Course>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Course _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpCenterName;
            if (_cursor.isNull(_cursorIndexOfCenterName)) {
              _tmpCenterName = null;
            } else {
              _tmpCenterName = _cursor.getString(_cursorIndexOfCenterName);
            }
            final String _tmpTrade;
            if (_cursor.isNull(_cursorIndexOfTrade)) {
              _tmpTrade = null;
            } else {
              _tmpTrade = _cursor.getString(_cursorIndexOfTrade);
            }
            final String _tmpDuration;
            if (_cursor.isNull(_cursorIndexOfDuration)) {
              _tmpDuration = null;
            } else {
              _tmpDuration = _cursor.getString(_cursorIndexOfDuration);
            }
            final String _tmpDurationType;
            if (_cursor.isNull(_cursorIndexOfDurationType)) {
              _tmpDurationType = null;
            } else {
              _tmpDurationType = _cursor.getString(_cursorIndexOfDurationType);
            }
            final String _tmpFee;
            if (_cursor.isNull(_cursorIndexOfFee)) {
              _tmpFee = null;
            } else {
              _tmpFee = _cursor.getString(_cursorIndexOfFee);
            }
            final String _tmpEligibility;
            if (_cursor.isNull(_cursorIndexOfEligibility)) {
              _tmpEligibility = null;
            } else {
              _tmpEligibility = _cursor.getString(_cursorIndexOfEligibility);
            }
            final String _tmpStartDate;
            if (_cursor.isNull(_cursorIndexOfStartDate)) {
              _tmpStartDate = null;
            } else {
              _tmpStartDate = _cursor.getString(_cursorIndexOfStartDate);
            }
            final int _tmpSeatsLeft;
            _tmpSeatsLeft = _cursor.getInt(_cursorIndexOfSeatsLeft);
            final int _tmpTotalSeats;
            _tmpTotalSeats = _cursor.getInt(_cursorIndexOfTotalSeats);
            final String _tmpJobGuarantee;
            if (_cursor.isNull(_cursorIndexOfJobGuarantee)) {
              _tmpJobGuarantee = null;
            } else {
              _tmpJobGuarantee = _cursor.getString(_cursorIndexOfJobGuarantee);
            }
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final List<String> _tmpSyllabus;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfSyllabus)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfSyllabus);
            }
            _tmpSyllabus = __converters.toStringList(_tmp);
            final String _tmpTrainerName;
            if (_cursor.isNull(_cursorIndexOfTrainerName)) {
              _tmpTrainerName = null;
            } else {
              _tmpTrainerName = _cursor.getString(_cursorIndexOfTrainerName);
            }
            final String _tmpTrainerPhone;
            if (_cursor.isNull(_cursorIndexOfTrainerPhone)) {
              _tmpTrainerPhone = null;
            } else {
              _tmpTrainerPhone = _cursor.getString(_cursorIndexOfTrainerPhone);
            }
            final String _tmpDistrictName;
            if (_cursor.isNull(_cursorIndexOfDistrictName)) {
              _tmpDistrictName = null;
            } else {
              _tmpDistrictName = _cursor.getString(_cursorIndexOfDistrictName);
            }
            final String _tmpCenterAddress;
            if (_cursor.isNull(_cursorIndexOfCenterAddress)) {
              _tmpCenterAddress = null;
            } else {
              _tmpCenterAddress = _cursor.getString(_cursorIndexOfCenterAddress);
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
            final boolean _tmpIsActive;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_1 != 0;
            _item = new Course(_tmpId,_tmpTitle,_tmpCenterName,_tmpTrade,_tmpDuration,_tmpDurationType,_tmpFee,_tmpEligibility,_tmpStartDate,_tmpSeatsLeft,_tmpTotalSeats,_tmpJobGuarantee,_tmpLanguage,_tmpDescription,_tmpSyllabus,_tmpTrainerName,_tmpTrainerPhone,_tmpDistrictName,_tmpCenterAddress,_tmpIconEmoji,_tmpBannerColor,_tmpIsActive);
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
  public LiveData<List<Course>> getCoursesByDuration(final String type) {
    final String _sql = "SELECT * FROM courses WHERE isActive = 1 AND durationType = ? ORDER BY startDate ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, type);
    }
    return __db.getInvalidationTracker().createLiveData(new String[] {"courses"}, false, new Callable<List<Course>>() {
      @Override
      @Nullable
      public List<Course> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfCenterName = CursorUtil.getColumnIndexOrThrow(_cursor, "centerName");
          final int _cursorIndexOfTrade = CursorUtil.getColumnIndexOrThrow(_cursor, "trade");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfDurationType = CursorUtil.getColumnIndexOrThrow(_cursor, "durationType");
          final int _cursorIndexOfFee = CursorUtil.getColumnIndexOrThrow(_cursor, "fee");
          final int _cursorIndexOfEligibility = CursorUtil.getColumnIndexOrThrow(_cursor, "eligibility");
          final int _cursorIndexOfStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "startDate");
          final int _cursorIndexOfSeatsLeft = CursorUtil.getColumnIndexOrThrow(_cursor, "seatsLeft");
          final int _cursorIndexOfTotalSeats = CursorUtil.getColumnIndexOrThrow(_cursor, "totalSeats");
          final int _cursorIndexOfJobGuarantee = CursorUtil.getColumnIndexOrThrow(_cursor, "jobGuarantee");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfSyllabus = CursorUtil.getColumnIndexOrThrow(_cursor, "syllabus");
          final int _cursorIndexOfTrainerName = CursorUtil.getColumnIndexOrThrow(_cursor, "trainerName");
          final int _cursorIndexOfTrainerPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "trainerPhone");
          final int _cursorIndexOfDistrictName = CursorUtil.getColumnIndexOrThrow(_cursor, "districtName");
          final int _cursorIndexOfCenterAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "centerAddress");
          final int _cursorIndexOfIconEmoji = CursorUtil.getColumnIndexOrThrow(_cursor, "iconEmoji");
          final int _cursorIndexOfBannerColor = CursorUtil.getColumnIndexOrThrow(_cursor, "bannerColor");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final List<Course> _result = new ArrayList<Course>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Course _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpCenterName;
            if (_cursor.isNull(_cursorIndexOfCenterName)) {
              _tmpCenterName = null;
            } else {
              _tmpCenterName = _cursor.getString(_cursorIndexOfCenterName);
            }
            final String _tmpTrade;
            if (_cursor.isNull(_cursorIndexOfTrade)) {
              _tmpTrade = null;
            } else {
              _tmpTrade = _cursor.getString(_cursorIndexOfTrade);
            }
            final String _tmpDuration;
            if (_cursor.isNull(_cursorIndexOfDuration)) {
              _tmpDuration = null;
            } else {
              _tmpDuration = _cursor.getString(_cursorIndexOfDuration);
            }
            final String _tmpDurationType;
            if (_cursor.isNull(_cursorIndexOfDurationType)) {
              _tmpDurationType = null;
            } else {
              _tmpDurationType = _cursor.getString(_cursorIndexOfDurationType);
            }
            final String _tmpFee;
            if (_cursor.isNull(_cursorIndexOfFee)) {
              _tmpFee = null;
            } else {
              _tmpFee = _cursor.getString(_cursorIndexOfFee);
            }
            final String _tmpEligibility;
            if (_cursor.isNull(_cursorIndexOfEligibility)) {
              _tmpEligibility = null;
            } else {
              _tmpEligibility = _cursor.getString(_cursorIndexOfEligibility);
            }
            final String _tmpStartDate;
            if (_cursor.isNull(_cursorIndexOfStartDate)) {
              _tmpStartDate = null;
            } else {
              _tmpStartDate = _cursor.getString(_cursorIndexOfStartDate);
            }
            final int _tmpSeatsLeft;
            _tmpSeatsLeft = _cursor.getInt(_cursorIndexOfSeatsLeft);
            final int _tmpTotalSeats;
            _tmpTotalSeats = _cursor.getInt(_cursorIndexOfTotalSeats);
            final String _tmpJobGuarantee;
            if (_cursor.isNull(_cursorIndexOfJobGuarantee)) {
              _tmpJobGuarantee = null;
            } else {
              _tmpJobGuarantee = _cursor.getString(_cursorIndexOfJobGuarantee);
            }
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final List<String> _tmpSyllabus;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfSyllabus)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfSyllabus);
            }
            _tmpSyllabus = __converters.toStringList(_tmp);
            final String _tmpTrainerName;
            if (_cursor.isNull(_cursorIndexOfTrainerName)) {
              _tmpTrainerName = null;
            } else {
              _tmpTrainerName = _cursor.getString(_cursorIndexOfTrainerName);
            }
            final String _tmpTrainerPhone;
            if (_cursor.isNull(_cursorIndexOfTrainerPhone)) {
              _tmpTrainerPhone = null;
            } else {
              _tmpTrainerPhone = _cursor.getString(_cursorIndexOfTrainerPhone);
            }
            final String _tmpDistrictName;
            if (_cursor.isNull(_cursorIndexOfDistrictName)) {
              _tmpDistrictName = null;
            } else {
              _tmpDistrictName = _cursor.getString(_cursorIndexOfDistrictName);
            }
            final String _tmpCenterAddress;
            if (_cursor.isNull(_cursorIndexOfCenterAddress)) {
              _tmpCenterAddress = null;
            } else {
              _tmpCenterAddress = _cursor.getString(_cursorIndexOfCenterAddress);
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
            final boolean _tmpIsActive;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_1 != 0;
            _item = new Course(_tmpId,_tmpTitle,_tmpCenterName,_tmpTrade,_tmpDuration,_tmpDurationType,_tmpFee,_tmpEligibility,_tmpStartDate,_tmpSeatsLeft,_tmpTotalSeats,_tmpJobGuarantee,_tmpLanguage,_tmpDescription,_tmpSyllabus,_tmpTrainerName,_tmpTrainerPhone,_tmpDistrictName,_tmpCenterAddress,_tmpIconEmoji,_tmpBannerColor,_tmpIsActive);
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
  public LiveData<List<Course>> getCoursesByTrade(final String trade) {
    final String _sql = "SELECT * FROM courses WHERE isActive = 1 AND trade LIKE '%' || ? || '%' ORDER BY startDate ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (trade == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, trade);
    }
    return __db.getInvalidationTracker().createLiveData(new String[] {"courses"}, false, new Callable<List<Course>>() {
      @Override
      @Nullable
      public List<Course> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfCenterName = CursorUtil.getColumnIndexOrThrow(_cursor, "centerName");
          final int _cursorIndexOfTrade = CursorUtil.getColumnIndexOrThrow(_cursor, "trade");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfDurationType = CursorUtil.getColumnIndexOrThrow(_cursor, "durationType");
          final int _cursorIndexOfFee = CursorUtil.getColumnIndexOrThrow(_cursor, "fee");
          final int _cursorIndexOfEligibility = CursorUtil.getColumnIndexOrThrow(_cursor, "eligibility");
          final int _cursorIndexOfStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "startDate");
          final int _cursorIndexOfSeatsLeft = CursorUtil.getColumnIndexOrThrow(_cursor, "seatsLeft");
          final int _cursorIndexOfTotalSeats = CursorUtil.getColumnIndexOrThrow(_cursor, "totalSeats");
          final int _cursorIndexOfJobGuarantee = CursorUtil.getColumnIndexOrThrow(_cursor, "jobGuarantee");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfSyllabus = CursorUtil.getColumnIndexOrThrow(_cursor, "syllabus");
          final int _cursorIndexOfTrainerName = CursorUtil.getColumnIndexOrThrow(_cursor, "trainerName");
          final int _cursorIndexOfTrainerPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "trainerPhone");
          final int _cursorIndexOfDistrictName = CursorUtil.getColumnIndexOrThrow(_cursor, "districtName");
          final int _cursorIndexOfCenterAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "centerAddress");
          final int _cursorIndexOfIconEmoji = CursorUtil.getColumnIndexOrThrow(_cursor, "iconEmoji");
          final int _cursorIndexOfBannerColor = CursorUtil.getColumnIndexOrThrow(_cursor, "bannerColor");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final List<Course> _result = new ArrayList<Course>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Course _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpCenterName;
            if (_cursor.isNull(_cursorIndexOfCenterName)) {
              _tmpCenterName = null;
            } else {
              _tmpCenterName = _cursor.getString(_cursorIndexOfCenterName);
            }
            final String _tmpTrade;
            if (_cursor.isNull(_cursorIndexOfTrade)) {
              _tmpTrade = null;
            } else {
              _tmpTrade = _cursor.getString(_cursorIndexOfTrade);
            }
            final String _tmpDuration;
            if (_cursor.isNull(_cursorIndexOfDuration)) {
              _tmpDuration = null;
            } else {
              _tmpDuration = _cursor.getString(_cursorIndexOfDuration);
            }
            final String _tmpDurationType;
            if (_cursor.isNull(_cursorIndexOfDurationType)) {
              _tmpDurationType = null;
            } else {
              _tmpDurationType = _cursor.getString(_cursorIndexOfDurationType);
            }
            final String _tmpFee;
            if (_cursor.isNull(_cursorIndexOfFee)) {
              _tmpFee = null;
            } else {
              _tmpFee = _cursor.getString(_cursorIndexOfFee);
            }
            final String _tmpEligibility;
            if (_cursor.isNull(_cursorIndexOfEligibility)) {
              _tmpEligibility = null;
            } else {
              _tmpEligibility = _cursor.getString(_cursorIndexOfEligibility);
            }
            final String _tmpStartDate;
            if (_cursor.isNull(_cursorIndexOfStartDate)) {
              _tmpStartDate = null;
            } else {
              _tmpStartDate = _cursor.getString(_cursorIndexOfStartDate);
            }
            final int _tmpSeatsLeft;
            _tmpSeatsLeft = _cursor.getInt(_cursorIndexOfSeatsLeft);
            final int _tmpTotalSeats;
            _tmpTotalSeats = _cursor.getInt(_cursorIndexOfTotalSeats);
            final String _tmpJobGuarantee;
            if (_cursor.isNull(_cursorIndexOfJobGuarantee)) {
              _tmpJobGuarantee = null;
            } else {
              _tmpJobGuarantee = _cursor.getString(_cursorIndexOfJobGuarantee);
            }
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final List<String> _tmpSyllabus;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfSyllabus)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfSyllabus);
            }
            _tmpSyllabus = __converters.toStringList(_tmp);
            final String _tmpTrainerName;
            if (_cursor.isNull(_cursorIndexOfTrainerName)) {
              _tmpTrainerName = null;
            } else {
              _tmpTrainerName = _cursor.getString(_cursorIndexOfTrainerName);
            }
            final String _tmpTrainerPhone;
            if (_cursor.isNull(_cursorIndexOfTrainerPhone)) {
              _tmpTrainerPhone = null;
            } else {
              _tmpTrainerPhone = _cursor.getString(_cursorIndexOfTrainerPhone);
            }
            final String _tmpDistrictName;
            if (_cursor.isNull(_cursorIndexOfDistrictName)) {
              _tmpDistrictName = null;
            } else {
              _tmpDistrictName = _cursor.getString(_cursorIndexOfDistrictName);
            }
            final String _tmpCenterAddress;
            if (_cursor.isNull(_cursorIndexOfCenterAddress)) {
              _tmpCenterAddress = null;
            } else {
              _tmpCenterAddress = _cursor.getString(_cursorIndexOfCenterAddress);
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
            final boolean _tmpIsActive;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_1 != 0;
            _item = new Course(_tmpId,_tmpTitle,_tmpCenterName,_tmpTrade,_tmpDuration,_tmpDurationType,_tmpFee,_tmpEligibility,_tmpStartDate,_tmpSeatsLeft,_tmpTotalSeats,_tmpJobGuarantee,_tmpLanguage,_tmpDescription,_tmpSyllabus,_tmpTrainerName,_tmpTrainerPhone,_tmpDistrictName,_tmpCenterAddress,_tmpIconEmoji,_tmpBannerColor,_tmpIsActive);
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
  public LiveData<List<Course>> getCoursesByTradeAndDuration(final String trade,
      final String duration) {
    final String _sql = "SELECT * FROM courses WHERE isActive = 1 AND trade LIKE '%' || ? || '%' AND durationType = ? ORDER BY startDate ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (trade == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, trade);
    }
    _argIndex = 2;
    if (duration == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, duration);
    }
    return __db.getInvalidationTracker().createLiveData(new String[] {"courses"}, false, new Callable<List<Course>>() {
      @Override
      @Nullable
      public List<Course> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfCenterName = CursorUtil.getColumnIndexOrThrow(_cursor, "centerName");
          final int _cursorIndexOfTrade = CursorUtil.getColumnIndexOrThrow(_cursor, "trade");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfDurationType = CursorUtil.getColumnIndexOrThrow(_cursor, "durationType");
          final int _cursorIndexOfFee = CursorUtil.getColumnIndexOrThrow(_cursor, "fee");
          final int _cursorIndexOfEligibility = CursorUtil.getColumnIndexOrThrow(_cursor, "eligibility");
          final int _cursorIndexOfStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "startDate");
          final int _cursorIndexOfSeatsLeft = CursorUtil.getColumnIndexOrThrow(_cursor, "seatsLeft");
          final int _cursorIndexOfTotalSeats = CursorUtil.getColumnIndexOrThrow(_cursor, "totalSeats");
          final int _cursorIndexOfJobGuarantee = CursorUtil.getColumnIndexOrThrow(_cursor, "jobGuarantee");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfSyllabus = CursorUtil.getColumnIndexOrThrow(_cursor, "syllabus");
          final int _cursorIndexOfTrainerName = CursorUtil.getColumnIndexOrThrow(_cursor, "trainerName");
          final int _cursorIndexOfTrainerPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "trainerPhone");
          final int _cursorIndexOfDistrictName = CursorUtil.getColumnIndexOrThrow(_cursor, "districtName");
          final int _cursorIndexOfCenterAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "centerAddress");
          final int _cursorIndexOfIconEmoji = CursorUtil.getColumnIndexOrThrow(_cursor, "iconEmoji");
          final int _cursorIndexOfBannerColor = CursorUtil.getColumnIndexOrThrow(_cursor, "bannerColor");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final List<Course> _result = new ArrayList<Course>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Course _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpCenterName;
            if (_cursor.isNull(_cursorIndexOfCenterName)) {
              _tmpCenterName = null;
            } else {
              _tmpCenterName = _cursor.getString(_cursorIndexOfCenterName);
            }
            final String _tmpTrade;
            if (_cursor.isNull(_cursorIndexOfTrade)) {
              _tmpTrade = null;
            } else {
              _tmpTrade = _cursor.getString(_cursorIndexOfTrade);
            }
            final String _tmpDuration;
            if (_cursor.isNull(_cursorIndexOfDuration)) {
              _tmpDuration = null;
            } else {
              _tmpDuration = _cursor.getString(_cursorIndexOfDuration);
            }
            final String _tmpDurationType;
            if (_cursor.isNull(_cursorIndexOfDurationType)) {
              _tmpDurationType = null;
            } else {
              _tmpDurationType = _cursor.getString(_cursorIndexOfDurationType);
            }
            final String _tmpFee;
            if (_cursor.isNull(_cursorIndexOfFee)) {
              _tmpFee = null;
            } else {
              _tmpFee = _cursor.getString(_cursorIndexOfFee);
            }
            final String _tmpEligibility;
            if (_cursor.isNull(_cursorIndexOfEligibility)) {
              _tmpEligibility = null;
            } else {
              _tmpEligibility = _cursor.getString(_cursorIndexOfEligibility);
            }
            final String _tmpStartDate;
            if (_cursor.isNull(_cursorIndexOfStartDate)) {
              _tmpStartDate = null;
            } else {
              _tmpStartDate = _cursor.getString(_cursorIndexOfStartDate);
            }
            final int _tmpSeatsLeft;
            _tmpSeatsLeft = _cursor.getInt(_cursorIndexOfSeatsLeft);
            final int _tmpTotalSeats;
            _tmpTotalSeats = _cursor.getInt(_cursorIndexOfTotalSeats);
            final String _tmpJobGuarantee;
            if (_cursor.isNull(_cursorIndexOfJobGuarantee)) {
              _tmpJobGuarantee = null;
            } else {
              _tmpJobGuarantee = _cursor.getString(_cursorIndexOfJobGuarantee);
            }
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final List<String> _tmpSyllabus;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfSyllabus)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfSyllabus);
            }
            _tmpSyllabus = __converters.toStringList(_tmp);
            final String _tmpTrainerName;
            if (_cursor.isNull(_cursorIndexOfTrainerName)) {
              _tmpTrainerName = null;
            } else {
              _tmpTrainerName = _cursor.getString(_cursorIndexOfTrainerName);
            }
            final String _tmpTrainerPhone;
            if (_cursor.isNull(_cursorIndexOfTrainerPhone)) {
              _tmpTrainerPhone = null;
            } else {
              _tmpTrainerPhone = _cursor.getString(_cursorIndexOfTrainerPhone);
            }
            final String _tmpDistrictName;
            if (_cursor.isNull(_cursorIndexOfDistrictName)) {
              _tmpDistrictName = null;
            } else {
              _tmpDistrictName = _cursor.getString(_cursorIndexOfDistrictName);
            }
            final String _tmpCenterAddress;
            if (_cursor.isNull(_cursorIndexOfCenterAddress)) {
              _tmpCenterAddress = null;
            } else {
              _tmpCenterAddress = _cursor.getString(_cursorIndexOfCenterAddress);
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
            final boolean _tmpIsActive;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_1 != 0;
            _item = new Course(_tmpId,_tmpTitle,_tmpCenterName,_tmpTrade,_tmpDuration,_tmpDurationType,_tmpFee,_tmpEligibility,_tmpStartDate,_tmpSeatsLeft,_tmpTotalSeats,_tmpJobGuarantee,_tmpLanguage,_tmpDescription,_tmpSyllabus,_tmpTrainerName,_tmpTrainerPhone,_tmpDistrictName,_tmpCenterAddress,_tmpIconEmoji,_tmpBannerColor,_tmpIsActive);
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
  public Object getCourseById(final int id, final Continuation<? super Course> $completion) {
    final String _sql = "SELECT * FROM courses WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Course>() {
      @Override
      @Nullable
      public Course call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfCenterName = CursorUtil.getColumnIndexOrThrow(_cursor, "centerName");
          final int _cursorIndexOfTrade = CursorUtil.getColumnIndexOrThrow(_cursor, "trade");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfDurationType = CursorUtil.getColumnIndexOrThrow(_cursor, "durationType");
          final int _cursorIndexOfFee = CursorUtil.getColumnIndexOrThrow(_cursor, "fee");
          final int _cursorIndexOfEligibility = CursorUtil.getColumnIndexOrThrow(_cursor, "eligibility");
          final int _cursorIndexOfStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "startDate");
          final int _cursorIndexOfSeatsLeft = CursorUtil.getColumnIndexOrThrow(_cursor, "seatsLeft");
          final int _cursorIndexOfTotalSeats = CursorUtil.getColumnIndexOrThrow(_cursor, "totalSeats");
          final int _cursorIndexOfJobGuarantee = CursorUtil.getColumnIndexOrThrow(_cursor, "jobGuarantee");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfSyllabus = CursorUtil.getColumnIndexOrThrow(_cursor, "syllabus");
          final int _cursorIndexOfTrainerName = CursorUtil.getColumnIndexOrThrow(_cursor, "trainerName");
          final int _cursorIndexOfTrainerPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "trainerPhone");
          final int _cursorIndexOfDistrictName = CursorUtil.getColumnIndexOrThrow(_cursor, "districtName");
          final int _cursorIndexOfCenterAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "centerAddress");
          final int _cursorIndexOfIconEmoji = CursorUtil.getColumnIndexOrThrow(_cursor, "iconEmoji");
          final int _cursorIndexOfBannerColor = CursorUtil.getColumnIndexOrThrow(_cursor, "bannerColor");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final Course _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpCenterName;
            if (_cursor.isNull(_cursorIndexOfCenterName)) {
              _tmpCenterName = null;
            } else {
              _tmpCenterName = _cursor.getString(_cursorIndexOfCenterName);
            }
            final String _tmpTrade;
            if (_cursor.isNull(_cursorIndexOfTrade)) {
              _tmpTrade = null;
            } else {
              _tmpTrade = _cursor.getString(_cursorIndexOfTrade);
            }
            final String _tmpDuration;
            if (_cursor.isNull(_cursorIndexOfDuration)) {
              _tmpDuration = null;
            } else {
              _tmpDuration = _cursor.getString(_cursorIndexOfDuration);
            }
            final String _tmpDurationType;
            if (_cursor.isNull(_cursorIndexOfDurationType)) {
              _tmpDurationType = null;
            } else {
              _tmpDurationType = _cursor.getString(_cursorIndexOfDurationType);
            }
            final String _tmpFee;
            if (_cursor.isNull(_cursorIndexOfFee)) {
              _tmpFee = null;
            } else {
              _tmpFee = _cursor.getString(_cursorIndexOfFee);
            }
            final String _tmpEligibility;
            if (_cursor.isNull(_cursorIndexOfEligibility)) {
              _tmpEligibility = null;
            } else {
              _tmpEligibility = _cursor.getString(_cursorIndexOfEligibility);
            }
            final String _tmpStartDate;
            if (_cursor.isNull(_cursorIndexOfStartDate)) {
              _tmpStartDate = null;
            } else {
              _tmpStartDate = _cursor.getString(_cursorIndexOfStartDate);
            }
            final int _tmpSeatsLeft;
            _tmpSeatsLeft = _cursor.getInt(_cursorIndexOfSeatsLeft);
            final int _tmpTotalSeats;
            _tmpTotalSeats = _cursor.getInt(_cursorIndexOfTotalSeats);
            final String _tmpJobGuarantee;
            if (_cursor.isNull(_cursorIndexOfJobGuarantee)) {
              _tmpJobGuarantee = null;
            } else {
              _tmpJobGuarantee = _cursor.getString(_cursorIndexOfJobGuarantee);
            }
            final String _tmpLanguage;
            if (_cursor.isNull(_cursorIndexOfLanguage)) {
              _tmpLanguage = null;
            } else {
              _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final List<String> _tmpSyllabus;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfSyllabus)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfSyllabus);
            }
            _tmpSyllabus = __converters.toStringList(_tmp);
            final String _tmpTrainerName;
            if (_cursor.isNull(_cursorIndexOfTrainerName)) {
              _tmpTrainerName = null;
            } else {
              _tmpTrainerName = _cursor.getString(_cursorIndexOfTrainerName);
            }
            final String _tmpTrainerPhone;
            if (_cursor.isNull(_cursorIndexOfTrainerPhone)) {
              _tmpTrainerPhone = null;
            } else {
              _tmpTrainerPhone = _cursor.getString(_cursorIndexOfTrainerPhone);
            }
            final String _tmpDistrictName;
            if (_cursor.isNull(_cursorIndexOfDistrictName)) {
              _tmpDistrictName = null;
            } else {
              _tmpDistrictName = _cursor.getString(_cursorIndexOfDistrictName);
            }
            final String _tmpCenterAddress;
            if (_cursor.isNull(_cursorIndexOfCenterAddress)) {
              _tmpCenterAddress = null;
            } else {
              _tmpCenterAddress = _cursor.getString(_cursorIndexOfCenterAddress);
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
            final boolean _tmpIsActive;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_1 != 0;
            _result = new Course(_tmpId,_tmpTitle,_tmpCenterName,_tmpTrade,_tmpDuration,_tmpDurationType,_tmpFee,_tmpEligibility,_tmpStartDate,_tmpSeatsLeft,_tmpTotalSeats,_tmpJobGuarantee,_tmpLanguage,_tmpDescription,_tmpSyllabus,_tmpTrainerName,_tmpTrainerPhone,_tmpDistrictName,_tmpCenterAddress,_tmpIconEmoji,_tmpBannerColor,_tmpIsActive);
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

  @Override
  public Object getCourseCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM courses WHERE isActive = 1";
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
