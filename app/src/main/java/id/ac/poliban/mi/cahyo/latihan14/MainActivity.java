package id.ac.poliban.mi.cahyo.latihan14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private EditText etInput;
    private TextView tvResult;
    private String file = "dts.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = findViewById(R.id.etInput);
        tvResult = findViewById(R.id.tvResult);

        Button btLoad = findViewById(R.id.btLoad);
        Button btSave = findViewById(R.id.btSave);

        btSave.setOnClickListener(v -> {
            String s = etInput.getText().toString();
            try (FileOutputStream fos = openFileOutput(file, MODE_APPEND)){
                fos.write(s.getBytes());

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        btLoad.setOnClickListener(v ->  {
            StringBuilder sb = new StringBuilder();
            try(FileInputStream fis = openFileInput(file)){
                int read;
                while ((read = fis.read()) != -1) {
                    sb.append((char) read);
                }
                tvResult.setText(sb.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
