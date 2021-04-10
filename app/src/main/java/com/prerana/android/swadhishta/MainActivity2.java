package com.prerana.android.swadhishta;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Todo;

public class MainActivity2 extends AppCompatActivity {
    public EditText name,desc;
    public Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name = findViewById(R.id.edname);
        desc = findViewById(R.id.eddes);
        btn = findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 =   name.getText().toString();
                String name2 =  desc.getText().toString();
                Todo todo = Todo.builder()
                        .name(name1)
                        .description(name2)
                        .build();
                Amplify.API.mutate(
                        ModelMutation.create(todo),
                        response -> Log.i("MyAmplifyApp", "Added Todo with id: " + response.getData().getId()),
                        error -> Log.e("MyAmplifyApp", "Create failed", error)
                );
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
      startActivity (new Intent(com.prerana.android.swadhishta.MainActivity2.this,MainActivity.class));
    }
}