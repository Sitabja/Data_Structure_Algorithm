package mapsql.sql.test;

import mapsql.sql.condition.Equals;
import mapsql.sql.condition.GreaterThan;
import mapsql.sql.condition.GreaterThanOrEqual;
import mapsql.sql.condition.LessThan;
import mapsql.sql.condition.LessThanOrEqual;
import mapsql.sql.condition.Like;
import mapsql.sql.condition.OrCondition;
import mapsql.sql.core.Condition;
import mapsql.sql.core.Field;
import mapsql.sql.core.SQLException;
import mapsql.sql.core.SQLManager;
import mapsql.sql.core.SQLResult;
import mapsql.sql.core.SQLStatement;
import mapsql.sql.field.CHARACTER;
import mapsql.sql.field.INTEGER;
import mapsql.sql.statement.CreateTable;
import mapsql.sql.statement.Delete;
import mapsql.sql.statement.DropTable;
import mapsql.sql.statement.Insert;
import mapsql.sql.statement.Select;
import mapsql.sql.statement.Update;

public class ExampleTestTask {
	static SQLManager manager = new SQLManager();
	
	public static void main(String[] args) {
		createTableStatement();

		showTables();
		insertData("sitabja","sitabja.ukil@gmail.com","878565878","27");
		insertData("anandita","anandita.pal@gmail.com","668908761","26");
		insertData("marry","marry.o'lerry@gmail.com","667808761","50");
		insertData("tony","tony.watson@gmail.com","667234670","55");
		insertData("ella","ella.o'lerry@gmail.com","639634670","25");
		
		selectTable();
		System.out.println("Task 1: Basic Conditions test");
		System.out.println("****age Greater Than 27*******");
		selectGreaterThan("age","27");
		System.out.println("****age Greater Than Or Equal 27*******");
		selectGreaterThanOrEqual("age","27");
		System.out.println("****age Less Than 27*******");
		selectLessThan("age","27");
		System.out.println("****age Less Than Or Equal 27*******");
		selectLessOrEqual("age","27");
		
		System.out.println("Task 2: The Like Condition test");
		System.out.println("partial matching");
		System.out.println("*****No % ******");
		System.out.println("*****name like 'anandita' ******");
		selectLikeCondition("name","anandita");
		System.out.println("**** % at the beiginning ******");
		System.out.println("*****name like '%a' ******");
		selectLikeCondition("name","%a");
		System.out.println("**** % at the end ******");
		System.out.println("*****name like 'sita%' ******");
		selectLikeCondition("name","sita%");
		System.out.println("**** % at both side ******");
		System.out.println("*****name like '%nan%' ******");
		selectLikeCondition("name","%nan%");
		
		System.out.println("Task 3: The Table.update() method test");
		System.out.println("Update 'email' and 'age' to 'sitabja.ukil@ucdconnect.ie' and '25' where 'name' = 'Sitabja'");
		updateData(new String[] {"email","age"}, 
				   new String[] {"sitabja.ukil@ucdconnect.ie","25"}, "name", "sitabja");
		selectTable();
		
		System.out.println("Trying to update a unique field to an existing value");
		updateData(new String[]{"id"},new String[]{"1"},"id","2");
		selectTable();
		
		System.out.println("Task 4: The Table.delete() method test");
		System.out.println("delete row where name equal to 'sitabja' ");
		deleteData("name","sitabja");
		selectTable();
		
		System.out.println("Task 5: TableDescription.checkForNotNulls() test");
		System.out.println("Trying to insert with not missing contact (not null field) ");
		insertPartialData(new String[]{"name","email","age"}, new String[]{"Maxy","maxy@gmail.com","26"});
		selectTable();
		
		System.out.println("Task 6: The DropTable.execute() method test");
		dropTable();
		showTables();
		
		
	}

	private static void selectLikeCondition(String column, String value) {
		executeStatement(new Select("contact", new String[] { "id", "name" }, new Like(column, value)));
	}

	private static void selectLessOrEqual(String column, String value) {
		executeStatement(new Select("contact", new String[] { "id", "name" }, new LessThanOrEqual(column, value)));
	}

	private static void selectLessThan(String column, String value) {
		executeStatement(new Select("contact", new String[] { "id", "name" }, new LessThan(column, value)));
	}

	private static void selectGreaterThanOrEqual(String column, String value) {
		executeStatement(new Select("contact", new String[] { "id", "name" }, new GreaterThanOrEqual(column, value)));
		
	}

	private static void selectGreaterThan(String column, String value) {
		executeStatement(new Select("contact", new String[] { "id", "name" }, new GreaterThan(column, value)));
		
	}

	private static void executeStatement(SQLStatement statement) {
		try {
			SQLResult result = manager.execute(statement);
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void createTableStatement() {
		executeStatement(
				new CreateTable(
						"contact", 
						new Field[] {
								new INTEGER("id", true, false, true), 
								new CHARACTER("name", 30, false, true), 
								new CHARACTER("email", 30, false, false),
								new CHARACTER("contact", 30, false, true),
								new INTEGER("age", false, false, true)
						}
				)
		);
	}
	
	public static void showTables() {
		executeStatement(new Select("mapsql.tables", new String[] { "*" }));
	}
	
	public static void selectTable() {
		executeStatement(new Select("contact", new String[] { "*" }));
	}
	
	public static void dropTable() {
		executeStatement(new DropTable("contact"));
	}
	
	public static void insertData(String name, String email, String contact, String age) {
		executeStatement(
				new Insert(
						"contact", 
						new String[] {"name", "email", "contact", "age"}, 
						new String[] {name,email,contact,age}
				)
		);
	}

	public static void insertPartialData(String[] columns,String[] values) {
		executeStatement(new Insert("contact", columns,values));
	}

	public static void updateData(String[] column, String[] values, String conditionColumn, String conditionValue) {
		executeStatement(
				new Update(
						"contact", 
						column, 
						values, 
						new Equals(conditionColumn, conditionValue)
				)
		);
	}
	
	public static void updateOrData() {
		executeStatement(
				new Update(
						"contact", 
						new String[] {"email"}, 
						new String[] {"henry.mcloughlin@ucd.ie"}, 
						new OrCondition(
								new Equals("id", "1"), 
								new Equals("id", "2")
						)
				)
		);
	}
	
	public static void deleteData(String column,String value) {
		executeStatement(new Delete("contact", new Equals(column, value)));
	}
	
	public static void selectTableWithColumns() {
		executeStatement(new Select("contact", new String[] { "id", "name" }));
	}
}
