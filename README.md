
# Namma-Skill Android App 🎓

**Skill India · Self Employment Tracker**

A vocational course finder app that bridges the gap between government skill centers and rural youth.

---

## 📁 Project Structure

```
NammaSkill/
├── app/
│   ├── src/main/
│   │   ├── java/com/nammaskill/app/
│   │   │   ├── data/
│   │   │   │   ├── model/          # Course, UserProfile, Application, SuccessStory
│   │   │   │   └── repository/     # Room DAOs, Database, Repository, SeedData
│   │   │   ├── ui/
│   │   │   │   ├── onboarding/     # Splash, Onboarding, UserProfileSetup
│   │   │   │   ├── home/           # HomeFragment
│   │   │   │   ├── courses/        # CoursesFragment, CourseAdapter, AddCourseFragment
│   │   │   │   ├── detail/         # CourseDetailFragment
│   │   │   │   ├── apply/          # ApplyFragment, PingFragment, ApplicationAdapter
│   │   │   │   ├── map/            # MapFragment, CenterAdapter
│   │   │   │   ├── stories/        # StoriesFragment, StoryAdapter
│   │   │   │   ├── profile/        # ProfileFragment
│   │   │   │   ├── MainActivity.kt
│   │   │   │   └── MainViewModel.kt
│   │   │   └── utils/              # Converters, PrefManager
│   │   ├── res/
│   │   │   ├── layout/             # All XML layouts
│   │   │   ├── navigation/         # nav_graph.xml
│   │   │   ├── drawable/           # Backgrounds, icons
│   │   │   ├── color/              # Selectors
│   │   │   ├── values/             # colors, strings, themes
│   │   │   └── menu/               # bottom_nav_menu
│   │   └── AndroidManifest.xml
│   └── build.gradle.kts
├── gradle/libs.versions.toml
├── build.gradle.kts
└── settings.gradle.kts
```

---

## 🚀 How to Open in Android Studio

### Step 1 — Prerequisites
- Android Studio **Hedgehog (2023.1.1)** or newer
- JDK 17+
- Android SDK 34

### Step 2 — Open Project
1. Extract the ZIP file
2. Open Android Studio → **File → Open**
3. Select the `NammaSkill` folder (the one containing `settings.gradle.kts`)
4. Click **OK** and wait for Gradle sync

### Step 3 — Gradle Sync
- Android Studio will auto-sync. If it fails, go to **File → Sync Project with Gradle Files**
- If prompted about JDK, select JDK 17

### Step 4 — Run the App
- Connect an Android device (API 24+) or start an emulator
- Click the ▶ Run button

---

## 📱 Features Implemented

| Feature | Status |
|---|---|
| Splash Screen | ✅ |
| 4-page Onboarding | ✅ |
| User Profile Setup (full input form) | ✅ |
| Course Finder with Trade ChipGroups | ✅ |
| Duration Filter (Short/Long Term) | ✅ |
| Course Detail Screen | ✅ |
| One-tap Apply with Candidate Summary | ✅ |
| Reference ID generation | ✅ |
| Interest Ping (Callback request) | ✅ |
| Skill Centers Map & District Filter | ✅ |
| Google Maps SDK Integration | ⏳ (Add API Key) |
| Success Stories | ✅ |
| Profile & Notification Settings | ✅ |
| Add Custom Course (admin) | ✅ |
| Room Database (offline-first) | ✅ |
| Pre-seeded with 8 real courses | ✅ |
| Pre-seeded with 5 success stories | ✅ |
| ViewModel + LiveData (MVVM) | ✅ |
| Bottom Navigation | ✅ |

---

## 🔧 Tech Stack

- **Language**: Kotlin
- **Architecture**: MVVM (ViewModel + LiveData)
- **Database**: Room (SQLite)
- **Navigation**: Jetpack Navigation Component
- **UI**: Material Design 3, ViewBinding
- **Maps**: Google Maps SDK for Android

---

## 📌 Next Steps (Planned Enhancements)

1. **Firebase Firestore** — Replace Room seed data with live Firestore course batches
2. **FCM Push Notifications** — Alert users when new batches start
---

## 🏆 Impact Goals (Skill India)
- Bridge training infrastructure and rural youth
- Ensure equal access to vocational opportunities
- Reduce unemployment in Karnataka districts

*Built for Namma-Skill · Skill India Initiative*
