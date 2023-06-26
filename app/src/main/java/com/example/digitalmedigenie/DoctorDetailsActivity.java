package com.example.digitalmedigenie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Ajit", "Hospital Address : New Delhi", "Exp : 5yrs", "Mobile No. : 9898989898", "600"},
                    {"Doctor Name : Prasad", "Hospital Address : Pune", "Exp : 15yrs", "Mobile No. : 7898987898", "900"},
                    {"Doctor Name : Swapnil", "Hospital Address : Chandigarh", "Exp : 8yrs", "Mobile No. : 9785828989", "300"},
                    {"Doctor Name : Deepak", "Hospital Address : Panipat", "Exp : 6yrs", "Mobile No. : 7845989697", "500"},
                    {"Doctor Name : Ashok", "Hospital Address : Noida", "Exp : 7yrs", "Mobile No. : 8892967867", "800"},
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Neelam", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No. : 9785828989", "700"},
                    {"Doctor Name : Swati", "Hospital Address : New Delhi", "Exp : 5yrs", "Mobile No. : 8892967867", "900"},
                    {"Doctor Name : Neerja", "Hospital Address : Chandigarh", "Exp : 9yrs", "Mobile No. : 9785828989", "500"},
                    {"Doctor Name : Pooja", "Hospital Address : Hisar", "Exp : 4yrs", "Mobile No. : 7898987898", "800"},
                    {"Doctor Name : Mayuri", "Hospital Address : Noida", "Exp : 7yrs", "Mobile No. :  9898989898", "600"},
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Seema", "Hospital Address : Chandigarh", "Exp : 9yrs", "Mobile No. : 9671021983", "500"},
                    {"Doctor Name : Pankaj", "Hospital Address : New Delhi", "Exp : 7yrs", "Mobile No. : 9785828989", "600"},
                    {"Doctor Name : Manish", "Hospital Address : Mumbai", "Exp : 8yrs", "Mobile No. : 8892967867", "800"},
                    {"Doctor Name : Rahul", "Hospital Address : Rohtak", "Exp : 6yrs", "Mobile No. : 9785828989", "700"},
                    {"Doctor Name : Shivam", "Hospital Address : New Delhi", "Exp : 11yrs", "Mobile No. :  9785828989", "900"},
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Saumya", "Hospital Address : Karnal", "Exp : 10yrs", "Mobile No. : 9785828989", "700"},
                    {"Doctor Name : Nitin", "Hospital Address : Hyderabad", "Exp : 15yrs", "Mobile No. : 9671021983", "1000"},
                    {"Doctor Name : Amit", "Hospital Address : Ranchi", "Exp : 8yrs", "Mobile No. : 8708364567", "700"},
                    {"Doctor Name : Ankur", "Hospital Address : Ghaziabad", "Exp : 7yrs", "Mobile No. : 9991345678", "900"},
                    {"Doctor Name : Monika", "Hospital Address : Greater Noida", "Exp : 11yrs", "Mobile No. :  8059265999", "800"},
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Mayra", "Hospital Address : Lucknow", "Exp : 11yrs", "Mobile No. : 9521345679", "700"},
                    {"Doctor Name : Gunjan", "Hospital Address : Noida", "Exp : 16yrs", "Mobile No. : 9671021983", "1000"},
                    {"Doctor Name : Awanish", "Hospital Address : Patna", "Exp : 8yrs", "Mobile No. : 8608465676", "700"},
                    {"Doctor Name : Mayank", "Hospital Address : Ghaziabad", "Exp : 9yrs", "Mobile No. : 8708364567", "900"},
                    {"Doctor Name : Neelkanth", "Hospital Address : Kolkata", "Exp : 7yrs", "Mobile No. :  9991345678", "800"},
            };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonLTBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);
        if (title.compareTo("Family Physicians") == 0)
            doctor_details = doctor_details1;
        else if (title.compareTo("Dietician") == 0)
            doctor_details = doctor_details2;
        else if (title.compareTo("Dentist") == 0)
            doctor_details = doctor_details3;
        else if (title.compareTo("Surgeon") == 0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for (int i = 0; i < doctor_details.length; i++) {
            item = new HashMap<String, String>();
            item.put("Line1", doctor_details[i][0]);
            item.put("Line2", doctor_details[i][1]);
            item.put("Line3", doctor_details[i][2]);
            item.put("Line4", doctor_details[i][3]);
            item.put("Line5", "Cons Fees : " + doctor_details[i][4] + "/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"Line1", "Line2", "Line3", "Line4", "Line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
        ListView lst = findViewById(R.id.ListViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1", title);
                it.putExtra("text2", doctor_details[i][0]);
                it.putExtra("text3", doctor_details[i][1]);
                it.putExtra("text4", doctor_details[i][3]);
                it.putExtra("text5", doctor_details[i][4]);
                startActivity(it);


            }
        });

    }

}
