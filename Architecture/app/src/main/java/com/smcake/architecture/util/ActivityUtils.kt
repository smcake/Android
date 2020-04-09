package com.smcake.architecture.util

import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

/**
 * Created by JJH on 2020-04-10
 */
object ActivityUtils {

    public fun addFragmentToActivity(@NonNull fragmentManager: FragmentManager,
                                     @NonNull fragment : Fragment, frameId : Int) {
        checkNotNull(fragmentManager)
        checkNotNull(fragment)
        val transaction = fragmentManager.beginTransaction()
        transaction.add(frameId, fragment)
        transaction.commit()
    }

}