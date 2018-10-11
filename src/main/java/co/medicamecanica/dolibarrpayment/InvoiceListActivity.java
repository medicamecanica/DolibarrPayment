package co.medicamecanica.dolibarrpayment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import co.medicamecanica.dolibarrpayment.dummy.InvoiceContent;
import co.medicamecanica.dolibarrpayment.dummy.InvoiceListListener;
import co.medicamecanica.dolibarrpayment.dummy.ThirdpartyContent;

import java.util.List;

/**
 * An activity representing a list of invoices. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link InvoiceDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class InvoiceListActivity extends AppCompatActivity {

    public static final String ARG_THIRD_ID ="_ID_" ;
    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;
    private ThirdpartyContent.ThirdpartyItem thirdparty;
    private View recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        //get thirdparti
        //Log.i("invoice-third",getIntent().getExtras().toString());
        if(getIntent().getExtras()!=null) {
            if (getIntent().getExtras().containsKey(ARG_THIRD_ID)) {
                // Load the dummy content specified by the fragment
                // arguments. In a real-world scenario, use a Loader
                // to load content from a content provider.
                thirdparty = ThirdpartyContent.ITEM_MAP.get(getIntent().getExtras().getString(ARG_THIRD_ID));

                Activity activity = this;
                CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
                if (appBarLayout != null) {
                    appBarLayout.setTitle(thirdparty.getName());
                }
            }
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Snackbar.make(view, "Actualizando facturas...", Snackbar.LENGTH_LONG);
                if(thirdparty!=null) {
                    InvoiceContent.list(new InvoiceListListener() {
                        @Override
                        public void onPostExecute(InvoiceContent.InvoiceItem[] invoices, Integer code) {
                            if(code==200) {
                                    Snackbar.make(view, "Actualizado!!!", Snackbar.LENGTH_LONG);
                                setupRecyclerView((RecyclerView) recyclerView);
                            }
                            else if(code==404) {
                                Snackbar.make(view, "No hay facturas...", Snackbar.LENGTH_LONG);
                                InvoiceContent.clear();
                                setupRecyclerView((RecyclerView) recyclerView);
                            }
                        }
                    },thirdparty.getId() );
                }
            }
        });
        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if (findViewById(R.id.invoice_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }

         recyclerView = findViewById(R.id.invoice_list);
        assert recyclerView != null;
        if(thirdparty!=null) {
            InvoiceContent.list(new InvoiceListListener() {
                @Override
                public void onPostExecute(InvoiceContent.InvoiceItem[] invoices, Integer code) {
                    if(code==200)
                    setupRecyclerView((RecyclerView) recyclerView);
                    if(code==404) {
                        InvoiceContent.clear();
                        setupRecyclerView((RecyclerView) recyclerView);
                    }
                }
            },thirdparty.getId() );
        }
        setupRecyclerView((RecyclerView) recyclerView);
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
            Intent resultIntent = new Intent(this, thirdpartyDetailActivity.class);
            // TODO Add extras or a data URI to this intent as appropriate.
            resultIntent.putExtra(thirdpartyDetailFragment.ARG_ITEM_ID, thirdparty.getId());
         //   setResult(Activity.RESULT_OK, resultIntent);
            NavUtils.navigateUpTo(this,resultIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(this, InvoiceContent.ITEMS, mTwoPane));
    }

    public static class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final InvoiceListActivity mParentActivity;
        private final List<InvoiceContent.InvoiceItem> mValues;
        private final boolean mTwoPane;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InvoiceContent.InvoiceItem item = (InvoiceContent.InvoiceItem) view.getTag();
                if (mTwoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putString(InvoiceDetailFragment.ARG_ITEM_ID, item.getId());
                    InvoiceDetailFragment fragment = new InvoiceDetailFragment();
                    fragment.setArguments(arguments);
                    mParentActivity.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.invoice_detail_container, fragment)
                            .commit();
                } else {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, InvoiceDetailActivity.class);
                    intent.putExtra(InvoiceDetailFragment.ARG_ITEM_ID, item.getId());

                    context.startActivity(intent);
                }
            }
        };

        SimpleItemRecyclerViewAdapter(InvoiceListActivity parent,
                                      List<InvoiceContent.InvoiceItem> items,
                                      boolean twoPane) {
            mValues = items;
            mParentActivity = parent;
            mTwoPane = twoPane;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.invoice_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mIdView.setText(mValues.get(position).getId());
            holder.mContentView.setText(mValues.get(position).toString());

            holder.itemView.setTag(mValues.get(position));
            holder.itemView.setOnClickListener(mOnClickListener);
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final TextView mIdView;
            final TextView mContentView;

            ViewHolder(View view) {
                super(view);
                mIdView = (TextView) view.findViewById(R.id.id_text);
                mContentView = (TextView) view.findViewById(R.id.content);
            }
        }
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save your data here with savedInstanceState.put<something>...
    }
}
