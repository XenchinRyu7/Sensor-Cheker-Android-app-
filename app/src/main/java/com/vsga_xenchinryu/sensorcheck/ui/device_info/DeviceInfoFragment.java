package com.vsga_xenchinryu.sensorcheck.ui.device_info;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.vsga_xenchinryu.sensorcheck.R;
import com.vsga_xenchinryu.sensorcheck.databinding.FragmentDevinfoBinding;

public class DeviceInfoFragment extends Fragment {

    private FragmentDevinfoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDevinfoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        LinearLayout deviceInfoLayout = binding.deviceInfoLayout;

        addDeviceInfoTextView(deviceInfoLayout, "Device Model: " + Build.MODEL);
        addDeviceInfoTextView(deviceInfoLayout, "Android Version: " + Build.VERSION.RELEASE);
        addDeviceInfoTextView(deviceInfoLayout, "Manufacturer: " + Build.MANUFACTURER);
        addDeviceInfoTextView(deviceInfoLayout, "Board: " + Build.BOARD);
        addDeviceInfoTextView(deviceInfoLayout, "Brand: " + Build.BRAND);
        addDeviceInfoTextView(deviceInfoLayout, "Bootloader: " + Build.BOOTLOADER);
        addDeviceInfoTextView(deviceInfoLayout, "Display: " + Build.DISPLAY);
        addDeviceInfoTextView(deviceInfoLayout, "Fingerprint: " + Build.FINGERPRINT);
        addDeviceInfoTextView(deviceInfoLayout, "Hardware: " + Build.HARDWARE);
        addDeviceInfoTextView(deviceInfoLayout, "ID: " + Build.ID);
        addDeviceInfoTextView(deviceInfoLayout, "Tags: " + Build.TAGS);
        addDeviceInfoTextView(deviceInfoLayout, "Type: " + Build.TYPE);

        return root;
    }

    private void addDeviceInfoTextView(LinearLayout layout, String text) {
        TextView textView = new TextView(requireContext());
        textView.setText(text);
        textView.setTextSize(16);
        textView.setTextColor(getResources().getColor(android.R.color.black));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(16, 8, 16, 8);
        textView.setLayoutParams(layoutParams);
        layout.addView(textView);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
