package com.maikals.basearchitecture.view.moviesList

import android.os.Bundle
import android.view.View
import com.maikals.basearchitecture.R
import com.maikals.basearchitecture.view.base.BaseFragment

class MoviesListFragment: BaseFragment() {

    companion object {
        const val TAG = "MoviesListFragment"
        fun newInstance() : MoviesListFragment = MoviesListFragment()
    }

    override fun getFragmentLayout(): Int = R.layout.fragment_movies_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}