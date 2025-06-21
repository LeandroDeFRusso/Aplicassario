plugins {
    id(libs.plugins.androidApplication.get().pluginId) version libs.plugins.androidApplication.get().version.requiredVersion apply false
    id(libs.plugins.kotlinAndroid.get().pluginId) version libs.plugins.kotlinAndroid.get().version.requiredVersion apply false
    id(libs.plugins.ksp.get().pluginId) version libs.plugins.ksp.get().version.requiredVersion apply false
}


