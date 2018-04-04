#include <jni.h>

JNIEXPORT jstring JNICALL
Java_hiennguyen_me_weatherapp_common_NativeConnector_getWeatherApiKey(JNIEnv *env, jclass jobj) {
    return (*env)->NewStringUTF(env, "d3bba515c122d3d18a67a2bd7f36c3b9");
}