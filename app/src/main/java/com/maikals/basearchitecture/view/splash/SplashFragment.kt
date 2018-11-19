package com.maikals.basearchitecture.view.splash

import com.maikals.basearchitecture.R
import com.maikals.basearchitecture.view.base.BaseFragment

class SplashFragment : BaseFragment() {

    companion object {
        const val TAG = "SplashFragment"
        fun newInstance(): SplashFragment = SplashFragment()
    }

    override fun getFragmentLayout(): Int = R.layout.fragment_splash
}