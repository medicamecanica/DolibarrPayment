package co.medicamecanica.dolibarrpayment.dummy;

import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import co.medicamecanica.dolibarrpayment.R;
import co.medicamecanica.dolutils.RestClient;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class InvoiceContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<InvoiceItem> ITEMS = new ArrayList<InvoiceItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, InvoiceItem> ITEM_MAP = new HashMap<String, InvoiceItem>();
/**
        * Standard invoice
     */
    public static  int TYPE_STANDARD = 0;

    /**
     * Replacement invoice
     */
    public static  int TYPE_REPLACEMENT = 1;

    /**
     * Credit note invoice
     */
    public static  int TYPE_CREDIT_NOTE = 2;

    /**
     * Deposit invoice
     */
    public static  int TYPE_DEPOSIT = 3;

    /**
     * Proforma invoice (should not be used. a proforma is an order)
     */
    public static  int TYPE_PROFORMA = 4;

    /**
     * Situation invoice
     */
    public static  int TYPE_SITUATION = 5;

    /**
     * Draft
     */
    public static  final int STATUS_DRAFT = 0;

    /**
     * Validated (need to be paid)
     */
    public static final int STATUS_VALIDATED = 1;

    /**
     * Classified paid.
     * If paid partially, $this->close_code can be:
     * - CLOSECODE_DISCOUNTVAT
     * - CLOSECODE_BADDEBT
     * If paid completelly, this->close_code will be null
     */
    public static final int STATUS_CLOSED = 2;

    public static final int STATUS_ABANDONED = 3;

    /**
     * Classified abandoned and no payment done.
     * $this->close_code can be:
     * - CLOSECODE_BADDEBT
     * - CLOSECODE_ABANDONED
     * - CLOSECODE_REPLACED
     */


    public static final   String CLOSECODE_DISCOUNTVAT = "discount_vat";
    public static  final String CLOSECODE_BADDEBT = "badcustomer";
    public static  final String CLOSECODE_ABANDONED = "abandon";
    public static  final String CLOSECODE_REPLACED = "replaced";

    private static void addItem(InvoiceItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }


    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    public static void list(InvoiceListListener invoiceListListener, String id) {
        new GetInvoicesTask(invoiceListListener,id).execute();
    }

    /**
     * A dummy item representing a piece of content.
     */


    @JsonInclude(JsonInclude.Include.ALWAYS)
    @JsonPropertyOrder({
            "socid",
            "fk_user_author",
            "fk_user_valid",
            "date",
            "date_creation",
            "date_validation",
            "datem",
            "ref_client",
            "type",
            "remise_absolue",
            "remise_percent",
            "total_ht",
            "total_tva",
            "total_localtax1",
            "total_localtax2",
            "total_ttc",
            "revenuestamp",
            "close_code",
            "close_note",
            "paye",
            "fk_facture_source",
            "date_lim_reglement",
            "cond_reglement_code",
            "mode_reglement_code",
            "fk_bank",
            "lines",
            "fk_multicurrency",
            "multicurrency_code",
            "multicurrency_tx",
            "multicurrency_total_ht",
            "multicurrency_total_tva",
            "multicurrency_total_ttc",
            "situation_final",
            "id",
            "import_key",
            "fk_project",
            "ref",
            "ref_ext",
            "statut",
            "mode_reglement_id",
            "cond_reglement_id",
            "cond_reglement",
            "modelpdf",
            "fk_account",
            "note_public",
            "note_private",
            "fk_incoterms",
            "libelle_incoterms",
            "location_incoterms",
            "entity",
            "date_pointoftax",
            "mode_reglement",
            "cond_reglement_doc",
            "user_author",
            "user_valid",
            "last_main_doc",
            "brouillon",
            "totalpaid",
            "totalcreditnotes",
            "totaldeposits",
            "remaintopay"
    })
    public static class InvoiceItem {

        @JsonProperty("socid")
        private String socid;
        @JsonProperty("fk_user_author")
        private Integer fkUserAuthor;
        @JsonProperty("fk_user_valid")
        private Integer fkUserValid;
        @JsonProperty("date")
        private Integer date;
        @JsonProperty("date_creation")
        private Integer dateCreation;
        @JsonProperty("date_validation")
        private String dateValidation;
        @JsonProperty("datem")
        private Integer datem;
        @JsonProperty("ref_client")
        private String refClient;
        @JsonProperty("type")
        private String type;
        @JsonProperty("remise_absolue")
        private Integer remiseAbsolue;
        @JsonProperty("remise_percent")
        private Integer remisePercent;
        @JsonProperty("total_ht")
        private String totalHt;
        @JsonProperty("total_tva")
        private String totalTva;
        @JsonProperty("total_localtax1")
        private String totalLocaltax1;
        @JsonProperty("total_localtax2")
        private String totalLocaltax2;
        @JsonProperty("total_ttc")
        private String totalTtc;
        @JsonProperty("revenuestamp")
        private String revenuestamp;
        @JsonProperty("close_code")
        private String closeCode;
        @JsonProperty("close_note")
        private String closeNote;
        @JsonProperty("paye")
        private String paye;
        @JsonProperty("fk_facture_source")
        private Integer fkFactureSource;
        @JsonProperty("date_lim_reglement")
        private Integer dateLimReglement;
        @JsonProperty("cond_reglement_code")
        private String condReglementCode;
        @JsonProperty("mode_reglement_code")
        private String modeReglementCode;
        @JsonProperty("fk_bank")
        private Integer fkBank;
        @JsonProperty("lines")
        private List<Line> lines = null;
        @JsonProperty("fk_multicurrency")
        private String fkMulticurrency;
        @JsonProperty("multicurrency_code")
        private String multicurrencyCode;
        @JsonProperty("multicurrency_tx")
        private String multicurrencyTx;
        @JsonProperty("multicurrency_total_ht")
        private String multicurrencyTotalHt;
        @JsonProperty("multicurrency_total_tva")
        private String multicurrencyTotalTva;
        @JsonProperty("multicurrency_total_ttc")
        private String multicurrencyTotalTtc;
        @JsonProperty("situation_final")
        private String situationFinal;
        @JsonProperty("id")
        private String id;
        @JsonProperty("import_key")
        private String importKey;
        @JsonProperty("fk_project")
        private Integer fkProject;
        @JsonProperty("ref")
        private String ref;
        @JsonProperty("ref_ext")
        private String refExt;
        @JsonProperty("statut")
        private Integer statut;
        @JsonProperty("mode_reglement_id")
        private String modeReglementId;
        @JsonProperty("cond_reglement_id")
        private String condReglementId;
        @JsonProperty("cond_reglement")
        private String condReglement;
        @JsonProperty("modelpdf")
        private String modelpdf;
        @JsonProperty("fk_account")
        private Integer fkAccount;
        @JsonProperty("note_public")
        private String notePublic;
        @JsonProperty("note_private")
        private String notePrivate;
        @JsonProperty("fk_incoterms")
        private String fkIncoterms;
        @JsonProperty("libelle_incoterms")
        private String libelleIncoterms;
        @JsonProperty("location_incoterms")
        private String locationIncoterms;
        @JsonProperty("entity")
        private String entity;
        @JsonProperty("date_pointoftax")
        private String datePointoftax;
        @JsonProperty("mode_reglement")
        private String modeReglement;
        @JsonProperty("cond_reglement_doc")
        private String condReglementDoc;
        @JsonProperty("user_author")
        private String userAuthor;
        @JsonProperty("user_valid")
        private Integer userValid;
        @JsonProperty("last_main_doc")
        private String lastMainDoc;
        @JsonProperty("brouillon")
        private Integer brouillon;
        @JsonProperty("totalpaid")
        private Double totalpaid;
        @JsonProperty("totalcreditnotes")
        private Double totalcreditnotes;
        @JsonProperty("totaldeposits")
        private Double totaldeposits;
        @JsonProperty("remaintopay")
        private Double remaintopay;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();


        @Override
        public String toString() {
            return  ref + " - "+ InvoiceContent.getState(getStatut());
        }

        @JsonProperty("socid")
        public String getSocid() {
            return socid;
        }

        @JsonProperty("socid")
        public void setSocid(String socid) {
            this.socid = socid;
        }

        @JsonProperty("fk_user_author")
        public Integer getFkUserAuthor() {
            return fkUserAuthor;
        }

        @JsonProperty("fk_user_author")
        public void setFkUserAuthor(Integer fkUserAuthor) {
            this.fkUserAuthor = fkUserAuthor;
        }

        @JsonProperty("fk_user_valid")
        public Integer getFkUserValid() {
            return fkUserValid;
        }

        @JsonProperty("fk_user_valid")
        public void setFkUserValid(Integer fkUserValid) {
            this.fkUserValid = fkUserValid;
        }

        @JsonProperty("date")
        public Integer getDate() {
            return date;
        }

        @JsonProperty("date")
        public void setDate(Integer date) {
            this.date = date;
        }

        @JsonProperty("date_creation")
        public Integer getDateCreation() {
            return dateCreation;
        }

        @JsonProperty("date_creation")
        public void setDateCreation(Integer dateCreation) {
            this.dateCreation = dateCreation;
        }

        @JsonProperty("date_validation")
        public String getDateValidation() {
            return dateValidation;
        }

        @JsonProperty("date_validation")
        public void setDateValidation(String dateValidation) {
            this.dateValidation = dateValidation;
        }

        @JsonProperty("datem")
        public Integer getDatem() {
            return datem;
        }

        @JsonProperty("datem")
        public void setDatem(Integer datem) {
            this.datem = datem;
        }

        @JsonProperty("ref_client")
        public String getRefClient() {
            return refClient;
        }

        @JsonProperty("ref_client")
        public void setRefClient(String refClient) {
            this.refClient = refClient;
        }

        @JsonProperty("type")
        public String getType() {
            return type;
        }

        @JsonProperty("type")
        public void setType(String type) {
            this.type = type;
        }

        @JsonProperty("remise_absolue")
        public Integer getRemiseAbsolue() {
            return remiseAbsolue;
        }

        @JsonProperty("remise_absolue")
        public void setRemiseAbsolue(Integer remiseAbsolue) {
            this.remiseAbsolue = remiseAbsolue;
        }

        @JsonProperty("remise_percent")
        public Integer getRemisePercent() {
            return remisePercent;
        }

        @JsonProperty("remise_percent")
        public void setRemisePercent(Integer remisePercent) {
            this.remisePercent = remisePercent;
        }

        @JsonProperty("total_ht")
        public String getTotalHt() {
            return totalHt;
        }

        @JsonProperty("total_ht")
        public void setTotalHt(String totalHt) {
            this.totalHt = totalHt;
        }

        @JsonProperty("total_tva")
        public String getTotalTva() {
            return totalTva;
        }

        @JsonProperty("total_tva")
        public void setTotalTva(String totalTva) {
            this.totalTva = totalTva;
        }

        @JsonProperty("total_localtax1")
        public String getTotalLocaltax1() {
            return totalLocaltax1;
        }

        @JsonProperty("total_localtax1")
        public void setTotalLocaltax1(String totalLocaltax1) {
            this.totalLocaltax1 = totalLocaltax1;
        }

        @JsonProperty("total_localtax2")
        public String getTotalLocaltax2() {
            return totalLocaltax2;
        }

        @JsonProperty("total_localtax2")
        public void setTotalLocaltax2(String totalLocaltax2) {
            this.totalLocaltax2 = totalLocaltax2;
        }

        @JsonProperty("total_ttc")
        public String getTotalTtc() {
            return totalTtc;
        }

        @JsonProperty("total_ttc")
        public void setTotalTtc(String totalTtc) {
            this.totalTtc = totalTtc;
        }

        @JsonProperty("revenuestamp")
        public String getRevenuestamp() {
            return revenuestamp;
        }

        @JsonProperty("revenuestamp")
        public void setRevenuestamp(String revenuestamp) {
            this.revenuestamp = revenuestamp;
        }

        @JsonProperty("close_code")
        public String getCloseCode() {
            return closeCode;
        }

        @JsonProperty("close_code")
        public void setCloseCode(String closeCode) {
            this.closeCode = closeCode;
        }

        @JsonProperty("close_note")
        public String getCloseNote() {
            return closeNote;
        }

        @JsonProperty("close_note")
        public void setCloseNote(String closeNote) {
            this.closeNote = closeNote;
        }

        @JsonProperty("paye")
        public String getPaye() {
            return paye;
        }

        @JsonProperty("paye")
        public void setPaye(String paye) {
            this.paye = paye;
        }

        @JsonProperty("fk_facture_source")
        public Integer getFkFactureSource() {
            return fkFactureSource;
        }

        @JsonProperty("fk_facture_source")
        public void setFkFactureSource(Integer fkFactureSource) {
            this.fkFactureSource = fkFactureSource;
        }

        @JsonProperty("date_lim_reglement")
        public Integer getDateLimReglement() {
            return dateLimReglement;
        }

        @JsonProperty("date_lim_reglement")
        public void setDateLimReglement(Integer dateLimReglement) {
            this.dateLimReglement = dateLimReglement;
        }

        @JsonProperty("cond_reglement_code")
        public String getCondReglementCode() {
            return condReglementCode;
        }

        @JsonProperty("cond_reglement_code")
        public void setCondReglementCode(String condReglementCode) {
            this.condReglementCode = condReglementCode;
        }

        @JsonProperty("mode_reglement_code")
        public String getModeReglementCode() {
            return modeReglementCode;
        }

        @JsonProperty("mode_reglement_code")
        public void setModeReglementCode(String modeReglementCode) {
            this.modeReglementCode = modeReglementCode;
        }

        @JsonProperty("fk_bank")
        public Integer getFkBank() {
            return fkBank;
        }

        @JsonProperty("fk_bank")
        public void setFkBank(Integer fkBank) {
            this.fkBank = fkBank;
        }

        @JsonProperty("lines")
        public List<Line> getLines() {
            return lines;
        }

        @JsonProperty("lines")
        public void setLines(List<Line> lines) {
            this.lines = lines;
        }

        @JsonProperty("fk_multicurrency")
        public String getFkMulticurrency() {
            return fkMulticurrency;
        }

        @JsonProperty("fk_multicurrency")
        public void setFkMulticurrency(String fkMulticurrency) {
            this.fkMulticurrency = fkMulticurrency;
        }

        @JsonProperty("multicurrency_code")
        public String getMulticurrencyCode() {
            return multicurrencyCode;
        }

        @JsonProperty("multicurrency_code")
        public void setMulticurrencyCode(String multicurrencyCode) {
            this.multicurrencyCode = multicurrencyCode;
        }

        @JsonProperty("multicurrency_tx")
        public String getMulticurrencyTx() {
            return multicurrencyTx;
        }

        @JsonProperty("multicurrency_tx")
        public void setMulticurrencyTx(String multicurrencyTx) {
            this.multicurrencyTx = multicurrencyTx;
        }

        @JsonProperty("multicurrency_total_ht")
        public String getMulticurrencyTotalHt() {
            return multicurrencyTotalHt;
        }

        @JsonProperty("multicurrency_total_ht")
        public void setMulticurrencyTotalHt(String multicurrencyTotalHt) {
            this.multicurrencyTotalHt = multicurrencyTotalHt;
        }

        @JsonProperty("multicurrency_total_tva")
        public String getMulticurrencyTotalTva() {
            return multicurrencyTotalTva;
        }

        @JsonProperty("multicurrency_total_tva")
        public void setMulticurrencyTotalTva(String multicurrencyTotalTva) {
            this.multicurrencyTotalTva = multicurrencyTotalTva;
        }

        @JsonProperty("multicurrency_total_ttc")
        public String getMulticurrencyTotalTtc() {
            return multicurrencyTotalTtc;
        }

        @JsonProperty("multicurrency_total_ttc")
        public void setMulticurrencyTotalTtc(String multicurrencyTotalTtc) {
            this.multicurrencyTotalTtc = multicurrencyTotalTtc;
        }

        @JsonProperty("situation_final")
        public String getSituationFinal() {
            return situationFinal;
        }

        @JsonProperty("situation_final")
        public void setSituationFinal(String situationFinal) {
            this.situationFinal = situationFinal;
        }

        @JsonProperty("id")
        public String getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(String id) {
            this.id = id;
        }

        @JsonProperty("import_key")
        public String getImportKey() {
            return importKey;
        }

        @JsonProperty("import_key")
        public void setImportKey(String importKey) {
            this.importKey = importKey;
        }

        @JsonProperty("fk_project")
        public Integer getFkProject() {
            return fkProject;
        }

        @JsonProperty("fk_project")
        public void setFkProject(Integer fkProject) {
            this.fkProject = fkProject;
        }

        @JsonProperty("ref")
        public String getRef() {
            return ref;
        }

        @JsonProperty("ref")
        public void setRef(String ref) {
            this.ref = ref;
        }

        @JsonProperty("ref_ext")
        public String getRefExt() {
            return refExt;
        }

        @JsonProperty("ref_ext")
        public void setRefExt(String refExt) {
            this.refExt = refExt;
        }

        @JsonProperty("statut")
        public Integer getStatut() {
            return statut;
        }

        @JsonProperty("statut")
        public void setStatut(Integer statut) {
            this.statut = statut;
        }

        @JsonProperty("mode_reglement_id")
        public String getModeReglementId() {
            return modeReglementId;
        }

        @JsonProperty("mode_reglement_id")
        public void setModeReglementId(String modeReglementId) {
            this.modeReglementId = modeReglementId;
        }

        @JsonProperty("cond_reglement_id")
        public String getCondReglementId() {
            return condReglementId;
        }

        @JsonProperty("cond_reglement_id")
        public void setCondReglementId(String condReglementId) {
            this.condReglementId = condReglementId;
        }

        @JsonProperty("cond_reglement")
        public String getCondReglement() {
            return condReglement;
        }

        @JsonProperty("cond_reglement")
        public void setCondReglement(String condReglement) {
            this.condReglement = condReglement;
        }

        @JsonProperty("modelpdf")
        public String getModelpdf() {
            return modelpdf;
        }

        @JsonProperty("modelpdf")
        public void setModelpdf(String modelpdf) {
            this.modelpdf = modelpdf;
        }

        @JsonProperty("fk_account")
        public Integer getFkAccount() {
            return fkAccount;
        }

        @JsonProperty("fk_account")
        public void setFkAccount(Integer fkAccount) {
            this.fkAccount = fkAccount;
        }

        @JsonProperty("note_public")
        public String getNotePublic() {
            return notePublic;
        }

        @JsonProperty("note_public")
        public void setNotePublic(String notePublic) {
            this.notePublic = notePublic;
        }

        @JsonProperty("note_private")
        public String getNotePrivate() {
            return notePrivate;
        }

        @JsonProperty("note_private")
        public void setNotePrivate(String notePrivate) {
            this.notePrivate = notePrivate;
        }

        @JsonProperty("fk_incoterms")
        public String getFkIncoterms() {
            return fkIncoterms;
        }

        @JsonProperty("fk_incoterms")
        public void setFkIncoterms(String fkIncoterms) {
            this.fkIncoterms = fkIncoterms;
        }

        @JsonProperty("libelle_incoterms")
        public String getLibelleIncoterms() {
            return libelleIncoterms;
        }

        @JsonProperty("libelle_incoterms")
        public void setLibelleIncoterms(String libelleIncoterms) {
            this.libelleIncoterms = libelleIncoterms;
        }

        @JsonProperty("location_incoterms")
        public String getLocationIncoterms() {
            return locationIncoterms;
        }

        @JsonProperty("location_incoterms")
        public void setLocationIncoterms(String locationIncoterms) {
            this.locationIncoterms = locationIncoterms;
        }

        @JsonProperty("entity")
        public String getEntity() {
            return entity;
        }

        @JsonProperty("entity")
        public void setEntity(String entity) {
            this.entity = entity;
        }

        @JsonProperty("date_pointoftax")
        public String getDatePointoftax() {
            return datePointoftax;
        }

        @JsonProperty("date_pointoftax")
        public void setDatePointoftax(String datePointoftax) {
            this.datePointoftax = datePointoftax;
        }

        @JsonProperty("mode_reglement")
        public String getModeReglement() {
            return modeReglement;
        }

        @JsonProperty("mode_reglement")
        public void setModeReglement(String modeReglement) {
            this.modeReglement = modeReglement;
        }

        @JsonProperty("cond_reglement_doc")
        public String getCondReglementDoc() {
            return condReglementDoc;
        }

        @JsonProperty("cond_reglement_doc")
        public void setCondReglementDoc(String condReglementDoc) {
            this.condReglementDoc = condReglementDoc;
        }

        @JsonProperty("user_author")
        public String getUserAuthor() {
            return userAuthor;
        }

        @JsonProperty("user_author")
        public void setUserAuthor(String userAuthor) {
            this.userAuthor = userAuthor;
        }

        @JsonProperty("user_valid")
        public Integer getUserValid() {
            return userValid;
        }

        @JsonProperty("user_valid")
        public void setUserValid(Integer userValid) {
            this.userValid = userValid;
        }

        @JsonProperty("last_main_doc")
        public String getLastMainDoc() {
            return lastMainDoc;
        }

        @JsonProperty("last_main_doc")
        public void setLastMainDoc(String lastMainDoc) {
            this.lastMainDoc = lastMainDoc;
        }

        @JsonProperty("brouillon")
        public Integer getBrouillon() {
            return brouillon;
        }

        @JsonProperty("brouillon")
        public void setBrouillon(Integer brouillon) {
            this.brouillon = brouillon;
        }

        @JsonProperty("totalpaid")
        public Double getTotalpaid() {
            return totalpaid;
        }

        @JsonProperty("totalpaid")
        public void setTotalpaid(Double totalpaid) {
            this.totalpaid = totalpaid;
        }

        @JsonProperty("totalcreditnotes")
        public Double getTotalcreditnotes() {
            return totalcreditnotes;
        }

        @JsonProperty("totalcreditnotes")
        public void setTotalcreditnotes(Double totalcreditnotes) {
            this.totalcreditnotes = totalcreditnotes;
        }

        @JsonProperty("totaldeposits")
        public Double getTotaldeposits() {
            return totaldeposits;
        }

        @JsonProperty("totaldeposits")
        public void setTotaldeposits(Double totaldeposits) {
            this.totaldeposits = totaldeposits;
        }

        @JsonProperty("remaintopay")
        public Double getRemaintopay() {
            return remaintopay;
        }

        @JsonProperty("remaintopay")
        public void setRemaintopay(Double remaintopay) {
            this.remaintopay = remaintopay;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(dateCreation).append(remisePercent).append(condReglement).append(fkProject).append(entity).append(type).append(multicurrencyCode).append(fkAccount).append(condReglementCode).append(socid).append(totalpaid).append(modeReglement).append(datem).append(statut).append(brouillon).append(userAuthor).append(condReglementId).append(fkIncoterms).append(dateLimReglement).append(dateValidation).append(totalcreditnotes).append(locationIncoterms).append(notePublic).append(closeCode).append(additionalProperties).append(multicurrencyTotalTtc).append(datePointoftax).append(lines).append(fkBank).append(fkMulticurrency).append(importKey).append(multicurrencyTotalHt).append(closeNote).append(totalTva).append(paye).append(fkFactureSource).append(totalLocaltax1).append(totalLocaltax2).append(totaldeposits).append(date).append(situationFinal).append(libelleIncoterms).append(notePrivate).append(id).append(userValid).append(remiseAbsolue).append(lastMainDoc).append(fkUserValid).append(remaintopay).append(totalTtc).append(fkUserAuthor).append(modelpdf).append(condReglementDoc).append(multicurrencyTx).append(modeReglementCode).append(ref).append(refExt).append(multicurrencyTotalTva).append(totalHt).append(revenuestamp).append(refClient).append(modeReglementId).toHashCode();
        }

        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }
            if ((other instanceof InvoiceItem) == false) {
                return false;
            }
            InvoiceItem rhs = ((InvoiceItem) other);
            return new EqualsBuilder().append(dateCreation, rhs.dateCreation).append(remisePercent, rhs.remisePercent).append(condReglement, rhs.condReglement).append(fkProject, rhs.fkProject).append(entity, rhs.entity).append(type, rhs.type).append(multicurrencyCode, rhs.multicurrencyCode).append(fkAccount, rhs.fkAccount).append(condReglementCode, rhs.condReglementCode).append(socid, rhs.socid).append(totalpaid, rhs.totalpaid).append(modeReglement, rhs.modeReglement).append(datem, rhs.datem).append(statut, rhs.statut).append(brouillon, rhs.brouillon).append(userAuthor, rhs.userAuthor).append(condReglementId, rhs.condReglementId).append(fkIncoterms, rhs.fkIncoterms).append(dateLimReglement, rhs.dateLimReglement).append(dateValidation, rhs.dateValidation).append(totalcreditnotes, rhs.totalcreditnotes).append(locationIncoterms, rhs.locationIncoterms).append(notePublic, rhs.notePublic).append(closeCode, rhs.closeCode).append(additionalProperties, rhs.additionalProperties).append(multicurrencyTotalTtc, rhs.multicurrencyTotalTtc).append(datePointoftax, rhs.datePointoftax).append(lines, rhs.lines).append(fkBank, rhs.fkBank).append(fkMulticurrency, rhs.fkMulticurrency).append(importKey, rhs.importKey).append(multicurrencyTotalHt, rhs.multicurrencyTotalHt).append(closeNote, rhs.closeNote).append(totalTva, rhs.totalTva).append(paye, rhs.paye).append(fkFactureSource, rhs.fkFactureSource).append(totalLocaltax1, rhs.totalLocaltax1).append(totalLocaltax2, rhs.totalLocaltax2).append(totaldeposits, rhs.totaldeposits).append(date, rhs.date).append(situationFinal, rhs.situationFinal).append(libelleIncoterms, rhs.libelleIncoterms).append(notePrivate, rhs.notePrivate).append(id, rhs.id).append(userValid, rhs.userValid).append(remiseAbsolue, rhs.remiseAbsolue).append(lastMainDoc, rhs.lastMainDoc).append(fkUserValid, rhs.fkUserValid).append(remaintopay, rhs.remaintopay).append(totalTtc, rhs.totalTtc).append(fkUserAuthor, rhs.fkUserAuthor).append(modelpdf, rhs.modelpdf).append(condReglementDoc, rhs.condReglementDoc).append(multicurrencyTx, rhs.multicurrencyTx).append(modeReglementCode, rhs.modeReglementCode).append(ref, rhs.ref).append(refExt, rhs.refExt).append(multicurrencyTotalTva, rhs.multicurrencyTotalTva).append(totalHt, rhs.totalHt).append(revenuestamp, rhs.revenuestamp).append(refClient, rhs.refClient).append(modeReglementId, rhs.modeReglementId).isEquals();
        }

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "fk_facture",
            "fk_parent_line",
            "label",
            "desc",
            "localtax1_type",
            "localtax2_type",
            "fk_remise_except",
            "rang",
            "fk_fournprice",
            "pa_ht",
            "marge_tx",
            "marque_tx",
            "special_code",
            "fk_code_ventilation",
            "date_start",
            "date_end",
            "ref",
            "product_ref",
            "libelle",
            "product_label",
            "product_desc",
            "situation_percent",
            "multicurrency_subprice",
            "multicurrency_total_ht",
            "multicurrency_total_tva",
            "multicurrency_total_ttc",
            "qty",
            "subprice",
            "product_type",
            "fk_product",
            "vat_src_code",
            "tva_tx",
            "localtax1_tx",
            "localtax2_tx",
            "remise_percent",
            "total_ht",
            "total_tva",
            "total_localtax1",
            "total_localtax2",
            "total_ttc",
            "info_bits",
            "id",
            "rowid",
            "fk_unit",
            "import_key",
            "description",
            "fk_product_type",
            "code_ventilation"
    })
    public static class Line {

        @JsonProperty("fk_facture")
        private String fkFacture;
        @JsonProperty("fk_parent_line")
        private Integer fkParentLine;
        @JsonProperty("label")
        private String label;
        @JsonProperty("desc")
        private String desc;
        @JsonProperty("localtax1_type")
        private String localtax1Type;
        @JsonProperty("localtax2_type")
        private String localtax2Type;
        @JsonProperty("fk_remise_except")
        private Integer fkRemiseExcept;
        @JsonProperty("rang")
        private String rang;
        @JsonProperty("fk_fournprice")
        private Integer fkFournprice;
        @JsonProperty("pa_ht")
        private String paHt;
        @JsonProperty("marge_tx")
        private String margeTx;
        @JsonProperty("marque_tx")
        private Integer marqueTx;
        @JsonProperty("special_code")
        private String specialCode;
        @JsonProperty("fk_code_ventilation")
        private Integer fkCodeVentilation;
        @JsonProperty("date_start")
        private String dateStart;
        @JsonProperty("date_end")
        private String dateEnd;
        @JsonProperty("ref")
        private String ref;
        @JsonProperty("product_ref")
        private String productRef;
        @JsonProperty("libelle")
        private String libelle;
        @JsonProperty("product_label")
        private String productLabel;
        @JsonProperty("product_desc")
        private String productDesc;
        @JsonProperty("situation_percent")
        private String situationPercent;
        @JsonProperty("multicurrency_subprice")
        private String multicurrencySubprice;
        @JsonProperty("multicurrency_total_ht")
        private String multicurrencyTotalHt;
        @JsonProperty("multicurrency_total_tva")
        private String multicurrencyTotalTva;
        @JsonProperty("multicurrency_total_ttc")
        private String multicurrencyTotalTtc;
        @JsonProperty("qty")
        private String qty;
        @JsonProperty("subprice")
        private String subprice;
        @JsonProperty("product_type")
        private String productType;
        @JsonProperty("fk_product")
        private String fkProduct;
        @JsonProperty("vat_src_code")
        private String vatSrcCode;
        @JsonProperty("tva_tx")
        private String tvaTx;
        @JsonProperty("localtax1_tx")
        private String localtax1Tx;
        @JsonProperty("localtax2_tx")
        private String localtax2Tx;
        @JsonProperty("remise_percent")
        private String remisePercent;
        @JsonProperty("total_ht")
        private String totalHt;
        @JsonProperty("total_tva")
        private String totalTva;
        @JsonProperty("total_localtax1")
        private String totalLocaltax1;
        @JsonProperty("total_localtax2")
        private String totalLocaltax2;
        @JsonProperty("total_ttc")
        private String totalTtc;
        @JsonProperty("info_bits")
        private String infoBits;
        @JsonProperty("id")
        private String id;
        @JsonProperty("rowid")
        private String rowid;
        @JsonProperty("fk_unit")
        private Integer fkUnit;
        @JsonProperty("import_key")
        private String importKey;
        @JsonProperty("description")
        private String description;
        @JsonProperty("fk_product_type")
        private String fkProductType;
        @JsonProperty("code_ventilation")
        private String codeVentilation;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonProperty("fk_facture")
        public String getFkFacture() {
            return fkFacture;
        }

        @JsonProperty("fk_facture")
        public void setFkFacture(String fkFacture) {
            this.fkFacture = fkFacture;
        }

        @JsonProperty("fk_parent_line")
        public Integer getFkParentLine() {
            return fkParentLine;
        }

        @JsonProperty("fk_parent_line")
        public void setFkParentLine(Integer fkParentLine) {
            this.fkParentLine = fkParentLine;
        }

        @JsonProperty("label")
        public String getLabel() {
            return label;
        }

        @JsonProperty("label")
        public void setLabel(String label) {
            this.label = label;
        }

        @JsonProperty("desc")
        public String getDesc() {
            return desc;
        }

        @JsonProperty("desc")
        public void setDesc(String desc) {
            this.desc = desc;
        }

        @JsonProperty("localtax1_type")
        public String getLocaltax1Type() {
            return localtax1Type;
        }

        @JsonProperty("localtax1_type")
        public void setLocaltax1Type(String localtax1Type) {
            this.localtax1Type = localtax1Type;
        }

        @JsonProperty("localtax2_type")
        public String getLocaltax2Type() {
            return localtax2Type;
        }

        @JsonProperty("localtax2_type")
        public void setLocaltax2Type(String localtax2Type) {
            this.localtax2Type = localtax2Type;
        }

        @JsonProperty("fk_remise_except")
        public Integer getFkRemiseExcept() {
            return fkRemiseExcept;
        }

        @JsonProperty("fk_remise_except")
        public void setFkRemiseExcept(Integer fkRemiseExcept) {
            this.fkRemiseExcept = fkRemiseExcept;
        }

        @JsonProperty("rang")
        public String getRang() {
            return rang;
        }

        @JsonProperty("rang")
        public void setRang(String rang) {
            this.rang = rang;
        }

        @JsonProperty("fk_fournprice")
        public Integer getFkFournprice() {
            return fkFournprice;
        }

        @JsonProperty("fk_fournprice")
        public void setFkFournprice(Integer fkFournprice) {
            this.fkFournprice = fkFournprice;
        }

        @JsonProperty("pa_ht")
        public String getPaHt() {
            return paHt;
        }

        @JsonProperty("pa_ht")
        public void setPaHt(String paHt) {
            this.paHt = paHt;
        }

        @JsonProperty("marge_tx")
        public String getMargeTx() {
            return margeTx;
        }

        @JsonProperty("marge_tx")
        public void setMargeTx(String margeTx) {
            this.margeTx = margeTx;
        }

        @JsonProperty("marque_tx")
        public Integer getMarqueTx() {
            return marqueTx;
        }

        @JsonProperty("marque_tx")
        public void setMarqueTx(Integer marqueTx) {
            this.marqueTx = marqueTx;
        }

        @JsonProperty("special_code")
        public String getSpecialCode() {
            return specialCode;
        }

        @JsonProperty("special_code")
        public void setSpecialCode(String specialCode) {
            this.specialCode = specialCode;
        }

        @JsonProperty("fk_code_ventilation")
        public Integer getFkCodeVentilation() {
            return fkCodeVentilation;
        }

        @JsonProperty("fk_code_ventilation")
        public void setFkCodeVentilation(Integer fkCodeVentilation) {
            this.fkCodeVentilation = fkCodeVentilation;
        }

        @JsonProperty("date_start")
        public String getDateStart() {
            return dateStart;
        }

        @JsonProperty("date_start")
        public void setDateStart(String dateStart) {
            this.dateStart = dateStart;
        }

        @JsonProperty("date_end")
        public String getDateEnd() {
            return dateEnd;
        }

        @JsonProperty("date_end")
        public void setDateEnd(String dateEnd) {
            this.dateEnd = dateEnd;
        }

        @JsonProperty("ref")
        public String getRef() {
            return ref;
        }

        @JsonProperty("ref")
        public void setRef(String ref) {
            this.ref = ref;
        }

        @JsonProperty("product_ref")
        public String getProductRef() {
            return productRef;
        }

        @JsonProperty("product_ref")
        public void setProductRef(String productRef) {
            this.productRef = productRef;
        }

        @JsonProperty("libelle")
        public String getLibelle() {
            return libelle;
        }

        @JsonProperty("libelle")
        public void setLibelle(String libelle) {
            this.libelle = libelle;
        }

        @JsonProperty("product_label")
        public String getProductLabel() {
            return productLabel;
        }

        @JsonProperty("product_label")
        public void setProductLabel(String productLabel) {
            this.productLabel = productLabel;
        }

        @JsonProperty("product_desc")
        public String getProductDesc() {
            return productDesc;
        }

        @JsonProperty("product_desc")
        public void setProductDesc(String productDesc) {
            this.productDesc = productDesc;
        }

        @JsonProperty("situation_percent")
        public String getSituationPercent() {
            return situationPercent;
        }

        @JsonProperty("situation_percent")
        public void setSituationPercent(String situationPercent) {
            this.situationPercent = situationPercent;
        }

        @JsonProperty("multicurrency_subprice")
        public String getMulticurrencySubprice() {
            return multicurrencySubprice;
        }

        @JsonProperty("multicurrency_subprice")
        public void setMulticurrencySubprice(String multicurrencySubprice) {
            this.multicurrencySubprice = multicurrencySubprice;
        }

        @JsonProperty("multicurrency_total_ht")
        public String getMulticurrencyTotalHt() {
            return multicurrencyTotalHt;
        }

        @JsonProperty("multicurrency_total_ht")
        public void setMulticurrencyTotalHt(String multicurrencyTotalHt) {
            this.multicurrencyTotalHt = multicurrencyTotalHt;
        }

        @JsonProperty("multicurrency_total_tva")
        public String getMulticurrencyTotalTva() {
            return multicurrencyTotalTva;
        }

        @JsonProperty("multicurrency_total_tva")
        public void setMulticurrencyTotalTva(String multicurrencyTotalTva) {
            this.multicurrencyTotalTva = multicurrencyTotalTva;
        }

        @JsonProperty("multicurrency_total_ttc")
        public String getMulticurrencyTotalTtc() {
            return multicurrencyTotalTtc;
        }

        @JsonProperty("multicurrency_total_ttc")
        public void setMulticurrencyTotalTtc(String multicurrencyTotalTtc) {
            this.multicurrencyTotalTtc = multicurrencyTotalTtc;
        }

        @JsonProperty("qty")
        public String getQty() {
            return qty;
        }

        @JsonProperty("qty")
        public void setQty(String qty) {
            this.qty = qty;
        }

        @JsonProperty("subprice")
        public String getSubprice() {
            return subprice;
        }

        @JsonProperty("subprice")
        public void setSubprice(String subprice) {
            this.subprice = subprice;
        }

        @JsonProperty("product_type")
        public String getProductType() {
            return productType;
        }

        @JsonProperty("product_type")
        public void setProductType(String productType) {
            this.productType = productType;
        }

        @JsonProperty("fk_product")
        public String getFkProduct() {
            return fkProduct;
        }

        @JsonProperty("fk_product")
        public void setFkProduct(String fkProduct) {
            this.fkProduct = fkProduct;
        }

        @JsonProperty("vat_src_code")
        public String getVatSrcCode() {
            return vatSrcCode;
        }

        @JsonProperty("vat_src_code")
        public void setVatSrcCode(String vatSrcCode) {
            this.vatSrcCode = vatSrcCode;
        }

        @JsonProperty("tva_tx")
        public String getTvaTx() {
            return tvaTx;
        }

        @JsonProperty("tva_tx")
        public void setTvaTx(String tvaTx) {
            this.tvaTx = tvaTx;
        }

        @JsonProperty("localtax1_tx")
        public String getLocaltax1Tx() {
            return localtax1Tx;
        }

        @JsonProperty("localtax1_tx")
        public void setLocaltax1Tx(String localtax1Tx) {
            this.localtax1Tx = localtax1Tx;
        }

        @JsonProperty("localtax2_tx")
        public String getLocaltax2Tx() {
            return localtax2Tx;
        }

        @JsonProperty("localtax2_tx")
        public void setLocaltax2Tx(String localtax2Tx) {
            this.localtax2Tx = localtax2Tx;
        }

        @JsonProperty("remise_percent")
        public String getRemisePercent() {
            return remisePercent;
        }

        @JsonProperty("remise_percent")
        public void setRemisePercent(String remisePercent) {
            this.remisePercent = remisePercent;
        }

        @JsonProperty("total_ht")
        public String getTotalHt() {
            return totalHt;
        }

        @JsonProperty("total_ht")
        public void setTotalHt(String totalHt) {
            this.totalHt = totalHt;
        }

        @JsonProperty("total_tva")
        public String getTotalTva() {
            return totalTva;
        }

        @JsonProperty("total_tva")
        public void setTotalTva(String totalTva) {
            this.totalTva = totalTva;
        }

        @JsonProperty("total_localtax1")
        public String getTotalLocaltax1() {
            return totalLocaltax1;
        }

        @JsonProperty("total_localtax1")
        public void setTotalLocaltax1(String totalLocaltax1) {
            this.totalLocaltax1 = totalLocaltax1;
        }

        @JsonProperty("total_localtax2")
        public String getTotalLocaltax2() {
            return totalLocaltax2;
        }

        @JsonProperty("total_localtax2")
        public void setTotalLocaltax2(String totalLocaltax2) {
            this.totalLocaltax2 = totalLocaltax2;
        }

        @JsonProperty("total_ttc")
        public String getTotalTtc() {
            return totalTtc;
        }

        @JsonProperty("total_ttc")
        public void setTotalTtc(String totalTtc) {
            this.totalTtc = totalTtc;
        }

        @JsonProperty("info_bits")
        public String getInfoBits() {
            return infoBits;
        }

        @JsonProperty("info_bits")
        public void setInfoBits(String infoBits) {
            this.infoBits = infoBits;
        }

        @JsonProperty("id")
        public String getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(String id) {
            this.id = id;
        }

        @JsonProperty("rowid")
        public String getRowid() {
            return rowid;
        }

        @JsonProperty("rowid")
        public void setRowid(String rowid) {
            this.rowid = rowid;
        }

        @JsonProperty("fk_unit")
        public Integer getFkUnit() {
            return fkUnit;
        }

        @JsonProperty("fk_unit")
        public void setFkUnit(Integer fkUnit) {
            this.fkUnit = fkUnit;
        }

        @JsonProperty("import_key")
        public String getImportKey() {
            return importKey;
        }

        @JsonProperty("import_key")
        public void setImportKey(String importKey) {
            this.importKey = importKey;
        }

        @JsonProperty("description")
        public String getDescription() {
            return description;
        }

        @JsonProperty("description")
        public void setDescription(String description) {
            this.description = description;
        }

        @JsonProperty("fk_product_type")
        public String getFkProductType() {
            return fkProductType;
        }

        @JsonProperty("fk_product_type")
        public void setFkProductType(String fkProductType) {
            this.fkProductType = fkProductType;
        }

        @JsonProperty("code_ventilation")
        public String getCodeVentilation() {
            return codeVentilation;
        }

        @JsonProperty("code_ventilation")
        public void setCodeVentilation(String codeVentilation) {
            this.codeVentilation = codeVentilation;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(remisePercent).append(libelle).append(productLabel).append(productType).append(fkUnit).append(localtax2Tx).append(description).append(rang).append(localtax2Type).append(fkFournprice).append(infoBits).append(fkFacture).append(subprice).append(localtax1Tx).append(fkCodeVentilation).append(tvaTx).append(qty).append(label).append(margeTx).append(dateStart).append(codeVentilation).append(additionalProperties).append(multicurrencyTotalTtc).append(importKey).append(situationPercent).append(multicurrencyTotalHt).append(totalTva).append(fkProduct).append(desc).append(totalLocaltax1).append(totalLocaltax2).append(dateEnd).append(fkRemiseExcept).append(id).append(marqueTx).append(productRef).append(localtax1Type).append(fkProductType).append(totalTtc).append(fkParentLine).append(vatSrcCode).append(productDesc).append(ref).append(specialCode).append(multicurrencySubprice).append(multicurrencyTotalTva).append(totalHt).append(paHt).append(rowid).toHashCode();
        }

        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }
            if ((other instanceof Line) == false) {
                return false;
            }
            Line rhs = ((Line) other);
            return new EqualsBuilder().append(remisePercent, rhs.remisePercent).append(libelle, rhs.libelle).append(productLabel, rhs.productLabel).append(productType, rhs.productType).append(fkUnit, rhs.fkUnit).append(localtax2Tx, rhs.localtax2Tx).append(description, rhs.description).append(rang, rhs.rang).append(localtax2Type, rhs.localtax2Type).append(fkFournprice, rhs.fkFournprice).append(infoBits, rhs.infoBits).append(fkFacture, rhs.fkFacture).append(subprice, rhs.subprice).append(localtax1Tx, rhs.localtax1Tx).append(fkCodeVentilation, rhs.fkCodeVentilation).append(tvaTx, rhs.tvaTx).append(qty, rhs.qty).append(label, rhs.label).append(margeTx, rhs.margeTx).append(dateStart, rhs.dateStart).append(codeVentilation, rhs.codeVentilation).append(additionalProperties, rhs.additionalProperties).append(multicurrencyTotalTtc, rhs.multicurrencyTotalTtc).append(importKey, rhs.importKey).append(situationPercent, rhs.situationPercent).append(multicurrencyTotalHt, rhs.multicurrencyTotalHt).append(totalTva, rhs.totalTva).append(fkProduct, rhs.fkProduct).append(desc, rhs.desc).append(totalLocaltax1, rhs.totalLocaltax1).append(totalLocaltax2, rhs.totalLocaltax2).append(dateEnd, rhs.dateEnd).append(fkRemiseExcept, rhs.fkRemiseExcept).append(id, rhs.id).append(marqueTx, rhs.marqueTx).append(productRef, rhs.productRef).append(localtax1Type, rhs.localtax1Type).append(fkProductType, rhs.fkProductType).append(totalTtc, rhs.totalTtc).append(fkParentLine, rhs.fkParentLine).append(vatSrcCode, rhs.vatSrcCode).append(productDesc, rhs.productDesc).append(ref, rhs.ref).append(specialCode, rhs.specialCode).append(multicurrencySubprice, rhs.multicurrencySubprice).append(multicurrencyTotalTva, rhs.multicurrencyTotalTva).append(totalHt, rhs.totalHt).append(paHt, rhs.paHt).append(rowid, rhs.rowid).isEquals();
        }

    }

    public static class GetInvoicesTask extends AsyncTask<Void, Void, Integer> {
        InvoiceListListener invoiceListListener;
        private InvoiceItem[] invoices;
        private String thirdid ="0";




        public GetInvoicesTask(InvoiceListListener thirdpartyListListener, String thirdid) {
            this.invoiceListListener = thirdpartyListListener;
            this.thirdid = thirdid;
        }

        @Override
        protected Integer doInBackground(Void... voids) {

            try {

                ClientResource cr = RestClient.BuildClientResource(RestClient.getURL());
                cr.addSegment("invoices");

                    cr.addQueryParameter("sqlfilters", "(t.fk_soc:=:" + thirdid + ")" );

                RestClient.addToken(cr, RestClient.getToken());
                InvoiceResource resource = cr.wrap(InvoiceResource.class);

                invoices = resource.list();

                clear();
                for (InvoiceItem invoice : invoices) {
                    addItem(invoice);
                }

                Log.i("success", ITEMS.toString());
                return 200;
            } catch (ResourceException e) {
                e.printStackTrace();
                Log.e("uri", e.getResponse().getEntityAsText());
                return e.getResponse().getStatus().getCode();
            }
        }


        @Override
        protected void onPostExecute(Integer code) {
            super.onPostExecute(code);
            invoiceListListener.onPostExecute(invoices, code);

        }
    }

    public static void clear() {
        ITEM_MAP.clear();
        ITEMS.clear();
    }
    public static String getState(int state){
        switch (state){
            case STATUS_DRAFT: return "Borrador";
            case STATUS_VALIDATED: return "Validada";
            case STATUS_CLOSED: return "Cerrada";
            case STATUS_ABANDONED: return "Abandonada";
            default:return "";
        }
    }
    public static int getStateImg(int state){
        switch (state){
            case STATUS_DRAFT: return R.drawable.invoice_draft;
            case STATUS_VALIDATED: return R.drawable.invoice_validated;
            case STATUS_CLOSED: return R.drawable.invoice_colsed;
            case STATUS_ABANDONED: return R.drawable.invoice_inpayment;
            default:return R.drawable.invoice_draft;
        }
    }
    public static int getStateIcon(int state){
        switch (state){
            case STATUS_DRAFT: return R.drawable.calculator_edit;
            case STATUS_VALIDATED: return R.drawable.coins_add;
            case STATUS_CLOSED: return R.drawable.coins;
            case STATUS_ABANDONED: return R.drawable.coins_delete;
            default:return R.drawable.invoice_draft;
        }
    }
    public static String getCloseNote(String closeCode){
        switch (closeCode){
            case CLOSECODE_DISCOUNTVAT: return "Descuento";
            case CLOSECODE_ABANDONED: return "Abandonada";
            case CLOSECODE_BADDEBT: return "Mal pagador";
            case CLOSECODE_REPLACED: return "Reemplazada";
            default:return "";
        }
    }
}
