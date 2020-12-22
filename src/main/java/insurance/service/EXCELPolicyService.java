package insurance.service;

import insurance.pojo.PersonalPolicy;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

@Service
public class EXCELPolicyService {

    @Autowired
    PersonalPolicyService personalPolicyService;

    public void writeExcelFile(Integer policyId, String filePath) {
        String[] columns = {"id", "clientId", "shortDescription", "objectOfInsurance", "coverageType"};
        try (Workbook workbook = new XSSFWorkbook()) {

            Sheet sheet = workbook.createSheet("policies");

            Row headerRow = sheet.createRow(0);
            for (int col = 0; col < columns.length; col++) {
                Cell cell = headerRow.createCell(col);

                cell.setCellValue(columns[col]);
                sheet.autoSizeColumn(col);
            }

            Optional <PersonalPolicy> policy = personalPolicyService.findPoliceById(policyId);
            if(policy.isPresent()) {


                Row row = sheet.createRow(1);

                row.createCell(0).setCellValue(policy.get().getId());

                row.createCell(1).setCellValue(policy.get().getClientId());
                row.createCell(2).setCellValue(policy.get().getObjectOfInsurance());
                row.createCell(3).setCellValue(policy.get().getShortDescription());
                row.createCell(4).setCellValue(policy.get().getCoverageType().toString());
            }

            else {
                throw new NullPointerException("Not found");
            }

            try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
                workbook.write(fileOutputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
