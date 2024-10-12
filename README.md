# Gemini Bot

Gemini Bot is a mobile application built using Android Studio and Kotlin. The app utilizes Jetpack Compose for building UI components, integrates ViewModel for managing app state, and employs modern state management principles. Additionally, it leverages generative AI features to create dynamic, interactive responses.

## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Setup & Installation](#setup--installation)
- [Architecture](#architecture)
- [Usage](#usage)
- [State Management](#state-management)


## Features

- **Generative AI Integration:** Leverages AI models for generating bot responses.
- **Modern Android Development:** Built using Kotlin, Jetpack Compose, and the MVVM architecture.
- **Real-time State Management:** Efficient state handling using Jetpack Compose's `@State` and `ViewModel`.
- **Responsive UI:** Clean and dynamic UI powered by Jetpack Compose.
- **Easy Extensibility:** Simple to extend the bot’s behavior with new features and commands.

## Tech Stack

- **Kotlin**: The primary language for Android development.
- **Jetpack Compose**: For building declarative UIs.
- **ViewModel**: Part of Android's architecture components, helps manage UI-related data lifecycle.
- **State Management**: Managed using Jetpack Compose’s `@State` and `MutableState`.
- **Generative AI**: Powered by an AI model integrated to generate conversational responses.

## Setup & Installation

### Prerequisites

Ensure you have the following setup on your system:

- Android Studio (version 4.2 or higher)
- Kotlin 1.5+
- Gradle 6.7 or higher

### Steps

1. **Clone the Repository:**

   Clone the repository from GitHub:
   ```bash
   git clone https://github.com/Sighmore/Gemini-Bot.git
   cd Gemini-Bot
   ```

2. **Open the Project in Android Studio:**

   Open Android Studio and choose the project directory to load.

3. **Sync Gradle:**

   Let Android Studio sync Gradle dependencies automatically, or you can trigger it manually by clicking "Sync Now."

4. **Run the Project:**

   Select a device or emulator and click the "Run" button in Android Studio to launch the Gemini Bot app.

## Architecture

Gemini Bot follows the **MVVM (Model-View-ViewModel)** architecture pattern, which separates UI logic from business logic and enables more maintainable, testable, and scalable code.

### Key Components

- **ViewModel:** Handles the business logic and interacts with the generative AI model.
- **Jetpack Compose:** For building declarative UIs that respond to state changes.
- **State Management:** Uses `MutableState` variables and Jetpack Compose’s state functions like `remember` and `@State` annotations to track and update UI in real-time.

## Usage

### Main Features

- **Generative AI Responses:**
   - The bot responds to user input by using a generative AI model embedded within the app's architecture.
   - To use, simply type a command or a question into the input field, and the bot will respond with generated content.

- **State-Managed UI:**
   - The app UI updates dynamically in response to changes in state.
   - UI components are written using Jetpack Compose to render layouts declaratively.

### Example Workflow

1. Type a message or query into the input field.
2. The message is passed to the ViewModel, which processes the query.
3. The AI generates a response, and the state in the ViewModel is updated.
4. Jetpack Compose reacts to the state change and re-renders the UI with the new bot response.

## State Management

Gemini Bot's state is managed with **Jetpack Compose** and **ViewModel**. The key principles include:

- **@State:** Annotations are used to define state variables within the Composable functions.
- **ViewModel:** Maintains app state across configuration changes.
- **LiveData & MutableState:** Used to notify the UI of changes, ensuring that any UI components depending on the state are re-composed when the state changes.

