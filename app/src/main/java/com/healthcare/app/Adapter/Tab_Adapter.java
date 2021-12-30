package com.healthcare.app.Adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.healthcare.app.About.About_Frag;
import com.healthcare.app.Fragment.Actions;
import com.healthcare.app.Fragment.CausesFragment;
import com.healthcare.app.Fragment.DescriptionFragment;
import com.healthcare.app.Fragment.FurtherInfo;
import com.healthcare.app.Fragment.OverviewFragment;
import com.healthcare.app.Fragment.SelfCare;
import com.healthcare.app.Fragment.Source_Frag;
import com.healthcare.app.Fragment.SymptomsFragment;
import com.healthcare.app.Fragment.Test;
import com.healthcare.app.Fragment.WarningSigns;
import com.healthcare.app.HealthSolutions.Description_Tablayout;

public class Tab_Adapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public Tab_Adapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                OverviewFragment overview_frag = new OverviewFragment();
                return overview_frag;
            case 1:
                DescriptionFragment descriptionFragment = new DescriptionFragment();
                return descriptionFragment;
            case 2:
                CausesFragment causesFragment = new CausesFragment();
                return causesFragment;
            case 3:
                SymptomsFragment symptomsFragment = new SymptomsFragment();
                return symptomsFragment;

            case 4:
                WarningSigns warningSigns = new WarningSigns();
                return warningSigns;

            case 5:
                SelfCare selfCare = new SelfCare();
                return selfCare;

            case 6:
                Actions actions = new Actions();
                return actions;

            case 7:
                Test test = new Test();
                return test;

            case 8:
                FurtherInfo furtherInfo = new FurtherInfo();
                return furtherInfo;

            case 9:
                Source_Frag source_frag = new Source_Frag();
                return source_frag;

            case 10:
                About_Frag about_frag = new About_Frag();
                return about_frag;

            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}
