# Gemini Project Log

This file tracks the setup and development of the Tool2 Android project.

## Initial Setup

- Initialized the project as a standard Android Gradle project.
- Created `README.MD` and this `GEMINI.md` file.

## Feature Implementation

### Material 3 and Navigation

- Verified that the Material 3 dependency (`androidx.compose.material3`) was included in the project.
- Added the Jetpack Navigation Compose dependency (`androidx.navigation:navigation-compose:2.7.7`) to the project's Gradle files (`app/build.gradle.kts` and `gradle/libs.versions.toml`).
- Implemented a bottom navigation bar with three tabs: Home, Profile, and Settings.

### Code Refactoring and Best Practices

- Refactored the initial UI code from `MainActivity.kt`.
- Organized composables into a structured directory format:
    - Screen composables (`HomeScreen.kt`, `ProfileScreen.kt`, `SettingsScreen.kt`) were moved to `app/src/main/java/io/github/hyunjae/tool/ui/screens/`.
    - Navigation-related components (`BottomNavigationBar.kt`, `NavigationGraph.kt`, `Screen.kt`) were moved to `app/src/main/java/io/github/hyunjae/tool/ui/navigation/`.
- Ensured the project builds successfully after all changes.

## Architecture

- Set up the project to follow Clean Architecture.
- Created `domain`, `data`, and `presentation` modules.
- The `domain` module is a pure Kotlin module.
- The `data` module is an Android library module and depends on the `domain` module.
- The `presentation` module is an Android library module and depends on the `domain` module.
- The `app` module depends on the `presentation` module.
- Created `.gitignore` files in `domain`, `data`, and `presentation` modules to exclude build artifacts.
- Untracked files that should be ignored by Git based on the `.gitignore` rules.
