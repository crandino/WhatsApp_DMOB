package carlos.whatsapp_dmob;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class Activity_Chat extends Activity {

    private ScrollView scrollView;
    private LinearLayout conversation;
    private EditText input_text;
    private boolean align_to_the_right;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        scrollView = (ScrollView)findViewById(R.id.scrollview);
        conversation = (LinearLayout) findViewById(R.id.conversation);
        input_text = (EditText) findViewById(R.id.input);

        Bundle extras = getIntent().getExtras();

        String nick = extras.getString("Nick");
        String server = extras.getString("Server");
        String port = extras.getString("Port");

        TextView tv = (TextView)findViewById(R.id.title_chat);
        tv.setText(nick + "@" + server + ":" + port);
    }

    public void addText(final View view) {

        if(input_text.getEditableText().toString().equals("")) return;
        else
        {
            TextView tv = new TextView(this);
            tv.setText(input_text.getEditableText());
            tv.setTextSize(30);

            if(align_to_the_right)
            {
                tv.setTextColor(getResources().getColor(R.color.black));
                tv.setGravity(Gravity.RIGHT);
            }

            tv.setTextColor(Color.RED);

            align_to_the_right = !align_to_the_right;
            input_text.setText("");
            conversation.addView(tv);
        }

        //to scroll down to the bottom for each new message:
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });

        //as previous sentence gets focus on scrollview:
        input_text.post(new Runnable() {
            @Override
            public void run() {
                input_text.requestFocus();
            }
        });

    }

}
