package www.rutvikgandhiassignment2.com;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Gradesearch extends Fragment {

    View v;
    EditText et1;
    TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7;
    Button btn01;
    DbHelperClass dbh;

    String id, name, program;
    int id2;
    float m1, m2, m3, m4, total;

    @Override
    public View onCreateView(LayoutInflater inflater03, ViewGroup container03,
                             Bundle savedInstanceState30) {

        v = inflater03.inflate(R.layout.fragment_grade_search, container03, false);

        et1 = v.findViewById(R.id.editTextTextPersonName);
        tv1 = v.findViewById(R.id.textView11);
        tv2 = v.findViewById(R.id.textView12);
        tv3 = v.findViewById(R.id.textView17);
        tv4 = v.findViewById(R.id.textView18);
        tv5 = v.findViewById(R.id.textView19);
        tv6 = v.findViewById(R.id.textView20);
        tv7 = v.findViewById(R.id.textView25);
        btn01 = v.findViewById(R.id.button2);
        dbh=new DbHelperClass(getActivity());

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                id = et1.getText().toString();

                id2 = Integer.parseInt(id);

                Cursor cu = dbh.gradeSearch(id2);

                if(cu==null)
                {
                    Toast.makeText(getActivity(),"No Records", Toast.LENGTH_LONG).show();
                }
                else
                {
                    cu.moveToFirst();

                    name = cu.getString(1);
                    program = cu.getString(2);
                    m1 = cu.getFloat(3);
                    m2 = cu.getFloat(4);
                    m3 = cu.getFloat(5);
                    m4 = cu.getFloat(6);

                    total = m1 + m2 + m3 + m4;
                    String total2 = String.format("%.2f", total);

                    tv1.setText(name);
                    tv2.setText(program);
                    tv3.setText(String.valueOf(m1));
                    tv4.setText(String.valueOf(m2));
                    tv5.setText(String.valueOf(m3));
                    tv6.setText(String.valueOf(m4));
                    tv7.setText(total2);
                    cu.close();
                    dbh.close();
                }
            }

        });

        return v;
    }
}
