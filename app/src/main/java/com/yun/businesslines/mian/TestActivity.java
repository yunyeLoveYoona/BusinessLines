package com.yun.businesslines.mian;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.yun.businesslines.BusinessBus;
import com.yun.businesslines.R;
import com.yun.businesslines.core.Product;
import com.yun.businesslines.core.SalesMan;
import com.yun.businesslines.mian.product.MainProduct;

/**
 * Created by dell on 2016/7/12.
 */
public class TestActivity extends AppCompatActivity implements SalesMan {
    private TextView textView;
    private MainProduct mainProduct;
    private MainBusinessLine mainBusinessLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        textView = (TextView) findViewById(R.id.msg);
        mainBusinessLine = (MainBusinessLine) BusinessBus.getBus().getResource(MainBusinessLine.ID);
        if (mainBusinessLine != null) {
            mainBusinessLine.join(this);
            mainProduct = (MainProduct) mainBusinessLine.getResource(MainProduct.ID);
        }

        if (mainProduct != null) {
            textView.setText(mainProduct.msg);
        }

        findViewById(R.id.change).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainProduct != null) {
                    mainProduct.msg = "改变后的值";
                    mainProduct.change();
                    textView.setText(mainProduct.msg);
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void getProduct(Product product) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mainBusinessLine != null)
            mainBusinessLine.leave(this);
    }
}
