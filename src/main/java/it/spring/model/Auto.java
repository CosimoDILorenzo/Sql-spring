package it.spring.model;

public class Auto {
    private Long id;
    private String modello;
    private String colore;
    private Integer cv;
    private Long brand_id;

    public Auto() {
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getModello() {
        return modello;
    }
    public void setModello(String modello) {
        this.modello = modello;
    }
    public String getColore() {
        return colore;
    }
    public void setColore(String colore) {
        this.colore = colore;
    }
    public Integer getCvv() {
        return cv;
    }
    public void setCvv(Integer cv) {
        this.cv = cv;
    }
    public Long getBrand_id() {
        return brand_id;
    }
    public void setBrand_id(Long brand_id) {
        this.brand_id = brand_id;
    }
}
