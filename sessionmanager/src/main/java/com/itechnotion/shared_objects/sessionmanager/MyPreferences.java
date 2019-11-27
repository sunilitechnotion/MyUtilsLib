package com.itechnotion.shared_objects.sessionmanager;

import android.content.Context;
import android.content.SharedPreferences;

public class MyPreferences {

    Context context ;
    public String prefName = "MyPreferences";

    SharedPreferences mySharedPreference;
    SharedPreferences.Editor myEditor;
    public static int PRIVATE_MODE = 0;

    public MyPreferences(Context context, String prefName) {
        this.context = context;
        this.prefName = prefName ;

        mySharedPreference = context.getSharedPreferences(prefName, PRIVATE_MODE);
        myEditor = mySharedPreference.edit();
    }

    public MyPreferences(Context context, String prefName, int prefMode) {
        this.context = context;
        this.prefName = prefName ;

        if (prefMode == Context.MODE_PRIVATE){
            mySharedPreference = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        }else if (prefMode == Context.MODE_WORLD_WRITEABLE){
            mySharedPreference = context.getSharedPreferences(prefName, Context.MODE_WORLD_WRITEABLE);
        }else if (prefMode == Context.MODE_WORLD_READABLE){
            mySharedPreference = context.getSharedPreferences(prefName, Context.MODE_WORLD_READABLE);
        }else{
            mySharedPreference = context.getSharedPreferences(prefName, PRIVATE_MODE);
        }

        myEditor = mySharedPreference.edit();
    }

    public void setPreference(String key, String value) {
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
