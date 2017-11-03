package com.example.trupti.external_storage;

        import android.content.Intent;
        import android.os.Environment;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.Toast;

        import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.FileOutputStream;
        import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText)findViewById(R.id.uname);

    }

   public void saveInternalCache(View v)
   {

       String data=editText.getText().toString();
       File folder=getCacheDir();
       File myfile=new File(folder,"medata1.txt");
       writeData(myfile,data);

   }
    public void saveExternalCache(View v)
    {
        String data=editText.getText().toString();
        File folder=getExternalCacheDir();
        File myfile=new File(folder,"medata2.txt");
        writeData(myfile,data);
    }
    public void savePrivateExternalFile(View v)
    {

        String data=editText.getText().toString();
        File folder=getExternalFilesDir("Slidenerd");
        File myfile=new File(folder,"medata3.txt");
        writeData(myfile,data);
    }
    public void savePublicExternalFile(View v)
    {

        String data=editText.getText().toString();
        File folder=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File myfile=new File(folder,"medata4.txt");
        writeData(myfile,data);


    }

    private void writeData(File myfile,String data) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(myfile);
            fileOutputStream.write(data.getBytes());
            Message(data + " was writer successfull" + myfile.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }



    public void next(View v)
    {

        Intent i=new Intent(MainActivity.this,Second_activity.class);
        startActivity(i);
    }

    public void Message(String msg)
    {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
