To use mssql integrated authentication for errror "JDBC SQLServerException: “This driver is not configured for integrated authentication.":

  - Download https://www.microsoft.com/en-us/download/details.aspx?id=11774
  - Run sqljdbc_6.0.8112.200_enu and extract to default dir
  - Copy Microsoft JDBC Driver 6.0 for SQL Server\sqljdbc_6.0\enu\auth\x64\sqljdbc_auth.dll to jdk bin folder, e.g. C:\Program Files\AdoptOpenJDK\jdk-8.0.232.09-hotspot\bin

https://stackoverflow.com/questions/6087819/jdbc-sqlserverexception-this-driver-is-not-configured-for-integrated-authentic
