package org.mywire.temiroapp.ui.test;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import org.mywire.temiroapp.R;
import org.mywire.temiroapp.data.prefs.PreferencesHelper;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TestDaltonismo3#newInstance} factory method to create an instance of this fragment.
 */
public class TestDaltonismo3 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private static String tipoTest;
    private static int pasoTest;

    ImageView placa;
    Button boton1;
    Button boton2;
    Button boton3;
    ProgressBar pb1;
    Context ctx;
    DaltonProcs DPR;

    public TestDaltonismo3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TestDaltonismo3.
     */
    // TODO: Rename and change types and number of parameters
    public static TestDaltonismo3 newInstance(String param1, String param2) {
        TestDaltonismo3 fragment = new TestDaltonismo3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tipoTest = "BAS";
        pasoTest = 3;
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ctx = getActivity();
        View vista = inflater.inflate(R.layout.test_frag_daltonismo3, container, false);

        DPR = new DaltonProcs(ctx);
        pb1 = (ProgressBar) vista.findViewById(R.id.progressBarTD1);
        placa = (ImageView) vista.findViewById(R.id.imagePlaca);
        boton1 = (Button) vista.findViewById(R.id.button1);
        boton2 = (Button) vista.findViewById(R.id.button2);
        boton3 = (Button) vista.findViewById(R.id.button3);

        PreferencesHelper prefs = new PreferencesHelper(ctx);
        tipoTest = prefs.getTipoDalton1();
        if (tipoTest.equals("BAS")) {
            DPR.cargarPasoBasico(pasoTest);
        } else if (tipoTest.equals("ADV")) {
            DPR.cargarPasoAvanzado(pasoTest);
        }
        DPR.colocarImagen(placa);
        boton1.setText(DPR.botones[0]);
        boton2.setText(DPR.botones[1]);
        boton3.setText(DPR.botones[2]);
        pb1.setProgress(pasoTest*33, true);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int respuesta = Integer.parseInt((String) v.getTag());
                Log.d("DALTON", "TD1 = "+String.valueOf(respuesta));
                DPR.TDRespuestas[2] = respuesta;
                if (tipoTest.equals("BAS")) {
                    androidx.navigation.Navigation.findNavController(v).navigate(R.id.action_testDaltonismo3_to_testDaltonismoR);
                } else if (tipoTest.equals("ADV")) {
                    androidx.navigation.Navigation.findNavController(v).navigate(R.id.action_testDaltonismo3_to_testDaltonismo4);
                }
            }
        };
        boton1.setOnClickListener(listener);
        boton2.setOnClickListener(listener);
        boton3.setOnClickListener(listener);
        return vista;
    }

}
