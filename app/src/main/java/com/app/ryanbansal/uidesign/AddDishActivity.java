package com.app.ryanbansal.uidesign;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class AddDishActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 1888;
    ImageView DishImage;
    EditText DishName;
    EditText Description;
    Button AddImage;
    Button AddDish;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
    private DatabaseReference mRootReference = firebaseDatabase.getReference("Dishes");
    private DatabaseReference mChildReference = mRootReference.child("Saved Dishes");
    private StorageReference dishImageReference = firebaseStorage.getReference("DISH IMAGES");

    Uri capturedImage;
    Uri downloadUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dish);

        DishImage = (ImageView) findViewById(R.id.image_dish);
        DishName = (EditText) findViewById(R.id.dish_name);
        Description = (EditText) findViewById(R.id.dish_descrip);
        AddImage = (Button) findViewById(R.id.add_img_btn);
        AddDish = (Button) findViewById(R.id.add_btn);

        AddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
                getIntent.setType("image/*");

                Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                pickIntent.setType("image/*");

                Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{
                        pickIntent});

                startActivityForResult(chooserIntent, CAMERA_REQUEST);
            }
        });

        AddDish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveToFirebase();

                Intent i  = new Intent(AddDishActivity.this,MainActivity.class);
                startActivity(i);

            }

        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            capturedImage = data.getData();
            DishImage.setImageURI(capturedImage);

            StorageReference PhotoRef = dishImageReference.child(capturedImage.getLastPathSegment());

            PhotoRef.putFile(capturedImage).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    downloadUrl = taskSnapshot.getDownloadUrl();

                }
            });
        }
    }

    public void SaveToFirebase(){
        String dishName = DishName.getText().toString();
        String description = Description.getText().toString();
        String dishImage = downloadUrl.toString();
        StorageReference photoRef = dishImageReference.child(capturedImage.getLastPathSegment());


        photoRef.putFile(capturedImage).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                downloadUrl = taskSnapshot.getDownloadUrl();
                }
            });


        SavedDish savedDish = new SavedDish(dishName,description,dishImage);
        String id = mChildReference.push().getKey();

        mChildReference.child(id).setValue(savedDish);



    }


    }