# Connexx
Connexx allows two Karoo users to share riding data in real time.

## Setup
After following these steps, you should be able to build the application.
### Authenticating to GitHub Packages
1. Create a [personal access token (classic)](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/managing-your-personal-access-tokens#creating-a-personal-access-token-classic) with `read:packages` permissions at the minimum. Save the token.
2. Navigate to your [Gradle User Home](https://docs.gradle.org/current/userguide/directory_layout.html#dir:gradle_user_home) directory. If there is no `gradle.properties` file, make one.
3. Add to `gradle.properties` the properties `gh.user=<USERNAME>` and `gh.token=<TOKEN>` where USERNAME and TOKEN are your GitHub username and the token from step 1, respectively.
4. Build the project to confirm that all dependencies are successfully resolved.

## Dependencies
- `karoo-ext` is the Android library that is used to create Karoo Extensions. It is open source and can be found [here](https://github.com/hammerheadnav/karoo-ext). The README links to documentation, and the repository itself includes a sample app.
- `Hilt` is Android's dependency injection (DI) framework. You will probably want to read [this page](https://developer.android.com/training/dependency-injection/hilt-android) to learn how to use it.
- `Timber` is just a logging utility (https://github.com/JakeWharton/timber).

## Project Structure
### Extension
The extension is the interface with the Karoo system. Here are the classes and their purposes:
- `ConnexxExtension` adds new behavior to the Karoo by overriding the methods of `KarooExtension`, defined in the `karoo-ext` library.
- `ConnexxModule` is a `Hilt` module that provides dependencies to `ConnexxExtension`.
- `KarooDataSource` represents a Karoo device as a data source. A typical data source is a heart-rate monitor, but Connexx allows a Karoo to function as a source of data.
### Service
Right now, the only service is `BluetoothService`, which is a lightweight abstraction over the Android Bluetooth API. It uses Kotlin [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html). `BluetoothModule` provides dependencies to `BluetoothService`.
