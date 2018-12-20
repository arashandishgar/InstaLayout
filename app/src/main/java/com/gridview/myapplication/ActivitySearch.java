package com.gridview.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
    final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recy);
    final RecyclerView recyclerView0 = (RecyclerView) findViewById(R.id.recy0);
    SpannedGridLayoutManager manager = new SpannedGridLayoutManager(
      new SpannedGridLayoutManager.GridSpanLookup() {
        @Override
        public SpannedGridLayoutManager.SpanInfo getSpanInfo(int position) {
          // Conditions for 2x2 items
          if (position % 18 == 1 || position % 18 == 9) {
            return new SpannedGridLayoutManager.SpanInfo(2, 2);
          } else {
            return new SpannedGridLayoutManager.SpanInfo(1, 1);
          }
        }
      },
      3, // number of columns
      1f // how big is default item
    );
    recyclerView.setLayoutManager(manager);
    recyclerView0.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
    ArrayList<Integer> integers=new ArrayList<>();
    integers.add(R.drawable.image1);
    integers.add(R.drawable.image2);
    integers.add(R.drawable.image3);
    integers.add(R.drawable.image4);
    integers.add(R.drawable.image5);
    integers.add(R.drawable.image6);
    integers.add(R.drawable.image7);
    integers.add(R.drawable.image8);
    integers.add(R.drawable.image9);
    integers.add(R.drawable.image10);
    integers.add(R.drawable.image11);
    integers.add(R.drawable.image12);
    integers.add(R.drawable.image13);
    integers.add(R.drawable.image14);
    recyclerView.setAdapter(new Adapter(MainActivity.this,integers));
    recyclerView0.setAdapter(new Adapter(MainActivity.this, integers));
  }

  void intentMessageTelegram(String msg, Uri uri) {
    final String appName = "org.telegram.messenger";
    final boolean isAppInstalled = isAppAvailable(this.getApplicationContext(), appName);
    if (isAppInstalled) {
      Intent myIntent = new Intent(Intent.ACTION_SEND);
      myIntent.setType("text/plain");
      myIntent.putExtra(Intent.EXTRA_TEXT, msg);//
      startActivity(Intent.createChooser(myIntent, "Share with"));
    } else {
      Toast.makeText(this, "Telegram not Installed", Toast.LENGTH_SHORT).show();
    }
  }

  public static boolean isAppAvailable(Context context, String appName) {
    PackageManager pm = context.getPackageManager();
    try {
      pm.getPackageInfo(appName, PackageManager.GET_ACTIVITIES);
      return true;
    } catch (PackageManager.NameNotFoundException e) {
      return false;
    }
  }
}
