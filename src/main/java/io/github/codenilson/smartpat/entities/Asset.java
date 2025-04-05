package io.github.codenilson.smartpat.entities;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Asset {
    private SimpleLongProperty tombamento;

    private SimpleStringProperty category;

    private SimpleStringProperty unidadeAdministrativa;

    private SimpleStringProperty unidadeDeLocalizacao;

    private SimpleStringProperty property;

    public Asset(Long tombamento, String category,
            String unidadeAdministrativa, String unidadeDeLocalizacao,
            String property) {
        this.tombamento = new SimpleLongProperty(tombamento);
        this.category = new SimpleStringProperty(category);
        this.unidadeAdministrativa = new SimpleStringProperty(unidadeAdministrativa);
        this.unidadeDeLocalizacao = new SimpleStringProperty(unidadeDeLocalizacao);
        this.property = new SimpleStringProperty(property);
    }

    public Long getTombamento() {
        return tombamento.get();
    }

    public void setTombamento(Long tombamento) {
        this.tombamento = new SimpleLongProperty(tombamento);
    }

    public String getCategory() {
        return category.get();
    }

    public void setCategory(String category) {
        this.category = new SimpleStringProperty(category);
    }

    public String getUnidadeAdministrativa() {
        return unidadeAdministrativa.get();
    }

    public void setUnidadeAdministrativa(String unidadeAdministrativa) {
        this.unidadeAdministrativa = new SimpleStringProperty(unidadeAdministrativa);
    }

    public String getUnidadeDeLocalizacao() {
        return unidadeDeLocalizacao.get();
    }

    public void setUnidadeDeLocalizacao(String unidadeDeLocalizacao) {
        this.unidadeDeLocalizacao = new SimpleStringProperty(unidadeDeLocalizacao);
    }

    public String getProperty() {
        return property.get();
    }

    public void setProperty(String property) {
        this.property = new SimpleStringProperty(property);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tombamento == null) ? 0 : tombamento.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Asset other = (Asset) obj;
        if (tombamento == null) {
            if (other.tombamento != null)
                return false;
        } else if (!tombamento.equals(other.tombamento))
            return false;
        return true;
    }


    
}
