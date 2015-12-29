FORM jetty:9
MAINTAINER Ian Hu <hu2008yinxiang@163.com>
# 拷贝jar
COPY target/jetty-xdeploy-1.0.0.jar /usr/local/jetty/lib/jetty-xdeploy-1.0.0.jar
# 编辑配置文件
RUN sed -i '/lib\/jetty-deploy-${jetty.version}.jar/a\lib/jetty-xdeploy-1.0.0.jar' /usr/local/jetty/modules/deploy.mod
RUN sed '/<Set name="configurationManager">/i\              <Set name="prefix"><Property name="context.prefix" default="null"\/></Set>' /usr/local/jetty/etc/jetty-deploy.xml