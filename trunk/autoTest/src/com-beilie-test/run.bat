d:
set dt=%date:~0,4%-%date:~5,2%-%date:~8,2%
set tm=%time:~0,2%-%time:~3,2%
cd D:\workPlace\trunk\autoTest\src\com-beilie-test\
mvn test > test_%dt%_%tm%.log