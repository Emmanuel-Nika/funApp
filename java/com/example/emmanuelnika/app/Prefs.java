package com.example.emmanuelnika.app;

import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

import com.example.emmanuelnika.app.R;

/**
 * Created by
 * Okot Emmanuel
 * Masiga David Kelvin
 * Nabwire Barbra Sandra
 * Lema James on 7/27/2017.
 */

public class Prefs extends PreferenceActivity {
    // Option names and default values
    private static final String OPT_MUSIC = "music" ;
    private static final boolean OPT_MUSIC_DEF = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }

    /** Get the current value of the music option */
    public static boolean getMusic(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(OPT_MUSIC, OPT_MUSIC_DEF);
    }
}
