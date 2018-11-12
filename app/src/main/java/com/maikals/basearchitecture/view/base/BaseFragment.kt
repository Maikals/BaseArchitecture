package com.maikals.basearchitecture.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import org.koin.standalone.KoinComponent

abstract class BaseFragment : Fragment(), KoinComponent {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(getFragmentLayout(), container, false)

    @LayoutRes
    protected abstract fun getFragmentLayout(): Int

}
