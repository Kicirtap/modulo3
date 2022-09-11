package br.com.viagem.teste;

import java.util.Date;
import java.util.Scanner;

import br.com.viagem.dao.ClienteDAO;
import br.com.viagem.dao.CotacaoDAO;
import br.com.viagem.dao.ViagemDAO;
import br.com.viagem.model.Cliente;
import br.com.viagem.model.Cotacao;
import br.com.viagem.model.Viagem;

public class Teste {

	public static void main(String[] args) {
        
		 int opcao;
		  Scanner op = new Scanner(System.in);
		  
		  System.out.println("-------- MENU ---------");
		  
		  
		  do {
			  System.out.println("\n1 - Cliente | 2 - Cotacao | 3 - Viagem | 4 - Finalizar\n");
			  opcao = Integer.parseInt(op.nextLine());
			  
			  switch(opcao) {
			  
			  case 1:
				  acessarClientes(op);
				  break;
				  
			  case 2:
				  acessarCotacao(op);
				  break;
				  
			  case 3:
				  acessarViagem(op);
				  break;
				  
			
			  case 4:
				  System.out.println("Programa finalizado com sucesso");
				  break;
			  
			  default: System.out.println("\nOpcao invalida");
			  
			  }
			  
			  
		  } while(opcao != 4);

	}
	//menu clientes
	private static void acessarClientes(Scanner op) {
		 ClienteDAO clienteDAO = new ClienteDAO();
   	 int selecionarCliente;
   	 System.out.println("\n1 - Novo cliente | 2 - Alterar cliente | 3 - Deletar cliente | 4 - Mostrar clientes\n");
   	 selecionarCliente = Integer.parseInt(op.nextLine());
   	
   	 switch(selecionarCliente) {
   	 	case 1:
   	 		Cliente cliente = new Cliente();
   	 		System.out.println("Nome:");
   	 		cliente.setNome(op.nextLine());
   	 		System.out.println("Email:");
   	 		cliente.setEmail(op.nextLine());
   	 		cliente.setDataCadastro(new Date());
   	 		
   	 		clienteDAO.salvar(cliente);
   	 		
   	 		break;
   	 		
   	 	case 2:
   	 		Cliente alterarCliente = new Cliente();
   	 		System.out.println("Id do cliente:");
   	 	    alterarCliente.setId(Integer.parseInt(op.nextLine()));
   	 		System.out.println("Nome:");
   	 		alterarCliente.setNome(op.nextLine());
   	 		System.out.println("Email:");
   	 		alterarCliente.setEmail(op.nextLine());
   	 	    alterarCliente.setDataCadastro(new Date());
   	 		
   	 	    clienteDAO.update(alterarCliente);
   	 		break;
   	 		
   	 	case 3:
   	 		int id;
   	 		System.out.println("Informe o id do cliente para exclusao");
   	 		id = Integer.parseInt(op.nextLine());
   	 		clienteDAO.deleteByID(id);
   	 		break;
   	 		
   	 	case 4:
   	 		for(Cliente c : clienteDAO.getClientes()) {
   	 			System.out.println("Cliente: "+c.getNome());
   	 			System.out.println("Email: "+c.getEmail());
   	 			System.out.println("Data Cadastro: "+c.getDataCadastro());
   	 			System.out.println("---------------------------------------");
   	 		}
   	 		break;
   	 		
	 		default: System.out.println("Escolha uma opcao valida.");
   	 }
   	 		
   	 		
   	 }
   	 
	
	//Menu cotaçoes
	
	
   	 private static void acessarCotacao(Scanner op) {
	 CotacaoDAO cotacaoDAO = new CotacaoDAO();
 	 int selecionarCotacao;
 	 System.out.println("\n1 - Nova cotacao | 2 - Alterar cotacao| 3 - Deletar cotacao | 4 - Mostrar cotacao\n");
 	 selecionarCotacao = Integer.parseInt(op.nextLine());
 	
 	 switch(selecionarCotacao) {
 	 	case 1:
 	 		Cotacao cotacao = new Cotacao();
 	 		System.out.println("Destino:");
 	 		cotacao.setDestino(op.nextLine());
 	 		System.out.println("Valor:");
 	 		cotacao.setValor(op.nextLine());
 	 		cotacao.setDataCotacao(new Date());
 	 		
 	 		cotacaoDAO.salvar(cotacao);
 	 		
 	 		break;
 	 		
 	 	case 2:
   	 		Cotacao alterarCotacao = new Cotacao();
   	 		System.out.println("Id da cotacao:");
   	 		alterarCotacao.setCotacao_id(Integer.parseInt(op.nextLine()));
   	 		System.out.println("Destino:");
   	 		alterarCotacao.setDestino(op.nextLine());
   	 		System.out.println("Valor:");
   	 		alterarCotacao.setValor(op.nextLine());
   	 		alterarCotacao.setDataCotacao(new Date());
   	 		
   	 	    cotacaoDAO.update(alterarCotacao);
   	 		break;
   	 		
   	 	case 3:
   	 		int cotacao_id;
   	 		System.out.println("Informe o id do cliente para exclusao");
   	 	    cotacao_id= Integer.parseInt(op.nextLine());
   	 		cotacaoDAO.deleteByID(cotacao_id);
   	 		break;
   	 		
   	 	case 4:
   	 		for(Cotacao c : cotacaoDAO.getCotacoes()) {
   	 			System.out.println("Destino: "+c.getDestino());
   	 			System.out.println("Valor: "+c.getValor());
   	 			System.out.println("Data Cotacao: "+c.getDataCotacao());
   	 		}
   	 		break;
   	 		
	 		default: System.out.println("Escolha uma opcao valida.");
   	    }	
	 }
	
