package com.waheed.tutorial9;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.io.File;

public class Head implements Runnable {
    private static final String LOGBACK_FILE = "sample9_thread.xml";

    static Logger LOG = LoggerFactory.getLogger(Head.class);

    private String name;

    private void initLogger(String loggerFile) {
        LOG.info("Initializing Logger: " + loggerFile);
        File logbackConf = null;
        logbackConf = new File(loggerFile);
        if (!logbackConf.canRead()) {
            LOG.error("Logging configuration can not be read: " + logbackConf
                    + "possibly running under wrong user directory");
        }
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        try {
            JoranConfigurator configurator = new JoranConfigurator();
            // Call lc.reset() to clear any previous configuration,
            configurator.setContext(lc);
            lc.reset();
            configurator.doConfigure(logbackConf.getAbsolutePath());
        } catch (JoranException je) {
            je.printStackTrace();
        }
        // StatusPrinter will handle this
        StatusPrinter.printInCaseOfErrorsOrWarnings(lc);
        LOG.info("Initialized Logger: " + loggerFile);
    }

    @Override
    public void run() {
        initLogger(LOGBACK_FILE);
        MDC.put("logFileName", getName());

        LOG.debug("hello");

        //remember remove this
        MDC.remove("logFileName");

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}