package tech.skylife.starkar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HomePageActivity extends AppCompatActivity {

    ImageView furnImage, apparelsImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        furnImage = findViewById(R.id.furn_btn);
        furnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent furnIntent = new Intent(HomePageActivity.this, FurnitureActivity.class);
                startActivity(furnIntent);
            }
        });
        apparelsImage = findViewById(R.id.apparels_btn);
        apparelsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent apparelsIntent = new Intent(HomePageActivity.this, ApparelActivity.class);
                startActivity(apparelsIntent);
            }
        });
    }
}
