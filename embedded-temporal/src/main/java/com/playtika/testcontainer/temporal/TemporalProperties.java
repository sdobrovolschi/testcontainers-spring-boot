package com.playtika.testcontainer.temporal;

import com.playtika.testcontainer.common.properties.CommonContainerProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@EqualsAndHashCode(callSuper = true)
@ConfigurationProperties("embedded.temporal")
public class TemporalProperties extends CommonContainerProperties {

    public static final String BEAN_NAME_EMBEDDED_TEMPORAL = "embeddedTemporal";
    public static final int INTERNAL_PORT = 7233;
    public static final int INTERNAL_UI_PORT = 8233;

    private boolean uiEnabled;
    private String cliVersion = "1.3.0";

    @Override
    public String getDefaultDockerImage() {
        return "temporalio/dev:" + cliVersion;
    }
}
