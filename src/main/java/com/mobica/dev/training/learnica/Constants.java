package com.mobica.dev.training.lernica;

import com.google.api.server.spi.Constant;

/**
 * Contains the client IDs and scopes for allowed clients consuming the conference API.
 */
public class Constants {
    public static final String WEB_CLIENT_ID = "114294263067-fvd6rjsl439gbas8ta8dfb87feda089b.apps.googleusercontent.com";
    public static final String ANDROID_CLIENT_ID = "114294263067-fvd6rjsl439gbas8ta8dfb87feda089b.apps.googleusercontent.com	";
    public static final String IOS_CLIENT_ID = "AIzaSyD67GSJOx2E917ccYOywYpuRbuDVi5AzKU";
    public static final String ANDROID_AUDIENCE = WEB_CLIENT_ID;
    public static final String EMAIL_SCOPE = Constant.API_EMAIL_SCOPE;
    public static final String API_EXPLORER_CLIENT_ID = Constant.API_EXPLORER_CLIENT_ID;

    public static final String MEMCACHE_ANNOUNCEMENTS_KEY = "RECENT_ANNOUNCEMENTS";
}
