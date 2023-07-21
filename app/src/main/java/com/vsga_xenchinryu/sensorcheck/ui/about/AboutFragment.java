package com.vsga_xenchinryu.sensorcheck.ui.about;

import android.os.Bundle;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.vsga_xenchinryu.sensorcheck.R;
import com.vsga_xenchinryu.sensorcheck.databinding.FragmentAboutBinding;

public class AboutFragment extends Fragment {

    private FragmentAboutBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentAboutBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        LinearLayout aboutLayout = binding.aboutLayout;

        addDeviceInfoTextView(aboutLayout, "Nama Aplikasi : Sensor Checker");
        addDeviceInfoTextView(aboutLayout, "Versi Aplikasi : 1.0.0");
        addDeviceInfoTextView(aboutLayout, "Deskripsi Aplikasi : Aplikasi ini bertujuan untuk mengecek informasi mengenai sensor yang tersedia dalam perangkat anda dan informasi tambahan perangkat");
        addDeviceInfoTextView(aboutLayout, "Pengembang : Saeful Rohman" );
        addDeviceInfoTextView(aboutLayout, "Email : saefulrohmansmantika@gmail.com");
        addDeviceInfoTextView(aboutLayout, "Lisensi : 2023 Saeful Rohman All Rights Reserved");

        addSocialMediaTextView(aboutLayout, "Sosial Media :\nINSTAGRAM : https://www.instagram.com/saefulr_24/\nGITHUB : https://github.com/XenchinRyu7\nGoogle Dev Profile : https://g.dev/SaefulR");

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

    private void addSocialMediaTextView(LinearLayout layout, String text) {
        TextView textView = new TextView(requireContext());
        textView.setText(text);
        textView.setTextSize(16);
        textView.setTextColor(getResources().getColor(android.R.color.black));
        Linkify.addLinks(textView, Linkify.WEB_URLS);
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