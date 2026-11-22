
package com.katza.myfirstappnoam98;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.SeekBar;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener,
        SeekBar.OnSeekBarChangeListener {

    Button btnIsrael;
    Button btnSecond;

    Switch switchButtons;
    SeekBar seekImage;

    ImageView ivFlag;
    ImageView ivSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // חיבור הכפתורים
        btnIsrael = findViewById(R.id.btnIsrael);
        btnSecond = findViewById(R.id.btnSecond);

        btnIsrael.setOnClickListener(this);
        btnSecond.setOnClickListener(this);

        // חיבור המתג
        switchButtons = findViewById(R.id.switchButtons);

        switchButtons.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (isChecked) {
                btnIsrael.setVisibility(View.VISIBLE);
                btnSecond.setVisibility(View.VISIBLE);
            } else {
                btnIsrael.setVisibility(View.GONE);
                btnSecond.setVisibility(View.GONE);
            }
        });

        // חיבור התמונות
        ivFlag = findViewById(R.id.ivFlag);
        ivSecond = findViewById(R.id.ivSecond);

        // חיבור SeekBar
        seekImage = findViewById(R.id.seekImage);
        seekImage.setOnSeekBarChangeListener(this);

        // מצב התחלתי
        ivFlag.setAlpha(1f);
        ivSecond.setAlpha(0f);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btnIsrael) {

            Toast.makeText(this,
                    "אני אוהב את ישראל",
                    Toast.LENGTH_SHORT).show();

        } else if (view.getId() == R.id.btnSecond) {

            btnSecond.setText("מעקב");
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar,
                                  int progress,
                                  boolean fromUser) {

        float alpha = progress / 100f;

        ivFlag.setAlpha(alpha);
        ivSecond.setAlpha(1 - alpha);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
