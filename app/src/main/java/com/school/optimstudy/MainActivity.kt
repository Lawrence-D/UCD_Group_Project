package com.school.optimstudy

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.school.optimstudy.create_study_group.CreateStudyGroupActivity
import com.school.optimstudy.find_study_group_activity.FindStudyGroup
import com.school.optimstudy.practice_test_activity.PracticeTest
import com.school.optimstudy.scheduler_activity.Scheduler
import com.school.optimstudy.study_tracker_activity.StudyTracker
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /**
     * This listener is called when an item is clicked on the bottom navigation bar.
     * We use the *when* statement as sort of a case statement to tell the app what to do when
     * an item is clicked.
     */
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        var selectedFragment: Fragment = Fragment()
        when (item.itemId) {
            //This is called when the create_study_group item is selected
            R.id.create_study_group -> {
                selectedFragment = CreateStudyGroupActivity.newInstance()
            }
            //This one is called when the practice_test item is selected...
            R.id.practice_test -> {
                selectedFragment = PracticeTest.newInstance()
            }
            //I hope you get the point by now....
            R.id.scheduler -> {
                selectedFragment = Scheduler.newInstance()
            }
            R.id.find_study_group -> {
                selectedFragment = FindStudyGroup.newInstance()
            }
            R.id.study_tracker -> {
                selectedFragment = StudyTracker.newInstance()
            }
        }
        val transaction: android.support.v4.app.FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, selectedFragment)
        transaction.commit()
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Here we tell the bottom nav to use the above mOnNavigationItemSelectedListener
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
