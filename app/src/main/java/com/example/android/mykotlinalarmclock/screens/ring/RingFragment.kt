package com.example.android.mykotlinalarmclock.screens.ring

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.android.mykotlinalarmclock.R
import com.example.android.mykotlinalarmclock.databinding.RingFragmentBinding
import com.example.android.mykotlinalarmclock.utils.EventObserver

class RingFragment : Fragment() {

    companion object {
        fun newInstance() = RingFragment()
    }

    private lateinit var viewModel: RingViewModel
    private lateinit var binding:RingFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.ring_fragment,container,false)

        val application = requireActivity().application
        viewModel = ViewModelProvider(this,RingViewModelFactory(application)).get(RingViewModel::class.java)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        animateClock()

        viewModel.finishActivity.observe(viewLifecycleOwner,EventObserver{
            requireActivity().finish()
        })
        return binding.root
    }


    private fun animateClock() {
        val rotateAnimation = ObjectAnimator.ofFloat(binding.alarmImage,"rotation",0f, 20f, 0f, -20f, 0f)
        rotateAnimation.repeatCount = ValueAnimator.INFINITE
        rotateAnimation.duration = 800
        rotateAnimation.start()
    }


}