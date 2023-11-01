package com.example.photoeditingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.dsphotoeditor.sdk.activity.DsPhotoEditorActivity;
import com.dsphotoeditor.sdk.utils.DsPhotoEditorConstants;
import com.example.photoeditingapp.databinding.ActivityFinalBinding;

public class Final extends AppCompatActivity {

    ActivityFinalBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityFinalBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_final);
        setContentView(mBinding.getRoot());

        // If the input image uri for DS Photo Editor is "inputImageUri", launch the editor UI
        // using the following code
        Intent dsPhotoEditorIntent = new Intent(this, DsPhotoEditorActivity.class);
        dsPhotoEditorIntent.setData(getIntent().getData());


        // This is optional. By providing an output directory, the edited photo
        // will be saved in the specified folder on your device's external storage;
        // If this is omitted, the edited photo will be saved to a folder
        // named "DS_Photo_Editor" by default.
        dsPhotoEditorIntent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_OUTPUT_DIRECTORY, "My Editor");

        // Optional customization: hide some tools you don't need as below
//        int[] toolsToHide = {DsPhotoEditorActivity.TOOL_ORIENTATION, DsPhotoEditorActivity.TOOL_CROP};
//        dsPhotoEditorIntent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_TOOLS_TO_HIDE, toolsToHide);

        startActivityForResult(dsPhotoEditorIntent, 200);



    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            switch (requestCode) {

                case 200:

                    Uri outputUri = data.getData();

                    // handle the result uri as you want, such as display it in an imageView;

                    // imageView.setImageURI(outputUri);
                    mBinding.img.setImageURI(outputUri);

                    break;

            }

        }

    }
}