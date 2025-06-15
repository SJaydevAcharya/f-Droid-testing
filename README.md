# F-Droid Website Testing Project

This is an automated testing project built using **Selenium WebDriver** with the **Page Object Model (POM)** design pattern. The test suite targets the [F-Droid](https://f-droid.org) website and performs automated functional testing.

---

## ✅ Features Implemented

- ✅ **Page Object Model (POM)** structure  
- ✅ **Data-Driven Testing** using Excel file  
- ✅ **Positive and Negative Test Cases**  
- ✅ **Product Search Verification**  
- ✅ **Cross-Browser Testing** (Chrome & Firefox)  
- ✅ **Screenshot Capture on Failure**  
- ✅ **Extent Reports** for detailed test results  

---

## 🧪 Technologies Used

- **Java**
- **Selenium WebDriver**
- **Apache POI** (for reading Excel)
- **TestNG**
- **ExtentReports**
- **Maven**
- **WebDriverManager**

---

## 🚀 How to Run This Project

1. **Clone the Repository**
   ```bash
   git clone <your-repo-url>
   cd <project-folder>
   ```

2. **Install Dependencies**
   - Make sure Maven is installed and configured.
   - Run:
     ```bash
     mvn clean install
     ```

3. **Run the Tests**
   - To run all tests:
     ```bash
     mvn test
     ```

4. **View Reports**
   - After test execution, open the `ExtentReport.html` file from the `/test-output/` folder.

---

## 📂 Test Data

- Positive Test data is stored in an Excel file (`PositiveTestSearchList.xlsx`)
- Negative Test data is stored in an Excel file (`NegativeSearchTest.xlsx`)
- Data includes:
  - Valid and invalid search terms
  - Expected product names for validation

---

## 📸 Screenshots

- Captured automatically on test failure
- Located in `/screenshots/` folder

---

## 🌐 Cross Browser Support

- This project is configured to run on:
  - Google Chrome
  - Mozilla Firefox  
- Set the desired browser in the `testng1.xml` or configuration class

---

## 📁 Folder Structure

```
.
├── src
│   ├── main
│   │   └── java
│   │       └── pages/          # POM page classes
│   ├── test
│       └── java
│           ├── tests/         # TestNG test classes
│           └── utils/         # ExcelUtils, ScreenshotUtils, etc.
├── resources/
│   └── TestData.xlsx          # Test data
├── screenshots/
├── test-output/
│   └── ExtentReport.html
├── pom.xml
└── README.md
```

---

## 🧑‍💻 Author

**SJaydevAcharya**  
Automation Tester | Java | Selenium | Postman | Newman

---

## 📄 License

This project is open-source and free to use for learning and demonstration purposes.
