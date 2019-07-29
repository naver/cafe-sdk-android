# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/Naver/Library/Android/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

-ignorewarnings
-keepattributes SourceFile, LineNumberTable, *Annotation*, Signature, EnclosingMethod, InnerClasses, EnclosingMethod

-keep class com.naver.cafe.** { *; }
-keep interface com.naver.cafe.** { *; }
-keepclassmembers class com.naver.cafe.** {
  <fields>;
  <methods>;
}

-keep class com.naver.glink.** { *; }
-keep interface com.naver.glink.** { *; }

-keep class com.nhn.** { *; }
-keep interface com.nhn.** { *; }

-keep class p.com.bumptech.glide.** { *; }
-keep interface p.com.bumptech.glide.** { *; }

-keep class com.android.volley.** { *; }
-keep interface com.android.volley.** {*;}

-keep class com.navercorp.volleyextensions.** { *; }
-keep interface com.navercorp.volleyextensions.** { *; }

-keep class p.android.support.v4.util.Pair.** { *; }
-keep interface p.android.support.v4.util.Pair.** { *; }

-keep class p.android.support.v4.** { *; }
-keep interface p.android.support.v4.** { *; }


-keep class com.squareup.** { *; }
-keep interface com.squareup.** { *; }

-keep class com.github.clans.fab.** { *; }

-dontwarn com.nhn.android.neoid.**
-dontwarn com.navercorp.volleyextensions.volleyer.response.parser.**

##---------------Begin: proguard configuration for Gson  ----------
# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
-keepattributes Signature

# For using GSON @Expose annotation
-keepattributes *Annotation*

# Gson specific classes
-keep class sun.misc.Unsafe { *; }
#-keep class com.google.gson.stream.** { *; }

# Prevent proguard from stripping interface information from TypeAdapterFactory,
# JsonSerializer, JsonDeserializer instances (so they can be used in @JsonAdapter)
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer

-keep class com.google.gson.Gson
##---------------End: proguard configuration for Gson  ----------
