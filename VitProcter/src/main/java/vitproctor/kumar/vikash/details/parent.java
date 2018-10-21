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


/**
 * A simple {@link Fragment} subclass.
 */
public class parent extends Fragment {
    DatabaseReference dreference;
    String student_name,teacher_name,parent_name,parent_mobile,parent_remarks;
    TextView Sparent_name,Sparent_mobile,Sparent_remarks;

    public parent() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_parent, container, false);
        student_details activity = (student_details) getActivity();
        student_name = activity.getStudentName();
        teacher_name = activity.getParentName();
        Sparent_name=(TextView)view.findViewById(R.id.parent_name);
        Sparent_mobile=(TextView)view.findViewById(R.id.parent_mobile);
        Sparent_remarks=(TextView)view.findViewById(R.id.parent_remarks);

        dreference = FirebaseDatabase.getInstance().getReference().child("Faculty_Name").child(teacher_name).child(student_name);
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                parent_name=dataSnapshot.child("PARENT NAME").getValue().toString();
                parent_mobile=dataSnapshot.child("PARENT MOBILE").getValue().toString();
                parent_remarks=dataSnapshot.child("PARENT REMARKS").getValue().toString();
                Sparent_name.setText(parent_name);
                Sparent_mobile.setText(parent_mobile);
                Sparent_remarks.setText(parent_remarks);
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
