package www.rutvikgandhiassignment2.com;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelperClass  extends SQLiteOpenHelper
{
    static final String DATABASE_NAME = "School.db";
    static final int VERSION = 1;
    static final String TABLE_NAME1 = "Grades";
    static final String TABLE_NAME2 = "Improvement";

    static final String T1C1="StudentId";
    static final String T1C2="Student Name";
    static final String T1C3="Program Name";
    static final String T1C4="Course-1";
    static final String T1C5="Course-2";
    static final String T1C6="Course-3";
    static final String T1C7="Course-4";

    static final String T2C1="ImprovementId";
    static final String T2C2="StudentId";
    static final String T2C3="Course";
    static final String T2C4="Marks";

    static final String CREATE_TABLE1="create table " + TABLE_NAME1 + " (" + T1C1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + T1C2 + "TEXT NOT NULL, "
            + T1C3 + "TEXT, "  + T1C4 + " FLOAT, " + T1C5 + " FLOAT, " + T1C6 + " FLOAT, " + T1C7 + " FLOAT); ";
    static final String DROP_TABLE1="DROP TABLE IF EXISTS " + TABLE_NAME1;

    static final String CREATE_TABLE2="create table " + TABLE_NAME2 + " (" + T2C1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + T2C2 + " INTEGER, "
            + T2C3 + "TEXT, "  + T2C4 + " FLOAT); ";
    static final String DROP_TABLE2="DROP TABLE IF EXISTS " + TABLE_NAME2;


    public DbHelperClass(Context context01)
    {
        super(context01, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase01) {

        sqLiteDatabase01.execSQL(CREATE_TABLE1);
        sqLiteDatabase01.execSQL(CREATE_TABLE2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase01, int i, int i1) {

        sqLiteDatabase01.execSQL(DROP_TABLE1);
        sqLiteDatabase01.execSQL(DROP_TABLE2);

        onCreate(sqLiteDatabase01);
    }
    public boolean gradesEnter(Grades g)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(T1C2,g.getName());
        cv.put(T1C3,g.getProgram());
        cv.put(T1C4,g.getMarks1());
        cv.put(T1C5,g.getMarks2());
        cv.put(T1C6,g.getMarks3());
        cv.put(T1C7,g.getMarks4());
        long result = db.insert(TABLE_NAME1, null,cv);
        return (result != -1);
    }

    public int improvementEnter(Improvment i)
    {
        long r2 = -1;

        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put(T2C2,i.getStudentId());
        cv.put(T2C3,i.getCourse());
        cv.put(T2C4, i.getMarks());
        long res = db.insert(TABLE_NAME2, null,cv);

        SQLiteDatabase db1 = this.getReadableDatabase();

        Cursor cu = db1.query(TABLE_NAME1, new String[] { i.getCourse() }, T1C1 + "=?",
                new String[] {String.valueOf(i.getStudentId()) }, null, null, null, null);

        if (cu.moveToFirst()) {

            float m1 = Float.parseFloat(cu.getString(0));
            float m2 = m1 + i.getMarks();

            if(m2<=100)
            {
                ContentValues cv2 = new ContentValues();
                cv2.put(i.getCourse(), m2);
                String whereClause = T1C1 + "=?";
                String whereArgs[] = {String.valueOf(i.getStudentId())};

                r2 = db.update(TABLE_NAME1, cv2, whereClause, whereArgs);

                return ((r2==-1) ? -1 : 1);
            }
            else
            {
                return 2;
            }
        }
        else
        {
            return 0;
        }
    }

    public Cursor gradeSearch(int studentId)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cu = db.query(TABLE_NAME1, new String[] { T1C1, T1C2, T1C3, T1C4, T1C5, T1C6, T1C7 }, T1C1 + "=?",
                new String[] {String.valueOf(studentId) }, null, null, null, null);

        return cu;
    }

    public Cursor allStudents()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cu;
        cu=db.rawQuery("select * from " + TABLE_NAME1, null);
        if(cu != null)
        {
            cu.moveToFirst();
        }
        return cu;
    }
}

