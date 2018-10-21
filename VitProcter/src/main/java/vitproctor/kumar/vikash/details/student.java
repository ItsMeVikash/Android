package vitproctor.kumar.vikash.details;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import vitproctor.kumar.vikash.R;
import vitproctor.kumar.vikash.details.student_details;


public class student extends Fragment{
    DatabaseReference dreference;
    String student_name,teacher_name,id,mobile,remarks;
    TextView Sname,Sid,Smobile,Sremarks;
    public student() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_student, container, false);
        student_details activity = (student_details) getActivity();
         student_name = activity.getStudentName();
         teacher_name = activity.getParentName();
        Sname=(TextView)view.findViewById(R.id.student_name);
        Sid=(TextView)view.findViewById(R.id.student_reg_no);
        Smobile=(TextView)view.findViewById(R.id.student_mobile);
        Sremarks=(TextView)view.findViewById(R.id.student_remarks);
        dreference = FirebaseDatabase.getInstance().getReference().child("Faculty_Name").child(teacher_name).child(student_name);
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                id=dataSnapshot.child("ID").getValue().toString();
                remarks=dataSnapshot.child("REMARKS").getValue().toString();
                mobile=dataSnapshot.child("MOBILE").getValue().toString();
                Sname.setText(student_name);
                Sid.setText(id);
                Smobile.setText(mobile);
                Sremarks.setText(remarks);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                System.out.println(databaseError.toException());
                // ...
            }
        };
        dreference.addValueEventListener(listener);

        return view;
    }

}