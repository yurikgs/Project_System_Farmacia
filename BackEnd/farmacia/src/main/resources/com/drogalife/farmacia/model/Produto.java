package com.drogalife.farmacia.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produtos")
public class Produto {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@NotBlank(message = "Este campo não pode ficar em branco, por favor insira alguma informação.")
		@Size(min = 2, max = 50, message = "Esse campo deve ter no min 2 e no max 50 caracteres, por favor reescreva seu texto")
		private String nomeProduto;
		
		@NotBlank(message = "Este campo não pode ficar em branco, por favor insira alguma informação.")
		@Size(max = 90, message = "Esse campo deve ter no max 90 caracteres, por favor reescreva seu texto")
		private String descricao;
		
		
		@NotNull(message = "O valor do produto precisa ser setado!!")
		@DecimalMax(value = "9999999.99", message = "O valor máximo permitido é: 999999.99")
		private BigDecimal preco;        //Restringimos aqui o tipo a BigDecimal, assim 
										//nao teremos inteiro na entrada, e podemos restringir um
										//DecimalMax
		//Criar tarja Aqui (?)
		
		
		@ManyToOne
		@JsonIgnoreProperties("produtos")
		private List<Categoria> categoria;
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getNomeProduto() {
			return nomeProduto;
		}
		public void setNomeProduto(String nomeProduto) {
			this.nomeProduto = nomeProduto;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public BigDecimal getPreco() {
			return preco;
		}
		public void setPreco(BigDecimal preco) {
			this.preco = preco;
		}
		public List<Categoria> getCategoria() {
			return categoria;
		}
		public void setCategoria(List<Categoria> categoria) {
			this.categoria = categoria;
		}
}
