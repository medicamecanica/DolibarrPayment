package co.medicamecanica.dolibarrpayment.dummy;

import android.os.AsyncTask;
import android.util.Log;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import co.medicamecanica.dolutils.RestClient;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public  class ThirdpartyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<ThirdpartyItem> ITEMS = new ArrayList<ThirdpartyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, ThirdpartyItem> ITEM_MAP = new HashMap<String, ThirdpartyItem>();



    private static void addItem(ThirdpartyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.getId(), item);
    }
    private static void clear() {
        ITEMS.clear();
        ITEM_MAP.clear();
    }




    /**
     * A dummy item representing a piece of content.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public  static class ThirdpartyItem {
        private String id;
        private String name;
        private String idprof1;
        private String idprof2;
        private String town;
        private String state;
        private String address;
        private String phone;
        private String email;
        ThirdpartyItem(){};
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIdprof1() {
            return idprof1;
        }

        public void setIdprof1(String idprof1) {
            this.idprof1 = idprof1;
        }

        public String getIdprof2() {
            return idprof2;
        }

        public void setIdprof2(String idprof2) {
            this.idprof2 = idprof2;
        }

        public String getTown() {
            return town;
        }

        public void setTown(String town) {
            this.town = town;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
        @Override
        public String toString() {
            return "ThirdpartyItem{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", idprof1='" + idprof1 + '\'' +
                    ", idprof2='" + idprof2 + '\'' +
                    ", town='" + town + '\'' +
                    ", state='" + state + '\'' +
                    ", address='" + address + '\'' +
                    ", phone='" + phone + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }


    }
    public static void list(ThirdpartyListListener tl){

         new GetThirdpartiesTask(tl).execute();

    }
    public static void list(ThirdpartyListListener tl,String query){

        new GetThirdpartiesTask(tl,query).execute();

    }
    public static class GetThirdpartiesTask extends AsyncTask<Void, Void, Integer>{
        ThirdpartyListListener thirdpartyListListener;
        private ThirdpartyItem[] thirdparties;
        private String query=null;

        public GetThirdpartiesTask(ThirdpartyListListener thirdpartyListListener) {
            this.thirdpartyListListener=thirdpartyListListener;
        }

        public GetThirdpartiesTask(ThirdpartyListListener thirdpartyListListener, String query) {
            this.thirdpartyListListener = thirdpartyListListener;
            this.query = query;
        }

        @Override
        protected Integer doInBackground(Void... voids) {

            try {

                ClientResource cr = RestClient.BuildClientResource(RestClient.getURL());
                cr.addSegment("thirdparties");
                if(query!=null)
                  cr.addQueryParameter("sqlfilters",  "(t.nom:like:'%"+query+"%') or (t.siren:like:'%"+query+"%') or (t.siret:like:'%"+query+"%')");

                RestClient.addToken(cr,RestClient.getToken());
                ThirdPartyResource resource = cr.wrap(ThirdPartyResource.class);

                 thirdparties = resource.list();

               clear();
                for (ThirdpartyItem thirdparty:thirdparties) {
                    addItem(thirdparty);
                }

                Log.i("success",ITEMS.toString() );
                return 200;
            } catch (ResourceException e) {
                e.printStackTrace();
                Log.e("uri",e.getResponse().getEntityAsText());
                return e.getResponse().getStatus().getCode();
            }
        }

        @Override
        protected void onPostExecute(Integer code) {
            super.onPostExecute(code);
            thirdpartyListListener.onPostExecute(thirdparties,code);

        }
    }
}


