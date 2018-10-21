package vikash.ganpatimart.supplier;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

import vikash.ganpatimart.Login;
import vikash.ganpatimart.customer.List_Items;
import vikash.ganpatimart.R;

public class MainActivity extends AppCompatActivity {
    EditText serial_no,item_name,mrp,market_rate,descount;
    Button save;
    FloatingActionButton choose;
    ImageView image;
    // Folder path for Firebase Storage.
    String Storage_Path = "image/";
    Uri FilePathUri;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    // Image request code for onActivityResult() .
    int Image_Request_Code = 7;
    ProgressDialog progressDialog ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar as actionBar
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar.setLogo(R.mipmap.ic_launcher_round);
        toolbar.setTitle("Ganpati Mart");
        setSupportActionBar(toolbar);
        mTitle.setText(toolbar.getTitle());
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        storageReference = FirebaseStorage.getInstance().getReference();
        progressDialog = new ProgressDialog(MainActivity.this);

        serial_no=(EditText)findViewById(R.id.serial_no);
        item_name=(EditText)findViewById(R.id.item_name);
        mrp=(EditText)findViewById(R.id.mrp);
        market_rate=(EditText)findViewById(R.id.market_rate);
        descount=(EditText)findViewById(R.id.descount);
        choose=(FloatingActionButton) findViewById(R.id.choose);
        save=(Button)findViewById(R.id.save);
        image=(ImageView)findViewById(R.id.image);
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Please Select Image"), Image_Request_Code);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!TextUtils.isEmpty(serial_no.getText().toString())||
                        (!TextUtils.isEmpty(item_name.getText().toString()))||
                        (!TextUtils.isEmpty(mrp.getText().toString()))||
                        (!TextUtils.isEmpty(market_rate.getText().toString()))||
                        (!TextUtils.isEmpty(descount.getText().toString())))
                {
                    progressDialog.setTitle("Image is Uploading...");
                    progressDialog.show();
                    databaseReference = FirebaseDatabase.getInstance().getReference("Products").push();
                    databaseReference.child("Serial_No").setValue(serial_no.getText().toString().trim());
                    databaseReference.child("Item_Name").setValue(item_name.getText().toString().trim());
                    databaseReference.child("MRP").setValue(mrp.getText().toString().trim());
                    databaseReference.child("Market_Rate").setValue(market_rate.getText().toString().trim());
                    databaseReference.child("Discount").setValue(descount.getText().toString().trim());
                    StorageReference storageReference2nd = storageReference.child(Storage_Path +new Date().getTime() + "." + GetFileExtension(FilePathUri));
                    storageReference2nd.putFile(FilePathUri)
                            .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   databaseReference.child("Image").setValue(taskSnapshot.getDownloadUrl().toString());
                                    progressDialog.dismiss();
                                    Toast.makeText(getApplicationContext(), "Data Uploaded Successfully ", Toast.LENGTH_LONG).show();

                                }
                            })
                            // If something goes wrong .
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception exception) {
                                    progressDialog.dismiss();
                                    Toast.makeText(MainActivity.this, exception.getMessage(), Toast.LENGTH_LONG).show();
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
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                    alertDialogBuilder.setMessage("Enter All Details First");
                    alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                        }
                    });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
                serial_no.setText("");
                item_name.setText("");
                mrp.setText("");
                market_rate.setText("");
                descount.setText("");
                image.setImageBitmap(null);
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i=new Intent(this,supplier_list_items.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        //showing confirmation dialog box
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setMessage("Are You Sure to Close The App?");
        alertDialogBuilder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//***Change Here***
                startActivity(intent);
                finish();
                System.exit(0);
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
