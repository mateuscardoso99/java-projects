package com.example;

public abstract class JanelaDecorator extends Janela {

	protected Janela janelaDecorada;

	public JanelaDecorator(Janela janelaDecorada) {
		this.janelaDecorada = janelaDecorada;
	}

}
