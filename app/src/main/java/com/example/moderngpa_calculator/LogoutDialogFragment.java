package com.example.moderngpa_calculator;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.firebase.auth.FirebaseAuth;

public class LogoutDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setMessage("Do you wish to Log out?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    FirebaseAuth.getInstance().signOut();
                    Intent Myintent=new Intent(getContext(),Signup.class);
                    startActivity(Myintent);
                    getActivity().finish();
                    dialog.dismiss();

                })
                .setNegativeButton("No", (dialog, which) -> {
                    dialog.dismiss();
                });

        return builder.create();

    }
}
