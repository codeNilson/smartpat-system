package io.github.codenilson.smartpat.entities;

public class Asset {
    private Long tombamento;

    private String category;

    private String unidadeAdministrativa;

    private String unidadeDeLocalizacao;

    private String property;

    public Asset(Long tombamento, String category,
            String unidadeAdministrativa, String unidadeDeLocalizacao,
            String property) {
        this.tombamento = tombamento;
        this.category = category;
        this.unidadeAdministrativa = unidadeAdministrativa;
        this.unidadeDeLocalizacao = unidadeDeLocalizacao;
        this.property = property;
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

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
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
