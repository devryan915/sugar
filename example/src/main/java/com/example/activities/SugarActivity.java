package com.example.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.R;
import com.example.bean.Book;

import java.util.List;


public class SugarActivity extends Activity
{
    private static final String TAG =SugarActivity.class.getSimpleName() ;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        testSugar();
    }
    private void testSugar() {
        Book book = new Book("Title here", "2nd edition");
        long savedID = book.save();
        Log.d(TAG, "book saved success savedID:" + savedID);
        Book bookGet = Book.findById(Book.class, savedID);
        if (bookGet != null) {
            bookGet.title = "updated title here"; // modify the values
            bookGet.edition = "3rd edition";
            long saveIDN = bookGet.save(); // updates the previous entry with new values.
            Log.d(TAG, "bookGet saved success savedID:" + savedID + " saveIDN:" + saveIDN);
        }
        List<Book> bookGet1 = Book.find(Book.class, "title=?", "updated title here");
        if (bookGet1 != null && bookGet1.size() > 0) {
            Log.d(TAG, "query Book title='updated title here' success size:" + bookGet1.size());
        }
    }
}
