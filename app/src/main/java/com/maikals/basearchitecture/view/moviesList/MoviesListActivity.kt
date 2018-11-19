package com.maikals.basearchitecture.view.moviesList

import com.maikals.basearchitecture.view.base.BaseActivity
import com.maikals.basearchitecture.view.base.BaseFragment

class MoviesListActivity : BaseActivity() {
    override fun createFragmentAndTAG(): Pair<BaseFragment, String> =
          MoviesListFragment.newInstance() to MoviesListFragment.TAG

}
