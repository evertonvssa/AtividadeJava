import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        Bilheteria bilheteria = new Bilheteria();

        System.out.println("    BEM VINDO À BILHETERIA DIGITAL    ");

        String continuarAtendimento = "S";

        do {
            System.out.println("\n    NOVO ATENDIMENTO    ");

            System.out.println("Informe a quantidade de ingressos: ");
            int quantidade = leitor.nextInt();

            System.out.println("Informe o tipo de ingresso desejado: ");
            System.out.println("1 - Inteira | 2 - Meia | 3 - Promocional");
            int tipoIngresso = leitor.nextInt();

            System.out.println("Informa a idade do cliente (0 a 120 anos): ");
            int idade = leitor.nextInt();

            Vendas venda = new Vendas(quantidade, tipoIngresso, idade);

            venda.calcularValorTotal();

            System.out.println("\n   RESUMO DA COMPRA   ");
            System.out.println("Quantidade de ingressos: " + venda.getQuantIngressos());
            System.out.println("Tipo de Ingresso Aplicado: " + venda.getTipoIngressoAplicado());
            System.out.printf("Valor Total: R$ %.2f\n", venda.getValorTotal());

            if (venda.getValorTotal() > 0) {
                System.out.print("\nMétodo de Pagamento (Dinheiro/Cartao): ");
                String metodoPagamento = leitor.next();

                if (metodoPagamento.equalsIgnoreCase("Dinheiro")) {
                    System.out.print("Valor pago pelo cliente: R$ ");
                    double valorPago = leitor.nextDouble();

                    if (valorPago < venda.getValorTotal()) {
                        System.out.println("Valor insuficiente. Venda cancelada.");
                    } else {
                        double troco = valorPago - venda.getValorTotal();
                        System.out.printf("Troco: R$ %.2f\n", troco);
                        System.out.println("Pagamento recebido. Obrigado!");
                        bilheteria.registrarVendas(venda);
                    }
                } else { // Assume Cartão ou qualquer outra coisa
                    System.out.println("Transação com cartão confirmada. Obrigado!");
                    bilheteria.registrarVendas(venda);
                }
            } else { // Se a venda for gratuita, não precisa de pagamento
                System.out.println("Ingressos gratuitos emitidos com sucesso!");
                bilheteria.registrarVendas(venda);
            }

            System.out.println("\n Atender o próximo Cliente? (S/N");
            continuarAtendimento = leitor.next();
        }
        while (continuarAtendimento.equalsIgnoreCase("S"));

        bilheteria.exibirRelatorioFinal();

        System.out.println("\nPrograma finalizado!");

        leitor.close();

    }

}