package com.example.itoledo.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editName = (EditText)findViewById(R.id.editText);
        final EditText editAge = (EditText)findViewById(R.id.editText2);

        //Creamos la lectura de las preferencias
        final SharedPreferences pref = getPreferences(MODE_PRIVATE);
        editAge.setText(String.valueOf(pref.getInt("age", 0)));
        editName.setText(pref.getString("name",""));

        final Button guardar = (Button)findViewById(R.id.button);

        //Creamos el evento Click del boton
        guardar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Creamos la escritura de los datos
                        SharedPreferences.Editor prefEd = pref.edit();
                        prefEd.putInt("age",Integer.parseInt(editAge.getText().toString()));
                        prefEd.putString("name",editName.getText().toString());
                        prefEd.commit();
                    }
                }



        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
