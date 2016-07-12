package com.yun.businesslines.mian;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.yun.businesslines.R;
import com.yun.businesslines.core.Product;
import com.yun.businesslines.core.SalesMan;
import com.yun.businesslines.mian.product.MainProduct;
import com.yun.businesslines.mian.recourse.MainResource;

public class MainActivity extends AppCompatActivity implements SalesMan {
    private TextView msg;
    private EditText str;
    private Button button;
    private MainBusinessLine mainBusinessLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBusinessLine = new MainBusinessLine();
        mainBusinessLine.join(this);

        setContentView(R.layout.activity_main);
        msg = (TextView) findViewById(R.id.msg);
        str = (EditText) findViewById(R.id.str);
        button = (Button) findViewById(R.id.send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainResource mainResource = new MainResource();
                mainResource.str = str.getText().toString();
                mainBusinessLine.sendMeg(mainResource);
            }
        });
        findViewById(R.id.jump).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void getProduct(Product product) {
        switch (product.getProductId()) {
            case MainProduct.ID:
                msg.setText(((MainProduct) product).msg);
                mainBusinessLine.addResource(((MainProduct) product));
                com.yun.businesslines.BusinessBus.getBus().addResource(mainBusinessLine);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainBusinessLine.leave(this);
    }
}
