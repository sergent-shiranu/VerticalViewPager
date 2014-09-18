package com.adva.verticalviewpager.sample;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

import com.adva.verticalviewpager.VerticalAccordionTransformer;
import com.adva.verticalviewpager.VerticalBackgroundToForegroundTransformer;
import com.adva.verticalviewpager.VerticalCubeInTransformer;
import com.adva.verticalviewpager.VerticalCubeOutTransformer;
import com.adva.verticalviewpager.VerticalDefaultTransformer;
import com.adva.verticalviewpager.VerticalDepthPageTransformer;
import com.adva.verticalviewpager.VerticalFlipHorizontalTransformer;
import com.adva.verticalviewpager.VerticalFlipVerticalTransformer;
import com.adva.verticalviewpager.VerticalForegroundToBackgroundTransformer;
import com.adva.verticalviewpager.VerticalRotateDownTransformer;
import com.adva.verticalviewpager.VerticalRotateUpTransformer;
import com.adva.verticalviewpager.VerticalStackTransformer;
import com.adva.verticalviewpager.VerticalTabletTransformer;
import com.adva.verticalviewpager.VerticalViewPager;
import com.adva.verticalviewpager.VerticalZoomInTransformer;
import com.adva.verticalviewpager.VerticalZoomOutSlideTransformer;
import com.adva.verticalviewpager.VerticalZoomOutTranformer;


public class MainActivity extends Activity implements ActionBar.OnNavigationListener {

    private VerticalViewPager verticalViewPager;

    private static final ArrayList<TransformerItem> TRANSFORM_CLASSES;

    private int mSelectedItem;

    static {
        TRANSFORM_CLASSES = new ArrayList<TransformerItem>();
        TRANSFORM_CLASSES.add(new TransformerItem(VerticalDefaultTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(VerticalAccordionTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(VerticalBackgroundToForegroundTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(VerticalCubeInTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(VerticalCubeOutTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(VerticalDepthPageTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(VerticalFlipHorizontalTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(VerticalFlipVerticalTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(VerticalForegroundToBackgroundTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(VerticalRotateDownTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(VerticalRotateUpTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(VerticalStackTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(VerticalTabletTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(VerticalZoomInTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(VerticalZoomOutSlideTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(VerticalZoomOutTranformer.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ArrayAdapter<TransformerItem> actionBarAdapter = new ArrayAdapter<TransformerItem>(
                getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1, TRANSFORM_CLASSES);

        final ActionBar actionBar = getActionBar();
        actionBar.setListNavigationCallbacks(actionBarAdapter, this);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE);


        setContentView(R.layout.activity_main);
        verticalViewPager = (VerticalViewPager) findViewById(R.id.verticalviewpager);

        verticalViewPager.setAdapter(new DummyAdapter(getFragmentManager()));
        mSelectedItem = 0;
        actionBar.setSelectedNavigationItem(mSelectedItem);
    }

    @Override
    public boolean onNavigationItemSelected(int position, long itemId) {
        mSelectedItem = position;
        try {
            verticalViewPager.setPageTransformer(true, TRANSFORM_CLASSES.get(position).clazz.newInstance());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        if (verticalViewPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            verticalViewPager.setCurrentItem(verticalViewPager.getCurrentItem() - 1);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Toggle Fade");
        String[] effects = this.getResources().getStringArray(R.array.jazzy_effects);
        for (String effect : effects)
            menu.add(effect);
        return true;
    }

    public class DummyAdapter extends FragmentPagerAdapter {

        public DummyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            // Show 5 total pages.
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return "PAGE 0";
                case 1:
                    return "PAGE 1";
                case 2:
                    return "PAGE 2";
                case 3:
                    return "PAGE 3";
                case 4:
                    return "PAGE 4";
                case 5:
                    return "PAGE 5";
            }
            return null;
        }

    }


    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_layout, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.textview);

            int num = getArguments().getInt(ARG_SECTION_NUMBER);

            textView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));

            switch (num) {
                case 0:
                    rootView.setBackgroundColor(Color.BLUE);
                    break;
                case 1:
                    rootView.setBackgroundColor(Color.RED);
                    break;
                case 2:
                    rootView.setBackgroundColor(Color.GREEN);
                    break;
                case 3:
                    rootView.setBackgroundColor(Color.GRAY);
                    break;
                case 4:
                    rootView.setBackgroundColor(Color.YELLOW);
                    break;
            }
            return rootView;
        }


    }

    private static final class TransformerItem {

        final String title;
        final Class<? extends ViewPager.PageTransformer> clazz;

        public TransformerItem(Class<? extends ViewPager.PageTransformer> clazz) {
            this.clazz = clazz;
            title = clazz.getSimpleName();
        }

        @Override
        public String toString() {
            return title;
        }

    }

}
