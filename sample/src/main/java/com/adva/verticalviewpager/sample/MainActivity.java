package com.adva.verticalviewpager.sample;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Locale;

import com.adva.verticalviewpager.VerticalCubeInTransformer;
import com.adva.verticalviewpager.VerticalViewPager;


public class MainActivity extends Activity {

    private VerticalViewPager verticalViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verticalViewPager = (VerticalViewPager) findViewById(R.id.verticalviewpager);

        verticalViewPager.setAdapter(new DummyAdapter(getFragmentManager()));
        verticalViewPager.setPageMargin(getResources().getDimensionPixelSize(R.dimen.pagemargin));
        verticalViewPager.setPageMarginDrawable(new ColorDrawable(getResources().getColor(android.R.color.holo_green_dark)));

        //verticalViewPager.setPageTransformer(true, new VerticalDefaultTransformer());
        //verticalViewPager.setPageTransformer(true, new VerticalAccordionTransformer());
        //verticalViewPager.setPageTransformer(true, new VerticalBackgroundToForegroundTransformer());
        //verticalViewPager.setPageTransformer(true, new VerticalForegroundToBackgroundTransformer());
        verticalViewPager.setPageTransformer(true, new VerticalCubeInTransformer());
        //verticalViewPager.setPageTransformer(true, new VerticalCubeOutTransformer());
        //verticalViewPager.setPageTransformer(true, new VerticalDepthPageTransformer());
        //verticalViewPager.setPageTransformer(true, new VerticalFlipHorizontalTransformer());
        //verticalViewPager.setPageTransformer(true, new VerticalFlipVerticalTransformer());
        //verticalViewPager.setPageTransformer(true, new VerticalRotateDownTransformer());
        //verticalViewPager.setPageTransformer(true, new VerticalRotateUpTransformer());
        //verticalViewPager.setPageTransformer(true, new VerticalStackTransformer());
        //verticalViewPager.setPageTransformer(true, new VerticalZoomOutTranformer());
        //verticalViewPager.setPageTransformer(true, new VerticalZoomInTransformer());
        //verticalViewPager.setPageTransformer(true, new VerticalZoomOutSlideTransformer());
        //verticalViewPager.setPageTransformer(true, new VerticalTabletTransformer());

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

}
