#-dump ./proguard-dump.txt
#printseeds ./proguard-seeds.txt
#-printusage ./proguard-unused.txt
#-printmapping ./proguard-mapping.txt

-dontshrink
-dontoptimize
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontpreverify
-verbose
-ignorewarnings
-keepattributes SourceFile, LineNumberTable, *Annotation*, Signature, EnclosingMethod, InnerClasses, EnclosingMethod

-keep class com.nhn.** { *; }
-keep class p.android.support.v7.** { *; }
-keep interface p.android.support.v7.** { *; }
-keep class p.android.support.** { *; }
-keep interface p.android.support.** { *; }
-keep class com.navercorp.volleyextensions.** { *; }
-keep interface com.navercorp.volleyextensions.** { *; }
-keep class google.gson.** { *; }
-keep interface google.gson.** { *; }
-keep enum google.gson.** { *; }
-keep class p.com.bumptech.glide.** { *; }
-keep interface p.com.bumptech.glide.** { *; }
-keep class com.squareup.** { *; }
-keep interface com.squareup.** { *; }

-keep class p.android.support.v4.** { *; }
-keep interface p.android.support.v4.** { *; }

-keep class p.android.support.v4.util.Pair.** { *; }
-keep interface p.android.support.v4.util.Pair.** { *; }

-keep class com.android.volley.** { *; }
-keep interface com.android.volley.** {*;}

-keep class android.net.** { *; }
-keep class org.** { *; }
-keep interface org.** { *; }
-keep class com.fasterxml.jackson.** { *; }

#--G-LINK SDK
-keep class com.naver.plug.core.api.** {
    *;
}


-keep class com.naver.plug.core.api.** {*;}

-keepclassmembers class com.naver.plug.core.api.** {
    <fields>;
    <methods>;
}

-keepclassmembers class com.naver.plug.cafe.api.** {
    <fields>;
}


-keep class com.naver.vapp.broadcast.publisher.** {*;}
-keepclassmembers class com.naver.vapp.broadcast.publisher.** {
    <fields>;
}



-keepparameternames
-keep class com.naver.glink.android.sdk.Glink {*;}
-keep interface com.naver.glink.android.sdk.Glink {*;}
-keep interface com.naver.glink.android.sdk.Glink$* {*;}
-keep class com.naver.plug.cafe.model.** {*;}
-keepclassmembers class com.naver.plug.cafe.model.** {*;}

-keep class com.naver.plug.cafe.ui.ItemsDialogFragment {*;}
-keep interface com.naver.plug.cafe.ui.ItemsDialogFragment$* {*;}
-keep class com.naver.plug.cafe.ui.ItemsDialogFragment$* {*;}

-keep class com.naver.glink.android.sdk.samsung.SPlug {*;}
-keep interface com.naver.glink.android.sdk.samsung.SPlug {*;}
-keep interface com.naver.glink.android.sdk.samsung.SPlug$* {*;}

-keep class com.naver.plug.moot.api.response.** {*;}
-keep class com.naver.plug.moot.model.** {*;}
-keep class com.naver.plug.moot.ui.write.model.** {*;}
-keep class com.nhncorp.nelo2.android.** {*;}
#-keep class com.naver.plug.cafe.model.WritingArticle {*;}
#-keep class com.naver.plug.cafe.model.WritingArticle$Builder {*;}

-keep public class **.R {
  public *;
}
-keep public class **.R$* {
  public *;
}


##---------------Begin: proguard configuration for Common Android  ----------
# For native methods, see http://proguard.sourceforge.net/manual/examples.html#native
-keepclasseswithmembernames class * {
    native <methods>;
}

# keep setters in Views so that animations can still work.
# see http://proguard.sourceforge.net/manual/examples.html#beans
-keepclassmembers public class * extends android.view.View {
   void set*(***);
   *** get*();
}

# We want to keep methods in Activity that could be used in the XML attribute onClick
-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

# For enumeration classes, see http://proguard.sourceforge.net/manual/examples.html#enumerations
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

-keepclassmembers class **.R$* {
    public static <fields>;
}

-keep public class * extends android.view.View {
     public <init>(android.content.Context);
     public <init>(android.content.Context, android.util.AttributeSet);
     public <init>(android.content.Context, android.util.AttributeSet, int);
     public void set*(...);
 }

-keepclasseswithmembers public class * extends android.preference.Preference {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    public void set*(...);
}

-keepclassmembers class * implements android.os.Parcelable {
    static android.os.Parcelable$Creator CREATOR;
}

-keepclassmembers class * {
    @android.webkit.JavascriptInterface *;
}

-keep class * implements java.io.Serializable { *; }

##---------------End: proguard configuration for Common Android  ----------



## Google Play Services 4.3.23 specific rules ##
## https://developer.android.com/google/play-services/setup.html#Proguard ##

-keep class * extends java.util.ListResourceBundle {
    protected java.lang.Object[][] getContents();
}

-keep public class com.google.android.gms.common.internal.safeparcel.SafeParcelable {
    public static final *** NULL;
}

-keepnames @com.google.android.gms.common.annotation.KeepName class *
-keepclassmembernames class * {
    @com.google.android.gms.common.annotation.KeepName *;
}

-keepnames class * implements android.os.Parcelable {
    public static final ** CREATOR;
}

## GSON 2.2.4 specific rules ##

# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.

# For using GSON @Expose annotation
# Gson specific classes

-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }

-keepclassmembers class com.google.gson.** {
    <fields>;
    <methods>;
}


-keep class com.google.gson.** { *; }
-keep interface com.google.gson.** { *; }


#--dontwarn
-dontwarn org.**
-dontwarn com.fasterxml.jackson.**
-dontwarn com.nhn.android.login.**
-dontwarn com.nhn.android.naverlogin.**
-dontwarn com.nhn.android.maps.**
-dontwarn roboguice.**
-dontwarn net.sf.cglib.**
-dontwarn com.nhncorp.**
-dontwarn com.nhn.nni.**
-dontwarn com.nhn.npush.**
-dontwarn com.nhn.android.inappwebview.**
-dontwarn android.**

-dontwarn java.lang.invoke.*
-dontwarn **$$Lambda$*

-dontwarn com.google.gson.**
-dontnote com.google.gson.**
-dontnote org.**
