package rs.aleph.android.example21.activities;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import rs.aleph.android.example21.R;
import rs.aleph.android.example21.dialogs.AboutDialog;

public class MainActivity extends AppCompatActivity{



    private AlertDialog dialog;





    private int productId = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        //showing AboutDialog
        if (dialog == null){
            dialog = new AboutDialog(MainActivity.this).prepareDialog();
        } else {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
        }

        dialog.show();



        //Showing a dialog

        final Dialog dialog = new Dialog(MainActivity.this);

        dialog.setContentView(R.layout.dialog_layout);

        dialog.setTitle("Dialog");

        Button ok = (Button) dialog.findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final EditText editName = (EditText) dialog.findViewById(R.id.product_name);
                final EditText editDescription = (EditText) dialog.findViewById(R.id.product_description);
                final RatingBar ratingBar = (RatingBar) dialog.findViewById(R.id.rb_product);
                Button btnImage = (Button) dialog.findViewById(R.id.btn_browse_image);
                btnImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                        /*final Spinner image = (Spinner) dialog.findViewById(R.id.sp_dialog_images);

                        List<String> images  = new ArrayList<String>();
                        images.add("apples.jpg");
                        images.add("bananas.jpg");
                        images.add("oranges.jpg");
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, images);
                        image.setAdapter(adapter);
                        image.setSelection(1);*/

                Spinner category = (Spinner)dialog.findViewById(R.id.sp_dialog_categories);


                //ArrayAdapter<Category> adapter1 = new ArrayAdapter<Category>(MainActivity.this,android.R.layout.simple_spinner_item,categories);
                //category.setAdapter(adapter1);
                //category.setSelection(0);


                dialog.dismiss();


            }
        });

        Button cancel = (Button) dialog.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                //Toast.makeText(MainActivity.this, R.string.dialog_message_no,Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();




        // Enable ActionBar app icon to behave as action to toggle nav drawer
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            //actionBar.setHomeAsUpIndicator(R.drawable.ic_drawer);
            actionBar.setHomeButtonEnabled(true);
            actionBar.show();
        }



        if (savedInstanceState == null) {

        }




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_item_master, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     *
     * Metoda koja je izmenjena da reflektuje rad sa Asinhronim zadacima
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                Toast.makeText(MainActivity.this, "Sinhronizacija pokrenuta u pozadini niti. dobro :)",Toast.LENGTH_SHORT).show();

                break;
            case R.id.action_add:

                    Toast.makeText(MainActivity.this, "Sinhronizacija pokrenuta u glavnoj niti. Nije dobro :(",Toast.LENGTH_SHORT).show();


                break;
            case R.id.action_delete:

                break;
        }

        return super.onOptionsItemSelected(item);
    }

   /* @Override
    public void setTitle(CharSequence title) {
        getSupportActionBar().setTitle(title);
    }*/









   /* @Override
    public void onBackPressed() {

        if (landscapeMode) {
            finish();
        } else if (listShown == true) {
            finish();
        } else if (detailShown == true) {

        }

    }*/

}


