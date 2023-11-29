package com.example.fragmentapplication;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Category#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Category extends Fragment {

    private int[] buttons = {R.id.showNews, R.id.sportsNews, R.id.storyNews};

    private int selected = -1;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Category() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Category.
     */
    // TODO: Rename and change types and number of parameters
    public static Category newInstance(String param1, String param2) {
        Category fragment = new Category();
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
        View fragmentCategory = inflater.inflate(R.layout.fragment_category, container, false);

        ImageButton imageButton;

        if (getArguments() != null) {
            selected = getArguments().getInt("categorySelected");
        }

        for (int i = 0; i < buttons.length; i++) {
            final int imageButtonSelected = i;
            imageButton = (ImageButton) fragmentCategory.findViewById(buttons[i]);

            if (selected == i) {
                imageButton.setBackgroundColor(Color.parseColor("#3FB1F6"));
            }

            imageButton.setOnClickListener((v) -> {
                Activity activity = getActivity();
                ICategory category = (ICategory) activity;
                category.getCategorySelected(imageButtonSelected);
            });
        }

        return fragmentCategory;
    }


}