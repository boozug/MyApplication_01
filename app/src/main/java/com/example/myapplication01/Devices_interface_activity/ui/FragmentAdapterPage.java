package com.example.myapplication01.Devices_interface_activity.ui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication01.Devices_interface_activity.fragments.Monitordevices.EventsFragment;
import com.example.myapplication01.Devices_interface_activity.fragments.Writedevices.MoviesFragment;
import com.example.myapplication01.Devices_interface_activity.fragments.Logging.TicketsFragment;

public class FragmentAdapterPage extends FragmentStateAdapter {
    private static final int CARD_ITEM_SIZE = 3;
    public FragmentAdapterPage(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
//        public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new MoviesFragment();
            case 1:
                return new EventsFragment();
            case 2:
                return new TicketsFragment();
        }
        return new MoviesFragment();
    }
//    }
    @Override
    public int getItemCount() {
        return CARD_ITEM_SIZE;
    }
}
