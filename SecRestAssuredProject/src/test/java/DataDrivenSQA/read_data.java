package DataDrivenSQA;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class read_data {

    public String[][] read_data() throws InvalidFormatException, IOException {
        File file=new File("C:\\Users\\Ahmed.Abdelkhalek\\Documents\\RestAssured.xlsx");
        XSSFWorkbook wb=new XSSFWorkbook(file);
        XSSFSheet sheet=wb.getSheet("Sheet1");
        int number_of_rows=sheet.getPhysicalNumberOfRows();
        int getNumber_of_columns=sheet.getRow(0).getLastCellNum();
        String[][]array=new String[number_of_rows-1][getNumber_of_columns];
        for(int i=1;i<number_of_rows;i++)
        {
            for (int a=0;a<getNumber_of_columns;a++)
            {
                XSSFRow row=sheet.getRow(i);
                array[i-1][a]=row.getCell(a).getStringCellValue();

            }

        }
        return array;

    }




}
