package com.tmosest.androidxylophone

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.media.MediaPlayer
import android.view.View


class MainActivity : AppCompatActivity() {

    private fun soundIdFromViewId(viewId : Int) : Int {
        return when(viewId) {
            R.id.xy_note2 -> R.raw.xy_note2
            R.id.xy_note3 -> R.raw.xy_note3
            R.id.xy_note4 -> R.raw.xy_note4
            R.id.xy_note5 -> R.raw.xy_note5
            R.id.xy_note6 -> R.raw.xy_note6
            R.id.xy_note7 -> R.raw.xy_note7
            else -> R.raw.xy_note1
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val noteClickListener = View.OnClickListener {
            // TODO replace with a sound pool
            val mp = MediaPlayer.create(this@MainActivity, soundIdFromViewId(it.id))
            mp.setOnCompletionListener {
                it.release()
            }
            mp.start()
        }
        xy_note1.setOnClickListener(noteClickListener)
        xy_note2.setOnClickListener(noteClickListener)
        xy_note3.setOnClickListener(noteClickListener)
        xy_note4.setOnClickListener(noteClickListener)
        xy_note5.setOnClickListener(noteClickListener)
        xy_note6.setOnClickListener(noteClickListener)
        xy_note7.setOnClickListener(noteClickListener)
    }
}
