package grupo1;
import java.util.scanner;
public class Teste {
	Scanner scanner = new Scanner(System.in);

	GereEventos gestor = new GereEventos();

	int opcao = -1;

	while (opcao != 0) {

	    System.out.println("\n--- MENU GESTÃO DE EVENTOS ---");
	    System.out.println("1. Registar Evento");
	    System.out.println("2. Registar Participante");
	    System.out.println("3. Criar Inscrição");
	    System.out.println("4. Confirmar Inscrição");
	    System.out.println("5. Cancelar Inscrição");
	    System.out.println("6. Listar Participantes Confirmados");
	    System.out.println("7. Ver Vagas Disponíveis");
	    System.out.println("8. Evento com Mais Inscrições Confirmadas");
	    System.out.println("0. Sair");

	    System.out.print("Escolha uma opção: ");
	    opcao = scanner.nextInt();
	    scanner.nextLine();

	    switch (opcao) {
	        case 1:
	            gestor.registarEvento();
	            break;
	        case 2:
	            gestor.registarParticipante();
	            break;
	        case 3:
	            gestor.registarInscricao();
	            break;
	        case 4:
	            gestor.confirmarInscricao();
	            break;
	        case 5:
	            gestor.cancelarInscricao();
	            break;
	        case 6:
	            gestor.listarParticipantesConfirmados();
	            break;
	        case 7:
	            gestor.obterVagasDisponiveis();
	            break;
	        case 8:
	            gestor.obterEventoComMaisInscricoesConfirmadas();
	            break;
	        case 0:
	            System.out.println("A encerrar o programa...");
	            break;
	        default:
	            System.out.println("Opção inválida!");
	    }
	}

	scanner.close();
}
