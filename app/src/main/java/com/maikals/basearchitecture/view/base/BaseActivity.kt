package com.maikals.basearchitecture.view.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.maikals.basearchitecture.R
import kotlinx.android.synthetic.main.activity_base.*
import org.koin.standalone.KoinComponent

abstract class BaseActivity : AppCompatActivity(), KoinComponent {

    protected var currentTag: String? = null
    protected var currentFragment: Fragment? = null


    companion object {
        private const val CURRENT_FRAGMENT_TAG: String = "currentTag"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getActivityLayout())
        setToolbar()
        setCurrentFragment(savedInstanceState)
        beginTransaction()
    }

    private fun setCurrentFragment(savedInstanceState: Bundle?) =
            if (savedInstanceState != null
                    && savedInstanceState.containsKey(CURRENT_FRAGMENT_TAG)) {
                currentTag = savedInstanceState.getString(CURRENT_FRAGMENT_TAG)
                currentFragment = supportFragmentManager.getFragment(savedInstanceState, currentTag!!) as BaseFragment
            } else
                setCurrentFragmentAndTag(createFragmentAndTAG())

    private fun setToolbar() {
        setSupportActionBar(toolbar)
    }

    protected open fun getActivityLayout() = R.layout.activity_base

    override fun onSaveInstanceState(outState: Bundle?) {
        supportFragmentManager.putFragment(outState!!, currentTag!!, currentFragment!!)
        outState.putString(CURRENT_FRAGMENT_TAG, currentTag)
        super.onSaveInstanceState(outState)
    }

    private fun beginTransaction() =
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, currentFragment!!, currentTag).commit()

    abstract fun createFragmentAndTAG(): Pair<BaseFragment, String>

    private fun setCurrentFragmentAndTag(pair: Pair<BaseFragment, String>) {
        currentFragment = pair.first
        currentTag = pair.second
    }


    protected fun setToolbarTitle(title: String) {
        supportActionBar?.title = title
    }

}
