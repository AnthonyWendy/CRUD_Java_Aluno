import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;

public class CadastraDAO {
	String url = "jdbc:postgresql://localhost:5432/aluno";
	private Connection connection = null;;
	private String user = "postgre";
	private String senha = "mudar@123";
	
	public void Cad_aluno(Cadastra Cadastra) throws ClassNotFoundException
	{	
		String sql = "insert into aluno(nome, matricula, numero)values(?, ?, ?)";
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, user, senha);
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1,Cadastra.getNome());
			stmt.setString(2, Cadastra.getMatricula());
			stmt.setString(3, Cadastra.getCpf());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	

}
