# Tool2 Android Project

This is an Android project built with Jetpack Compose and Material 3, following a Clean Architecture approach.

## Architecture

The project is structured into the following modules:

- **`app`**: The main application module, responsible for integrating all other modules and launching the UI.
- **`presentation`**: Contains the UI layer, including Composables, ViewModels, and navigation logic. It depends on the `domain` module.
- **`data`**: Implements the data layer, handling data sources (e.g., network, database) and repositories. It depends on the `domain` module.
- **`domain`**: The core business logic layer, containing use cases, entities, and interfaces. It is a pure Kotlin module and has no dependencies on other layers.

## Features

- **Material 3 Design**: Utilizes the latest Material Design guidelines for a modern and consistent user experience.
- **Jetpack Compose**: Built entirely with Jetpack Compose for a declarative UI development experience.
- **Bottom Navigation Bar**: Includes a three-tab bottom navigation bar for easy navigation between Home, Profile, and Settings screens.

## Getting Started

To run this project, open it in Android Studio and sync the Gradle files. You can then run the `app` module on an Android emulator or device.