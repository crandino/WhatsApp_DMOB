package carlos.whatsapp_dmob.Activities;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

import carlos.whatsapp_dmob.Adapters.MyAdapter;
import carlos.whatsapp_dmob.R;

public class Activity_Chat extends Activity {

    //private ScrollView scrollView;
    private ListView conversation;
    private EditText input_text;
    private MyAdapter adapter;
    private ArrayList<String> messages;
    private boolean align_to_the_right;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        //scrollView = (ScrollView)findViewById(R.id.scrollview);
        conversation = (ListView) findViewById(R.id.conversation);
        messages = new ArrayList<String>();
        adapter = new MyAdapter(this, messages);
        conversation.setAdapter(adapter);
        input_text = (EditText) findViewById(R.id.input);

        Bundle extras = getIntent().getExtras();

        String nick = extras.getString("Nick");
        String server = extras.getString("Server");
        String port = extras.getString("Port");

        TextView tv = (TextView)findViewById(R.id.chat_title);
        tv.setText(nick + "@" + server + ":" + port);

        for(int i=0; i<100; i++)
            messages.add("content of message nº"+i);

    }

    public void addText(final View view) {

        if(input_text.getEditableText().toString().equals(""))
            return;

        messages.add(input_text.getEditableText().toString());
        input_text.setText("");

        conversation.post(new Runnable() {
            @Override
            public void run() {
                conversation.setSelection(conversation.getCount() - 1);
            }
        });

        adapter.notifyDataSetChanged();
    }

}
