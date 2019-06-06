//package msg.bug.control;
//
//import msg.bug.entity.dto.BugDTO;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.List;
//
//public class ExtractingBugsForAUser {
//
//    private List<BugDTO> bugEntities;
//
//    public ExtractingBugsForAUser(List<BugDTO> bugEntities) {
//        this.bugEntities = bugEntities;
//    }
//
//    private String[] columns = {"Title", "Description", "Version", "TargetDate", "Severity",
//            "Status", "fixedVersion"};
//
//    public void MakingExcel() throws IOException {
//        Workbook workbook = new XSSFWorkbook();
//        Sheet sheet = workbook.createSheet("Buugs");
//        sheet.setColumnWidth(0, 6000);
//        sheet.setColumnWidth(1, 4000);
//        Font headerfont = workbook.createFont();
//        headerfont.setFontName("Arial");
//        headerfont.setColor(IndexedColors.RED.getIndex());
//        headerfont.setFontHeightInPoints((short) 16);
//        headerfont.setBold(true);
//        CellStyle headerStyle = workbook.createCellStyle();
//        headerStyle.setFont(headerfont);
//        Row headerRow = sheet.createRow(0);
//        for (int i = 0; i < columns.length; i++) {
//            Cell cell = headerRow.createCell(i);
//            cell.setCellValue(columns[i]);
//            cell.setCellStyle(headerStyle);
//        }
//        int rowNum = 1;
//        for (BugDTO bugEntity : bugEntities) {
//            Row row = sheet.createRow(rowNum++);
//            row.createCell(0).setCellValue(bugEntity.getTitle());
//            row.createCell(1).setCellValue(bugEntity.getDescription());
//            row.createCell(2).setCellValue(bugEntity.getVersion());
//            row.createCell(3).setCellValue(bugEntity.getTargetDate());
//            row.createCell(4).setCellValue(bugEntity.getFixedVersion());
//            row.createCell(5).setCellValue(bugEntity.getSeverity());
//            row.createCell(6).setCellValue(bugEntity.getStatus());
//        }
////       for(int i =0;i<columns.length;i++){
////           sheet.autoSizeColumn(i);
////       }
//        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\schulcj01\\IdeaProjects\\msg_java_training4\\Buugs.xlsx");
//        workbook.write(fileOutputStream);
//        fileOutputStream.close();
//        workbook.close();
//    }
//}
//
