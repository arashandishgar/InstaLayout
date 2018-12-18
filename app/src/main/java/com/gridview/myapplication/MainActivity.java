package com.gridview.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    SpannedGridLayoutManager manager = new SpannedGridLayoutManager(
      new SpannedGridLayoutManager.GridSpanLookup() {
        @Override
        public SpannedGridLayoutManager.SpanInfo getSpanInfo(int position) {
          // Conditions for 2x2 items
          if (position % 18 == 1||position %18==9) {
            return new SpannedGridLayoutManager.SpanInfo(2, 2);
          } else {
            return new SpannedGridLayoutManager.SpanInfo(1, 1);
          }
        }
      },
      3, // number of columns
      1f // how big is default item
    );
    RecyclerView recyclerView=(RecyclerView) findViewById(R.id.recy);
    recyclerView.setLayoutManager(manager);
    recyclerView.setAdapter(new Adapter(this));
  }
}
