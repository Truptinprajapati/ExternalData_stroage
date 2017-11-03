package com.example.trupti.external_storage;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Second_activity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);

        editText=(EditText)findViewById(R.id.loaddata);

    }
    public void loadInternalcache(View view)
    {
        File floder=getCacheDir();
        File myfile=new File(floder,"medata1.txt");
        String data=redData(myfile);
        if (data!= null)
        {
            editText.setText(data);
        }

        else
        {
            editText.setText("data was no return");
        }
    }





    public void loadExternalcache(View view)
    {
        File floder=getExternalCacheDir();
        File myfile=new File(floder,"medata2.txt");
        String data=redData(myfile);
        if (data!= null)
        {
            editText.setText(data);
        }

        else
        {
            editText.setText("data was no return");
        }
    }




    public void loadExternalprivate(View view)
    {

        File floder=getExternalFilesDir("Slidenerd");
        File myfile=new File(floder,"medata3.txt");
        String data=redData(myfile);
        if (data!= null)
        {
            editText.setText(data);
        }

        else
        {
            editText.setText("data was no return");
        }
    }




    public void loadExternalPublic(View view)
    {

        File floder=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File myfile=new File(floder,"medata4.txt");
        String data=redData(myfile);
        if (data!= null)
        {
            editText.setText(data);
        }

        else
        {
            editText.setText("data was no return");
        }
    }







    private String redData(File myfile)
    {
        FileInputStream fileInputStream=null;
        try {
            fileInputStream =new FileInputStream(myfile);
            int read=-1;
            StringBuffer stringBuffer=new StringBuffer();
            while ((read=fileInputStream.read())!=-1)
            {
                stringBuffer.append((char)read);
            }
            return stringBuffer.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
        finally {
            if (fileInputStream!=null)
            {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }






    public void previous(View v)
    {

        Intent i=new Intent(Second_activity.this,MainActivity.class);
        startActivity(i);
    }

    public void Message(String msg)
    {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
