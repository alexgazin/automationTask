package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:src/main/resources/app.properties"
})
public interface Configuration extends Config {

    @Key("web_host")
    String web_host();
}