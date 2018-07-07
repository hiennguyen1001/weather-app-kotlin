import Versions.archPagging
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
    val kotlin_version = "1.2.50"
    val buildToolsVersion = "27.0.3"
    val compileSdkVersion = 27
    val minSdkVersion = 16
    val targetSdkVersion = 27
    val support = "27.1.1"
    val constraint = "1.0.2"
    val architecture = "1.1.0"
    val archPagging = "1.0.0-beta1"
    val dagger2 = "2.16"
    val okHttp = "3.9.0"
    val retrofit = "2.3.0"
    val stetho = "1.5.0"
    val gson = "2.8.2"
    val glide = "4.5.0"
    val rxJava = "2.1.11"
    val rxKotlin = "2.2.0"
    val rxAndroid = "2.0.1"
    val leakCanary = "1.5.4"
    val objectboxVersion = "1.4.4"
    val playServicesVersion = "15.0.1"


    val junit = "4.12"
    val testRunner = "1.0.1"
    val espresso = "3.0.1"
    val multiDex = "1.0.2"
}

object Deps {

    val supportDeps = arrayOf("com.android.support:appcompat-v7:$support"
            , "com.android.support.constraint:constraint-layout:$constraint"
            , "com.android.support:design:$support"
            , "com.android.support:recyclerview-v7:$support"
            , "com.android.support:multidex:$multiDex"
    )

    val archDeps = arrayOf(
            "android.arch.lifecycle:extensions:$architecture"
            , "android.arch.paging:runtime:$archPagging"
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
            "android.arch.lifecycle:compiler:$architecture"
            , "com.google.dagger:dagger-compiler:$dagger2"
            , "com.google.dagger:dagger-android-processor:$dagger2"
            , "com.github.bumptech.glide:compiler:$glide"
            , "io.objectbox:objectbox-processor:$objectboxVersion")

    val unitTest = arrayOf("junit:junit:${Versions.junit}")

    val androidTest = arrayOf("com.android.support.test:runner:$testRunner"
            , "com.android.support.test.espresso:espresso-core:$espresso")

    val otherLibs = arrayOf(glideLibs, glideOkhttp, bindingList, circleimage, indicatore)
    val placeLib = "com.google.android.gms:play-services-places:$playServicesVersion"
    val playServiceLibs = arrayOf(placeLib)
    val javaInject = "javax.inject:javax.inject:1"
}