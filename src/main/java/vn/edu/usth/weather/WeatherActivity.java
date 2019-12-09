package vn.edu.usth.weather;

import androidx.fragment.app.FragmentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.media.MediaPlayer;
import android.os.Bundle;

import android.content.res.AssetFileDescriptor;

import android.util.Log;
import android.os.Bundle;
import android.os.Environment;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.google.android.material.tabs.TabLayout;
import android.content.res.AssetFileDescriptor;
import android.util.Log;
import android.widget.Adapter;
import android.widget.TextView;

import org.w3c.dom.Text;

public class WeatherActivity extends AppCompatActivity {

    MediaPlayer music;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        HomeFragmentPaperAdapter adapter = new HomeFragmentPaperAdapter(getSupportFragmentManager());
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);

        copyFileToExternalStorage(R.raw.lavie,"lavie.mp3");

        music = MediaPlayer.create(WeatherActivity.this,R.raw.lavie);
        music.start();

    }

    private void copyFileToExternalStorage(int resourceId, String resourceName){
        String pathSDCard = Environment.getExternalStorageDirectory()
                + "/Android/data/vn.edu.usth.weather/" + resourceName;
        try{
            InputStream in = getResources().openRawResource(resourceId);
            FileOutputStream out = null;
            out = new FileOutputStream(pathSDCard);
            byte[] buff = new byte[1024];
            int read = 0;
            try {
                while ((read = in.read(buff)) > 0) {
                    out.write(buff, 0, read);
                }
            } finally {
                in.close();
                out.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        //WeatherAndForecastFragment.ForecastFragment firstFragment = new WeatherAndForecastFragment.ForecastFragment();
        // Add the fragment to the ' container' FrameLayout
        //getSupportFragmentManager(). beginTransaction(). add(
        //        R.id.container, firstFragment). commit();


        @Override
    protected void onStart()
    {
        super.onStart();
        Log.i( "This","Welcome to USTH Wheather");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.i( "This","Welcome to Weather Prediction");
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        Log.i( "This"," USTH Wheather");
    }
    @Override
    protected  void onStop()
    {
        super.onStop();
        Log.i("This", "You dead");
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.i("This", "You dead");
    }




}
