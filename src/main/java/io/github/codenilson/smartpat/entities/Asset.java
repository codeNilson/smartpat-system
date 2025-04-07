package io.github.codenilson.smartpat.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "asset")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column(unique = true)
    private Long tombamento;

    private String category;

    private String unidadeAdministrativa;

    private String unidadeDeLocalizacao;

    private String attributes;

    public Asset(Long tombamento, String category,
            String unidadeAdministrativa, String unidadeDeLocalizacao,
            String attributes) {
        this.tombamento = tombamento;
        this.category = category;
        this.unidadeAdministrativa = unidadeAdministrativa;
        this.unidadeDeLocalizacao = unidadeDeLocalizacao;
        this.attributes = attributes;
    }

    public Asset() {
    }

    public Long getTombamento() {
        return tombamento;
    }

    public void setTombamento(Long tombamento) {
        this.tombamento = tombamento;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUnidadeAdministrativa() {
        return unidadeAdministrativa;
    }

    public void setUnidadeAdministrativa(String unidadeAdministrativa) {
        this.unidadeAdministrativa = unidadeAdministrativa;
    }

    public String getUnidadeDeLocalizacao() {
        return unidadeDeLocalizacao;
    }

    public void setUnidadeDeLocalizacao(String unidadeDeLocalizacao) {
        this.unidadeDeLocalizacao = unidadeDeLocalizacao;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
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
