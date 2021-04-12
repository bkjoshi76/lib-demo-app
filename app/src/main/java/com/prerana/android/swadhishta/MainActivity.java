/*
 * MIT License
 *
 * Copyright (c) 2018 Yuriy Budiyev [yuriy.budiyev@yandex.ru]
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.prerana.android.swadhishta;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.amplifyframework.datastore.generated.model.ScanResult;
import com.amplifyframework.datastore.generated.model.Todo;
import com.amplifyframework.storage.options.StorageDownloadFileOptions;
import com.amplifyframework.storage.s3.AWSS3StoragePlugin;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.prerana.android.swadhishta.base.BaseActivity;
import com.prerana.android.swadhishta.codescanner.CodeScannerActivity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    // declaration
    public FloatingActionButton btn;
    public TextView textView;
    public String[] st;
    int i = 0;
    Handler handler;

    // the array adapter converts an ArrayList of objects
    // into View items filled into the ListView container
    ArrayAdapter<String> arrayAdapter;

    // list to store data
    public static List<String> ls;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.food_product_scanner)
                .setOnClickListener(v -> startActivity(new Intent(this, CodeScannerActivity.class)));

        // provide id to the layout items
        btn = findViewById(R.id.fab);
        st = new String[100];



        // set listener to the floating button which takes
        // you to the next activity where you add and sore
        // your data
        btn.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
        ls = new ArrayList<String>();
        ls.add("Please scan the food product");

        // add the code below to initialize Amplpify
        try {
            // Add these lines to add the AWSApiPlugin plugins
            Amplify.addPlugin(new AWSDataStorePlugin());
            Amplify.addPlugin(new AWSCognitoAuthPlugin());
            Amplify.addPlugin(new AWSS3StoragePlugin());
            Amplify.addPlugin(new AWSApiPlugin());
            Amplify.configure(getApplicationContext());
            uploadFile();
            downloadFile();
            Log.i("SwadhishtaApp", "Initialized Amplify");
        }
        catch (AmplifyException error) {
            Log.e("SwadhishtaApp", "Could not initialize Amplify", error);
        }

        displayImage("none");
        //createTodo();

        showScanResults();
    }

    private void uploadFile() {
        File exampleFile = new File(getApplicationContext().getFilesDir(), "ExampleKey");

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(exampleFile));
            writer.append("Example file contents");
            writer.close();
        } catch (Exception exception) {
            Log.e("SwadhishtaApp", "Upload failed", exception);
        }

        Amplify.Storage.uploadFile(
                "ExampleKey",
                exampleFile,
                result -> Log.i("SwadhishtaApp", "Successfully uploaded: " + result.getKey()),
                storageFailure -> Log.e("SwadhishtaApp", "Upload failed", storageFailure)
        );
    }

    private void downloadFile() {
        Amplify.Storage.downloadFile(
                "ExampleKey",
                new File(getApplicationContext().getFilesDir() + "/download.txt"),
                StorageDownloadFileOptions.defaultInstance(),
                progress -> Log.i("SwadhishtaApp", "Fraction completed: " + progress.getFractionCompleted()),
                result -> Log.i("SwadhishtaApp", "Successfully downloaded: " + result.getFile().getName()),
                error -> Log.e("SwadhishtaApp",  "Download Failure", error)
        );
    }

    private void showScanResults()

    {
        ScanInfo scanInstance = ScanInfo.getInstance();
        Log.i("SwadhishtaApp", scanInstance.getScanId());

        textView = findViewById(R.id.food_description);

        if (!scanInstance.getScanId().isEmpty())
        {
            Amplify.API.query(ModelQuery.list(ScanResult.class), response -> {
                        for (ScanResult data : response.getData()) {
                            if (data.getName().contentEquals(scanInstance.getScanId()))
                            {
                                ls.add(data.getName());
                                textView.setText(data.getName());
                                Log.i("SwadhishtaApp", data.getName());
                            }
                        }
                    },
                    error -> Log.e("SwadhishtaApp", "Query failure", error));
        }
        else
        {
            Log.i("SwadhishtaApp", "ScanId is empty");
            ls.add("Please scan food product");
            textView.setText("         Please scan the  food product");
        }
    }

    private void createTodo()
    {
        Todo todo = Todo.builder()
                .name("My first todo")
                .description("todo description")
                .build();

        Amplify.API.mutate(
                ModelMutation.create(todo),
                response -> Log.i("SwadhishtaApp", "Added Todo with id: " + response.getData().getId()),
                error -> Log.e("SwadhishtaApp", "Create failed", error)
        );

        // add the code below to fetch
        // data/run queries to
        // retrieve the stored data

        Amplify.API.query(ModelQuery.list(Todo.class), response -> {
                    for (Todo data : response.getData()) {
                        //ls.add(data.getName());
                        Log.i("SwadhishtaApp", data.getName());
                    }
                },
                error -> Log.e("SwadhishtaApp", "Query failure", error));
    }

    private void displayImage(String imageType)
    {
        ImageView backgroundView  = (ImageView) findViewById(R.id.swadhishta);
        backgroundView.setImageResource(R.drawable.swad);

        ImageView simpleImageView = (ImageView) findViewById(R.id.simpleImageView);//get the id of first image view
        if (imageType.equals("Red"))
            simpleImageView.setImageResource(R.drawable.traffic_light_red);//set the source in java class
        else if (imageType.equals("Green"))
            simpleImageView.setImageResource(R.drawable.traffic_light_green);//set the source in java class
        else if (imageType.equals("Yellow"))
            simpleImageView.setImageResource(R.drawable.traffic_light_yellow);//set the source in java class
        else
            simpleImageView.setImageResource(android.R.color.transparent);
    }
}


