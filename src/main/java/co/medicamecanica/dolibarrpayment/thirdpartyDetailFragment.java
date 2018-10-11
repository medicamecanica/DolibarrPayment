package co.medicamecanica.dolibarrpayment;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import co.medicamecanica.dolibarrpayment.dummy.ThirdpartyContent;

/**
 * A fragment representing a single thirdparty detail screen.
 * This fragment is either contained in a {@link thirdpartyListActivity}
 * in two-pane mode (on tablets) or a {@link thirdpartyDetailActivity}
 * on handsets.
 */
public class thirdpartyDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private ThirdpartyContent.ThirdpartyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public thirdpartyDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = ThirdpartyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.getName());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.thirdparty_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            String detail="";
            if(mItem.getIdprof1()!=null)
                detail+="RUT: "+mItem.getIdprof1()+"\n";
            if(mItem.getIdprof2()!=null)
                detail+="CC: "+mItem.getIdprof2()+"\n";
            if(mItem.getState()!=null)
                detail+="Departamento: "+mItem.getState()+"\n";
            if(mItem.getTown()!=null)
                detail+="Municipio: "+mItem.getTown()+"\n";
            if(mItem.getAddress()!=null)
                detail+="Direccón: "+mItem.getAddress()+"\n";
            if(mItem.getPhone()!=null)
                detail+="Telefono: "+mItem.getPhone()+"\n";
            if(mItem.getEmail()!=null)
                detail+="Email: "+mItem.getEmail();
            ((TextView) rootView.findViewById(R.id.thirdparty_detail)).setText(detail);
        }

        return rootView;
    }
}
