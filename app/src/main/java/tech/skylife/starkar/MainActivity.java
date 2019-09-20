package tech.skylife.starkar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    CallbackManager callbackManager;
    LoginButton loginButton;
    boolean isLoggedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        callbackManager = CallbackManager.Factory.create();

        loginButton =  findViewById(R.id.login_button);
        loginButton.setPermissions(Arrays.asList("email", "public_profile"));

        //check if user is already signed in
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        isLoggedIn = accessToken != null && !accessToken.isExpired();
        if(isLoggedIn){
            startActivity(new Intent(this, HomePageActivity.class));
        }

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d("FACEBOOK: ", "SUCCESS");
                startActivity(new Intent(MainActivity.this, HomePageActivity.class));
                Toast.makeText(MainActivity.this, "Login Successfully ", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {
                Log.d("FACEBOOK: ", "CANCELLED");
                Toast.makeText(MainActivity.this, "Login Interrupted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException exception) {
                //startActivity(new Intent(MainActivity.this, HomePageActivity.class));
                Log.d("FACEBOOK_ERROR", ""+exception);
                Toast.makeText(MainActivity.this, "Error Occurred Please try again", Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
