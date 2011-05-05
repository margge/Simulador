package com.arquitectura.project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.StringTokenizer;


public class Interfaz extends JFrame implements ActionListener  {	
	
	// etiquetas para la memoria principal
	private JLabel [] memoria = new JLabel [4];
	private JLabel[] caches = new JLabel[18];
	private JButton[] cpus = new JButton[24];
	
	// metodo constructor
	public Interfaz(){
		super("Simulador de Memoria Cache");
		BorderLayout simulador = new BorderLayout(8,8);
		GridLayout componentes = new GridLayout(2,3,5,5);
		GridLayout memoriaP = new GridLayout(4,8,8,8);
		GridLayout cpu = new GridLayout(4,2,16,8);
		GridLayout cache = new GridLayout(2,3,8,20);
							
		Container conteSimulador = getContentPane();
		getContentPane().setLayout(simulador);			    
		
		JPanel conteComponentes = new JPanel();
		conteComponentes.setBackground(Color.darkGray);
		conteComponentes.setBorder(BorderFactory.createBevelBorder(30));
		conteComponentes.setLayout(componentes);
				
		JPanel panel = new JPanel(memoriaP);
		panel.setBackground(Color.GREEN.brighter());
		
		for(int i=0; i<memoria.length;i++){			
			memoria[i] = new JLabel("Address : a " +i+ " Data: 0");
			memoria[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			memoria[i].setBackground(Color.WHITE);
			memoria[i].setOpaque(true);
			memoria[i].setBounds(20,20,20,20);
			panel.add(memoria[i]);
		}
		JPanel panelAlineadoAlCentro = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelAlineadoAlCentro.add(panel);
		conteSimulador.add(panelAlineadoAlCentro, BorderLayout.NORTH);
		
		
		for(int i =0; i<caches.length;i++){
			if( i % 6 == 0 ){
				panel = new JPanel(cache);
				conteComponentes.add(panel);
				//panel.setBackground(Color.orange);
			}
			caches[i] = new JLabel(""+(i+1));
			panel.add(caches[i]);
			caches[i].setBorder(BorderFactory.createLineBorder(Color.black));
			caches[i].setOpaque(true);
			caches[i].setBackground(Color.WHITE);
			
		}
		
		String lecturaEscritura = "L";
		for(int i =0, contCpu = 0; i<cpus.length;i++){
			if( i % 8 == 0 ){
				panel = new JPanel(cpu);
				conteComponentes.add(panel);
				contCpu++;
			}
			if( i % 4 == 0 && i > 0 ){
				lecturaEscritura = "E";
			}
			cpus[i] = new JButton("Address: a"+(i%4)+" data: 0");			
			cpus[i].setActionCommand(contCpu+"_"+lecturaEscritura+"_"+(i%4));
			cpus[i].addActionListener(this);
			panel.add(cpus[i]);
		}
		
		// JPanel para la memoria principal
		JPanel memoriaPrincipal = new JPanel();
		memoriaPrincipal.setLayout(memoriaP);
				
		conteSimulador.add(conteComponentes, BorderLayout.CENTER);	
		//conteSimulador.add(memoriaPrincipal, BorderLayout.NORTH);	
			
		setVisible(true);
		setSize(900, 400);
	}// fin del constructor

	@Override
	public void actionPerformed(ActionEvent e) {
		String cadena = e.getActionCommand();
		String [] campos = cadena.split("_");		
		System.out.println(e.getActionCommand());
	}			
}// fin de la clase Interfaz
