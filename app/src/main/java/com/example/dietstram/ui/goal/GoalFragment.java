package com.example.dietstram.ui.goal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.dietstram.MainActivity;
import com.example.dietstram.R;

import static com.example.dietstram.OpenCloseDB.changeTitle;

public class GoalFragment extends Fragment {
    /* Action buttons */
    MenuItem menuItemEdit;
    MenuItem menuItemDelete;
    MenuItem menuItemAdd;



    private String currentId;
    private String currentName;
    private View mainView;

    private GoalViewModel goalViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Set title */
        changeTitle(getActivity(),"Profile");

    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        goalViewModel =
                ViewModelProviders.of(this).get(GoalViewModel.class);
         mainView = inflater.inflate(R.layout.fragment_goal, container, false);

        return mainView;
    }
}