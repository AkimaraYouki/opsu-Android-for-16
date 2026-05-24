# [opsu!](https://itdelatrisu.github.io/opsu/) — Android (Modern Compatibility Fix)

A fork of [opsu-Android](https://github.com/AnirudhRahul/opsu-Android), which itself is a fork of [opsu!](https://github.com/fluddokt/opsu) using libGDX to fake Slick2D's API.

This branch modernizes the project to run on **Android 11+ (API 30+)** with current build tools.

---

## What was fixed

### Build system
- **Android Gradle Plugin**: `3.4.1` → `8.9.1`
- **Gradle wrapper**: `8.10` → `8.11.1`
- **compileSdk / targetSdk**: `29` → `35`
- **minSdk**: `18` → `21`
- Removed dead repositories: `jcenter()`, `maven.fabric.io`
- Removed Fabric/Crashlytics SDK (service shut down)
- Disabled AdMob / Firebase (no `google-services.json`)
- Fixed `compile` → `implementation` / `api` (AGP 7+ requirement)
- Fixed `java-library` plugin for `:core` module (`api` configuration)
- Fixed Kotlin stdlib version conflicts (forced to `1.8.22`)
- Added `namespace` to `android/build.gradle` (AGP 8.x requirement)
- Added `android.useAndroidX=true` / `android.enableJetifier=true`

### Android compatibility
- Added `android:exported="true"` to launcher activity (Android 12+ requirement)
- Added `android:requestLegacyExternalStorage="true"` (Android 10 compatibility)
- Fixed **Scoped Storage** (Android 10+): replaced hardcoded `./opsu` path with `DeviceInfo.getDataDir()` so the app creates `/storage/emulated/0/opsu/` correctly
- Added `MANAGE_EXTERNAL_STORAGE` permission (Android 11+) for full Downloads folder access
- Runtime permission request via `Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION`
- Updated storage permissions with proper API-level limits

### Features
- **Auto `.osz` import from Downloads folder**: on startup, the app scans the Downloads folder for `.osz` beatmap files, unpacks them to `Songs/`, and deletes the originals — no manual file moving needed
- Auto `.sk` skin import from Downloads folder

---

## First launch (Android 11+)

1. Open the app → **"Allow access to manage all files"** settings screen appears
2. Toggle **on** → press back
3. **Force-close and reopen the app** ← required once after granting permission
4. `/storage/emulated/0/opsu/` folder is created automatically

From then on, drop `.osz` files into your Downloads folder and they'll be imported on next launch.

---

## Building

Open the project in **Android Studio Meerkat (2024.3+)** or later.

1. Clone the repo
2. Open as an existing Android project
3. Let Gradle sync finish
4. Build → **Build APK** or run on a connected device

> Debugging over USB works fine. To test Downloads import, push `.osz` files via `adb push file.osz /storage/emulated/0/Download/`.

---

## File structure (on device)

```
/storage/emulated/0/opsu/
├── Songs/       ← beatmaps
├── Skins/       ← skins
├── Import/      ← manual import folder
├── Replays/
└── Screenshots/
```

---

## License
**This software is licensed under GNU GPL version 3.**
Full license text: [LICENSE](LICENSE)

Original opsu! (desktop): https://github.com/itdelatrisu/opsu  
Original opsu-Android: https://github.com/AnirudhRahul/opsu-Android
