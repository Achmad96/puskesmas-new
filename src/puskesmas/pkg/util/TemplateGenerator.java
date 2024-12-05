package puskesmas.pkg.util;

import puskesmas.pkg.exception.ReportGenerationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class TemplateGenerator {

  private void printTemplate(String templatePath, HashMap<String, Object> additionalParams) {
    Connection connection = null;
    InputStream templateStream = null;
    try {
      connection = DatabaseConnection.getConnection();
      templateStream = getTemplateStream(templatePath);
      final HashMap<String, Object> params = new HashMap<>();
      final Path imagePath = Paths.get("leaf_banner_red.png");
      params.put("image_path", imagePath.toAbsolutePath().toString());
      if (additionalParams != null) {
        for (String paramKey : additionalParams.keySet()) {
          params.put(paramKey, additionalParams.get(paramKey));
        }
      }
      final JasperPrint jasperPrint = generateReport(templateStream, connection, params);
      this.displayReport(jasperPrint);
      System.out.println("Report generated successfully!");
    } catch (FileNotFoundException | JRException exception) {
      try {
        System.out.println(exception.getMessage());
        throw new ReportGenerationException("Failed to generate payment receipt", exception);
      } catch (ReportGenerationException exception1) {
        Logger.getLogger(TemplateGenerator.class.getName()).log(Level.SEVERE, null, exception1);
      }
    } finally {
      this.closeResources(connection, templateStream);
    }
  }

  public void printReceipt(String paymentId) throws ReportGenerationException {
    final HashMap<String, Object> parameters = new HashMap<>();
    parameters.put("payment_id", paymentId);
    this.printTemplate("/template/PaymentReceiptTemplate.jrxml", parameters);
  }

  public void printPaymentsHistory(String groupBy) {
    final HashMap<String, Object> options = new HashMap<>();
    options.put("group_by", groupBy);
    this.printTemplate("/template/PaymentsHistoryTemplate.jrxml", options);
  }

  public void printExaminationsHistory(String groupBy) {
    final HashMap<String, Object> options = new HashMap<>();
    options.put("group_by", groupBy);
    this.printTemplate("/template/ExaminationsHistoryTemplate.jrxml", options);
  }

  private InputStream getTemplateStream(String templatePath) throws FileNotFoundException {
    final InputStream templateStream = getClass().getResourceAsStream(templatePath);
    if (templateStream == null) {
      throw new FileNotFoundException("Jasper template not found at: " + templatePath);
    }
    return templateStream;
  }

  /**
   * @param templateStream The data comes from.
   * @param paymentId The ID of the latest payment.
   * @param connection Get the current connection.
   */
  @SuppressWarnings("deprecation")
  private JasperPrint generateReport(InputStream templateStream, Connection connection, HashMap<String, Object> params) throws JRException {
    final JasperReport jasperReport = JasperCompileManager.compileReport(templateStream);
    return JasperFillManager.fillReport(jasperReport, params, connection);
  }

  private void exportReport(JasperPrint jasperPrint, String outputFile) throws JRException {
    final Path outputPath = Paths.get(outputFile).toAbsolutePath();
    JasperExportManager.exportReportToPdfFile(jasperPrint, outputPath.toString());
  }

  private void displayReport(JasperPrint jasperPrint) {
    SwingUtilities.invokeLater(() -> {
      JasperViewer.viewReport(jasperPrint, false);
    });
  }

  private void closeResources(Connection connection, InputStream templateStream) {
    try {
      if (templateStream != null) {
        templateStream.close();
      }
      if (connection != null) {
        connection.close();
      }
    } catch (IOException | SQLException exception) {
      System.err.println(exception.getMessage());
    }
  }
}
