package com.example.yerckomontero.fintonicprueba.operations.detail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yerckomontero.fintonicprueba.R;
import com.example.yerckomontero.fintonicprueba.models.Heroe;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity implements IDetailView {
    public static String EXTRA_DATA = "EXTRA_DATA";
    private Heroe heroe;
    private ImageView iv_photo;
    private TextView tv_realName;
    private TextView tv_height;
    private TextView tv_power;
    private TextView tv_abilities;
    private TextView tv_groups;
    private TextView tv_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initViews();
        initValues();
    }

    public void initViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(getString(R.string.title_detail));
        }
        iv_photo = (ImageView) findViewById(R.id.iv_photo);
        tv_realName = (TextView) findViewById(R.id.tv_real_name);
        tv_height = (TextView) findViewById(R.id.tv_height);
        tv_power = (TextView) findViewById(R.id.tv_power);
        tv_abilities = (TextView) findViewById(R.id.tv_abilities);
        tv_groups = (TextView) findViewById(R.id.tv_groups);
        tv_name = (TextView) findViewById(R.id.tv_name);
    }

    public void initValues(){
        Intent extras = getIntent();
        if (extras != null) {
            heroe = (Heroe) extras.getSerializableExtra(EXTRA_DATA);
        }
        Picasso.with(this).load(heroe.getPhoto()).into(iv_photo);
        tv_realName.setText(heroe.getRealName());
        tv_height.setText(heroe.getHeight());
        tv_power.setText(heroe.getPower());
        tv_abilities.setText(heroe.getAbilities());
        tv_groups.setText(heroe.getGroups());
        tv_name.setText(heroe.getName());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
