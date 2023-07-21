package com.vsga_xenchinryu.sensorcheck.ui.list_sensor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vsga_xenchinryu.sensorcheck.Adapters.AdapterList;
import com.vsga_xenchinryu.sensorcheck.databinding.FragmentListSensorBinding;

public class ListFragment extends Fragment {

    private AdapterList adapterList;

    private FragmentListSensorBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ListSensorViewModel viewModel =
                new ViewModelProvider(this).get(ListSensorViewModel.class);

        binding = FragmentListSensorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(decoration);

        viewModel.getSensorList(requireContext()).observe(getViewLifecycleOwner(), sensorList -> {
            adapterList = new AdapterList(sensorList);
            recyclerView.setAdapter(adapterList);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
