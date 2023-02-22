package com.example.unionpplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UseCam_Activity extends AppCompatActivity {
    public Uri imageUri;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_cam);

        iv = findViewById(R.id.iv);
        File tmpImage = new File(getExternalCacheDir(),"tmp.jpg");
        if(tmpImage.exists()){
            tmpImage.delete();
        }
        try {
            tmpImage.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        imageUri = FileProvider.getUriForFile(UseCam_Activity.this,"com.example.unionpplication.file_provider",tmpImage);

        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
        startActivityForResult(intent, 1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                if(resultCode == RESULT_OK){
                    Bitmap bitmap = null;
                    try {
                        bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    iv.setImageBitmap(bitmap);
                }
                break;
            default:break;
        }
    }
}