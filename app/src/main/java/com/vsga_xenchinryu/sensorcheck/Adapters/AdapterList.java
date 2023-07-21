    package com.vsga_xenchinryu.sensorcheck.Adapters;

    import android.view.LayoutInflater;
    import android.view.ViewGroup;

    import androidx.annotation.NonNull;
    import androidx.recyclerview.widget.RecyclerView;

    import com.vsga_xenchinryu.sensorcheck.databinding.ListSensorBinding;
    import com.vsga_xenchinryu.sensorcheck.ui.list_sensor.ListSensorViewModel;
    import com.vsga_xenchinryu.sensorcheck.ui.list_sensor.ListSensorViewModel.SensorItem;

    import java.util.List;

    public class AdapterList extends RecyclerView.Adapter<AdapterList.HolderData> {
        private final List<SensorItem> sensorItems;

        public AdapterList(List<SensorItem> sensorItems) {
            this.sensorItems = sensorItems;
        }

        public static class HolderData extends RecyclerView.ViewHolder {
            private final ListSensorBinding binding;

            public HolderData(@NonNull ListSensorBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }

            public void bind(ListSensorViewModel.SensorItem sensorItem) {
                binding.textViewTypeSensor.setText(sensorItem.getSensorName());
                binding.textViewInfoSensor.setText(sensorItem.isAvailable() ? "Support" : "Tidak Support");
            }
        }

        @NonNull
        @Override
        public AdapterList.HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            ListSensorBinding binding = ListSensorBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new HolderData(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull AdapterList.HolderData holder, int position) {
            SensorItem sensorItem = sensorItems.get(position);
            holder.bind(sensorItem);
        }

        @Override
        public int getItemCount() {
            return sensorItems.size();
        }
    }
