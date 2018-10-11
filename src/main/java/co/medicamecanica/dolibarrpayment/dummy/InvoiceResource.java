package co.medicamecanica.dolibarrpayment.dummy;

import org.restlet.resource.Get;

interface InvoiceResource {
    @Get
    public InvoiceContent.InvoiceItem[] list() ;
}
