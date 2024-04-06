package ru.mirea.kateninva.notebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private	static final int REQUEST_CODE_PERMISSION = 200;

    private EditText filenameText;
    private EditText quoteText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filenameText = findViewById(R.id.filenameText);
        quoteText = findViewById(R.id.quoteText);

        if ((isExternalStorageReadable() || isExternalStorageWritable()) == false) {
            ActivityCompat.requestPermissions(this,	new	String[]
                    {android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_CODE_PERMISSION);
        }
    }

    /* Проверяем хранилище на доступность чтения и записи*/
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Проверяем внешнее хранилище на доступность чтения */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    public void writeFileToExternalStorage(View view) {
        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(path, filenameText.getText().toString());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file.getAbsoluteFile());
            OutputStreamWriter output = new OutputStreamWriter(fileOutputStream);
            //	Запись строки в файл
            output.write(quoteText.getText().toString());
            //	Закрытие потока записи
            output.close();

        } catch (IOException e) {
            Log.w("ExternalStorage", "Error writing " + file, e);
        }
    }

    public void readFileFromExternalStorage(View view) {
        File path = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOCUMENTS);
        File file =	new	File(path, filenameText.getText().toString());
        try	{
            FileInputStream fileInputStream	=	new	FileInputStream(file.getAbsoluteFile());
            InputStreamReader inputStreamReader	=	new	InputStreamReader(fileInputStream,	StandardCharsets.UTF_8);
            List<String> lines	=	new ArrayList<String>();
            BufferedReader reader	=	new	BufferedReader(inputStreamReader);
            String	line	=	reader.readLine();
            while (line	!=	null)	{
                lines.add(line);
                line =	reader.readLine();
            }

            String listString = String.join("\n", lines);

            quoteText.setText(listString);
            Log.w("ExternalStorage",	String.format("Read	from	file	%s	successful",	lines.toString()));
        }	catch	(Exception	e)	{
            Log.w("ExternalStorage",	String.format("Read	from	file	%s	failed",	e.getMessage()));
        }
    }
}