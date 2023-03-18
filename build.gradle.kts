buildscript {
    val wear_compose_version by extra("1.1.2")
    val horologist_version by extra("0.3.9")
    val wear_tiles_version by extra("1.2.0-alpha01")
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0-alpha09" apply false
    id("com.android.library") version "8.1.0-alpha09" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
}