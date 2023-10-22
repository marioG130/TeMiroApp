package org.mywire.temiroapp.ui.test;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import org.mywire.temiroapp.R;
import org.mywire.temiroapp.model.Test;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TestDaltonismo1#newInstance} factory method to create an instance of this fragment.
 */
public class TestDaltonismo1 extends Fragment {

    private static final String ARG_TIPO_TEST = "ARG_TIPO_TEST";
    private static final String ARG_PASO_TEST = "ARG_PASO_TEST";

    private static String tipoTest;
    private static int pasoTest;

    ImageView placa;
    Button boton1;
    Button boton2;
    Button boton3;
    ProgressBar pb1;
    Context ctx;
    DaltonProcs DUT;

    public TestDaltonismo1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TestDaltonismo1.
     */
    public static TestDaltonismo1 newInstance(String param1, int param2) {
        TestDaltonismo1 fragment = new TestDaltonismo1();
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
        View vista = inflater.inflate(R.layout.test_frag_daltonismo1, container, false);

        Test TD1 = new Test(ctx);
        TD1.setIdTest(4);
        TD1.setNombre("Daltonismo Básico");
        TD1.setCantidadPasos(3);
        TD1.insertar();

        TD1.buscar(2);
        TD1.setCantidadPasos(6);
        TD1.modificar();

        DUT = new DaltonProcs(ctx);
        pb1 = (ProgressBar) vista.findViewById(R.id.progressBarTD1);
        placa = (ImageView) vista.findViewById(R.id.imagePlaca);
        boton1 = (Button) vista.findViewById(R.id.button1);
        boton2 = (Button) vista.findViewById(R.id.button2);
        boton3 = (Button) vista.findViewById(R.id.button3);

        if (tipoTest.equals("BAS")) {
            DUT.cargarPasoBasico(pasoTest);
            DUT.colocarImagen(placa);
            boton1.setText(DUT.botones[0]);
            boton2.setText(DUT.botones[1]);
            boton3.setText(DUT.botones[2]);
            pb1.setProgress(pasoTest*33, true);
            pasoTest = pasoTest + 1;
        } else if (tipoTest.equals("ADV")) {
            DUT.cargarPasoAvanzado(pasoTest);
            DUT.colocarImagen(placa);
            // TODO: completar
        }

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // androidx.navigation.Navigation.findNavController(v).navigate(R.id.action_testDaltonismo1_self);
                // int respuesta = (int) v.getTag();
                androidx.navigation.Navigation.findNavController(v).navigate(R.id.action_testDaltonismo1_to_testDaltonismo2);
            }
        };
        boton1.setOnClickListener(listener);
        boton2.setOnClickListener(listener);
        boton3.setOnClickListener(listener);
        return vista;
    }

}
