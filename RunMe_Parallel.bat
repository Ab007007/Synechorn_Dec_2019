echo "Welcome to batch Execution"
cd D:\Synechron_16_Dec_2019\Eclipse_WS\actitime
d:
set classpath=D:\Synechron_16_Dec_2019\Eclipse_WS\actitime\target\*;.
mvn test -PRegression
PAUSE >nul

