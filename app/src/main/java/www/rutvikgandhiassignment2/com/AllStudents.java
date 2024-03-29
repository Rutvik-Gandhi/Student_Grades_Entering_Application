// Define the package name
package www.rutvikgandhiassignment2.com;

// Import the required libraries
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

// Define the class that extends Fragment
public class AllStudents extends Fragment {

    // Define the RecyclerView and other variables
    RecyclerView rv;
    View v;
    List<Grades> list = new ArrayList<>();
    DbHelperClass dbh;
    ListAdapter la;

    // Override the onCreateView method to create the view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_all_students, container, false);

        // Find the RecyclerView from the layout
        rv= v.findViewById(R.id.rv);

        // Create a new instance of the database helper class
        dbh=new DbHelperClass(getActivity());

        // Get all the students from the database and store them in a Cursor object
        Cursor cu = dbh.allStudents();

        // Check if the Cursor is null, if so, show a toast message and return the view
        if(cu==null)
        {
            Toast.makeText(getActivity(),"No Data available", Toast.LENGTH_LONG).show();
            return v;
        }
        // If the Cursor is not null, move to the first record and loop through all the records
        else
        {
            cu.moveToFirst();

            do {
                // Create a new instance of the Grades class and set its properties from the record
                Grades g = new Grades();
                g.setId(cu.getInt(0));
                g.setName(cu.getString(1));
                g.setProgram(cu.getString(2));
                g.setMarks1(cu.getFloat(3));
                g.setMarks2(cu.getFloat(4));
                g.setMarks3(cu.getFloat(5));
                g.setMarks4(cu.getFloat(6));

                // Add the Grades object to the list
                list.add(g);

            }while (cu.moveToNext());

            // Close the Cursor and the database connection
            cu.close();
            dbh.close();

            // Create a new LinearLayoutManager and set it to vertical orientation
            LinearLayoutManager lm = new LinearLayoutManager(getContext());
            lm.setOrientation(LinearLayoutManager.VERTICAL);

            // Set the LinearLayoutManager to the RecyclerView
            rv.setLayoutManager(lm);

            // Create a new instance of the ListAdapter and set it to the RecyclerView
            la=new ListAdapter(list);
            rv.setAdapter(la);

            // Notify the adapter that the data has changed
            la.notifyDataSetChanged();

            // Return the view
            return v;
        }
    }
}