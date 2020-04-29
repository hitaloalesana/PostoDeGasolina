import java.awt.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class bombaCombustivel {


    DecimalFormat df = new DecimalFormat("0.00"); //Litros
    DecimalFormat rs = new DecimalFormat("0.000"); //Preços

    public float[] tanquesCorona = new float[4]; //0 = Etanol | 1 = Gasolina Comum | 2 = Gasolina Aditivada
    public int[] servicosCorona = new int[5]; //0 = Ducha | 1 = Óleo | 2 = Balanceamento | 3 = Café | 4 = Total
    public float[] litrosVendidos = new float[4]; //0 = Etanol | 1 = Gasolina Comum | 2 = Gasolina Aditivada | 3 = Total
    public float[] litrosComprados = new float[4]; //0 = Etanol | 1 = Gasolina Comum | 2 = Gasolina Aditivada | 3 = Total
    public float despesaCombu;
    public float lucroCombu;
    public float lucroServs;

    public bombaCombustivel() { //Inicializa os tanquesCorona com 0;
        for (int i = 0; i < 3; i++) {
            this.tanquesCorona[i] = 0;
        }
    }

    public void abastecerTanque(int tanque, int valor) { //É passado qual o tanque a ser abastecido e o valor;
        if (tanque == 1) { //TANQUE ETANOL

            if ((this.tanquesCorona[0] + valor) <= 20000 && (valor > 0)) {
                this.tanquesCorona[0] += valor;
                this.litrosComprados[0] += valor;
                this.litrosComprados[3] += valor;
                this.despesaCombu += (valor * 1.19);
                JOptionPane.showMessageDialog(null, "Tanque abastecido com sucesso !!!", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
            } else if (this.tanquesCorona[0] == 20000 && (valor > 0)) {
                JOptionPane.showMessageDialog(null, "O tanque está cheio!!", "Erro", JOptionPane.WARNING_MESSAGE);
            } else if (valor <= 0) {
                JOptionPane.showMessageDialog(null, "Erro, valor negativo !!!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if ((this.tanquesCorona[0] + valor) > 2000) {
                JOptionPane.showMessageDialog(null, "O valor excede a capacidade do tanque!", "Erro", JOptionPane.WARNING_MESSAGE);
            }

        } else if (tanque == 2) {//TANQUE GASOLINA COMUM

            if ((this.tanquesCorona[1] + valor) <= 20000 && (valor > 0)) {
                this.tanquesCorona[1] += valor;
                this.litrosComprados[1] += valor;
                this.litrosComprados[3] += valor;
                this.despesaCombu += (valor * 2.19);
                JOptionPane.showMessageDialog(null, "Tanque abastecido com sucesso !!!", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
            } else if (this.tanquesCorona[1] == 20000 && (valor > 0)) {
                JOptionPane.showMessageDialog(null, "O tanque está cheio!!", "Erro", JOptionPane.WARNING_MESSAGE);
            } else if (valor <= 0) {
                JOptionPane.showMessageDialog(null, "Erro, valor negativo !!!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if ((this.tanquesCorona[1] + valor) > 2000) {
                JOptionPane.showMessageDialog(null, "O valor excede a capacidade do tanque!", "Erro", JOptionPane.WARNING_MESSAGE);
            }

        } else if (tanque == 3) {//TANQUE GAS ADITIVADA

            if ((this.tanquesCorona[2] + valor) <= 20000 && (valor > 0)) {
                this.tanquesCorona[2] += valor;
                this.litrosComprados[2] += valor;
                this.litrosComprados[3] += valor;
                this.despesaCombu += (valor * 2.29);
                JOptionPane.showMessageDialog(null, "Tanque abastecido com sucesso !!!", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
            } else if (this.tanquesCorona[2] == 20000 && (valor > 0)) {
                JOptionPane.showMessageDialog(null, "O tanque está cheio!!", "Erro", JOptionPane.WARNING_MESSAGE);
            } else if (valor <= 0) {
                JOptionPane.showMessageDialog(null, "Erro, valor negativo !!!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if ((this.tanquesCorona[2] + valor) > 2000) {
                JOptionPane.showMessageDialog(null, "O valor excede a capacidade do tanque!", "Erro", JOptionPane.WARNING_MESSAGE);
            }
    }
    }

    public void abastecerCarro(int tmpCombustivel, float valor) {
        float tmpLitros;

        if (tmpCombustivel == 1) {

            tmpLitros = (float) (valor / 3.50);

            if ((this.tanquesCorona[0] - tmpLitros) >= 0 && (valor > 0)) {
                this.tanquesCorona[0] -= tmpLitros;
                this.litrosVendidos[0] += tmpLitros;
                this.litrosVendidos[3] += tmpLitros;
                this.lucroCombu += valor;
                JOptionPane.showMessageDialog(null, "Abastecimento efetuado !!!\n" + df.format(tmpLitros) + " Litros", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
            } else if (this.tanquesCorona[0] == 0 && (valor > 0)) {
                JOptionPane.showMessageDialog(null, "A bomba de Etanol está vazia !!!", "Erro", JOptionPane.WARNING_MESSAGE);
            } else if (valor <= 0) {
                JOptionPane.showMessageDialog(null, "Erro, valor negativo !!!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if (tmpLitros > this.tanquesCorona[0]) {
                JOptionPane.showMessageDialog(null, "Não há combustível o suficiente !!!", "Erro", JOptionPane.WARNING_MESSAGE);
            }

        } else if (tmpCombustivel == 2) {

            tmpLitros = (float) (valor / 4.50);

            if ((this.tanquesCorona[1] - tmpLitros) >= 0 && (valor > 0)) {
                this.tanquesCorona[1] -= tmpLitros;
                this.litrosVendidos[1] += tmpLitros;
                this.litrosVendidos[3] += tmpLitros;
                this.lucroCombu += valor;
                JOptionPane.showMessageDialog(null, "Abastecimento efetuado !!!\n" + df.format(tmpLitros) + " Litros", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
            } else if (this.tanquesCorona[1] == 0 && (valor > 0)) {
                JOptionPane.showMessageDialog(null, "A bomba de Gasolina Comum está vazia !!!", "Erro", JOptionPane.WARNING_MESSAGE);
            } else if (valor <= 0) {
                JOptionPane.showMessageDialog(null, "Erro, valor negativo !!!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if (tmpLitros > this.tanquesCorona[1]) {
                JOptionPane.showMessageDialog(null, "Não há combustível o suficiente !!!", "Erro", JOptionPane.WARNING_MESSAGE);
            }

        } else if (tmpCombustivel == 3) {

            tmpLitros = (float) (valor / 5.00);

            if ((this.tanquesCorona[2] - tmpLitros) >= 0 && (valor > 0)) {
                this.tanquesCorona[2] -= tmpLitros;
                this.litrosVendidos[2] += tmpLitros;
                this.litrosVendidos[3] += tmpLitros;
                this.lucroCombu += valor;
                JOptionPane.showMessageDialog(null, "Abastecimento efetuado !!!\n" + df.format(tmpLitros) + " Litros", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
            } else if (this.tanquesCorona[2] == 0 && (valor > 0)) {
                JOptionPane.showMessageDialog(null, "A bomba de Gasolina Aditivada está vazia !!!", "Erro", JOptionPane.WARNING_MESSAGE);
            } else if (valor <= 0) {
                JOptionPane.showMessageDialog(null, "Erro, valor negativo !!!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if (tmpLitros > this.tanquesCorona[2]) {
                JOptionPane.showMessageDialog(null, "Não há combustível o suficiente !!!", "Erro", JOptionPane.WARNING_MESSAGE);
            }
    }
    }
 
    public String relatorioTanques() {
        String tmpRelatorioTanques = "";

        tmpRelatorioTanques += "Situação atual dos tanquesCorona:\n";
        tmpRelatorioTanques += "1 - Etanol: " + df.format(this.tanquesCorona[0]) + " litros\n";
        tmpRelatorioTanques += "2 - Gasolina Comum: " + df.format(this.tanquesCorona[1]) + " litros\n";
        tmpRelatorioTanques += "3 - Gasolina Aditivada: " + df.format(this.tanquesCorona[2]) + " litros\n";

        return tmpRelatorioTanques;
    }

    public void venderServico(int servico) {
        if (servico == 1) {
            this.servicosCorona[0]++;
            this.servicosCorona[4]++;
            this.lucroServs += 15.00;
            JOptionPane.showMessageDialog(null, "Ducha Concluída !!!\nValor: RS 15,00", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
        } else if (servico == 2) {
            this.servicosCorona[1]++;
            this.servicosCorona[4]++;
            this.lucroServs += 120.00;
            JOptionPane.showMessageDialog(null, "Troca de óleo efetuada !!!\nValor: R$ 120,00", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
        } else if (servico == 3) {
            this.servicosCorona[2]++;
            this.servicosCorona[4]++;
            this.lucroServs += 85.00;
            JOptionPane.showMessageDialog(null, "Balanceamento e Cambagem Concluído !!!\nValor: RS 85,00", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
        } else if (servico == 4) {
            this.servicosCorona[3]++;
            this.servicosCorona[4]++;
            this.lucroServs += 3.50;
            JOptionPane.showMessageDialog(null, "Capuccino comprado !!!\nValor: RS 3,50", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public String relatorioVendas() {
        String tmpRelatorioVendas = "";

        tmpRelatorioVendas += "Combustíveis Vendidos:\n";
        tmpRelatorioVendas += "Etanol = " + df.format(this.litrosVendidos[0]) + " litros | R$ " + rs.format(this.litrosVendidos[0] * 3.50) + "\n";
        tmpRelatorioVendas += "Gasolina Comum = " + df.format(this.litrosVendidos[1]) + " litros | R$ " + rs.format(this.litrosVendidos[1] * 4.50) + "\n";
        tmpRelatorioVendas += "Gasolina Aditivada = " + df.format(this.litrosVendidos[2]) + " litros | R$ " + rs.format(this.litrosVendidos[2] * 5.00) + "\n";
        tmpRelatorioVendas += "Total: " + df.format(this.litrosVendidos[3]) + " | R$ " + rs.format(this.lucroCombu) + "\n";
        tmpRelatorioVendas += "----------------------------------------------------\n";
        tmpRelatorioVendas += "Serviços Vendidos:\n";
        tmpRelatorioVendas += "Ducha = " + this.servicosCorona[0] + " | R$" + rs.format(this.servicosCorona[0] * 15.00) + "\n";
        tmpRelatorioVendas += "Troca de Óleo = " + this.servicosCorona[1] + " | R$" + rs.format(this.servicosCorona[1] * 120.00) + "\n";
        tmpRelatorioVendas += "Balanceamento e Cambagem = " + this.servicosCorona[2] + " | R$" + rs.format(this.servicosCorona[2] * 85.00) + "\n";
        tmpRelatorioVendas += "Capuccino = " + this.servicosCorona[3] + " | R$" + rs.format(this.servicosCorona[3] * 3.50) + "\n";
        tmpRelatorioVendas += "Total: " + this.servicosCorona[4] + " serviços | R$ " + rs.format(this.lucroServs) + "\n";

        return tmpRelatorioVendas;
    }

    public String relatorioDespesas() {
        String tmpRelatorioDespesas = "";

        tmpRelatorioDespesas += "Despesas:\n";
        tmpRelatorioDespesas += "Etanol = " + df.format(this.litrosComprados[0]) + " litros | R$ " + rs.format(this.litrosComprados[0] * 1.19) + "\n";
        tmpRelatorioDespesas += "Gasolina Comum = " + df.format(this.litrosComprados[1]) + " litros | R$" + rs.format(this.litrosComprados[1] * 2.19) + "\n";
        tmpRelatorioDespesas += "Gasolina Aditivada = " + df.format(this.litrosComprados[2]) + " litros | R$" + rs.format(this.litrosComprados[2] * 2.29) + "\n";
        tmpRelatorioDespesas += "Total = " + df.format(this.litrosComprados[3]) + " litros | R$ " + rs.format(this.despesaCombu) + "\n";

        return tmpRelatorioDespesas;
    }

    public String relatorioLucros() {
        String tmpRelatorioLucros = "";

        tmpRelatorioLucros += "Combustíveis:\n";
        tmpRelatorioLucros += "Lucro Bruto = R$ " + rs.format(this.lucroCombu) + "\n";
        tmpRelatorioLucros += "Lucro Líquido = R$ " + rs.format((this.lucroCombu - this.despesaCombu)) + "\n";
        tmpRelatorioLucros += "-------------------------\n";
        tmpRelatorioLucros += "Serviços:\n";
        tmpRelatorioLucros += "Lucro Bruto: R$ " + rs.format(this.lucroServs) + "\n";
        tmpRelatorioLucros += "-------------------------\n";
        tmpRelatorioLucros += "Total:\n";
        tmpRelatorioLucros += "Lucros Brutos: R$ " + rs.format((this.lucroCombu + this.lucroServs)) + "\n";
        tmpRelatorioLucros += "Lucros Líquidos: R$ " + rs.format(((this.lucroCombu - this.despesaCombu) + this.lucroServs)) + "\n";
        return tmpRelatorioLucros;
    }
}
