import java.util.ArrayList;

public class Main2 {
	

	public interface IPessoa{
		
		
		public boolean cadastrar();
		public Pessoa buscar(String id);
		public boolean remover(String id);
		public void listar();
		
		
	}
	
	
	public  abstract class Pessoa implements IPessoa {
		
		
		
		private String nome;
		private String endereco;
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getEndereco() {
			return endereco;
		}
		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
	
		
	
		
	}
	
	public class PessoaFisica extends Pessoa{
		
		protected ArrayList<PessoaFisica> PessoaRepository = new ArrayList<PessoaFisica>();;
		private String cpf;

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		@Override
		public boolean remover(String cpf) {
			
		PessoaFisica PF = this.buscar(cpf);	
		if( PF == null)
			return false;
		
		PessoaRepository.remove(PF);
		return true;
			
		}

		@Override
		public void listar() {
			
			for (PessoaFisica pessoaFisica : this.PessoaRepository) {
				System.out.println(pessoaFisica.getCpf());
				System.out.println(pessoaFisica.getNome());
				System.out.println(pessoaFisica.getEndereco());
				
			} 
			
			
		
		}
		
		

			@Override
			public boolean cadastrar() {
			PessoaFisica lis = new PessoaFisica();
			lis.setCpf(this.getCpf());
			lis.setEndereco(this.getEndereco());
			lis.setNome(this.getNome());
			
			this.PessoaRepository.add((PessoaFisica) lis);
			return true;
			}

		@Override
		public PessoaFisica buscar(String id) {
			
			for (PessoaFisica pessoa : PessoaRepository) {
				
				if(id == pessoa.cpf) 
					return pessoa;
					
			}

			return null;
	
		}

	}

	
	public  class PessoaJuridica extends Pessoa{
			
			private ArrayList<PessoaJuridica> PessoaRepository = new ArrayList<PessoaJuridica>();
			private String cnpj;
	
			public String getCnpj() {
				return cnpj;
			}
	
			public void setCnpj(String cnpj) {
				this.cnpj = cnpj;
			}
	
			@Override
			public boolean remover(String cnpj) {
				
			PessoaJuridica PJ = this.buscar(cnpj);	
			if( PJ == null) 
				return false;
			
			this.PessoaRepository.remove(PJ);
			return true;
				
			}
	
			@Override
			public void listar() {
				
				for (PessoaJuridica pessoaJuridica : this.PessoaRepository) {
					System.out.println(pessoaJuridica.getCnpj());
					System.out.println(pessoaJuridica.getNome());
					System.out.println(pessoaJuridica.getEndereco());
					
				}
				
				
			
			}
	
				@Override
				public boolean cadastrar() {
					PessoaJuridica PJ = new PessoaJuridica();
					PJ.setCnpj(this.getCnpj());
					PJ.setNome(this.getNome());
					PJ.setEndereco(this.getEndereco());
					
					this.PessoaRepository.add(PJ);
					return true;
					}
	
			@Override
			public PessoaJuridica buscar(String id) {
				
				for (PessoaJuridica pessoa : PessoaRepository) {
					
					if(id == pessoa.getCnpj()) 
						return pessoa;
						
				}
	
				return null;
		
			}
	
		
	
		}

	public static void main(String[] args) {
		Main2 main = new Main2();
		String bus;
		PessoaFisica lis = main.new PessoaFisica();

		scanner2 = new Scanner(System.in);
		boolean controle = true;
		do {
			try {
				controle = false;
				int opcao = menuOpcoes();

				if (opcao == 0 || opcao == 1) {
					System.out.println("\t menu");
					System.out.println("0. Fim");
					System.out.println("1. cadastrar");
					System.out.println("2. buscarr");
					System.out.println("3. remover");
					System.out.println("4. listar");
					System.out.println("Opcao:");
					int key = scanner2.nextInt();
					

					switch (key) {
					case 1:
						lis.setCpf("12345");
						lis.setEndereco("hbjjbjlb");
						lis.setNome("helio");
						lis.cadastrar();
						controle = false;
						break;
					case 0:
						controle = true;
						break;
					case 2:
						
						System.out.println("Digite o cpf da busca");
						scanner2.next();
						do {
						bus = scanner2.nextLine();
						}while(bus == " "||bus == null||bus.length()>2);
						PessoaFisica pff = lis.buscar(bus);
						System.out.println(pff.getCpf());
						System.out.println(pff.getNome());
						System.out.println(pff.getEndereco());
						System.out.println("--------------------");
						break;
					case 4:
						lis.listar();
						controle = false;
						break;
					case 5:
						
						
					}

				} // if
			} catch (java.util.InputMismatchException e) {
				System.out.println("Aviso de Excecao: Opcao Invalida! Sao permitidos apenas numeros!");
				System.out.println("Por favor, escolha uma opcao valida.");
				controle = false;
				// scanner.next();// limpar o buffer
			}
		} while (!controle);
		// scanner.close();
	}// menu()
		// --------------------------------------------------------------------------------------

	public static int menuOpcoes() {
		boolean controle = true;
		int opçao = 0;
		scanner2 = new Scanner(System.in);
		do {
			try {
				System.out.println("Escolha:");
				System.out.println("0 - Pessoa fisica");
				System.out.println("1 - Pessoa juridica");
				controle = true; // deve concluir o loop

				opçao = scanner2.nextInt();
				if (opçao == 0)
					controle = true;
				else if (opçao == 1)
					controle = true;
				else
					throw new InputMismatchException();
				// ------------------------------------------------------
			} catch (InputMismatchException e) {
				System.out.println("Aviso de Excecao: Opcao Invalida! Sao permitidos apena 0 ou 1!");
				System.out.println("Por favor, escolha uma opcao valida.");
				controle = false;// ainda NAO deve concluir o loop
				scanner2.next();// limpar o buffer
			}
		} while (!controle);
		// scanner.close();
		return opçao;

	}// menu()

	/*
	 * public static void inclui(){
	 * System.out.println("Você entrou no método Inclui."); }
	 * 
	 * public static void altera(){
	 * System.out.println("Você entrou no método Altera."); }
	 * 
	 * public static void exclui(){
	 * System.out.println("Você entrou no método Exclui."); }
	 * 
	 * public static void consulta(){
	 * System.out.println("Você entrou no método Consulta."); }
	 * 
	 * //public static void main(String[] args) { int opcao; Scanner entrada = new
	 * Scanner(System.in);
	 * 
	 * do{ menu(); opcao = entrada.nextInt();
	 * 
	 * switch(opcao){ case 1: inclui(); break;
	 * 
	 * case 2: altera(); break;
	 * 
	 * case 3: exclui(); break;
	 * 
	 * case 4: consulta(); break;
	 * 
	 * default: System.out.println("Opção inválida."); } } while(opcao != 0); } }
	 */

	/*
	 * PessoaFisica lis = main.new PessoaFisica(); lis.setCpf("12345");
	 * lis.setEndereco("hbjjbjlb"); lis.setNome("helio"); lis.cadastrar();
	 * 
	 * PessoaFisica pff = lis.buscar("12345");
	 * 
	 * System.out.println(pff.getCpf()); System.out.println(pff.getNome());
	 * System.out.println(pff.getEndereco());
	 * System.out.println("--------------------");
	 * 
	 * lis.setCpf("1234"); lis.setEndereco("hbghfghgfhfgjjbjlb");
	 * lis.setNome("hfhfghgfhelio"); lis.cadastrar(); lis.listar();
	 * System.out.println("--------------------"); lis.remover("1234");
	 * lis.listar(); System.out.println("--------------------");
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
}
