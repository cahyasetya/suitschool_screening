package id.ydev.suitschoolscreening;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    private Button pilihEventButton;
    private Button pilihGuestButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent=getIntent();
        String nama=intent.getStringExtra("nama");
        String event=intent.getStringExtra("nama_event");
        String guest=intent.getStringExtra("nama_guest");

        TextView namaTextView=(TextView)findViewById(R.id.nama_user);
        pilihEventButton=(Button)findViewById(R.id.pilih_event_button);
        pilihGuestButton=(Button)findViewById(R.id.pilih_guest_button);


        namaTextView.setText(this.getString(R.string.nama_profile,nama));
        pilihEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, EventActivity.class));
            }
        });
        pilihGuestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, GuestActivity.class));
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);

        if(intent.getStringExtra("nama_event")!=null){
            pilihEventButton.setText(intent.getStringExtra("nama_event"));
        }
        if(intent.getStringExtra("nama_guest")!=null){
            pilihGuestButton.setText(intent.getStringExtra("nama_guest"));
            int tanggal=intent.getIntExtra("tanggal",0);
            if(tanggal%3==0 && tanggal%2==0)
                Toast.makeText(this, "iOS",Toast.LENGTH_SHORT).show();
            else if(tanggal%3==0)
                Toast.makeText(this, "android",Toast.LENGTH_SHORT).show();
            else if(tanggal%2==0)
                Toast.makeText(this, "blackberry",Toast.LENGTH_SHORT).show();
            else Toast.makeText(this, "feature phone",Toast.LENGTH_SHORT).show();
        }
    }
}
