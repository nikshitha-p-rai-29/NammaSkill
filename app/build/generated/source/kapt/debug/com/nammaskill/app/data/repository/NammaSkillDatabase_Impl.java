package com.nammaskill.app.data.repository;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class NammaSkillDatabase_Impl extends NammaSkillDatabase {
  private volatile CourseDao _courseDao;

  private volatile UserProfileDao _userProfileDao;

  private volatile ApplicationDao _applicationDao;

  private volatile StoryDao _storyDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `courses` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT NOT NULL, `centerName` TEXT NOT NULL, `trade` TEXT NOT NULL, `duration` TEXT NOT NULL, `durationType` TEXT NOT NULL, `fee` TEXT NOT NULL, `eligibility` TEXT NOT NULL, `startDate` TEXT NOT NULL, `seatsLeft` INTEGER NOT NULL, `totalSeats` INTEGER NOT NULL, `jobGuarantee` TEXT NOT NULL, `language` TEXT NOT NULL, `description` TEXT NOT NULL, `syllabus` TEXT NOT NULL, `trainerName` TEXT NOT NULL, `trainerPhone` TEXT NOT NULL, `districtName` TEXT NOT NULL, `centerAddress` TEXT NOT NULL, `iconEmoji` TEXT NOT NULL, `bannerColor` TEXT NOT NULL, `isActive` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `user_profile` (`id` INTEGER NOT NULL, `fullName` TEXT NOT NULL, `age` TEXT NOT NULL, `gender` TEXT NOT NULL, `phone` TEXT NOT NULL, `district` TEXT NOT NULL, `village` TEXT NOT NULL, `education` TEXT NOT NULL, `preferredTrades` TEXT NOT NULL, `aadhaarLast4` TEXT NOT NULL, `isProfileComplete` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `applications` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `courseId` INTEGER NOT NULL, `courseTitle` TEXT NOT NULL, `centerName` TEXT NOT NULL, `appliedDate` TEXT NOT NULL, `status` TEXT NOT NULL, `referenceId` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `success_stories` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `personName` TEXT NOT NULL, `age` INTEGER NOT NULL, `location` TEXT NOT NULL, `trade` TEXT NOT NULL, `courseTaken` TEXT NOT NULL, `currentJob` TEXT NOT NULL, `monthlySalary` TEXT NOT NULL, `quote` TEXT NOT NULL, `iconEmoji` TEXT NOT NULL, `bannerColor` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'fe83b505498d49536c74605907cde044')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `courses`");
        db.execSQL("DROP TABLE IF EXISTS `user_profile`");
        db.execSQL("DROP TABLE IF EXISTS `applications`");
        db.execSQL("DROP TABLE IF EXISTS `success_stories`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsCourses = new HashMap<String, TableInfo.Column>(22);
        _columnsCourses.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCourses.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCourses.put("centerName", new TableInfo.Column("centerName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCourses.put("trade", new TableInfo.Column("trade", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCourses.put("duration", new TableInfo.Column("duration", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCourses.put("durationType", new TableInfo.Column("durationType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCourses.put("fee", new TableInfo.Column("fee", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCourses.put("eligibility", new TableInfo.Column("eligibility", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCourses.put("startDate", new TableInfo.Column("startDate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCourses.put("seatsLeft", new TableInfo.Column("seatsLeft", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCourses.put("totalSeats", new TableInfo.Column("totalSeats", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCourses.put("jobGuarantee", new TableInfo.Column("jobGuarantee", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCourses.put("language", new TableInfo.Column("language", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCourses.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCourses.put("syllabus", new TableInfo.Column("syllabus", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCourses.put("trainerName", new TableInfo.Column("trainerName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCourses.put("trainerPhone", new TableInfo.Column("trainerPhone", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCourses.put("districtName", new TableInfo.Column("districtName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCourses.put("centerAddress", new TableInfo.Column("centerAddress", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCourses.put("iconEmoji", new TableInfo.Column("iconEmoji", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCourses.put("bannerColor", new TableInfo.Column("bannerColor", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCourses.put("isActive", new TableInfo.Column("isActive", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCourses = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCourses = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCourses = new TableInfo("courses", _columnsCourses, _foreignKeysCourses, _indicesCourses);
        final TableInfo _existingCourses = TableInfo.read(db, "courses");
        if (!_infoCourses.equals(_existingCourses)) {
          return new RoomOpenHelper.ValidationResult(false, "courses(com.nammaskill.app.data.model.Course).\n"
                  + " Expected:\n" + _infoCourses + "\n"
                  + " Found:\n" + _existingCourses);
        }
        final HashMap<String, TableInfo.Column> _columnsUserProfile = new HashMap<String, TableInfo.Column>(11);
        _columnsUserProfile.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfile.put("fullName", new TableInfo.Column("fullName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfile.put("age", new TableInfo.Column("age", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfile.put("gender", new TableInfo.Column("gender", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfile.put("phone", new TableInfo.Column("phone", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfile.put("district", new TableInfo.Column("district", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfile.put("village", new TableInfo.Column("village", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfile.put("education", new TableInfo.Column("education", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfile.put("preferredTrades", new TableInfo.Column("preferredTrades", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfile.put("aadhaarLast4", new TableInfo.Column("aadhaarLast4", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfile.put("isProfileComplete", new TableInfo.Column("isProfileComplete", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserProfile = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUserProfile = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUserProfile = new TableInfo("user_profile", _columnsUserProfile, _foreignKeysUserProfile, _indicesUserProfile);
        final TableInfo _existingUserProfile = TableInfo.read(db, "user_profile");
        if (!_infoUserProfile.equals(_existingUserProfile)) {
          return new RoomOpenHelper.ValidationResult(false, "user_profile(com.nammaskill.app.data.model.UserProfile).\n"
                  + " Expected:\n" + _infoUserProfile + "\n"
                  + " Found:\n" + _existingUserProfile);
        }
        final HashMap<String, TableInfo.Column> _columnsApplications = new HashMap<String, TableInfo.Column>(7);
        _columnsApplications.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsApplications.put("courseId", new TableInfo.Column("courseId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsApplications.put("courseTitle", new TableInfo.Column("courseTitle", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsApplications.put("centerName", new TableInfo.Column("centerName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsApplications.put("appliedDate", new TableInfo.Column("appliedDate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsApplications.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsApplications.put("referenceId", new TableInfo.Column("referenceId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysApplications = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesApplications = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoApplications = new TableInfo("applications", _columnsApplications, _foreignKeysApplications, _indicesApplications);
        final TableInfo _existingApplications = TableInfo.read(db, "applications");
        if (!_infoApplications.equals(_existingApplications)) {
          return new RoomOpenHelper.ValidationResult(false, "applications(com.nammaskill.app.data.model.Application).\n"
                  + " Expected:\n" + _infoApplications + "\n"
                  + " Found:\n" + _existingApplications);
        }
        final HashMap<String, TableInfo.Column> _columnsSuccessStories = new HashMap<String, TableInfo.Column>(11);
        _columnsSuccessStories.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSuccessStories.put("personName", new TableInfo.Column("personName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSuccessStories.put("age", new TableInfo.Column("age", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSuccessStories.put("location", new TableInfo.Column("location", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSuccessStories.put("trade", new TableInfo.Column("trade", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSuccessStories.put("courseTaken", new TableInfo.Column("courseTaken", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSuccessStories.put("currentJob", new TableInfo.Column("currentJob", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSuccessStories.put("monthlySalary", new TableInfo.Column("monthlySalary", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSuccessStories.put("quote", new TableInfo.Column("quote", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSuccessStories.put("iconEmoji", new TableInfo.Column("iconEmoji", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSuccessStories.put("bannerColor", new TableInfo.Column("bannerColor", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSuccessStories = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSuccessStories = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSuccessStories = new TableInfo("success_stories", _columnsSuccessStories, _foreignKeysSuccessStories, _indicesSuccessStories);
        final TableInfo _existingSuccessStories = TableInfo.read(db, "success_stories");
        if (!_infoSuccessStories.equals(_existingSuccessStories)) {
          return new RoomOpenHelper.ValidationResult(false, "success_stories(com.nammaskill.app.data.model.SuccessStory).\n"
                  + " Expected:\n" + _infoSuccessStories + "\n"
                  + " Found:\n" + _existingSuccessStories);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "fe83b505498d49536c74605907cde044", "f80d355057341d7f509c8be41807978a");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "courses","user_profile","applications","success_stories");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `courses`");
      _db.execSQL("DELETE FROM `user_profile`");
      _db.execSQL("DELETE FROM `applications`");
      _db.execSQL("DELETE FROM `success_stories`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(CourseDao.class, CourseDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(UserProfileDao.class, UserProfileDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ApplicationDao.class, ApplicationDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(StoryDao.class, StoryDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public CourseDao courseDao() {
    if (_courseDao != null) {
      return _courseDao;
    } else {
      synchronized(this) {
        if(_courseDao == null) {
          _courseDao = new CourseDao_Impl(this);
        }
        return _courseDao;
      }
    }
  }

  @Override
  public UserProfileDao userProfileDao() {
    if (_userProfileDao != null) {
      return _userProfileDao;
    } else {
      synchronized(this) {
        if(_userProfileDao == null) {
          _userProfileDao = new UserProfileDao_Impl(this);
        }
        return _userProfileDao;
      }
    }
  }

  @Override
  public ApplicationDao applicationDao() {
    if (_applicationDao != null) {
      return _applicationDao;
    } else {
      synchronized(this) {
        if(_applicationDao == null) {
          _applicationDao = new ApplicationDao_Impl(this);
        }
        return _applicationDao;
      }
    }
  }

  @Override
  public StoryDao storyDao() {
    if (_storyDao != null) {
      return _storyDao;
    } else {
      synchronized(this) {
        if(_storyDao == null) {
          _storyDao = new StoryDao_Impl(this);
        }
        return _storyDao;
      }
    }
  }
}
