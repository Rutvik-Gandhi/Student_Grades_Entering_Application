// Import required libraries and classes
package www.rutvikgandhiassignment2.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

// Define MainActivity class
public class MainActivity extends AppCompatActivity {

    // Declare variables for DrawerLayout, ActionBarDrawerToggle, and NavigationView
    DrawerLayout dl;
    ActionBarDrawerToggle adt;
    NavigationView niv;

    // onCreate() method is called when the activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Set the layout for the activity

        // Initialize NavigationView and DrawerLayout
        niv = findViewById(R.id.nv);
        dl = findViewById(R.id.dl);

        // Display initial fragment in the activity (GradeEnter fragment)
        Fragment fragments = new GradeEnter();
        FragmentTransaction transactions = getSupportFragmentManager().beginTransaction();
        transactions.replace(R.id.frame, fragments);
        transactions.commit();

        // Initialize ActionBarDrawerToggle and add it as a DrawerListener to the DrawerLayout
        adt = new ActionBarDrawerToggle(this, dl, R.string.nav_open, R.string.nav_close);
        dl.addDrawerListener(adt);
        adt.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Display the navigation button on the action bar

        // Set a NavigationItemSelectedListener on the NavigationView to handle clicks on menu items
        niv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment frt = null;

                int itemId = item.getItemId();

                // Determine which menu item was clicked and set the appropriate fragment to be displayed
                if(itemId == R.id.item_grades)
                {
                    frt = new GradeEnter();
                }
                else if(itemId == R.id.item_improvement)
                {
                    frt = new ImprovementEnter();
                }
                else if(itemId == R.id.item_search)
                {
                    frt = new Gradesearch();
                }
                else if(itemId == R.id.item_list)
                {
                    frt = new AllStudents();
                }

                // Replace the current fragment with the selected fragment and close the drawer
                if(frt!=null)
                {
                    FragmentTransaction transactions = getSupportFragmentManager().beginTransaction();
                    transactions.replace(R.id.frame, frt);
                    transactions.commit();
                    dl.closeDrawers();
                    return true;
                }
                return false;
            }
        });
    }

    // onOptionsItemSelected() method is called when a menu item is selected
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(adt.onOptionsItemSelected(item)) // If the ActionBarDrawerToggle is selected, open the drawer
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
} // End of MainActivity class