package carlos.whatsapp_dmob;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity_Auth extends Activity implements View.OnClickListener {

    private EditText server, port, nick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        ((Button)findViewById(R.id.connect)).setOnClickListener(this);

        server = (EditText)findViewById(R.id.server);
        port = (EditText)findViewById(R.id.port);
        nick = (EditText)findViewById(R.id.nick);
    }

    public void onClick(View arg0)
    {
        if(arg0==findViewById(R.id.connect))
        {
            Intent intent = new Intent();
            intent = new Intent(this, Activity_Chat.class);

            String server_str = server.getText().toString();
            intent.putExtra("Server", server_str);
            String port_str = port.getText().toString();
            intent.putExtra("Port", port_str);
            String nick_str = nick.getText().toString();
            intent.putExtra("Nick", nick_str);

            startActivity(intent);
        }
    }
}
