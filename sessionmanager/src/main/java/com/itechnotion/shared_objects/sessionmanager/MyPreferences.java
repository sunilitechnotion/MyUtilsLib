package com.itechnotion.shared_objects.sessionmanager;

import android.content.Context;
import android.content.SharedPreferences;

public class MyPreferences {

    Context context ;
    public String prefName = "MyPreferences";

    static SharedPreferences mySharedPreference;
    static SharedPreferences.Editor myEditor;
    public static int PRIVATE_MODE = 0;

    public MyPreferences(Context context, String prefName) {
        this.context = context;
        this.prefName = prefName ;

        mySharedPreference = context.getSharedPreferences(prefName, PRIVATE_MODE);
        myEditor = mySharedPreference.edit();
    }

    public static void setPreference(String key, String value) {
        myEditor = mySharedPreference.edit();
        myEditor.putString(key, value);
        myEditor.commit();
    }

    public String getPreference(String key) {
        try {
            return mySharedPreference.getString(key, "");
        } catch (Exception exception) {
            return "";
        }
    }

    public void removeSinglePreference(String pref) {
        if (mySharedPreference.contains(pref)) {
            myEditor = mySharedPreference.edit();
            myEditor.remove(pref);
            myEditor.commit();
        }
    }

    public void clear() {
        myEditor = mySharedPreference.edit();
        myEditor.clear();
        myEditor.commit();
    }
}
