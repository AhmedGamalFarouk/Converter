package android.example.converter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    EditText paymentET;
    TextView balanceTV;
    Button convertBTN;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paymentET = findViewById(R.id.payment_et);
        balanceTV = findViewById(R.id.balance_tv);
        convertBTN = findViewById(R.id.convert_btn);
        recyclerView = findViewById(R.id.history_rv);

        convertBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Convert ();
            }
        });

    }


    private void Convert() {

        //float payment = 0;
        String paymentInput = paymentET.getText().toString();
         //int pay = Integer.parseInt(paymentInput);
        if (paymentInput.equals("") || paymentInput.equals(null) || paymentInput.matches("^0")) {
            Toast.makeText(getApplicationContext(), "Please enter a number", Toast.LENGTH_SHORT).show();
        } else {
           float payment = Float.parseFloat(paymentInput);
            float balance = payment * 70 / 100;

            balanceTV.setText("" + balance);
        }
    }

}