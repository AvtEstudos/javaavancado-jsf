package br.com.allianz.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import br.com.allianz.models.Livro;
import br.com.allianz.dao.LivrosDao;

@ManagedBean(name="beanLivro")
@RequestScoped
public class LivrosBean {	
	
	private Livro livro;
	
	public LivrosBean() {
		if(livro == null) {
			livro = new Livro();
		}
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	//M�todo de a��o (action) que, quando executado, retorna o redirecionamento conforme o resultado da execu��o
	public String incluirLivro() {
		try {
			new LivrosDao().IncluirLivro(livro);
			return "sucesso";
		} catch (Exception e) {
			return "erro";
		}
	}
	
	//propriedade usada para apresentar a lista dos livros cadastrados
	public List<Livro> getListaLivros() throws Exception{		
		return new LivrosDao().ListarLivros();
	}	

}
