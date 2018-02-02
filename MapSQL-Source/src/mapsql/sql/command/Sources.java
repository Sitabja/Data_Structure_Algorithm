package mapsql.sql.command;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import mapsql.shell.core.SQLVisitor;
import mapsql.shell.parser.MapSQL;
import mapsql.shell.parser.SimpleNode;
import mapsql.sql.core.SQLCommand;
import mapsql.sql.core.SQLException;
import mapsql.sql.core.SQLManager;
import mapsql.sql.core.SQLOperation;
import mapsql.util.List;

public class Sources implements SQLCommand {
	private String filename;
	
	public Sources(String filename) {
		this.filename = filename;
	}
	
	@Override
	public String execute(SQLManager manager) throws SQLException {
			FileReader fr = null;
			try {
				fr = new FileReader(filename);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			BufferedReader br = new BufferedReader(fr); 
			String sql;
			try {
				while((sql = br.readLine()) != null) { 
					SimpleNode n = new MapSQL(new ByteArrayInputStream( sql.getBytes() ) ).Start();

					List<SQLOperation> operations = (List<SQLOperation>) n.jjtAccept(new SQLVisitor(), null);
					for (SQLOperation operation : operations) {
						System.out.println(manager.execute(operation));
					}
				} 
				fr.close();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		return "OK";
	}
}
