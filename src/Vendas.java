public class Vendas {
    private int quantIngressos;
    private int tipoIngresso;
    private int idadeCliente;
    private String tipoIngressoAplicado;
    private double valorTotal;
    private static final double precoBase = 35.00;

    public Vendas (int quantIngressos, int tipoIngresso, int idadeCliente){
        this.quantIngressos = quantIngressos;
        this.tipoIngresso = tipoIngresso;
        this.idadeCliente = idadeCliente;
        this.valorTotal = 0.0;
        this.tipoIngressoAplicado = "";
    }
    public void calcularValorTotal(){
        double precoUnitario = 0;

        if (idadeCliente < 5){
            precoUnitario = 0;
            this.tipoIngressoAplicado = "Gratuito";
        }
        else {
            switch (tipoIngresso) {
                case 1:
                    precoUnitario = precoBase;
                    this.tipoIngressoAplicado = "Inteira";
                    break;
                case 2:
                    precoUnitario = precoBase * 0.5;
                    this.tipoIngressoAplicado = "Meia";
                    break;
                case 3:
                    precoUnitario = precoBase * 0.7;
                    this.tipoIngressoAplicado = "Promocional";
                    break;
                default:
                    precoUnitario = precoBase;
                    this.tipoIngressoAplicado = "Inteira";
                    break;
            }
        }
        this.valorTotal = precoUnitario * this.quantIngressos;
    }

    public String getTipoIngressoAplicado() {
        return tipoIngressoAplicado;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public int getQuantIngressos() {
        return quantIngressos;
    }
}
