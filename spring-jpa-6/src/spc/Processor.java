package spc;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Processor {

    @Id
    private String id;
    private String codename;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodename() {
        return this.codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }
    
}
