/*
 * package utils;
 * 
 * import java.io.FileInputStream; import java.util.Collection;
 * 
 * import com.google.api.services.sheets.v4.Sheets; import
 * com.google.auth.oauth2.GoogleCredentials;
 * 
 * public class GoogleSheetReader {
 * 
 * public static Sheets getSheetsService() throws Exception { GoogleCredentials
 * credentials = GoogleCredentials .fromStream(new
 * FileInputStream("/f-droid-tests/src/test/java/credentials.json"))
 * .createScoped(Collection.singleton(
 * "https://www.googleapis.com/auth/spreadsheets.readonly\"));\r\n")); return
 * new Sheets.Builder( GoogleNetHttpTransport.newTrustedTransport(); )
 * 
 * 
 * }
 * 
 * }
 */