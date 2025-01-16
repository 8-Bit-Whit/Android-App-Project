# Colorado STEM Ecosystem Android App

## What this app does

The Colorado STEM Ecosystem Android App is designed to connect and inform stakeholders in the STEM education community across Colorado. It offers the following key features:

1. Information about the Colorado STEM Ecosystem
2. A network visualization of ecosystem partners
3. Resources for STEM education
4. Ability to join or contact the ecosystem
5. Information on the ecosystem's mission and how to donate
6. Fun STEM Facts featuring random number facts and NASA's Astronomy Picture of the Day

The app aims to facilitate collaboration, share resources, and promote STEM education initiatives throughout Colorado.

## Overview

This Android application serves as a mobile platform for the Colorado STEM Ecosystem, providing information, resources, and networking opportunities for STEM education stakeholders in Colorado.

## Features

- **Home Screen**: Introduces users to the app and provides navigation to other sections.
- **Login**: Members able to login to a welcome screen. 
            *Current username and password are set to: 
            username: user
            password: password
- **About Ecosystem**: Detailed information about the Colorado STEM Ecosystem.
- **Join**: Allows users to join the ecosystem or request more information.
- **Network**: Displays a visualization of the ecosystem's network and stakeholders.
- **Mission**: Outlines the mission and goals of the Colorado STEM Ecosystem.
- **Donate**: Provides information on how to support the ecosystem.
- **Contact**: Contact information and form for reaching out to the organization.
- **Resources**: Links to various STEM education resources and partner organizations.
- **Fun STEM Facts**: Features fun number facts from the Numbers API and NASA Astronomy Pictures of the Day (APOD).

## Technical Implementation

- Developed for Android using Kotlin
- Implements Jetpack Navigation for seamless navigation between fragments
- Uses a NavigationDrawer for main menu navigation
- Includes tablet-specific layouts for better use of screen real estate on larger devices
- Implements message passing between fragments and activities for data transfer
- Utilizes Retrofit for API calls to Numbers API and NASA APOD API
- Uses Moshi for JSON parsing
- Implements Glide for efficient image loading and caching
- Creates a custom RecyclerView adapter (APODAdapter) for displaying APOD items

## Key Components

- Multiple Activities: MainActivity, LoginActivity, WelcomeActivity
- 9+ Fragments: HomeFragment, AboutEcoFragment, JoinFragment, NetworkFragment, MissionFragment, DonateFragment, ContactFragment, ResourcesFragment, FunSTEMFactsFragment
- Advanced Navigation: Drawer navigation with Jetpack Navigation
- Tablet Support: Includes sw600dp layouts for tablet optimization
- API Integration: Fetches data from Numbers API and NASA APOD API

## Setup and Installation
## How to run the app

1. Clone the repository
2. Open the project in Android Studio
3. Wait for Gradle to sync and download necessary dependencies
4. Connect an android device or emulator
5. Click the 'Run' button in Android Studio to build and run the app on your device

Note: Ensure you have the latest version of Android Studio and the Android SDK installed.

## Requirements

- Android Studio 4.0+
- Android SDK 21+
- Kotlin 1.5+
- Valid NASA API key for APOD feature

## Gradle Dependencies
-   implementation ("com.squareup.retrofit2:retrofit:2.9.0") 
    implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation ("com.squareup.moshi:moshi-kotlin:1.12.0")

    implementation ("com.github.bumptech.glide:glide:4.12.0")
    implementation ("androidx.recyclerview:recyclerview:1.2.1")
    implementation ("com.github.bumptech.glide:glide:4.12.0")
    
  ## Gradle Plugins  
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)


## How to use the app

1. Upon launching, you'll see the home screen with an overview of the ecosystem
2. Use the navigation drawer (accessible by swiping from the left edge or tapping the menu icon) to access different sections of the app
3. Explore each section for specific information:
   - About: Learn about the Colorado STEM Ecosystem
   - Join: Fill out a membership form, linked to web, to join the ecosystem
   - Network: View a visualization of the ecosystem's partners
   - Mission: Read about the ecosystem's goals and objectives
   - Donate: Find information on how to support the ecosystem
   - Contact: Get in touch with the ecosystem organizers
   - Resources: Access STEM education resources and partner links
   - Fun STEM Facts: View random math facts and NASA's Astronomy Pictures of the Day
4. In the Fun STEM Facts section:
   - View the current random math fact
   - Click "Fetch New Fact" to get a new random math fact
   - Scroll down to see recent Astronomy Pictures of the Day
5. Use the back button, home icon, or navigation drawer to navigate between screens

## Third-party sources used

1. Android Jetpack Libraries (androidx.*): For modern Android development practices
2. Material Design Components: For consistent and modern UI elements
3. [Kumu](https://kumu.io/): Used for creating and embedding the network visualization
4. [Google Forms](https://www.google.com/forms/about/): Used for the 'Join' form functionality
5. Retrofit: For making API calls to Numbers API and NASA APOD API
6. Moshi: For JSON parsing
7. Glide: For efficient image loading and caching
8. NASA API for Astronomy Picture of the Day (APOD): https://api.nasa.gov/
9. Numbers API for interesting facts about numbers: http://numbersapi.com/

## Additional Information

- The app is designed to work on both phones and tablets, with a specific layout for larger screens (tablets)
- Internet connection is required for some features like the network visualization, accessing external resources, and fetching STEM facts and APOD images
- The app uses Jetpack Navigation for handling navigation between different sections
- Data is passed between different parts of the app using Android's built-in message passing mechanisms

For developers looking to contribute or modify the app, please refer to the inline code comments for more detailed information about each component's functionality.

## Contributing

Contributions to improve the app are welcome. Please follow these steps:

1. Fork the repository
2. Create a new branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Contact

Whitney Haddad - whaddad@msudenver.edu
