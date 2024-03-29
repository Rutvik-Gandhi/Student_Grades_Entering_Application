package www.rutvikgandhiassignment2.com;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter  extends RecyclerView.Adapter<ListAdapter.ViewHolderList>
{
    private List<Grades> l;

    public ListAdapter(List<Grades> l)
    {
        super();
        this.l=l;
    }

    @NonNull
    @Override
    public ViewHolderList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom,parent,false);
        ViewHolderList vh = new ViewHolderList(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderList holder, int position) {

        Grades g = l.get(position);
        holder.tv1.setText( String.valueOf(g.getId()));
        holder.tv2.setText(g.getName());
        holder.tv3.setText(g.getProgram());
        float a=g.getMarks1();
        float b=g.getMarks2();
        float c=g.getMarks3();
        float d=g.getMarks4();
        holder.tv4.setText(String.valueOf(a));
        holder.tv5.setText(String.valueOf(b));
        holder.tv6.setText(String.valueOf(c));
        holder.tv7.setText(String.valueOf(d));
        float t = a+b+c+d;
        String t2 = String.format("%.2f", t);
        holder.tv8.setText("Total Marks : "+t2);
    }

    @Override
    public int getItemCount() {
        return  l.size();
    }

    class ViewHolderList extends RecyclerView.ViewHolder
    {
        public TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8;

        public ViewHolderList(@NonNull View itemView) {
            super(itemView);

            tv1 = itemView.findViewById(R.id.textView26);
            tv2 = itemView.findViewById(R.id.textView27);
            tv3 = itemView.findViewById(R.id.textView28);
            tv4 = itemView.findViewById(R.id.textView29);
            tv5 = itemView.findViewById(R.id.textView30);
            tv6 = itemView.findViewById(R.id.textView31);
            tv7 = itemView.findViewById(R.id.textView32);
            tv8 = itemView.findViewById(R.id.textView33);
        }
    }
}

