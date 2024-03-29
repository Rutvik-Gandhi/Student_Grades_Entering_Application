package www.rutvikgandhiassignment2.com;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GradeEnter extends Fragment {

    DbHelperClass dbHelperClass;

    View v;

    EditText et1, et2, et3, et4, et5, et6;
    Button btn01;
    Boolean bool;
    String name, program;
    String A,B,C,D;
    float c1, c2, c3, c4;

    @Override
    public View onCreateView(LayoutInflater inflater02, ViewGroup container02,
                             Bundle savedInstanceState02) {
        v = inflater02.inflate(R.layout.fragment_grade_enter, container02, false);

        et1 = v.findViewById(R.id.editTextTextPersonName3);
        et2 = v.findViewById(R.id.editTextTextPersonName4);
        et3 = v.findViewById(R.id.editTextNumberDecimal);
        et4 = v.findViewById(R.id.editTextNumberDecimal2);
        et5 = v.findViewById(R.id.editTextNumberDecimal3);
        et6 = v.findViewById(R.id.editTextNumberDecimal4);
        btn01=v.findViewById(R.id.button);

        dbHelperClass=new DbHelperClass(getActivity());

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = et1.getText().toString();
                program = et2.getText().toString();
                A = et3.getText().toString();
                B = et4.getText().toString();
                C = et5.getText().toString();
                D = et6.getText().toString();

                if(name.equalsIgnoreCase("") || program.equalsIgnoreCase("") ||
                        A.equalsIgnoreCase("") || B.equalsIgnoreCase("") || C.equalsIgnoreCase("") ||
                        D.equalsIgnoreCase(""))
                {

                }
                else
                {
                    c1 = Float.parseFloat(A);
                    c2 = Float.parseFloat(B);
                    c3 = Float.parseFloat(C);
                    c4 = Float.parseFloat(D);

                    Grades g = new Grades();

                    g.setName(name);
                    g.setProgram(program);
                    g.setMarks1(c1);
                    g.setMarks2(c2);
                    g.setMarks3(c3);
                    g.setMarks4(c4);

                    bool=dbHelperClass.gradesEnter(g);

                    if(bool)
                    {
                        Toast.makeText(getActivity(),"Grades Saved", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(getActivity(),"Grades Failure", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        return v;
    }
}
