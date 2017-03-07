package marufsharia.mstecsoft.com.msloveclaculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText editTextmale;
    EditText editTextfemale;
    TextView textView;
    Button btnCalc,btnClear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextmale= (EditText) findViewById(R.id.edtxtmale);
        editTextfemale= (EditText) findViewById(R.id.edtxtfemale);
        textView= (TextView) findViewById(R.id.textView);
        btnCalc = (Button) findViewById(R.id.btnClac);
        btnClear = (Button) findViewById(R.id.btnClear);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);//Menu Resource, Menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent i=new Intent(getApplicationContext(),AboutActivity.class);
                startActivity(i);
                //Toast.makeText(getApplicationContext(),"Item 1 Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.item2:
                System.exit(0);
                //Toast.makeText(getApplicationContext(),"Item 2 Selected",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void calculate(View view) {
        if (editTextmale.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Boy's can not be empty",Toast.LENGTH_SHORT).show();
        }
        else if (editTextfemale.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Girl's can not be empty",Toast.LENGTH_SHORT).show();
        }
        else
        {
            btnCalc.startAnimation(AnimationUtils.loadAnimation(this, R.anim.my_amin_calc));
            calculateLove();
        }

    }





    public void clear(View view) {
        editTextfemale.setText("");
        editTextmale.setText("");
        textView.setText("0%");
        Toast.makeText(getApplicationContext(),"Cleared",Toast.LENGTH_SHORT).show();
        btnClear.startAnimation(AnimationUtils.loadAnimation(this, R.anim.my_anim));
    }

    public void calculateLove()
    {
        try
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String s1=editTextmale.getText().toString();
            String s2=editTextfemale.getText().toString();
            int sum=0,sum2=0;
            //calculating ascii value for s1
            for(int i=0;i<s1.length();i++)
            {
                char ch=s1.charAt(i);
                int ascii=ch;
                sum=sum+ascii;
            }
            //calculating ascii value for s2
            for(int i=0;i<s2.length();i++)
            {
                char ch=s2.charAt(i);
                int ascii=ch;
                sum2=sum2+ascii;
            }
            int total=sum+sum2;
            int lovepercentage=total%100;
           // System.out.println("love between "+s1+" and "+s2+" is "+lovepercentage+"%");
            textView.setText(lovepercentage+"%");
        }
        catch(Exception e)
        {

        }
    }

}
