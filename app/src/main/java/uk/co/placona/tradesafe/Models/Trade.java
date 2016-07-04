package uk.co.placona.tradesafe.models;

import java.util.Date;
import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import uk.co.placona.tradesafe.CustomApplication;

/**
 * Created by mplacona on 27/06/2016.
 */
public class Trade extends RealmObject {
    @PrimaryKey
    private String id = UUID.randomUUID().toString();
    private String reference;
    private String uri;
    private String description;
    private Date date;

    public Trade() {

    }

    public Trade(String reference,String description, String uri, Date date) {
        this.date = date;
        this.description = description;
        this.reference = reference;
        this.uri = uri;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
