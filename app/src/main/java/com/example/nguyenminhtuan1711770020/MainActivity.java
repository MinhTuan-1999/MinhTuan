package com.example.nguyenminhtuan1711770020;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    public class LunchList extends Activity {
        private List<Restaurant>restaurantList=new ArrayList<Restaurant>();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button save = (Button)findViewById(R.id.save); // tham chiếu đến Button
        save.setOnClickListener(onSave); // khai báo listener cho Button
    }

    private View.OnClickListener onSave = new View.OnClickListener() {
        public void onClick(View v) {
            Restaurant r=new Restaurant();
            EditText name = (EditText)findViewById(R.id.name);
            EditText address = (EditText)findViewById(R.id.addr);
            r.setName(name.getText().toString());
            r.setAddress(address.getText().toString());
            RadioGroup type = (RadioGroup)findViewById(R.id.type);
            String str="";
            switch (type.getCheckedRadioButtonId())
            {
                case R.id.take_out:
                    r.setType("Take out");
                    str=name.getText().toString() + " "+address.getText().toString()+" "+"Take out";
                    break;
                case R.id.sit_down:
                    r.setType("Sit down");
                    str=name.getText().toString() + " "+address.getText().toString()+" "+"Sit down";
                    break;
                case R.id.delivery:
                    r.setType("Delivery");
                    str=name.getText().toString() + " "+address.getText().toString()+" "+"Delivery";
                    break;
            }
            Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
        }
    };

}