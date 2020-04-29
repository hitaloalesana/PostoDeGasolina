import javax.swing.*; // elementos graficos
import java.awt.*; //pacote awt (Color)

/* ********* TENTATIVA DE JFRAME - FALHA, FALTA TEMPO HÁBIL PARA CRIAÇÃO DAS SUB JANELAS, DEFINIDO A CRIAÇÃO DO PROGRAMA DE FORMA SIMPLES.
public class TelaView extends JFrame {
    
    //******** Declaração dos Objetos *************
    public static Container ctnTela1;
    public static JButton btnBombaCombu, btnBomba
    
    public TelaView(){
    
   super("Sistema de Gerenciamento do Posto Corona");
   
   //******** Construção (Instância) + Configuração dos Objetos *************
   
   ctnTela1 = new Container();
   ctnTela1.setLayout(null);
   this.add(ctnTela1); //adicionando Container no Jframe
   
   
   
   
   //******** Configurações da Janela *************
   
   
   this.setResizable(false);
   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   this.setSize(1024, 728);
   this.setVisible(true);

   
 
*/   
public class TelaView {
    
    public TelaView() {

        bombaCombustivel objVO = new bombaCombustivel(); //Instancia uma objeto da classe bombaCombustivel
        
        String menu1 = "";
        String menu2 = "";
        String menu3 = "";
        String menu4 = "";
        String menu5 = "";
        String menu6 = "";

        int opcao, opcao2, opcao3, opcao4, opcao5, opcao6;

        menu1 += "Escolha uma opçao: \n";
        menu1 += "1 - Gerenciamento\n";
        menu1 += "2 - Vendas\n";
        menu1 += "3 - Sair";

        menu2 += "Escolha uma opção: \n";
        menu2 += "1 - Abastecimento dos Tanques\n";
        menu2 += "2 - Situação dos Tanques\n";
        menu2 += "3 - Relatório de Vendas\n";
        menu2 += "4 - Relatório dos Lucros\n";
        menu2 += "5 - Voltar";

        menu3 += "Escolha o tanque a ser abastecido:\n";
        menu3 += "1 - Etanol\n";
        menu3 += "2 - Gasolina Comum\n";
        menu3 += "3 - Gasolina Aditivada\n";
        menu3 += "4 - Voltar";

        menu4 += "Escolha uma opção:\n";
        menu4 += "1 - Abastecimento\n";
        menu4 += "2 - Serviços\n";
        menu4 += "3 - Voltar";

        menu5 += "Escolha o combustível que deseja abastecer:\n";
        menu5 += "1 - Etanol (R$ 3,50)\n";
        menu5 += "2 - Gasolina comum (R$ 4,50)\n";
        menu5 += "3 - Gasolina Aditivada (R$ 5,00)\n";
        menu5 += "4 - Voltar";

        menu6 += "Escolha uma opção:\n";
        menu6 += "1 - Ducha (R$ 15,00)\n";
        menu6 += "2 - Troca de Óleo (R$ 120,00)\n";
        menu6 += "3 - Balanceamento e Cambagem (R$ 85,00)\n";
        menu6 += "4 - Cappucino (R$ 3,50)\n";
        menu6 += "5 - Voltar";

       
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, menu1, "Posto Corona", JOptionPane.INFORMATION_MESSAGE));

            if (opcao == 1) { //GERENCIAMENTO DO POSTO
                do {
                    opcao2 = Integer.parseInt(JOptionPane.showInputDialog(null, menu2, "Gerênciamento", JOptionPane.INFORMATION_MESSAGE));
                    if (opcao2 == 1) { //ABASTECIMENTO DOS TANQUES
                        do {
                            opcao3 = Integer.parseInt(JOptionPane.showInputDialog(null, menu3, "Abastecimento dos Tanques", JOptionPane.INFORMATION_MESSAGE));
                            if (opcao3 == 1) {
                                int tmpEtanol = Integer.parseInt(JOptionPane.showInputDialog(null, "Tanque de Etanol\nDigite o valor a ser abastecido:", "Etanol", JOptionPane.INFORMATION_MESSAGE));
                                objVO.abastecerTanque(opcao3, tmpEtanol);
                            } else if (opcao3 == 2) {
                                int tmpGasComum = Integer.parseInt(JOptionPane.showInputDialog(null, "Tanque de Gasolina Comum\nDigite o valor a ser abastecido:", "Gasolina Comum", JOptionPane.INFORMATION_MESSAGE));
                                objVO.abastecerTanque(opcao3, tmpGasComum);
                            } else if (opcao3 == 3) {
                                int tmpGasAditivada = Integer.parseInt(JOptionPane.showInputDialog(null, "Tanque de Gasolina Aditivada\nDigite o valor a ser abastecido:", "Gasolina Aditivada", JOptionPane.INFORMATION_MESSAGE));
                                objVO.abastecerTanque(opcao3, tmpGasAditivada);
                            } else if (opcao3 != 4) {
                                JOptionPane.showMessageDialog(null, "Opção inválida", "Erro", JOptionPane.ERROR_MESSAGE);
                            }
                        } while (opcao3 != 4);
                    } else if (opcao2 == 2) { //SITUAÇÃO DOS TANQUES
                        JOptionPane.showMessageDialog(null, objVO.relatorioTanques(), "Relatório dos Tanques", JOptionPane.INFORMATION_MESSAGE);
                    } else if (opcao2 == 3) { //RELATÓRIO DE VENDAS
                        JOptionPane.showMessageDialog(null, objVO.relatorioVendas(), "Relatório de Vendas", JOptionPane.INFORMATION_MESSAGE);
                    } else if (opcao2 == 4) { //RELATÓRIO LUCROS
                        JOptionPane.showMessageDialog(null, objVO.relatorioLucros(), "Relatório dos Lucros Brutos", JOptionPane.INFORMATION_MESSAGE);
                    } else if (opcao2 != 5) {
                        JOptionPane.showMessageDialog(null, "Opção inválida", "Erro", JOptionPane.ERROR_MESSAGE);
                    }

                } while (opcao2 != 5);

            } else if (opcao == 2) { //GERENCIAMENTO DE VENDAS
                do {
                    opcao4 = Integer.parseInt(JOptionPane.showInputDialog(null, menu4, "Posto Corona", JOptionPane.INFORMATION_MESSAGE));
                    if (opcao4 == 1) {//Abastecimento
                        do {
                            opcao5 = Integer.parseInt(JOptionPane.showInputDialog(null, menu5, "Bombas de Combustível", JOptionPane.INFORMATION_MESSAGE));
                            if (opcao5 == 1) {//Abastecer etanol
                                float tmpEtanol2 = Float.parseFloat(JOptionPane.showInputDialog(null, "Bomba de Etanol\nDigite o valor que deseja abastecer:", "Etanol", JOptionPane.INFORMATION_MESSAGE));
                                objVO.abastecerCarro(opcao5, tmpEtanol2);
                            } else if (opcao5 == 2) {//Abastecer Gasolina Comum
                                float tmpGasComum2 = Float.parseFloat(JOptionPane.showInputDialog(null, "Bomba de Gasolina Comum\nDigite o valor que deseja abastecer:", "Gasolina Comum", JOptionPane.INFORMATION_MESSAGE));
                                objVO.abastecerCarro(opcao5, tmpGasComum2);
                            } else if (opcao5 == 3) {//Abastecer Gasolina aditivada
                                float tmpGasAditivada2 = Float.parseFloat(JOptionPane.showInputDialog(null, "Bomba de Gasolina Aditivada\nDigite o valor que deseja abastecer:", "Gasolina Aditivada", JOptionPane.INFORMATION_MESSAGE));
                                objVO.abastecerCarro(opcao5, tmpGasAditivada2);
                            } else if (opcao5 != 4) {
                                JOptionPane.showMessageDialog(null, "Opção inválida", "Erro", JOptionPane.ERROR_MESSAGE);
                            }
                        } while (opcao5 != 4);
                    } else if (opcao4 == 2) {//SERVIÇOS
                        do {
                            opcao6 = Integer.parseInt(JOptionPane.showInputDialog(null, menu6, "Serviços", JOptionPane.INFORMATION_MESSAGE));
                            if (opcao6 == 1) {
                                objVO.venderServico(opcao6);
                            } else if (opcao6 == 2) {
                                objVO.venderServico(opcao6);
                            } else if (opcao6 == 3) {
                                objVO.venderServico(opcao6);
                            } else if (opcao6 == 4) {
                                objVO.venderServico(opcao6);
                            } else if (opcao6 != 5) {
                                JOptionPane.showMessageDialog(null, "Opção inválida", "Erro", JOptionPane.ERROR_MESSAGE);
                            }
                        } while (opcao6 != 5);
                    } else if (opcao4 != 3) {
                        JOptionPane.showMessageDialog(null, "Opção inválida", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } while (opcao4 != 3);
            } else if (opcao != 3) {
                JOptionPane.showMessageDialog(null, "Opção inválida", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } while (opcao != 3);

    }

}