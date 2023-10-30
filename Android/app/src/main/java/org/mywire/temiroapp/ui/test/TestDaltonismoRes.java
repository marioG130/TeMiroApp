package org.mywire.temiroapp.ui.test;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.mywire.temiroapp.R;
import org.mywire.temiroapp.data.prefs.PreferencesHelper;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TestDaltonismoRes#newInstance} factory method to create an instance of this fragment.
 */
public class TestDaltonismoRes extends Fragment {

    private static final String ARG_TIPO_TEST = "ARG_TIPO_TEST";
    private static final String ARG_PASO_TEST = "ARG_PASO_TEST";

    private static String tipoTest;
    private static int pasoTest;

    TextView resultado1;
    TextView resultado2;
    Context ctx;
    DaltonProcs DPR;

    public TestDaltonismoRes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TestDaltonismo4.
     */
    // TODO: Rename and change types and number of parameters
    public static TestDaltonismoRes newInstance(String param1, int param2) {
        TestDaltonismoRes fragment = new TestDaltonismoRes();
        Bundle args = new Bundle();
        args.putString(ARG_TIPO_TEST, param1);
        args.putInt(ARG_PASO_TEST, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tipoTest = "BAS";
        pasoTest = 1;
        if (getArguments() != null) {
            tipoTest = getArguments().getString(ARG_TIPO_TEST);
            pasoTest = getArguments().getInt(ARG_PASO_TEST);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ctx = getActivity();
        View vista = inflater.inflate(R.layout.test_frag_daltonismo_res, container, false);
        resultado1 = (TextView) vista.findViewById(R.id.textResuD1);
        resultado2 = (TextView) vista.findViewById(R.id.textResuD2);

        PreferencesHelper prefs = new PreferencesHelper(ctx);
        tipoTest = prefs.getTipoDalton1();
        DPR = new DaltonProcs(ctx);
        boolean todasBien = true;
        if (tipoTest.equals("BAS")) {
            for (int i=1; i<=3; i++) {
                DPR.cargarPasoBasico(i);
                if (DPR.TDRespuestas[i-1] != DPR.botonCorrecto) {
                    todasBien = false;
                }
            }
        } else if (tipoTest.equals("ADV")) {
            for (int i=1; i<=4; i++) {
                DPR.cargarPasoAvanzado(i);
                if (DPR.TDRespuestas[i-1] != DPR.botonCorrecto) {
                    todasBien = false;
                }
            }
        }
        if (todasBien) {
            resultado1.setText("Felicitaciones !");
            resultado2.setText("Su visión de colores es normal");
        } else {
            resultado1.setText("Oops !");
            resultado2.setText("Ud. tiene problemas para ver algunos colores");
        }
        return vista;
    }

}
