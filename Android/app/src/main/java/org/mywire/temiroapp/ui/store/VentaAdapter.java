package org.mywire.temiroapp.ui.store;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import org.mywire.temiroapp.R;
import org.mywire.temiroapp.model.Venta;
import java.util.List;

public class VentaAdapter extends RecyclerView.Adapter<VentaAdapter.ViewHolder> {
    private List<Venta> ventas;

    public void setData(List<Venta> ventas) {
        this.ventas = ventas;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_venta, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (ventas != null && position < ventas.size()) {
            Venta venta = ventas.get(position);
            holder.bind(venta);
        }
    }

    @Override
    public int getItemCount() {
        return ventas != null ? ventas.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtIdVenta;
        private TextView txtDescripcion;

        public ViewHolder(View itemView) {
            super(itemView);
            txtIdVenta = itemView.findViewById(R.id.txtIdVenta);
            txtDescripcion = itemView.findViewById(R.id.txtDescripcion);
        }

        public void bind(Venta venta) {
            txtIdVenta.setText("ID Venta: " + String.valueOf(venta.getIdventa()));
            txtDescripcion.setText("Descripción: " + venta.getDescripcion());
        }
    }
}

