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
		
		PessoaFisica lis = main.new PessoaFisica();
		lis.setCpf("12345");
		lis.setEndereco("hbjjbjlb");
		lis.setNome("helio");
		lis.cadastrar();
		
		PessoaFisica pff = lis.buscar("12345");
		
		System.out.println(pff.getCpf());
		System.out.println(pff.getNome());
		System.out.println(pff.getEndereco());
		System.out.println("--------------------");
		
		lis.setCpf("1234");
		lis.setEndereco("hbghfghgfhfgjjbjlb");
		lis.setNome("hfhfghgfhelio");
		lis.cadastrar();
		lis.listar(); 
		System.out.println("--------------------");
		lis.remover("1234");
		lis.listar();
		System.out.println("--------------------");
		
		
		
		
	}
}