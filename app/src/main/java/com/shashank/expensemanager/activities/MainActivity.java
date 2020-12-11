package com.shashank.expensemanager.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.shashank.expensemanager.R;
import com.shashank.expensemanager.adapters.SectionsPageAdapter;
import com.shashank.expensemanager.fragments.BalanceFragment;
import com.shashank.expensemanager.fragments.CustomBottomSheetDialogFragment;
import com.shashank.expensemanager.fragments.ExpenseFragment;

public class MainActivity extends AppCompatActivity {

    public static FloatingActionButton fab;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CustomBottomSheetDialogFragment().show(getSupportFragmentManager(), "Dialog");

            }
        });

    }


    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new ExpenseFragment(), "Expenses");
        adapter.addFragment(new BalanceFragment(), "Balance");
        viewPager.setAdapter(adapter);
    }


}
