package domain;

public enum TipoFluxoCaixa {
    ENTRADA("entrada"),
    SAIDA("saída");

    private final String descricao;

    TipoFluxoCaixa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoFluxoCaixa fromDescricao(String descricao) {
        for (TipoFluxoCaixa tipo : TipoFluxoCaixa.values()) {
            if (tipo.getDescricao().equalsIgnoreCase(descricao)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de fluxo inválido: " + descricao);
    }
}