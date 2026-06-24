FROM my-first-image:1.0.2

LABEL version="0.1.7"

USER root

ENV TZ="Europe/Moscow"

ENV ADB_SERVER_DIR=/opt/adbserver
ENV MARATHON=/opt/marathon
ARG MARATHON_VER="0.10.3"
ARG MARATHON_ZIP="marathon-$MARATHON_VER.zip"
ARG MARATHON_URL="https://github.com/MarathonLabs/marathon/releases/download/$MARATHON_VER/$MARATHON_ZIP"
ARG ADB_SERVER_JAR=adbserver.jar
ARG ADB_SERVER_URL="https://github.com/KasperskyLab/Kaspresso/raw/master/artifacts/adbserver-desktop.jar"
ARG MARATHON_FILE="Marathonfile"

# ШАГ 1: Скачивание утилит и установка Node.js + npm
RUN mkdir -p $ADB_SERVER_DIR && \
    wget -c -O $ADB_SERVER_DIR/$ADB_SERVER_JAR ${ADB_SERVER_URL} && \
    mkdir -p $MARATHON && \
    wget -c -O $MARATHON/$MARATHON_ZIP $MARATHON_URL && \
    unzip -d $MARATHON $MARATHON/$MARATHON_ZIP && \
    # Настройка репозитория NodeSource
    apt-get update && apt-get install -y ca-certificates curl gnupg && \
    mkdir -p /etc/apt/keyrings && \
    curl -fsSL https://deb.nodesource.com/gpgkey/nodesource-repo.gpg.key | gpg --dearmor -o /etc/apt/keyrings/nodesource.gpg && \
    echo "deb [signed-by=/etc/apt/keyrings/nodesource.gpg] https://deb.nodesource.com/node_22.x nodistro main" | tee /etc/apt/keyrings/nodesource.list && \
    # ЯВНО ставим nodejs и npm вместе
    apt-get update && apt-get install -y nodejs npm

# ШАГ 2: Установка Mockoon (теперь npm точно инициализирован в системе)
RUN npm install -g @mockoon/cli && \
    npm cache clean --force

COPY "$MARATHON_FILE" $MARATHON/$MARATHON_FILE
ENV PATH="${PATH}:$MARATHON/marathon-$MARATHON_VER/bin"

RUN chown -R jenkins:jenkins $MARATHON && \
    chown -R jenkins:jenkins $ANDROID_HOME

USER jenkins