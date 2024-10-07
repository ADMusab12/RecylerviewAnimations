package com.example.recylerviewanimations

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recylerviewanimations.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private val dataStructure: MutableList<Int> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = GridLayoutManager(this,3)

        dataStructure.addAll(
            listOf(
                R.drawable.ic_android,
                R.drawable.ic_swift,
                R.drawable.flutter,

                R.drawable.flutter,
                R.drawable.ic_android,
                R.drawable.ic_swift,

                R.drawable.ic_swift,
                R.drawable.flutter,
                R.drawable.ic_android,

                R.drawable.ic_android,
                R.drawable.ic_swift,
                R.drawable.flutter,
            )
        )

        recyclerViewAdapter = RecyclerViewAdapter(this, dataStructure)
        binding.recyclerView.adapter = recyclerViewAdapter

        applyAnimation(R.anim.layout_animation_falldown)

        binding.apply {
            fallDownButton.setOnClickListener {
                applyAnimation(R.anim.layout_animation_falldown)
            }
            btnSlideUp.setOnClickListener {
                applyAnimation(R.anim.layout_animation_slide_up)
            }
            btnRotateIn.setOnClickListener {
                applyAnimation(R.anim.layout_animation_rotate)
            }
            btnScaleIn.setOnClickListener {
                applyAnimation(R.anim.layout_animation_scale)
            }
        }
    }

    private fun applyAnimation(animationResId: Int) {
        val animation: LayoutAnimationController = AnimationUtils.loadLayoutAnimation(this, animationResId)
        binding.recyclerView.layoutAnimation = animation
        binding.recyclerView.scheduleLayoutAnimation()
        recyclerViewAdapter.notifyDataSetChanged()
    }
}