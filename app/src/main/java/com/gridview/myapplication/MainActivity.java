package com.gridview.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

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
    recyclerView.setAdapter(new Adapter(MainActivity.this));
    recyclerView0.setAdapter(new Adapter(MainActivity.this, 1));

  }
}
