plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "dev.katiebarnett.wearexperiments"
    compileSdkPreview = "Tiramisu"

    defaultConfig {
        applicationId = "dev.katiebarnett.wearexperiments"
        minSdkPreview = "Tiramisu"
        targetSdkPreview = "Tiramisu"
        versionCode = 1
        versionName = "1.0"
        vectorDrawables {
            useSupportLibrary = true
        }

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("com.google.android.gms:play-services-wearable:18.0.0")
    implementation("androidx.percentlayout:percentlayout:1.0.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation(platform("androidx.compose:compose-bom:2022.10.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.wear.compose:compose-material:${rootProject.extra["wear_compose_version"]}")
    implementation("androidx.wear.compose:compose-foundation:${rootProject.extra["wear_compose_version"]}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    implementation("androidx.activity:activity-compose:1.5.1")
    implementation("androidx.wear.tiles:tiles:${rootProject.extra["wear_tiles_version"]}")
    implementation("androidx.wear.tiles:tiles-material:${rootProject.extra["wear_tiles_version"]}")
    implementation("com.google.android.horologist:horologist-compose-tools:${rootProject.extra["horologist_version"]}")
    implementation("com.google.android.horologist:horologist-tiles:${rootProject.extra["horologist_version"]}")
    implementation("androidx.wear.watchface:watchface-complications-data-source-ktx:1.1.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2022.10.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}