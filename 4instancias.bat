echo Prueba 01-Distribuida

CD build
CD install
CD distribuida
start java -Dserver.port=8080 -classpath lib/* com.distribuida.Servidor
start java -Dserver.port=8081 -classpath lib/* com.distribuida.Servidor
start java -Dserver.port=9090 -classpath lib/* com.distribuida.Servidor
start java -Dserver.port=9091 -classpath lib/* com.distribuida.Servidor


