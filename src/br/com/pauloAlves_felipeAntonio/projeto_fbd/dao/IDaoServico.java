package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Servico;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;

public interface IDaoServico {
	public void salvar(Servico servico) throws DaoException;
	public void editar(Servico servico) throws DaoException;
	public Servico buscarPorId(int id)  throws DaoException;
	//public Medicamento buscaPorHorario(String horario) throws DaoException;
	public List<Servico> buscarPorBusca(String busca)throws DaoException;
}
