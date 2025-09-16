public class Bilheteria {
    private int totalIngressosVendidos;
    private double totalArrecadado;
    private int quantIngressosInteira;
    private int quantIngressosMeia;
    private int quantIngressosPromocional;
    private int quantIngressosGratuito;

    public Bilheteria(){
        this.totalIngressosVendidos = 0;
        this.totalArrecadado = 0;
        this.quantIngressosInteira = 0;
        this.quantIngressosMeia = 0;
        this.quantIngressosPromocional = 0;
        this.quantIngressosGratuito = 0;
    }

    public void registrarVendas(Vendas vendas){
        this.totalIngressosVendidos += vendas.getValorTotal();
        this.totalIngressosVendidos += vendas.getQuantIngressos();

        String tipoIngressoAplicado = vendas.getTipoIngressoAplicado();
        switch (tipoIngressoAplicado){
            case "Inteira":
                this.quantIngressosInteira += vendas.getQuantIngressos();
                break;
            case "Meia":
                this.quantIngressosMeia += vendas.getQuantIngressos();
                break;
            case "Promocional":
                this.quantIngressosPromocional += vendas.getQuantIngressos();
                break;
            case "Gratuito":
                this.quantIngressosGratuito += vendas.getQuantIngressos();
        }
    }

    public void exibirRelatorioFinal(){
        System.out.println("\n    RELATÓRIO FINAL DE VENDAS   ");
        System.out.println("Total de ingressos vendidos: " + this.totalIngressosVendidos);
        System.out.println("_________________________________");
        System.out.println("Quantitade por Tipo:");
        System.out.println("Inteira: " + this.quantIngressosInteira);
        System.out.println("Meia: " + this.quantIngressosMeia);
        System.out.println("Promocional: " + this.quantIngressosPromocional);
        System.out.println("Gratuito: " + this.quantIngressosGratuito);
        System.out.println("__________________________________");
        System.out.println("VALOR TOTAL ARRECADADO: " + this.totalArrecadado);
        System.out.println("    FIM DO RELATÓRIO   ");

    }
}
