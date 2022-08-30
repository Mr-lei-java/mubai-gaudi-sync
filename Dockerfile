FROM registry-vpc.cn-shanghai.aliyuncs.com/li_java/li_java:8-jdk
MAINTAINER xxx<xxx@163.com>
RUN mkdir /var/jarDir
ADD mubai-gaudi-sync-0.0.1-SNAPSHOT.jar /var/jarDir
#设置时区
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone
CMD ["nohup","java","-jar","/var/jarDir/bbelc-sync-0.0.1-SNAPSHOT.jar","&"]

