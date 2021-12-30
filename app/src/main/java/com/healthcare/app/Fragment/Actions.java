package com.healthcare.app.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.healthcare.app.R;
import com.healthcare.app.ViewModel.DataViewModel;

public class Actions extends Fragment {

    View view;
    TextView rec_about;
    DataViewModel dataViewModel;
    String image_path = "https://apkconnectlab.com/healthcareapp/";
    private ProgressDialog progress;
    ImageView image_view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_actions, container, false);

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        rec_about = view.findViewById(R.id.rec_about);
        image_view = view.findViewById(R.id.image_view);

        rec_about.setText("<p>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \\\\\\\"de Finibus Bonorum et Malorum\\\\\\\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \\\\\\\"Lorem ipsum dolor sit amet..\\\\\\\", comes from a line in section 1.10.32</p>");
        return view;
    }
}
