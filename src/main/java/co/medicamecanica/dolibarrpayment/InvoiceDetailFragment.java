package co.medicamecanica.dolibarrpayment;

import android.app.Activity;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

import co.medicamecanica.dolibarrpayment.dummy.InvoiceContent;

/**
 * A fragment representing a single Invoice detail screen.
 * This fragment is either contained in a {@link InvoiceListActivity}
 * in two-pane mode (on tablets) or a {@link InvoiceDetailActivity}
 * on handsets.
 */
public class InvoiceDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private InvoiceContent.InvoiceItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public InvoiceDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = InvoiceContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            TextView subTitle = (TextView) activity.findViewById(R.id.sub_title);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.getRef());
                int statImg= InvoiceContent.getStateImg(mItem.getStatut());
              //  subTitle.setText(mItem.get);
                appBarLayout.setBackgroundResource(statImg);

            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.invoice_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            Spanned spanned=null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                String details="<ul>";
                for (InvoiceContent.Line line:mItem.getLines() ) {
                    details+="<li>";
                    details+=" "+line.getDesc()+" ";
                    details+="("+line.getQty()+"x";
                   // details+= String.format("" + new DecimalFormat("0.##").format((line.getTotalTtc())))+"$)";
                    details+= "" +line.getTotalTtc()+"$)";
                    details+="</li>";
                }
                details+="</ul>";
                spanned = Html.fromHtml(
                        "<h2>Total: </h2><p>"+mItem.getTotalTtc()+"</p>"+
                                "<h2>Pagado: </h2><p>"+(mItem.getTotalpaid()!=null?mItem.getTotalpaid():"0")+"</p>"+
                                details

                        , Html.FROM_HTML_MODE_COMPACT);
            }
            ((TextView) rootView.findViewById(R.id.invoice_detail)).setText(spanned);
        }

        return rootView;
    }
}
