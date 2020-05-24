# Sample Movie List App

Sample Multi-Module App based on the MVVM Design Pattern that uses The Movie DB API

<img src="https://github.com/yasintanriverdi/Movie-List-Sample/blob/master/images/home_dark.png" width="200" height="400"> <img src="https://github.com/yasintanriverdi/Movie-List-Sample/blob/master/images/detail_light.png" width="200" height="400">

## Environment setup

You need to get API Key from https://www.themoviedb.org/ and set it to `local.properties` file as `TMDB_API_KEY`

```properties
TMDB_API_KEY = <put your API key>
```

## Tech-stack

Main dependencies used in this project:

* [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)
* [Dagger](https://github.com/google/dagger)
* [Retrofit](https://github.com/square/retrofit)
* [Moshi](https://github.com/square/moshi)
* [Glide](https://github.com/bumptech/glide)
* [Spotless](https://github.com/diffplug/spotless/tree/master/plugin-gradle)
* [MockK](https://github.com/mockk/mockk)
* [Room](https://developer.android.com/topic/libraries/architecture/room)
* [Paging](https://developer.android.com/topic/libraries/architecture/paging)
* [Navigation](https://developer.android.com/guide/navigation)

## Inspired Projects

-   [plaid](https://github.com/android/plaid) (by [android](https://github.com/android)) - app which provides design news & inspiration, being an example of implementing material design.
-   [tivi](https://github.com/chrisbanes/tivi) (by [chrisbanes](https://github.com/chrisbanes)) - an app which attempts to use the latest cutting edge libraries and tools.
-   [kotlin-sample-app](https://github.com/VMadalin/kotlin-sample-app) (by [VMadalin](https://github.com/VMadalin)) - Android Sample App using modular, clean, scalable, testable Architecture written in Kotlin following the best practices with Jetpack.
-   [PureMVVM](https://github.com/Rasalexman/PureMVVM) (by [Rasalexman](https://github.com/Rasalexman)) - Example of usage multi-modules MVVM Pattern on Android with Navigation Component and Clean Architecture
-   [ProjectX](https://github.com/muratcanbur/ProjectX) (by [muratcanbur](https://github.com/muratcanbur)) - A simple app that contains some basic functionality. It connects to the Movies DB API and fetch current popular TV shows on TMDb.

## TODO List
- [ ] Integrate Room with Paging
- [ ] Support Offline Mode
- [ ] Add Instrumentation Tests
- [ ] Increase Unit Test Coverage
- [ ] Keep Dark mode status by using [Shared Preferences](https://developer.android.com/reference/android/content/SharedPreferences)
