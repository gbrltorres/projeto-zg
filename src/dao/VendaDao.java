package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.ItemVenda;

public class VendaDao extends BaseDao {

	public int deleteRegistros() throws SQLException {
		Connection connection = getConnection();
		PreparedStatement st = connection.prepareStatement(
				"DELETE FROM itemvenda"
		);
		int retorno = st.executeUpdate();
		st.close();
		closeConnection(connection);
		return retorno;
	}

	public int insereRegistros(List<ItemVenda> lista) throws SQLException { 
		Connection connection = getConnection();
		PreparedStatement st = null;
		int result = 0;
		for(ItemVenda item: lista) {
			st = connection.prepareStatement(
					  "INSERT INTO itemvenda"
					+ "(quantidade, nome, preco)"
				    + "VALUES (?, ?, ?)"
			);
			st.setInt(1, item.getQuantidade());
			st.setString(2, item.getProduto().getNome());
			st.setDouble(3, item.getPreco());
			result = st.executeUpdate();
		}
		st.close();
		closeConnection(connection);
		return result;
	}
}
