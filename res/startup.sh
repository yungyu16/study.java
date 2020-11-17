
rt LC_ALL=en_US.UTF-8
export LANG=en_US.UTF-8
export JAVA_HOME=/data/tools/jdk1.8
umask 022

echo "Begin to startup:"
APP_HOME=$(cd "$(dirname "$0")/..";pwd)
APP_LOG_HOME=${APP_HOME}/logs
APP_LIB_HOME=${APP_HOME}/lib
APP_CONF_HOME=${APP_HOME}/conf
APP_TEMP_DIR=${APP_HOME}/tmp

result=$(ps axw |grep "${APP_HOME}/" | grep java | wc -l)
if [ ${result} -ge 1 ];then
    echo -ne "${APP_HOME} process is exists"
    exit 1
fi

#检查并创建log的目录
if [[ ! -d ${APP_LOG_HOME} && ! -h ${APP_LOG_HOME} ]];then
    echo "${APP_LOG_HOME} not exists"
    mkdir ${APP_LOG_HOME}
fi
if [[ ! -d ${APP_TEMP_DIR} && ! -h ${APP_TEMP_DIR} ]];then
    echo "${APP_TEMP_DIR} not exists"
    mkdir ${APP_TEMP_DIR}
fi

#读取setenv.conf文件中的JAVA配置项
if [[ -f "${APP_CONF_HOME}/setenv.conf" ]];then
    while IFS='=' read -r key value
    do
        #过滤空行
        if [[ ${key} != "" && ${value} != "" ]];then
            #只读取指定变量，其余忽略
            if [[ ${key} == "JAVA_HOME" ]] || [[ ${key} == "JAVA_OPTS" ]] || [[ ${key} == "JAVA_MAIN_CLASS" ]] || [[ ${key} == "JAVA_LIBRARY_PATH" ]];then
                eval "${key}='${value}'"
            fi
        fi
    done < ${APP_CONF_HOME}/setenv.conf
else
    echo "${APP_CONF_HOME}/setenv.conf not exists"
    exit -1
fi

JAVA_OPTS="-server ${JAVA_OPTS}"

if [[ "DEBUG" = $1 ]];then
#开启debug
JAVA_OPTS="${JAVA_OPTS} -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=2345"
fi
#性能相关
JAVA_OPTS="${JAVA_OPTS} -XX:-UseBiasedLocking -XX:-UseCounterDecay -XX:AutoBoxCacheMax=20000"

#G1 GC
JAVA_OPTS="${JAVA_OPTS} -XX:+UseG1GC -XX:MaxGCPauseMillis=200"
#GC LOG
JAVA_OPTS="${JAVA_OPTS} -XX:+PrintGCDetails -XX:+PrintGCDateStamps"
JAVA_OPTS="${JAVA_OPTS} -Xloggc:${APP_LOG_HOME}/gc_%p.log"
#异常日志
JAVA_OPTS="${JAVA_OPTS} -XX:ErrorFile=${APP_LOG_HOME}/hs_err_%p.log"
JAVA_OPTS="${JAVA_OPTS} -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=${APP_LOG_HOME}"
JAVA_OPTS="${JAVA_OPTS} -XX:OnError=\"${JAVA_HOME}/bin/jstack %p > ${APP_LOG_HOME}/java_error_%p.log\""
#其它参数
JAVA_OPTS="${JAVA_OPTS} -Dfile.encoding=UTF-8 -Dlog.home=${APP_LOG_HOME} -Dio.netty.leakDetectionLevel=advanced"
JAVA_OPTS="${JAVA_OPTS} -Djava.io.tmpdir=${APP_TEMP_DIR} -Djna.tmpdir=${APP_TEMP_DIR}"
if [[ ${JAVA_LIBRARY_PATH} = "" ]];then
    JAVA_OPTS="${JAVA_OPTS} -Djava.library.path=${APP_LIB_HOME}"
else
    JAVA_OPTS="${JAVA_OPTS} -Djava.library.path=${APP_LIB_HOME}:${JAVA_LIBRARY_PATH}"
fi

#classpath将config放在前边，避免找classpath资源时先去找lib目录中的jar,如果lib中的jar有打包配置文件的话，就会先使用jar中的配置文件
CLASS_PATH="-classpath ${APP_CONF_HOME}:${APP_LIB_HOME}/*"
if [[ "${JAVA_MAIN_CLASS}" = "" ]];then
    echo "JAVA_MAIN_CLASS is empty"
    exit -1
fi

if [[ ! -d ${JAVA_HOME} && ! -h ${JAVA_HOME} ]];then
    echo "JAVA_HOME dir not exists"
    exit -1
fi

echo ${JAVA_HOME}
echo ${JAVA_OPTS}
echo "CLASSPATH:${CLASS_PATH}"
echo `date` >> ${APP_LOG_HOME}/out

eval "nohup ${JAVA_HOME}/bin/java ${JAVA_OPTS} ${CLASS_PATH} ${JAVA_MAIN_CLASS} >> ${APP_LOG_HOME}/out 2>&1 &"
echo "server process started"
