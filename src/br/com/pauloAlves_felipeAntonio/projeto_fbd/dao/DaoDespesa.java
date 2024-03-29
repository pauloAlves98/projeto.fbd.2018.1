package br.com.pauloAlves_felipeAntonio.projeto_fbd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.pauloAlves_felipeAntonio.projeto_fbd.entidade.Despesa;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.exception.DaoException;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLConnection;
import br.com.pauloAlves_felipeAntonio.projeto_fbd.sql.SQLUtil;

public class DaoDespesa implements IDaoDespesa{
	private Connection conexao;
	private PreparedStatement statement;
	@Override
	public void salvar(Despesa despesa) throws DaoException {
		try {
			conexao = SQLConnection.getConnectionInstance(SQLConnection.NOME_BD_CONNECTION_POSTGRESS);
			statement = conexao.prepareStatement(SQLUtil.Despesa.INSERT_ALL);
		
			statement.setString(1,despesa.getCategoria());
			statement.setFloat(2,despesa.getValor());
			statement.setDate(3,despesa.getData_vencimento());
			
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao inserir no banco!!!Contate o adm.");
		}
		
	}
	@Override
	public void editar(Despesa despesa) throws DaoException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Despesa buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Despesa> buscarPorBusca(String busca) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
