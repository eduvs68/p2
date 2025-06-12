package domain;

public enum TipoAjusteEstoque {
    ENTRADA("entrada"),
    SAIDA("saída");

    private final String descricao;

    TipoAjusteEstoque(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoAjusteEstoque fromDescricao(String descricao) {
        for (TipoAjusteEstoque tipo : TipoAjusteEstoque.values()) {
            if (tipo.getDescricao().equalsIgnoreCase(descricao)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de ajuste inválido: " + descricao);
    }
}