package tech.skylife.starkar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FurnitureActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView sofaOne, sofaTwo, sofaThree, chairOne, chairTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furniture);

        sofaOne = findViewById(R.id.sofa_one);
        sofaOne.setOnClickListener(this);

        sofaTwo = findViewById(R.id.sofa_two);
        sofaTwo.setOnClickListener(this);

        sofaThree = findViewById(R.id.sofa_three);
        sofaThree.setOnClickListener(this);

        chairOne = findViewById(R.id.chair_one);
        chairOne.setOnClickListener(this);

        chairTwo = findViewById(R.id.chair_two);
        chairTwo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Uri uri;
        switch(v.getId()){

            case R.id.sofa_one:
                uri = Uri.parse("https://www.facebook.com/fbcameraeffects/testit/764525327311941/MGYyM2IwNzlkNDM5MzA4MDgxNDlmODRmODQzNWQ4Yzc=/");
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
                break;
            case R.id.sofa_two:
                uri = Uri.parse("https://www.facebook.com/fbcameraeffects/testit/437343223794295/N2Q1ZWRhMGU5ODEwZTQ5ZDgyMmI3OTJjZDI5NTBkMTE=/");
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
                break;
            case R.id.sofa_three:
                uri = Uri.parse("https://www.facebook.com/fbcameraeffects/testit/2470795253006037/ZjBhMjBlNTY4ZWRkZmYyZDRiN2VjYmYyOTU1MjZlNGE=/");
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
                break;
            case R.id.chair_one:
                uri = Uri.parse("https://www.facebook.com/fbcameraeffects/testit/1180528725464718/ZGFmMDBjMzYyNzdmNmQ4Njg3Y2E5MTAxODlmYjE3YzE=/");
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
                break;
            case R.id.chair_two:
                uri = Uri.parse("https://www.facebook.com/fbcameraeffects/testit/500945414075636/ZTBjYmM4NDNiMzBhMGVmNDRmM2I3YmM0M2I1N2UyYzg=/");
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
                break;
        }

    }
}
