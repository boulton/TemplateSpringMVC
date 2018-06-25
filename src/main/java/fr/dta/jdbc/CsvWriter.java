package fr.dta.jdbc;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class CsvWriter implements ResultSetExtractor {

	@Override
	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

		String csvFile = "moncsv.csv";
		String split = ";";
		int numCol = rs.getMetaData().getColumnCount();
		// TODO Auto-generated method stub
		try {
			FileWriter writer = new FileWriter(csvFile);

			while (rs.next()) {
				List<String> line = new ArrayList<String>();
				for (int i = 1; i <= numCol; i++) {
					line.add(rs.getString(i));
				}
				line.add("\n");
				// System.out.println(line.stream().collect(Collectors.joining(split)));
				writer.write(line.stream().collect(Collectors.joining(split)));
			}

			writer.close();
			return rs;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
}