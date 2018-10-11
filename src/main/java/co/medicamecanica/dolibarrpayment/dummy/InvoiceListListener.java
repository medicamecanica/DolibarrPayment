package co.medicamecanica.dolibarrpayment.dummy;

public interface InvoiceListListener {
    void onPostExecute(InvoiceContent.InvoiceItem[] invoices, Integer code);
}
