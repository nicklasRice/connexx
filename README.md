# Connexx
Connexx allows two Karoo users to share riding data in real time.

## Setup
### Authenticating to GitHub Packages
1. Create a [personal access token (classic)](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/managing-your-personal-access-tokens#creating-a-personal-access-token-classic) with `read:packages` permissions at the minimum. Save the token.
2. Navigate to your [Gradle User Home](https://docs.gradle.org/current/userguide/directory_layout.html#dir:gradle_user_home) directory. If there is no `gradle.properties` file, make one.
3. Add to `gradle.properties` the properties `gh.user=<USERNAME>` and `gh.token=<TOKEN>` where USERNAME and TOKEN are your GitHub username and the token from step 1, respectively.
4. Build the project to confirm that all dependencies are succesfully resolved.
