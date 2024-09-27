package org.example;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ServiceEstacionamento {

    private static final double VALOR_FIXO = 5.90;
    private static final double VALOR_HORA_EXTRA = 2.50;
    private static final double VALOR_PERNOITE = 50.00;
    private static final long CORTESIA_MINUTOS = 15;
    private static final long UMA_HORA = 60;
    private static final int HORA_ABERTURA = 8; // 08:00 da manhã
    private static final int HORA_FECHAMENTO = 2; // 02:00 da manhã do dia seguinte

    public double calculaTarifa(boolean ehVip, Date entrada, Date saida) {
        long minutos = calcularDiferencaEmMinutos(entrada, saida);

        // Verifica se o cliente tem direito à cortesia
        if (minutos <= CORTESIA_MINUTOS) {
            return 0.0;
        }

        // Calcula tarifa normal ou VIP
        double tarifa = calculaTarifaNormal(entrada, saida);

        // Aplica desconto de 50% se for cliente VIP
        if (ehVip) {
            tarifa *= 0.5;
        }

        return tarifa;
    }

    private double calculaTarifaNormal(Date entrada, Date saida) {
        long minutos = calcularDiferencaEmMinutos(entrada, saida);

        // Se a diferença for menor ou igual a 1 hora, cobra valor fixo
        if (minutos <= UMA_HORA) {
            return VALOR_FIXO;
        }

        // Calcula o número de horas completas acima de 1 hora
        long horasExtras = (minutos - UMA_HORA) / UMA_HORA;

        // Verifica se o veículo ficou pernoite
        if (saida.getHours() >= HORA_ABERTURA) {
            return VALOR_PERNOITE;
        }

        // Valor fixo + valor adicional por cada hora extra
        return VALOR_FIXO + (horasExtras * VALOR_HORA_EXTRA);
    }

    // Função auxiliar para calcular a diferença em minutos entre dois horários
    private long calcularDiferencaEmMinutos(Date entrada, Date saida) {
        long diferencaEmMilissegundos = saida.getTime() - entrada.getTime();
        return TimeUnit.MILLISECONDS.toMinutes(diferencaEmMilissegundos);
    }
}
