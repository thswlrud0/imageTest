package net.daum.www.imagetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.File;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.MediaStore;
import android.view.View;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.Toast;

    public class PictureTest extends Activity implements View.OnClickListener{

        //사진으로 전송시 되돌려 받을 번호
        static int REQUEST_PICTURE=1;
        //앨범으로 전송시 돌려받을 번호
        static int REQUEST_PHOTO_ALBUM=2;
        //첫번째 이미지 아이콘 샘플 이다.
asdfasdfasdf
        static String Hello;
        ImageView iv;
      //  Dialog dialog;

        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_picture_test);
//여기에 일단 기본적인 이미지파일 하나를 가져온다.
            iv=(ImageView) findViewById(R.id.imgView);
//가져올 사진의 이름을 정한다.
            findViewById(R.id.getCustom).setOnClickListener(this);
        }
        @Override
        public void onClick(View v){

                photoAlbum();
            }

    void photoAlbum(){
//저장된 사진을 불러오는 함수이다. 즉앨범에있는것인데 인텐트는 ACTION_PICK
        Intent intent=new Intent(Intent.ACTION_PICK);
//갤러리리의 기본설정 해주도록하자!아래는이미지와그경로를 표준타입으로 설정한다.
        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
//사진이 저장된위치(sdcard)에 데이터가 잇다고 지정
        intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,REQUEST_PHOTO_ALBUM);
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){
            if(requestCode==REQUEST_PHOTO_ALBUM){
//앨범에서 호출한경우 data는 이전인텐트(사진갤러리)에서 선택한 영역을 가져오게된다. 
                iv.setImageURI(data.getData());
            }
        }
    }
}

