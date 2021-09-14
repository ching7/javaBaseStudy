#!/bin/bash 

#Java程序所在的目录（classes的上一级目录） 
APP_HOME=..

JVM_PARAMS="-Xms1g -Xmx1g"

#需要启动的Java主程序（main方法类） 
APP_MAIN_CLASS="com.iflytek.aicc.znwh.app.AiccZnwhApplication"

#拼凑完整的classpath参数，包括指定lib目录下所有的jar 
CLASSPATH="$APP_HOME/conf:$APP_HOME/lib/*:$APP_HOME/classes"

s_pid=0
checkPid() {
   if [ -f "main.pid" ];then
	   java_ps=`ps -aux |grep -v grep|grep \`cat main.pid\``
	   if [ -n "$java_ps" ]; then
		  s_pid=`echo $java_ps | awk '{print $2}'`
	   else 
		  s_pid=0
	   fi 
	else 
	    s_pid=0
    fi 
} 

start() { 
checkPid
if [ $s_pid -ne 0 ]; then
    echo "================================================================"
    echo "warn: $APP_MAIN_CLASS already started! (pid=$s_pid)"
    echo "================================================================"
else
    echo -n "Starting $APP_MAIN_CLASS ..."
    nohup java $JVM_PARAMS -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8000 -classpath $CLASSPATH $APP_MAIN_CLASS  >/dev/null 2>&1 &
    echo $! > main.pid
    checkPid
    if [ $s_pid -ne 0 ]; then
        echo "(pid=$s_pid) [OK]"
    else
        echo "[Failed]"
    fi
fi 
}

echo "start project......"
start