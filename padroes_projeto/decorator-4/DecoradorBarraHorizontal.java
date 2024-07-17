package com.example;

public class DecoradorBarraHorizontal extends JanelaDecorator{
    public DecoradorBarraHorizontal(Janela janelaDecorada) {
		super(janelaDecorada);
	}

	public void draw() {
		drawBarraHorizontalal();
		janelaDecorada.draw();
	}

	private void drawBarraHorizontalal() {
		System.out.println("desenha uma barra horizontal na janela");
	}
}
