package org.mywire.temiroapp.ui.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import org.mywire.temiroapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuBotones#newInstance} factory method to create an instance of this fragment.
 */
public class MenuBotones extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button boton1;
    Button boton2;
    Button boton3;

    public MenuBotones() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuBotones.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuBotones newInstance(String param1, String param2) {
        MenuBotones fragment = new MenuBotones();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View menuBot = inflater.inflate(R.layout.test_frag_menu_botones, container, false);
        boton1 = (Button) menuBot.findViewById(R.id.testButton1);
        boton2 = (Button) menuBot.findViewById(R.id.testButton2);
        boton3 = (Button) menuBot.findViewById(R.id.testButton3);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                androidx.navigation.Navigation.findNavController(v).navigate(R.id.action_menuBotones_to_testDaltonismo1);
            }
        });
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                androidx.navigation.Navigation.findNavController(v).navigate(R.id.action_menuBotones_to_testAgudeza1);
            }
        });
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                androidx.navigation.Navigation.findNavController(v).navigate(R.id.action_menuBotones_to_fragNoImplementado);
            }
        });
        return menuBot;
    }

}
