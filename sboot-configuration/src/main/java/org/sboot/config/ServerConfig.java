package org.sboot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Data
@Component
@ConfigurationProperties(prefix = "my-servers")
@Validated
public class ServerConfig {

    private String ipAddress;

    @Max(value = 8888, message = "最大值不能超过8888")
    @Min(value = 202, message = "最小值不能超过202")
    private int port;

    @NotNull(message = "不能为空")
    private Long timeout;

    @DurationUnit(ChronoUnit.MINUTES)
    private Duration serveTimeout;

    @DataSizeUnit(DataUnit.MEGABYTES)
    private DataSize dataSize;
}
