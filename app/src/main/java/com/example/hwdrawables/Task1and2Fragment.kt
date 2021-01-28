package com.example.hwdrawables

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.view.View
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.task1and2_fragment.*
import java.nio.ByteBuffer

class Task1and2Fragment : Fragment(R.layout.task1and2_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setClickListener()
    }

    private fun setClickListener() {
        button.setOnClickListener {
            drawMustacheAndConvertToArray()
            button.setOnClickListener(null)
        }
    }

    private fun drawMustacheAndConvertToArray() {
        val options = BitmapFactory.Options().apply {
            inMutable = true
        }
        val bitmapCan = (composite_view.drawable as LayerDrawable).toBitmap()
        val bitmapMustache = BitmapFactory.decodeResource(resources, R.drawable.mustache, options)
        val canvas = Canvas(bitmapCan)
        canvas.drawBitmap(
            bitmapMustache,
            (bitmapCan.width / 2.0f) - (bitmapMustache.width / 2.0f),
            (bitmapCan.height / 2.0f) + (bitmapMustache.height / 4.0f),
            null
        )

        composite_view.setImageBitmap(bitmapCan)

        // conversion to byte array
        val buffer: ByteArray = ByteBuffer.allocate(bitmapCan.byteCount).apply {
            bitmapCan.copyPixelsToBuffer(this)
            rewind()
        }.array()

    }
}