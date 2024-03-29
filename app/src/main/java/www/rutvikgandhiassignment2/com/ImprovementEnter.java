package www.rutvikgandhiassignment2.com;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ImprovementEnter extends Fragment {

    View v;
    EditText et1, et2;
    Spinner sp01;
    Button btn01;
    DbHelperClass dbh;
    String courses, marks, id;
    int id2, res;
    float marks02;
    ArrayAdapter ad;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_improvment_enter, container, false);

        et1 = v.findViewById(R.id.editTextTextPersonName2);
        et2=v.findViewById(R.id.editTextTextPersonName5);
        sp01=v.findViewById(R.id.spinner);
        btn01=v.findViewById(R.id.button3);

        dbh=new DbHelperClass(getActivity());

        ad = ArrayAdapter.createFromResource(getActivity(), R.array.sparray, android.R.layout.simple_spinner_item);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp01.setAdapter(ad);

        sp01.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {

                courses=sp01.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                id = et1.getText().toString();
                marks = et2.getText().toString();

                if(id.equalsIgnoreCase("") || marks.equalsIgnoreCase(""))
                {
                    Toast.makeText(getActivity(), "Fields can't be empty", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    id2 = Integer.parseInt(id);
                    marks02 = Float.parseFloat(marks);

                    Improvment i = new Improvment();

                    i.setStudentId(id2);
                    i.setCourse(courses);
                    i.setMarks(marks02);

                    res=dbh.improvementEnter(i);

                    if(res==1)
                    {
                        Toast.makeText(getActivity(),"Improvement Entered", Toast.LENGTH_LONG).show();
                    }
                    else if(res==-1)
                    {
                        Toast.makeText(getActivity(),"Improvement Failure", Toast.LENGTH_LONG).show();
                    }
                    else if(res==2)
                    {
                        Toast.makeText(getActivity(),"Total marks more than 100", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(getActivity(),"No record founds", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

        return v;
    }
}
