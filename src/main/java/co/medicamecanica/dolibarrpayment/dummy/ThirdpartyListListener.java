package co.medicamecanica.dolibarrpayment.dummy;

public interface ThirdpartyListListener {
    void onPostExecute(ThirdpartyContent.ThirdpartyItem[] thirdparties, Integer code);
}
