package com.example.hwdrawables

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import kotlinx.android.synthetic.main.task3_fragment.*

class Task3Fragment : Fragment(R.layout.task3_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setClickListener()
    }

    private fun setClickListener() {
        show_glide.setOnClickListener {
            showGlidePicture()
        }
    }

    private fun showGlidePicture() {
        Glide.with(this)
            .load("https://media0.giphy.com/media/aosOPhpJHrJq8/giphy.gif")
            .transition(DrawableTransitionOptions.withCrossFade(5000))
            .circleCrop()
            .into(glide_view)
    }
}