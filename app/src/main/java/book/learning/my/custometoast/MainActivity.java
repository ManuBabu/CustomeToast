package book.learning.my.custometoast;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b =(Button) findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater li = getLayoutInflater();
                //Getting the View object as defined in the customtoast.xml file
                View layout = li.inflate(R.layout.custome_toast,
                        (ViewGroup) findViewById(R.id.layout));

                //Creating the Toast object
                final Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setView(layout);//setting the view of custom toast layout
                CountDownTimer timer;
                timer =new CountDownTimer(20000, 1000)
                {
                    public void onTick(long millisUntilFinished)
                    {
                        toast.show();
                    }
                    public void onFinish()
                    {
                        toast.cancel();
                    }

                }.start();
            }
        });
    }



}
