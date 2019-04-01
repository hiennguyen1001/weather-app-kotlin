import Versions.architecture
import Versions.constraint
import Versions.dagger2
import Versions.espresso
import Versions.glide
import Versions.gson
import Versions.leakCanary
import Versions.multiDex
import Versions.objectboxVersion
import Versions.okHttp
import Versions.playServicesVersion
import Versions.retrofit
import Versions.rxAndroid
import Versions.rxJava
import Versions.rxKotlin
import Versions.stetho
import Versions.support
import Versions.testRunner

object Versions {
    const val kotlin_version = "1.3.21"
    const val compileSdkVersion = 28
    const val minSdkVersion = 16
    const val targetSdkVersion = 28
    const val support = "1.0.0"
    const val constraint = "1.1.2"
    const val architecture = "2.0.0"
    const val dagger2 = "2.16"
    const val okHttp = "3.9.0"
    const val retrofit = "2.3.0"
    const val stetho = "1.5.0"
    const val gson = "2.8.2"
    const val glide = "4.8.0"
    const val rxJava = "2.1.11"
    const val rxKotlin = "2.2.0"
    const val rxAndroid = "2.0.1"
    const val leakCanary = "1.5.4"
    const val objectboxVersion = "1.4.4"
    const val playServicesVersion = "12.0.0"


    const val junit = "4.12"
    const val testRunner = "1.1.0"
    const val espresso = "3.1.0"
    const val multiDex = "2.0.0"
}

object Deps {

    val supportDeps = arrayOf("androidx.appcompat:appcompat:$support"
            , "androidx.constraintlayout:constraintlayout:$constraint"
            , "com.google.android.material:material:1.0.0-rc01"
            , "androidx.recyclerview:recyclerview:$support"
            , "androidx.multidex:multidex:$multiDex"
    )

    val archDeps = arrayOf(
            "androidx.lifecycle:lifecycle-extensions:$architecture"
            , "androidx.paging:paging-runtime:$architecture"
            , "androidx.lifecycle:lifecycle-viewmodel-savedstate:1.0.0-alpha01"
            , "androidx.activity:activity-ktx:1.0.0-alpha05"
    )

    val dagger = arrayOf(
            "com.google.dagger:dagger:$dagger2"
            , "com.google.dagger:dagger-android:$dagger2"
            , "com.google.dagger:dagger-android-support:$dagger2"
    )

    val networking = arrayOf(
            "com.squareup.retrofit2:retrofit:$retrofit"
            , "com.squareup.retrofit2:converter-gson:$retrofit"
            , "com.squareup.retrofit2:adapter-rxjava2:$retrofit"
            , "com.squareup.okhttp3:logging-interceptor:$okHttp"
            , "com.facebook.stetho:stetho-okhttp3:$stetho"
            , "com.google.code.gson:gson:$gson")

    val reactiveX = arrayOf(
            "io.reactivex.rxjava2:rxandroid:$rxAndroid"
            , "io.reactivex.rxjava2:rxjava:$rxJava"
            , "io.reactivex.rxjava2:rxkotlin:$rxKotlin"
            , "com.jakewharton.rxrelay2:rxrelay:2.0.0")

    val objectBox = arrayOf("io.objectbox:objectbox-android:$objectboxVersion"
            , "io.objectbox:objectbox-kotlin:$objectboxVersion")

    val glideLibs = "com.github.bumptech.glide:glide:$glide"
    val glideOkhttp = "com.github.bumptech.glide:okhttp3-integration:$glide"
    val bindingList = "hiennguyen.me.bindingadapterdelegate:bindingadapterdelegate:0.1.1"
    val circleimage = "de.hdodenhof:circleimageview:2.2.0"
    val ktlint = "com.github.shyiko:ktlint:0.15.0"
    val indicatore = "com.romandanylyk:pageindicatorview:1.0.0"

    val onlyDebug = arrayOf(
            "com.squareup.leakcanary:leakcanary-android:$leakCanary")

    val onlyRelease = arrayOf(
            "com.squareup.leakcanary:leakcanary-android-no-op:$leakCanary")

    val annotationProccessor = arrayOf(
            "androidx.lifecycle:lifecycle-compiler:$architecture"
            , "com.google.dagger:dagger-compiler:$dagger2"
            , "com.google.dagger:dagger-android-processor:$dagger2"
            , "com.github.bumptech.glide:compiler:$glide"
            , "io.objectbox:objectbox-processor:$objectboxVersion"
            , "com.android.tools.build.jetifier:jetifier-core:1.0.0-beta04")

    val unitTest = arrayOf("junit:junit:${Versions.junit}")

    val androidTest = arrayOf("androidx.test:runner:$testRunner"
            , "androidx.test.espresso:espresso-core:$espresso")

    val otherLibs = arrayOf(glideLibs, glideOkhttp, bindingList, circleimage, indicatore)
    val placeLib = "com.google.android.gms:play-services-places:$playServicesVersion"
    val playServiceLibs = arrayOf(placeLib)
    val javaInject = "javax.inject:javax.inject:1"
}