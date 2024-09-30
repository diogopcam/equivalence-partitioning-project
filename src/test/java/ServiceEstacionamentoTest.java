import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.ServiceEstacionamento;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ServiceEstacionamentoTest {

    ServiceEstacionamento service = new ServiceEstacionamento();

    // Caso de Teste 1
    @Test
    public void testeCortesia() throws Exception {
        Date entrada = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2023-09-24 08:00");
        Date saida = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2023-09-24 08:15");
        double resultado = service.calculaTarifa(false, entrada, saida);
        assertEquals(0.00, resultado, 0.01);
    }

    // Caso de Teste 2
    @Test
    public void testeAteUmaHora() throws Exception {
        Date entrada = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2023-09-24 08:00");
        Date saida = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2023-09-24 08:59");
        double resultado = service.calculaTarifa(false, entrada, saida);
        assertEquals(5.90, resultado, 0.01);
    }

    // Caso de Teste 3
    @Test
    public void testeAteUmaHoraVip() throws Exception {
        Date entrada = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2023-09-24 08:00");
        Date saida = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2023-09-24 08:59");
        double resultado = service.calculaTarifa(true, entrada, saida);
        assertEquals(2.45, resultado, 0.01);
    }
}