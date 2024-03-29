package br.com.pauloAlves_felipeAntonio.projeto_fbd.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.view.CadastrosPanel;

public class ControleCadastros {
	public ControleCadastros(CadastrosPanel cadastrosPanel) {
		cadastrosPanel.getFornecedorButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastrosPanel.getTelaServico().setVisible(false);
				cadastrosPanel.getTelaPacientes().setVisible(false);
				cadastrosPanel.getFuncionarioPanel().setVisible(false);
				cadastrosPanel.getMedicoPanel().setVisible(false);
				cadastrosPanel.getTelaFornecedor().setVisible(true);
				cadastrosPanel.add(cadastrosPanel.getTelaFornecedor(),BorderLayout.CENTER);
			}
		});
		
		cadastrosPanel.getServicoButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cadastrosPanel.getTelaFornecedor().setVisible(false);
				cadastrosPanel.getTelaPacientes().setVisible(false);
				cadastrosPanel.getFuncionarioPanel().setVisible(false);
				cadastrosPanel.getMedicoPanel().setVisible(false);
				cadastrosPanel.getTelaServico().setVisible(true);
				cadastrosPanel.add(cadastrosPanel.getTelaServico(),BorderLayout.CENTER);
			}
		});
		
		cadastrosPanel.getPacienteButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastrosPanel.getTelaFornecedor().setVisible(false);
				cadastrosPanel.getTelaServico().setVisible(false);
				cadastrosPanel.getFuncionarioPanel().setVisible(false);
				cadastrosPanel.getMedicoPanel().setVisible(false);
				cadastrosPanel.getTelaPacientes().setVisible(true);	
				cadastrosPanel.add(cadastrosPanel.getTelaPacientes(),BorderLayout.CENTER);
			}
		});
		cadastrosPanel.getFuncionarioButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastrosPanel.getTelaFornecedor().setVisible(false);
				cadastrosPanel.getTelaServico().setVisible(false);
				cadastrosPanel.getTelaPacientes().setVisible(false);
				cadastrosPanel.getMedicoPanel().setVisible(false);
				cadastrosPanel.getFuncionarioPanel().setVisible(true);
				cadastrosPanel.add(cadastrosPanel.getFuncionarioPanel(),BorderLayout.CENTER);
			}
		});
	cadastrosPanel.getMedicoButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastrosPanel.getTelaFornecedor().setVisible(false);
				cadastrosPanel.getTelaServico().setVisible(false);
				cadastrosPanel.getTelaPacientes().setVisible(false);
				cadastrosPanel.getFuncionarioPanel().setVisible(false);
				cadastrosPanel.getMedicoPanel().setVisible(true);
				
				cadastrosPanel.add(cadastrosPanel.getMedicoPanel(),BorderLayout.CENTER);
			}
		});
	}
}
