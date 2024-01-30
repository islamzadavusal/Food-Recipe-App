pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Food Recipe App"
include(":app")
include(":entities")
include(":common")
include(":data")
include(":domain")
include(":features:recipes")
include(":features:favorite")
include(":network")
