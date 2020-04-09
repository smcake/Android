package com.smcake.architecture.tasks

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.smcake.architecture.R
import com.smcake.architecture.util.ActivityUtils
import kotlinx.android.synthetic.main.tasks_act.*

/**
 * Created by JJH on 2020-04-08
 */
class TasksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tasks_act)

        setToolbar()
        setupNavigationDrawer()

        val tasksFragment = findOrCreateViewFragment()
    }

    private fun findOrCreateViewFragment() : TasksFragment {
        var tasksFragment = supportFragmentManager.findFragmentById(R.id.contentFrame) as TasksFragment
        if (tasksFragment == null) {
            tasksFragment = TasksFragment.newInstance()
            ActivityUtils.addFragmentToActivity(
                supportFragmentManager, tasksFragment, R.id.contentFrame)
        }
        return tasksFragment
    }

    private fun setToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.setHomeAsUpIndicator(R.drawable.ic_menu)
            it.setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun setupNavigationDrawer() {
        drawer_layout.setStatusBarBackground(R.color.colorPrimaryDark)
        nav_view?.let {
            setupDrawerContent(it)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                drawer_layout.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupDrawerContent(navigationView : NavigationView) {
        navigationView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.list_navigation_menu_item -> {
                }
                R.id.statistics_navigation_menu_item -> {
                }
                else -> {
                }
            }
            it.isChecked = true
            drawer_layout.closeDrawers()
            true
        }

    }
}
