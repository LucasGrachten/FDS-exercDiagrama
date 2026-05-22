public class ContaMagica {
    private final String numeroConta;
    private final String nomeCorrentista;
    private double saldo;
    private String categoria;

    public ContaMagica(String nro, String nome) {
        this.numeroConta = nro;
        this.nomeCorrentista = nome;
        this.saldo = 0.0;
        this.categoria = "Silver";
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getNomeCorrentista() {
        return nomeCorrentista;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getCategoria() {
        return categoria;
    }

    public boolean deposito(double valor) {
        if (valor <= 0) return false;
        double credited = valor;
        if ("Gold".equals(categoria)) {
            credited = valor * 1.01; // 1%
        } else if ("Platinum".equals(categoria)) {
            credited = valor * 1.025; // 2.5%
        }
        saldo += credited;

        // Upgrade check: only one level per deposit
        if ("Silver".equals(categoria) && saldo >= 50000.0) {
            categoria = "Gold";
        } else if ("Gold".equals(categoria) && saldo >= 200000.0) {
            categoria = "Platinum";
        }
        return true;
    }

    public boolean saque(double valor) {
        if (valor <= 0) return false;
        if (valor > saldo) return false; // cannot go negative
        saldo -= valor;

        // Downgrade check: only one level per withdrawal
        if ("Platinum".equals(categoria) && saldo < 100000.0) {
            categoria = "Gold";
        } else if ("Gold".equals(categoria) && saldo < 25000.0) {
            categoria = "Silver";
        }
        return true;
    }
}
