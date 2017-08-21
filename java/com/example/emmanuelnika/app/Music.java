package com.example.emmanuelnika.app;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by
 * Okot Emmanuel
 * Masiga David Kelvin
 * Nabwire Barbra Sandra
 * Lema James on 7/27/2017.
 */

public class Music {

    private static MediaPlayer mp = null;

    public static void play(Context context, int resource) {
        stop(context);

        // Start music only if not disabled in preferences
        if (Prefs.getMusic(context)) {
            mp = MediaPlayer.create(context, resource);
            mp.setLooping(true);
            mp.start();
        }
    }

        /** Stop the music */
        public static void stop(Context context) {
            if (mp != null) {
                mp.stop();
                mp.release();
                mp = null;
            }
        }
}
