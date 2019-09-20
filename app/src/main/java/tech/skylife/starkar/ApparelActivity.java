package tech.skylife.starkar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ApparelActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView glassOne, glassTwo, glassThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apparel);

        glassOne = findViewById(R.id.glass_one);
        glassOne.setOnClickListener(this);

        glassTwo = findViewById(R.id.glass_two);
        glassTwo.setOnClickListener(this);

        glassThree = findViewById(R.id.glass_three);
        glassThree.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Uri uri;
        switch (v.getId()){

            case R.id.glass_one:
                uri = Uri.parse("https://www.facebook.com/fbcameraeffects/testit/420028301963196/M2JmNmRlNDA4MjRmZWFjMjIzMzIxMWZjOTA1MzA0YTg=/");
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
                break;
            case R.id.glass_two:
                uri = Uri.parse("https://www.facebook.com/fbcameraeffects/testit/508327649951884/NWI5YjIyNjBjNDM0MDVmODQ4MjE4NGRhMzIwMzI4NGQ=/");
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
                break;
            case R.id.glass_three:
                uri = Uri.parse("https://www.facebook.com/fbcameraeffects/testit/2397808460466011/ZmYxMzIwYTU1MjJlMWVjNzFkNGU0YzhjYWRkYTY2MmI=/");
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
                break;
        }
    }
}
