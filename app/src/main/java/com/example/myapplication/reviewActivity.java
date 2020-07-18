package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class reviewActivity extends AppCompatActivity implements View.OnClickListener{

    final String TAG = getClass().getSimpleName();
    ImageView imageView;
    ImageButton cameraBtn;
    ImageButton galleryBtn;
    ImageButton backBtn;
    RatingBar ratingbar;
    TextView score;

    final static int TAKE_PICTURE = 1;
    final static int RC_PICK_FROM_GALLERY = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        imageView = findViewById(R.id.receiptView);
        cameraBtn = findViewById(R.id.camera_button);
        galleryBtn = findViewById(R.id.gallery_button);
        backBtn = findViewById(R.id.back_button);
        ratingbar = findViewById(R.id.ratingBar);
        score = findViewById(R.id.rating_score);

        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                score.setText(""+rating);
            }
        });

        // 카메라 버튼에 리스터 추가
        cameraBtn.setOnClickListener(this);
        galleryBtn.setOnClickListener(this);
        backBtn.setOnClickListener(this);

        // 6.0 마쉬멜로우 이상일 경우에는 권한 체크 후 권한 요청
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED ) {
                Log.d(TAG, "권한 설정 완료");
            } else {
                Log.d(TAG, "권한 설정 요청");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        }
    }

    // 권한 요청
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d(TAG, "onRequestPermissionsResult");
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED ) {
            Log.d(TAG, "Permission: " + permissions[0] + "was " + grantResults[0]);
        }
    }

    // 버튼 onClick리스터 처리부분
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.back_button:
                Intent backIntent = new Intent(this, MainActivity.class);
                startActivity(backIntent);
            case R.id.camera_button:
                // 카메라 앱을 여는 소스
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, TAKE_PICTURE);
                break;
            case R.id.gallery_button:
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, RC_PICK_FROM_GALLERY);
        }
    }


    // 카메라로 촬영한 영상을 가져오는 부분
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        switch (requestCode) {
            case RC_PICK_FROM_GALLERY:
                Uri imageUri = intent.getData();
                Log.e("내태그", imageUri.toString());
                imageView.setImageURI(imageUri);
                break;
            case TAKE_PICTURE:
                if (resultCode == RESULT_OK && intent.hasExtra("data")) {
                    Bitmap bitmap = (Bitmap) intent.getExtras().get("data");
                    if (bitmap != null) {
                        imageView.setImageBitmap(bitmap);
                    }

                }
                break;
        }
    }
}
