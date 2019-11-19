package probe.mobile.appium.utils.appium;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class CapabilityBuilder {
    public DesiredCapabilities build(String platform) {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        System.out.println("Setting capabilities for platform: " + platform);

        // configuration.yaml under 'devices' key
        Map<String, Object> devicesMap = (Map<String, Object>) Config
                .instance().getYamlProperty("devices." + platform + ".capabilities");
        if (devicesMap == null) {
            throw new RuntimeException("Cannot find devices entry in configuration.yaml. : " + platform);
        }

        devicesMap.entrySet().stream().forEach(entry -> {
            String key = entry.getKey();
            String value = entry.getValue().toString();
            System.out.println("Setting capability " + key + " = " + value);
            capabilities.setCapability(key, value);
        });

        return capabilities;
    }

}
