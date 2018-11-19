package com.maikals.basearchitecture.view.splash

import com.maikals.basearchitecture.R
import com.maikals.basearchitecture.view.base.BaseActivity
import com.maikals.basearchitecture.view.base.BaseFragment

class SplashActivity: BaseActivity() {
    override fun createFragmentAndTAG(): Pair<BaseFragment, String> =
        SplashFragment.newInstance() to SplashFragment.TAG

    override fun getActivityLayout(): Int = R.layout.activity_splash
}