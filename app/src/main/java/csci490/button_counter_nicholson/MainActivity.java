//Sarah Nicholson

package csci490.button_counter_nicholson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    Button incButton;
    Button decButton;
    Button resetButton;

    TextView num;
    TextView title;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //make associations and set buttons
        num = (TextView) findViewById(R.id.number);
        title = (TextView) findViewById(R.id.textView2);
        incButton = (Button) findViewById(R.id.button);
        decButton = (Button) findViewById(R.id.button2);
        resetButton = (Button) findViewById(R.id.button3);

        incButton.setOnClickListener(this);
        decButton.setOnClickListener(this);
        resetButton.setOnClickListener(this);

        //set text sizes
        num.setTextSize(TypedValue.COMPLEX_UNIT_SP, 100);
        title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
    }

    @Override
    public void onClick(View view)
    {
        //if increase button is clicked, increase count
        if (view == incButton)
        {
            counter++;
            num.setText(Integer.toString(counter));

            //change count color depending on if positive, negative,
            //or zero
            if (counter < 0)
                num.setTextColor(Color.RED);
            else if (counter > 0)
                num.setTextColor(Color.GREEN);
            else
                num.setTextColor(Color.BLACK);
        }

        //if decrease button is clicked, decrease count
        if (view == decButton)
        {
            counter--;
            num.setText(Integer.toString(counter));

            //change count color depending on if positive, negative,
            //or zero
            if (counter < 0)
                num.setTextColor(Color.RED);
            else if (counter > 0)
                num.setTextColor(Color.GREEN);
            else
                num.setTextColor(Color.BLACK);
        }

        //if reset button is click, reset count to 0
        if (view == resetButton)
        {
            counter = 0;
            num.setText(Integer.toString(counter));
            num.setTextColor(Color.BLACK);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle state)
    {
        //save state
        super.onSaveInstanceState(state);
        state.putInt("number",counter);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);

        //restore state and color of the count
        counter = savedInstanceState.getInt("number");
        num.setText(Integer.toString(counter));
        if (counter < 0)
            num.setTextColor(Color.RED);
        else if (counter > 0)
            num.setTextColor(Color.GREEN);
        else
            num.setTextColor(Color.BLACK);


    }
}
