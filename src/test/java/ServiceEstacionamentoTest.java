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
        assertEquals(2.95, resultado, 0.01);
    }

    // Caso de Teste 4
    @Test
    public void testeAcimadeUmaHora() throws Exception {
        Date entrada = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2023-09-24 08:00");
        Date saida = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2023-09-24 09:01");
        double resultado = service.calculaTarifa(false, entrada, saida);
        assertEquals(8.40, resultado, 0.01);
    }

    // Caso de Teste 5
    @Test
    public void testeAcimadeUmaHoraVip() throws Exception {
        Date entrada = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2023-09-24 08:00");
        Date saida = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2023-09-24 09:01");
        double resultado = service.calculaTarifa(true, entrada, saida);
        assertEquals(4.20, resultado, 0.01);
    }
    // Caso de Teste 6
    @Test
    public void testePernoite() throws Exception {
        Date entrada = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2023-09-24 08:00");
        Date saida = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2023-09-25 09:00");
        double resultado = service.calculaTarifa(false, entrada, saida);
        assertEquals(50.00, resultado, 0.01);
    }
    // Caso de Teste 7
    @Test
    public void testePernoiteVip() throws Exception {
        Date entrada = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2023-09-24 08:00");
        Date saida = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2023-09-25 09:00");
        double resultado = service.calculaTarifa(true, entrada, saida);
        assertEquals(25.00, resultado, 0.01);
    }


}