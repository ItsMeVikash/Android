package kumar.vikash.sssbirthdayplanner;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.Date;

public class Admin extends AppCompatActivity {
    EditText name,price,description;
    Button save;
    FloatingActionButton choose;
    ImageView image;
    Spinner category;
    // Folder path for Firebase Storage.
    String Storage_Path = "image/";
    Uri FilePathUri;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    // Image request code for onActivityResult() .
    int Image_Request_Code = 7;
    ProgressDialog progressDialog ;
    String[] items = new String[]{"Trending", "Fruit", "Chocolate","Vanilla","Non-Veg","Eggless","Others"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        //Toolbar as actionBar
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar.setTitle("ADD ITEMS");
        setSupportActionBar(toolbar);
        mTitle.setText(toolbar.getTitle());
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        name=(EditText)findViewById(R.id.name);
        price=(EditText)findViewById(R.id.price);
        description=(EditText)findViewById(R.id.description);
        choose=(FloatingActionButton) findViewById(R.id.choose);
        save=(Button)findViewById(R.id.save);
        image=(ImageView)findViewById(R.id.image);
        category=(Spinner)findViewById(R.id.category);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        category.setAdapter(adapter);
        choose.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Please Select Image"), Image_Request_Code);
            }
        });
        storageReference = FirebaseStorage.getInstance().getReference();
        progressDialog = new ProgressDialog(Admin.this);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!TextUtils.isEmpty(name.getText().toString())||
                        (!TextUtils.isEmpty(price.getText().toString()))||
                        (!TextUtils.isEmpty(description.getText().toString())))
                {
                    progressDialog.setTitle("Image is Uploading...");
                    progressDialog.show();
                    databaseReference = FirebaseDatabase.getInstance().getReference("Cakes").child(category.getSelectedItem().toString().trim()).push();
                    databaseReference.child("Name").setValue(name.getText().toString().trim());
                    databaseReference.child("Price").setValue(price.getText().toString().trim());
                    databaseReference.child("Description").setValue(description.getText().toString().trim());
                    StorageReference storageReference2nd = storageReference.child(Storage_Path +new Date().getTime() + "." + GetFileExtension(FilePathUri));
                    storageReference2nd.putFile(FilePathUri)
                            .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                    databaseReference.child("Image").setValue(taskSnapshot.getDownloadUrl().toString());
                                    progressDialog.dismiss();
                                    Toast.makeText(getApplicationContext(), "Cake Added Successfully ", Toast.LENGTH_LONG).show();

                                }
                            })
                            // If something goes wrong .
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception exception) {
                                    progressDialog.dismiss();
                                    Toast.makeText(Admin.this, exception.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            })
                            // On progress change upload time.
                            .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                                    // Setting progressDialog Title.
                                    progressDialog.setTitle("Image is Uploading...");

                                }
                            });

                }
                else
                {
                    //showing confirmation dialog box
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Admin.this);
                    alertDialogBuilder.setMessage("Enter All Details First");
                    alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                        }
                    });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
                name.setText("");
                price.setText("");
                description.setText("");
                image.setImageBitmap(null);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Image_Request_Code && resultCode == RESULT_OK && data != null && data.getData() != null) {
            FilePathUri = data.getData();
            try {
                // Getting selected image into Bitmap.
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), FilePathUri);
                // Setting up bitmap selected image into ImageView.
                image.setImageBitmap(bitmap);
            }
            catch (IOException e) {e.printStackTrace();}
        }
    }
    // Creating Method to get the selected image file Extension from File Path URI.
    public String GetFileExtension(Uri uri) {
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        // Returning the file Extension.
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
    }
}
