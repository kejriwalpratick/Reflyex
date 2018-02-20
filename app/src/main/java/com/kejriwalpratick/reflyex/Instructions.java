package com.kejriwalpratick.reflyex;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class Instructions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.howtoplay);
        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        MyPagerAdapter adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
    }
}

    class MyPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 3;

    public MyPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Returns total number of pages.
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for a particular page.
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return myFragment.newInstance("Flying Squirrel can fly, so swiping up gives green checkmark.", R.drawable.and03,R.drawable.android_01,R.drawable.icons8checkmark48);
            case 1:
                return myFragment.newInstance("Hyena cannot fly, so swiping up gives red wrongmark.", R.drawable.and01,R.drawable.android_01,R.drawable.icons8wrong48);
            case 2:
                return myFragment.newInstance("Similarly swiping Down for a pencil gives green light.\nRemember with increase in level, time decreases.", R.drawable.and02,R.drawable.android_02,R.drawable.icons8checkmark48);
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return ""+ (position+1);
    }

}

