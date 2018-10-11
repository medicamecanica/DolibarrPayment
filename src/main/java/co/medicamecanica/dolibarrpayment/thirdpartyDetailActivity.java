package co.medicamecanica.dolibarrpayment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;

import co.medicamecanica.dolibarrpayment.dummy.ThirdpartyContent;

/**
 * An activity representing a single thirdparty detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link thirdpartyListActivity}.
 */
public class thirdpartyDetailActivity extends AppCompatActivity {

    private final int INVOICE_ACTIVITY=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdparty_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own detail action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                //ThirdpartyContent.ThirdpartyItem item = (ThirdpartyContent.ThirdpartyItem) view.getTag();


                   // Context context = view.getContext();
                    Intent intent = new Intent(thirdpartyDetailActivity.this, InvoiceListActivity.class);
                    intent.putExtra(InvoiceListActivity.ARG_THIRD_ID,  getIntent().getStringExtra(thirdpartyDetailFragment.ARG_ITEM_ID));

                   // context.startActivity(intent);
                    startActivityForResult(intent,INVOICE_ACTIVITY);
            }
        });

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(thirdpartyDetailFragment.ARG_ITEM_ID,
                    getIntent().getStringExtra(thirdpartyDetailFragment.ARG_ITEM_ID));
            thirdpartyDetailFragment fragment = new thirdpartyDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.thirdparty_detail_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. Use NavUtils to allow users
            // to navigate up one level in the application structure. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            NavUtils.navigateUpTo(this, new Intent(this, thirdpartyListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("result intent",requestCode+">>"+resultCode);
        switch(requestCode) {
            case (INVOICE_ACTIVITY) : {
                if (resultCode == Activity.RESULT_OK) {
                    // TODO Extract the data returned from the child Activity.

                        // Create the detail fragment and add it to the activity
                        // using a fragment transaction.
                        Bundle arguments = new Bundle();
                        arguments.putString(thirdpartyDetailFragment.ARG_ITEM_ID,
                                data.getStringExtra(thirdpartyDetailFragment.ARG_ITEM_ID));
                        thirdpartyDetailFragment fragment = new thirdpartyDetailFragment();
                        fragment.setArguments(arguments);
                        getSupportFragmentManager().beginTransaction()
                                .add(R.id.thirdparty_detail_container, fragment)
                                .commit();

                }
                break;
            }
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        if (getSupportFragmentManager().findFragmentById(R.id.thirdparty_detail_container) != null)
            getSupportFragmentManager().findFragmentById(R.id.thirdparty_detail_container).setRetainInstance(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (getSupportFragmentManager().findFragmentById(R.id.thirdparty_detail_container) != null)
            getSupportFragmentManager().findFragmentById(R.id.thirdparty_detail_container).getRetainInstance();
    }
}
