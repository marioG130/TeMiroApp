package org.mywire.temiroapp.ui.service;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.mywire.temiroapp.MainActivity;
import org.mywire.temiroapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ServiceFormuConsulta#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ServiceFormuConsulta extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ServiceFormuConsulta() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Service_Formu_Consulta.
     */
    // TODO: Rename and change types and number of parameters
    public static ServiceFormuConsulta newInstance(String param1, String param2) {
        ServiceFormuConsulta fragment = new ServiceFormuConsulta();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.service_formu_consulta, container, false);


        Button btnEnviar = view.findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (areFieldsValid()) {
                    Toast.makeText(getContext(), "Mensaje enviado", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                } else {

                    Toast.makeText(getContext(), "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    private boolean areFieldsValid() {
        EditText etApellido = getView().findViewById(R.id.etApellido);
        EditText etNombre = getView().findViewById(R.id.etNombre);
        EditText etEmail = getView().findViewById(R.id.etEmail);
        EditText etTelefono = getView().findViewById(R.id.etTelefono);
        EditText etConsulta = getView().findViewById(R.id.etConsulta);

        if (etApellido.getText().toString().trim().isEmpty() ||
                etNombre.getText().toString().trim().isEmpty() ||
                etEmail.getText().toString().trim().isEmpty() ||
                etTelefono.getText().toString().trim().isEmpty() ||
                etConsulta.getText().toString().trim().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}

