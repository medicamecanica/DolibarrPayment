package co.medicamecanica.dolibarrpayment.dummy;

import org.restlet.resource.Get;

interface ThirdPartyResource {
    @Get
    public ThirdpartyContent.ThirdpartyItem[] list();
}
