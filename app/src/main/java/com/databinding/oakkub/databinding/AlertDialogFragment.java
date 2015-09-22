package com.databinding.oakkub.databinding;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by OaKKuB on 9/22/2015.
 */
public class AlertDialogFragment extends DialogFragment {

    public static AlertDialogFragment newInstance(String title, String message) {

        AlertDialogFragment alertDialogFragment = new AlertDialogFragment();

        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("message", message);

        alertDialogFragment.setArguments(args);

        return alertDialogFragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Bundle args = getArguments();

        final String title = args.getString("title");
        final String message = args.getString("message");

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle(title)
                .setMessage(message)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setNegativeButton("OK", null);

        return builder.create();
    }
}
