package tech.skylife.starkar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.login.LoginManager;

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

    private void showDialogBox(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to Log out?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                LoginManager.getInstance().logOut();
                startActivity(new Intent(HomePageActivity.this, MainActivity.class));
                Toast.makeText(HomePageActivity.this, "User Logged Out", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.create().show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.log_out, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.log_out_btn) {
            showDialogBox();
        }
        return super.onOptionsItemSelected(item);
    }
}