   //Menu viagens
 	
 	
   	 private static void acessarViagem(Scanner op) {
	 ViagemDAO viagemDAO = new ViagemDAO();
 	 int selecionarViagem;
 	 System.out.println("\n1 - Nova viagem | 2 - Alterar viagem| 3 - Deletar viagem | 4 - Mostrar viagem\n");
 	 selecionarViagem = Integer.parseInt(op.nextLine());
 	
 	 switch(selecionarViagem) {
 	 	case 1:
 	 		Viagem viagem = new Viagem();
 	 		System.out.println("Destino: ");
 	 		viagem.setDestino(op.nextLine());
 	 		System.out.println("Descricao: ");
 	 		viagem.setDescricao(op.nextLine());
 	 		System.out.println("Data da Viagem: ");
 	 		viagem.setDataViagem(op.nextLine());
 	 		
 	 		viagemDAO.salvar(viagem);
 	 		
 	 		break;
 	 		
 	 	case 2:
   	 		Viagem alterarViagem = new Viagem();
   	 		System.out.println("Id da cotacao:");
   	 		alterarViagem.setViagem_id(Integer.parseInt(op.nextLine()));
   	 		System.out.println("Destino:");
   	 		alterarViagem.setDestino(op.nextLine());
   	 		System.out.println("Descricao:");
   	 		alterarViagem.setDescricao(op.nextLine());
   	 	    System.out.println("Data da Viagem: ");
   	 	    alterarViagem.setDataViagem(op.nextLine());
   	 		
   	 	    viagemDAO.update(alterarViagem);
   	 		break;
   	 		
   	 	case 3:
   	 		int viagem_id;
   	 		System.out.println("Informe o id do cliente para exclusao");
   	 	    viagem_id= Integer.parseInt(op.nextLine());
   	 		viagemDAO.deleteByID(viagem_id);
   	 		break;
   	 		
   	 	case 4:
   	 		for(Viagem c : viagemDAO.getViagens()) {
   	 			System.out.println("Destino: "+c.getDestino());
   	 			System.out.println("Descricao: "+c.getDescricao());
   	 			System.out.println("Data Viagem: "+c.getDataViagem());
   	 		}
   	 		break;
   	 		
	 		default: System.out.println("Escolha uma opcao valida.");
   	    }	
}
}   	 



	

	
