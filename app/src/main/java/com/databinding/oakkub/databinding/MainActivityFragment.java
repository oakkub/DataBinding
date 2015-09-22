package com.databinding.oakkub.databinding;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    @Bind(R.id.name_edittext)
    EditText nameEditText;
    @Bind(R.id.age_edittext)
    EditText ageEditText;
    @Bind(R.id.plus_one_button)
    Button plusOneButton;
    @Bind(R.id.save_button)
    Button saveButton;
    @Bind(R.id.radio_male)
    RadioButton radioMale;
    @Bind(R.id.radio_female)
    RadioButton radioFemale;

    private Employee employee;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.bind(this, rootView);

        employee = new Employee("Metas Kerdwat", 21, false);

        nameEditText.addTextChangedListener(this);
        ageEditText.addTextChangedListener(this);

        plusOneButton.setOnClickListener(this);
        saveButton.setOnClickListener(this);

        radioMale.setOnCheckedChangeListener(this);
        radioFemale.setOnCheckedChangeListener(this);

        nameEditText.setText(employee.getName());
        ageEditText.setText(String.valueOf(employee.getAge()));
        if (employee.getGender().equalsIgnoreCase("male")) radioMale.setChecked(true);
        else radioFemale.setChecked(false);

        return rootView;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}

    @Override
    public void afterTextChanged(Editable s) {

        if (nameEditText.getText().hashCode() == s.hashCode()) {

            employee.setName(s.toString());

        } else if (ageEditText.getText().hashCode() == s.hashCode()) {

            employee.setAge(Integer.parseInt(s.toString().equalsIgnoreCase("") ? "0" : s.toString()));
            if (s.toString().equalsIgnoreCase("")) ageEditText.setText("0");

        }

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.plus_one_button:

                employee.setAge(employee.getAge() + 1);

                ageEditText.setText(String.valueOf(employee.getAge()));

                break;

            case R.id.save_button:

                AlertDialogFragment dialog =
                        AlertDialogFragment.newInstance("Employee", employee.toString());

                dialog.show(getFragmentManager(), "alertEmployee");

                break;

        }

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        switch (buttonView.getId()) {

            case R.id.radio_male:

                if (isChecked) employee.setGender(false);

                break;

            case R.id.radio_female:

                if (isChecked) employee.setGender(true);

                break;

        }

    }
}
