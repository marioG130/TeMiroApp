package org.mywire.temiroapp.ui.main;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import org.mywire.temiroapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TopMenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TopMenuFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TopMenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TopMenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TopMenuFragment newInstance(String param1, String param2) {
        TopMenuFragment fragment = new TopMenuFragment();
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
        View menuTop = inflater.inflate(R.layout.main_frag_top_menu, container, false);
        ImageButton botonBack;
        botonBack = (ImageButton) menuTop.findViewById(R.id.backButton);
        botonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity estaActiv = getActivity();
                estaActiv.onBackPressed();
            }
        });
        return menuTop;
    }

}
